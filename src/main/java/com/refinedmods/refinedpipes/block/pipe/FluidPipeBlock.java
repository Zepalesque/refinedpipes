package com.refinedmods.refinedpipes.block.pipe;

import com.refinedmods.refinedpipes.blockentity.FluidPipeBlockEntity;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.network.pipe.shape.PipeShapeCache;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

public class FluidPipeBlock extends PipeBlock implements EntityBlock {
    private final FluidPipeType type;

    public FluidPipeBlock(PipeShapeCache shapeCache, FluidPipeType type) {
        super(shapeCache);

        this.type = type;
    }

    public FluidPipeType getType() {
        return type;
    }

    @Override
    protected boolean hasConnection(BlockGetter level, BlockPos pos, Direction direction) {
        BlockEntity currentBlockEntity = level.getBlockEntity(pos);
        if (currentBlockEntity instanceof FluidPipeBlockEntity fluidPipe
            && fluidPipe.getAttachmentManager().hasAttachment(direction)) {
            return false;
        }

        BlockState facingState = level.getBlockState(pos.relative(direction));
        BlockEntity facingBlockEntity = level.getBlockEntity(pos.relative(direction));

        if (facingBlockEntity instanceof FluidPipeBlockEntity fluidPipe
            && fluidPipe.getAttachmentManager().hasAttachment(direction.getOpposite())) {
            return false;
        }

        return facingState.getBlock() instanceof FluidPipeBlock fluidPipe
            && fluidPipe.getType() == type;
    }

    @Override
    protected boolean hasConnectionOrAttachment(BlockGetter level, BlockPos pos, Direction direction) {
        BlockEntity currentBlockEntity = level.getBlockEntity(pos);
        if (currentBlockEntity instanceof FluidPipeBlockEntity fluidPipe
            && fluidPipe.getAttachmentManager().hasAttachment(direction)) {
            return true;
        }

        BlockState facingState = level.getBlockState(pos.relative(direction));

        return facingState.getBlock() instanceof FluidPipeBlock fluidPipe
            && fluidPipe.getType() == type;
    }

    @Override
    protected boolean hasInvConnection(LevelAccessor level, BlockPos pos, Direction direction) {
        BlockEntity facingBlockEntity = level.getBlockEntity(pos.relative(direction));

        return facingBlockEntity != null
            && facingBlockEntity.getCapability(ForgeCapabilities.FLUID_HANDLER, direction.getOpposite()).isPresent();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new FluidPipeBlockEntity(pos, state, type);
    }
}
