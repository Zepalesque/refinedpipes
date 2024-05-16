package com.refinedmods.refinedpipes.network.pipe.energy;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.RefinedPipesBlockEntities;
import com.refinedmods.refinedpipes.blockentity.EnergyPipeBlockEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntityType;

public enum EnergyPipeType {
    BASIC(1),
    IMPROVED(2),
    ADVANCED(3),
    ELITE(4),
    ULTIMATE(5);

    private final int tier;

    EnergyPipeType(int tier) {
        this.tier = tier;
    }

    public int getTier() {
        return tier;
    }

    public int getCapacity() {
        switch (this) {
            case BASIC:
                return Pipes.SERVER_CONFIG.getBasicEnergyPipe().getCapacity();
            case IMPROVED:
                return Pipes.SERVER_CONFIG.getImprovedEnergyPipe().getCapacity();
            case ADVANCED:
                return Pipes.SERVER_CONFIG.getAdvancedEnergyPipe().getCapacity();
            case ELITE:
                return Pipes.SERVER_CONFIG.getEliteEnergyPipe().getCapacity();
            case ULTIMATE:
                return Pipes.SERVER_CONFIG.getUltimateEnergyPipe().getCapacity();
            default:
                throw new RuntimeException("?");
        }
    }

    public int getTransferRate() {
        switch (this) {
            case BASIC:
                return Pipes.SERVER_CONFIG.getBasicEnergyPipe().getTransferRate();
            case IMPROVED:
                return Pipes.SERVER_CONFIG.getImprovedEnergyPipe().getTransferRate();
            case ADVANCED:
                return Pipes.SERVER_CONFIG.getAdvancedEnergyPipe().getTransferRate();
            case ELITE:
                return Pipes.SERVER_CONFIG.getEliteEnergyPipe().getTransferRate();
            case ULTIMATE:
                return Pipes.SERVER_CONFIG.getUltimateEnergyPipe().getTransferRate();
            default:
                throw new RuntimeException("?");
        }
    }

    public ResourceLocation getId() {
        switch (this) {
            case BASIC:
                return new ResourceLocation(Pipes.ID, "basic_energy_pipe");
            case IMPROVED:
                return new ResourceLocation(Pipes.ID, "improved_energy_pipe");
            case ADVANCED:
                return new ResourceLocation(Pipes.ID, "advanced_energy_pipe");
            case ELITE:
                return new ResourceLocation(Pipes.ID, "elite_energy_pipe");
            case ULTIMATE:
                return new ResourceLocation(Pipes.ID, "ultimate_energy_pipe");
            default:
                throw new RuntimeException("?");
        }
    }

    public ResourceLocation getNetworkType() {
        switch (this) {
            case BASIC:
                return new ResourceLocation(Pipes.ID, "basic_energy_network");
            case IMPROVED:
                return new ResourceLocation(Pipes.ID, "improved_energy_network");
            case ADVANCED:
                return new ResourceLocation(Pipes.ID, "advanced_energy_network");
            case ELITE:
                return new ResourceLocation(Pipes.ID, "elite_energy_network");
            case ULTIMATE:
                return new ResourceLocation(Pipes.ID, "ultimate_energy_network");
            default:
                throw new RuntimeException("?");
        }
    }

    public BlockEntityType<EnergyPipeBlockEntity> getBlockEntityType() {
        switch (this) {
            case BASIC:
                return RefinedPipesBlockEntities.BASIC_ENERGY_PIPE;
            case IMPROVED:
                return RefinedPipesBlockEntities.IMPROVED_ENERGY_PIPE;
            case ADVANCED:
                return RefinedPipesBlockEntities.ADVANCED_ENERGY_PIPE;
            case ELITE:
                return RefinedPipesBlockEntities.ELITE_ENERGY_PIPE;
            case ULTIMATE:
                return RefinedPipesBlockEntities.ULTIMATE_ENERGY_PIPE;
            default:
                throw new RuntimeException("?");
        }
    }
}
