package com.refinedmods.refinedpipes.network.pipe.shape;

import com.refinedmods.refinedpipes.block.PipeBlock;
import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;

public class PipeShapeFactory {
    public VoxelShape createShape(BlockState state, ResourceLocation[] attachmentState) {
        VoxelShape shape = PipeShapeProps.CORE_SHAPE;

        if (state.getValue(PipeBlock.NORTH)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.NORTH_EXTENSION_SHAPE);
        }

        if (state.getValue(PipeBlock.EAST)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.EAST_EXTENSION_SHAPE);
        }

        if (state.getValue(PipeBlock.SOUTH)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.SOUTH_EXTENSION_SHAPE);
        }

        if (state.getValue(PipeBlock.WEST)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.WEST_EXTENSION_SHAPE);
        }

        if (state.getValue(PipeBlock.UP)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.UP_EXTENSION_SHAPE);
        }

        if (state.getValue(PipeBlock.DOWN)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.DOWN_EXTENSION_SHAPE);
        }

        if (attachmentState[Direction.NORTH.ordinal()] != null || state.getValue(PipeBlock.INV_NORTH)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.NORTH_ATTACHMENT_SHAPE);
        }

        if (attachmentState[Direction.EAST.ordinal()] != null || state.getValue(PipeBlock.INV_EAST)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.EAST_ATTACHMENT_SHAPE);
        }

        if (attachmentState[Direction.SOUTH.ordinal()] != null || state.getValue(PipeBlock.INV_SOUTH)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.SOUTH_ATTACHMENT_SHAPE);
        }

        if (attachmentState[Direction.WEST.ordinal()] != null || state.getValue(PipeBlock.INV_WEST)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.WEST_ATTACHMENT_SHAPE);
        }

        if (attachmentState[Direction.UP.ordinal()] != null || state.getValue(PipeBlock.INV_UP)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.UP_ATTACHMENT_SHAPE);
        }

        if (attachmentState[Direction.DOWN.ordinal()] != null || state.getValue(PipeBlock.INV_DOWN)) {
            shape = VoxelShapes.or(shape, PipeShapeProps.DOWN_ATTACHMENT_SHAPE);
        }

        return shape;
    }
}
