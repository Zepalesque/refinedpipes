package com.refinedmods.refinedpipes.render;

import com.google.common.collect.ImmutableList;
import com.mojang.math.Transformation;
import com.refinedmods.refinedpipes.block.pipe.PipeBlock;
import com.refinedmods.refinedpipes.blockentity.PipeBlockEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.IQuadTransformer;
import net.minecraftforge.client.model.QuadTransformers;
import net.minecraftforge.client.model.data.ModelData;
import net.minecraftforge.common.util.TransformationHelper;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PipeBakedModel implements BakedModel {
    private static final Map<Direction, Transformation> SIDE_TRANSFORMS = new EnumMap<>(Direction.class);
    private final BakedModel core;
    private final BakedModel north;
    private final BakedModel south;
    private final BakedModel east;
    private final BakedModel west;
    private final BakedModel up;
    private final BakedModel down;
    private final BakedModel inventoryAttachment;
    private final Map<ResourceLocation, BakedModel> attachmentModels;
    private final Map<PipeState, List<BakedQuad>> cache = new ConcurrentHashMap<>();

    public PipeBakedModel(BakedModel core, BakedModel north, BakedModel south, BakedModel east, BakedModel west, BakedModel up, BakedModel down,  BakedModel inventoryAttachment, Map<ResourceLocation, BakedModel> attachmentModels) {
        this.core = core;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.up = up;
        this.down = down;
        this.inventoryAttachment = inventoryAttachment;
        this.attachmentModels = attachmentModels;
    }

    private static List<BakedQuad> getTransformedQuads(BakedModel model, Direction facing, PipeState state, RenderType type) {
        Transformation transformation = SIDE_TRANSFORMS.computeIfAbsent(facing, face -> {
            Quaternionf quaternion;
            if (face == Direction.UP) {
                quaternion = TransformationHelper.quatFromXYZ(new Vector3f(90, 0, 0), true);
            } else if (face == Direction.DOWN) {
                quaternion = TransformationHelper.quatFromXYZ(new Vector3f(270, 0, 0), true);
            } else {
                double r = Math.PI * (360 - face.getOpposite().get2DDataValue() * 90) / 180d;

                quaternion = TransformationHelper.quatFromXYZ(new Vector3f(0, (float) r, 0), false);
            }

            return new Transformation(null, quaternion, null, null).blockCenterToCorner();
        });

        ImmutableList.Builder<BakedQuad> quads = ImmutableList.builder();
        Direction side = state.getSide();

        if (side != null && side.get2DDataValue() > -1) {
            int faceOffset = 4 + Direction.NORTH.get2DDataValue() - facing.get2DDataValue();
            side = Direction.from2DDataValue((side.get2DDataValue() + faceOffset) % 4);
        }

        IQuadTransformer transformer1 = QuadTransformers.applying(transformation);
        quads.addAll(transformer1.process(model.getQuads(state.getState(), side, state.getRand(), ModelData.EMPTY, type)));

        return quads.build();
    }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction direction, RandomSource random) {
        return getQuads(state, direction, random, ModelData.EMPTY, null);
    }


    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@javax.annotation.Nullable BlockState state, @javax.annotation.Nullable Direction side, @Nonnull RandomSource rand, @Nonnull ModelData extraData, @Nullable RenderType renderType) {
        PipeState pipeState = new PipeState(state, extraData.get(PipeBlockEntity.ATTACHMENTS_PROPERTY), side, rand);
        return cache.computeIfAbsent(pipeState, ps -> this.createQuads(ps, renderType));
    }

    private List<BakedQuad> createQuads(PipeState state, @Nullable RenderType renderType) {
        List<BakedQuad> quads = new ArrayList<>();

        if (state.getState() != null) {
            boolean north = state.getState().getValue(PipeBlock.NORTH);
            boolean east = state.getState().getValue(PipeBlock.EAST);
            boolean south = state.getState().getValue(PipeBlock.SOUTH);
            boolean west = state.getState().getValue(PipeBlock.WEST);
            boolean up = state.getState().getValue(PipeBlock.UP);
            boolean down = state.getState().getValue(PipeBlock.DOWN);

            quads.addAll(core.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));

            if (north) {
                quads.addAll(this.north.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }

            if (east) {
                quads.addAll(this.east.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }

            if (south) {
                quads.addAll(this.south.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }

            if (west) {
                quads.addAll(this.west.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }

            if (up) {
                quads.addAll(this.up.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }

            if (down) {
                quads.addAll(this.down.getQuads(state.getState(), state.getSide(), state.getRand(), ModelData.EMPTY, renderType));
            }
        }

        if (state.getAttachmentState() != null) {
            for (Direction dir : Direction.values()) {
                ResourceLocation attachmentId = state.getAttachmentState()[dir.ordinal()];

                if (attachmentId != null) {
                    quads.addAll(getTransformedQuads(attachmentModels.get(attachmentId), dir, state, renderType));
                }
            }
        }

        if (state.getState() != null) {
            boolean invNorth = state.getState().getValue(PipeBlock.INV_NORTH);
            boolean invEast = state.getState().getValue(PipeBlock.INV_EAST);
            boolean invSouth = state.getState().getValue(PipeBlock.INV_SOUTH);
            boolean invWest = state.getState().getValue(PipeBlock.INV_WEST);
            boolean invUp = state.getState().getValue(PipeBlock.INV_UP);
            boolean invDown = state.getState().getValue(PipeBlock.INV_DOWN);

            if (invNorth && !state.hasAttachmentState(Direction.NORTH)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.NORTH, state, renderType));
            }

            if (invEast && !state.hasAttachmentState(Direction.EAST)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.EAST, state, renderType));
            }

            if (invSouth && !state.hasAttachmentState(Direction.SOUTH)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.SOUTH, state, renderType));
            }

            if (invWest && !state.hasAttachmentState(Direction.WEST)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.WEST, state, renderType));
            }

            if (invUp && !state.hasAttachmentState(Direction.UP)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.UP, state, renderType));
            }

            if (invDown && !state.hasAttachmentState(Direction.DOWN)) {
                quads.addAll(getTransformedQuads(inventoryAttachment, Direction.DOWN, state, renderType));
            }
        }

        return quads;
    }

    @Override
    public boolean useAmbientOcclusion() {
        return core.useAmbientOcclusion();
    }

    @Override
    public boolean isGui3d() {
        return core.isGui3d();
    }

    @Override
    public boolean usesBlockLight() {
        return true;
    }

    @Override
    public boolean isCustomRenderer() {
        return core.isCustomRenderer();
    }

    @Override
    @SuppressWarnings("deprecation")
    public TextureAtlasSprite getParticleIcon() {
        return core.getParticleIcon();
    }

    @Override
    public ItemOverrides getOverrides() {
        return core.getOverrides();
    }
}
