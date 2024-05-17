package com.refinedmods.refinedpipes.network.pipe.fluid;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.blockentity.PipesBlockEntities;
import com.refinedmods.refinedpipes.blockentity.FluidPipeBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public enum FluidPipeType {
    BASIC(1),
    IMPROVED(2),
    ADVANCED(3),
    ELITE(4),
    ULTIMATE(5);

    private final int tier;

    FluidPipeType(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    public BlockEntityType<FluidPipeBlockEntity> getBlockEntityType() {
        return switch (this) {
            case BASIC -> PipesBlockEntities.BASIC_FLUID_PIPE.get();
            case IMPROVED -> PipesBlockEntities.IMPROVED_FLUID_PIPE.get();
            case ADVANCED -> PipesBlockEntities.ADVANCED_FLUID_PIPE.get();
            case ELITE -> PipesBlockEntities.ELITE_FLUID_PIPE.get();
            case ULTIMATE -> PipesBlockEntities.ULTIMATE_FLUID_PIPE.get();
        };
    }

    public int getCapacity() {
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicFluidPipe().getCapacity();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedFluidPipe().getCapacity();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedFluidPipe().getCapacity();
            case ELITE -> Pipes.SERVER_CONFIG.getEliteFluidPipe().getCapacity();
            case ULTIMATE -> Pipes.SERVER_CONFIG.getUltimateFluidPipe().getCapacity();
        };
    }

    public int getTransferRate() {
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicFluidPipe().getTransferRate();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedFluidPipe().getTransferRate();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedFluidPipe().getTransferRate();
            case ELITE -> Pipes.SERVER_CONFIG.getEliteFluidPipe().getTransferRate();
            case ULTIMATE -> Pipes.SERVER_CONFIG.getUltimateFluidPipe().getTransferRate();
        };
    }

    public ResourceLocation getId() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_fluid_pipe");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_fluid_pipe");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_fluid_pipe");
            case ELITE -> new ResourceLocation(Pipes.MODID, "elite_fluid_pipe");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "ultimate_fluid_pipe");
        };
    }

    public ResourceLocation getNetworkType() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_fluid_network");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_fluid_network");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_fluid_network");
            case ELITE -> new ResourceLocation(Pipes.MODID, "elite_fluid_network");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "ultimate_fluid_network");
        };
    }
}
