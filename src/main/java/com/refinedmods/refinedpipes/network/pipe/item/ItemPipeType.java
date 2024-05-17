package com.refinedmods.refinedpipes.network.pipe.item;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.blockentity.PipesBlockEntities;
import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public enum ItemPipeType {
    BASIC(1),
    IMPROVED(2),
    ADVANCED(3);

    private final int tier;

    ItemPipeType(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    public int getMaxTicksInPipe() {
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicItemPipe().getMaxTicks();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedItemPipe().getMaxTicks();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedItemPipe().getMaxTicks();
        };
    }

    public int getSpeedComparedToBasicTier() {
        int mySpeed = this == BASIC ? getMaxTicksInPipe() :
            (this == IMPROVED ? BASIC.getMaxTicksInPipe() + getMaxTicksInPipe() :
                (this == ADVANCED ? BASIC.getMaxTicksInPipe() + IMPROVED.getMaxTicksInPipe() + getMaxTicksInPipe() :
                    0));

        int speedOfBasicTier = BASIC.getMaxTicksInPipe();

        return (int) ((float) mySpeed / (float) speedOfBasicTier * 100F);
    }

    public BlockEntityType<ItemPipeBlockEntity> getBlockEntityType() {
        return switch (this) {
            case BASIC -> PipesBlockEntities.BASIC_ITEM_PIPE.get();
            case IMPROVED -> PipesBlockEntities.IMPROVED_ITEM_PIPE.get();
            case ADVANCED -> PipesBlockEntities.ADVANCED_ITEM_PIPE.get();
        };
    }

    public ResourceLocation getId() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_item_pipe");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_item_pipe");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_item_pipe");
        };
    }
}
