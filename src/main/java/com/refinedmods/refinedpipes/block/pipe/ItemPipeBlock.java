package com.refinedmods.refinedpipes.block.pipe;

import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeType;
import com.refinedmods.refinedpipes.network.pipe.shape.PipeShapeCache;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import org.jetbrains.annotations.Nullable;

public class ItemPipeBlock extends PipeBlock implements EntityBlock {
    private final ItemPipeType type;

    public ItemPipeBlock(PipeShapeCache shapeCache, ItemPipeType type) {
        super(shapeCache);

        this.type = type;
    }

    public ItemPipeType getType() {
        return type;
    }

    @Override
    protected boolean hasConnection(BlockGetter world, BlockPos pos, Direction direction) {
        BlockEntity currentBlockEntity = world.getBlockEntity(pos);
        if (currentBlockEntity instanceof ItemPipeBlockEntity itemPipe
            && itemPipe.getAttachmentManager().hasAttachment(direction)) {
            return false;
        }

        BlockState facingState = world.getBlockState(pos.relative(direction));
        BlockEntity facingBlockEntity = world.getBlockEntity(pos.relative(direction));

        if (facingBlockEntity instanceof ItemPipeBlockEntity itemPipe
            && itemPipe.getAttachmentManager().hasAttachment(direction.getOpposite())) {
            return false;
        }

        return facingState.getBlock() instanceof ItemPipeBlock;
    }

    @Override
    protected boolean hasConnectionOrAttachment(BlockGetter world, BlockPos pos, Direction direction) {
        BlockEntity currentBlockEntity = world.getBlockEntity(pos);
        if (currentBlockEntity instanceof ItemPipeBlockEntity itemPipe
            && itemPipe.getAttachmentManager().hasAttachment(direction)) {
            return true;
        }

        BlockState facingState = world.getBlockState(pos.relative(direction));

        return facingState.getBlock() instanceof ItemPipeBlock;
    }

    @Override
    protected boolean hasInvConnection(LevelAccessor world, BlockPos pos, Direction direction) {
        BlockEntity facingBlockEntity = world.getBlockEntity(pos.relative(direction));

        return facingBlockEntity != null
            && facingBlockEntity.getCapability(ForgeCapabilities.ITEM_HANDLER, direction.getOpposite()).isPresent();
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ItemPipeBlockEntity(pos, state, type);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? (levelTicker, pos, stateTicker, blockEntity) -> ItemPipeBlockEntity.tick((ItemPipeBlockEntity) blockEntity) : null;
    }
}
