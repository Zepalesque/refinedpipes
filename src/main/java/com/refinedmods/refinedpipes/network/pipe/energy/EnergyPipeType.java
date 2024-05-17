package com.refinedmods.refinedpipes.network.pipe.energy;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.blockentity.PipesBlockEntities;
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
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicEnergyPipe().getCapacity();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedEnergyPipe().getCapacity();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedEnergyPipe().getCapacity();
            case ELITE -> Pipes.SERVER_CONFIG.getEliteEnergyPipe().getCapacity();
            case ULTIMATE -> Pipes.SERVER_CONFIG.getUltimateEnergyPipe().getCapacity();
        };
    }

    public int getTransferRate() {
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicEnergyPipe().getTransferRate();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedEnergyPipe().getTransferRate();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedEnergyPipe().getTransferRate();
            case ELITE -> Pipes.SERVER_CONFIG.getEliteEnergyPipe().getTransferRate();
            case ULTIMATE -> Pipes.SERVER_CONFIG.getUltimateEnergyPipe().getTransferRate();
        };
    }

    public ResourceLocation getId() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_energy_pipe");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_energy_pipe");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_energy_pipe");
            case ELITE -> new ResourceLocation(Pipes.MODID, "elite_energy_pipe");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "ultimate_energy_pipe");
        };
    }

    public ResourceLocation getNetworkType() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_energy_network");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_energy_network");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_energy_network");
            case ELITE -> new ResourceLocation(Pipes.MODID, "elite_energy_network");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "ultimate_energy_network");
        };
    }

    public BlockEntityType<EnergyPipeBlockEntity> getBlockEntityType() {
        return switch (this) {
            case BASIC -> PipesBlockEntities.BASIC_ENERGY_PIPE.get();
            case IMPROVED -> PipesBlockEntities.IMPROVED_ENERGY_PIPE.get();
            case ADVANCED -> PipesBlockEntities.ADVANCED_ENERGY_PIPE.get();
            case ELITE -> PipesBlockEntities.ELITE_ENERGY_PIPE.get();
            case ULTIMATE -> PipesBlockEntities.ULTIMATE_ENERGY_PIPE.get();
        };
    }
}
