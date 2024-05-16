package com.refinedmods.refinedpipes.network.pipe.fluid;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.RefinedPipesBlockEntities;
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
        switch (this) {
            case BASIC:
                return RefinedPipesBlockEntities.BASIC_FLUID_PIPE;
            case IMPROVED:
                return RefinedPipesBlockEntities.IMPROVED_FLUID_PIPE;
            case ADVANCED:
                return RefinedPipesBlockEntities.ADVANCED_FLUID_PIPE;
            case ELITE:
                return RefinedPipesBlockEntities.ELITE_FLUID_PIPE;
            case ULTIMATE:
                return RefinedPipesBlockEntities.ULTIMATE_FLUID_PIPE;
            default:
                throw new RuntimeException("?");
        }
    }

    public int getCapacity() {
        switch (this) {
            case BASIC:
                return Pipes.SERVER_CONFIG.getBasicFluidPipe().getCapacity();
            case IMPROVED:
                return Pipes.SERVER_CONFIG.getImprovedFluidPipe().getCapacity();
            case ADVANCED:
                return Pipes.SERVER_CONFIG.getAdvancedFluidPipe().getCapacity();
            case ELITE:
                return Pipes.SERVER_CONFIG.getEliteFluidPipe().getCapacity();
            case ULTIMATE:
                return Pipes.SERVER_CONFIG.getUltimateFluidPipe().getCapacity();
            default:
                throw new RuntimeException("?");
        }
    }

    public int getTransferRate() {
        switch (this) {
            case BASIC:
                return Pipes.SERVER_CONFIG.getBasicFluidPipe().getTransferRate();
            case IMPROVED:
                return Pipes.SERVER_CONFIG.getImprovedFluidPipe().getTransferRate();
            case ADVANCED:
                return Pipes.SERVER_CONFIG.getAdvancedFluidPipe().getTransferRate();
            case ELITE:
                return Pipes.SERVER_CONFIG.getEliteFluidPipe().getTransferRate();
            case ULTIMATE:
                return Pipes.SERVER_CONFIG.getUltimateFluidPipe().getTransferRate();
            default:
                throw new RuntimeException("?");
        }
    }

    public ResourceLocation getId() {
        switch (this) {
            case BASIC:
                return new ResourceLocation(Pipes.ID, "basic_fluid_pipe");
            case IMPROVED:
                return new ResourceLocation(Pipes.ID, "improved_fluid_pipe");
            case ADVANCED:
                return new ResourceLocation(Pipes.ID, "advanced_fluid_pipe");
            case ELITE:
                return new ResourceLocation(Pipes.ID, "elite_fluid_pipe");
            case ULTIMATE:
                return new ResourceLocation(Pipes.ID, "ultimate_fluid_pipe");
            default:
                throw new RuntimeException("?");
        }
    }

    public ResourceLocation getNetworkType() {
        switch (this) {
            case BASIC:
                return new ResourceLocation(Pipes.ID, "basic_fluid_network");
            case IMPROVED:
                return new ResourceLocation(Pipes.ID, "improved_fluid_network");
            case ADVANCED:
                return new ResourceLocation(Pipes.ID, "advanced_fluid_network");
            case ELITE:
                return new ResourceLocation(Pipes.ID, "elite_fluid_network");
            case ULTIMATE:
                return new ResourceLocation(Pipes.ID, "ultimate_fluid_network");
            default:
                throw new RuntimeException("?");
        }
    }
}
