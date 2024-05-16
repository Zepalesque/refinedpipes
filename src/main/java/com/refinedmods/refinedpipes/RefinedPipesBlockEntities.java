package com.refinedmods.refinedpipes;

import com.refinedmods.refinedpipes.blockentity.EnergyPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.FluidPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.ObjectHolder;

public class RefinedPipesBlockEntities {
    @ObjectHolder(Pipes.ID + ":basic_item_pipe")
    public static final BlockEntityType<ItemPipeBlockEntity> BASIC_ITEM_PIPE = null;
    @ObjectHolder(Pipes.ID + ":improved_item_pipe")
    public static final BlockEntityType<ItemPipeBlockEntity> IMPROVED_ITEM_PIPE = null;
    @ObjectHolder(Pipes.ID + ":advanced_item_pipe")
    public static final BlockEntityType<ItemPipeBlockEntity> ADVANCED_ITEM_PIPE = null;
    @ObjectHolder(Pipes.ID + ":basic_fluid_pipe")
    public static final BlockEntityType<FluidPipeBlockEntity> BASIC_FLUID_PIPE = null;
    @ObjectHolder(Pipes.ID + ":improved_fluid_pipe")
    public static final BlockEntityType<FluidPipeBlockEntity> IMPROVED_FLUID_PIPE = null;
    @ObjectHolder(Pipes.ID + ":advanced_fluid_pipe")
    public static final BlockEntityType<FluidPipeBlockEntity> ADVANCED_FLUID_PIPE = null;
    @ObjectHolder(Pipes.ID + ":elite_fluid_pipe")
    public static final BlockEntityType<FluidPipeBlockEntity> ELITE_FLUID_PIPE = null;
    @ObjectHolder(Pipes.ID + ":ultimate_fluid_pipe")
    public static final BlockEntityType<FluidPipeBlockEntity> ULTIMATE_FLUID_PIPE = null;
    @ObjectHolder(Pipes.ID + ":basic_energy_pipe")
    public static final BlockEntityType<EnergyPipeBlockEntity> BASIC_ENERGY_PIPE = null;
    @ObjectHolder(Pipes.ID + ":improved_energy_pipe")
    public static final BlockEntityType<EnergyPipeBlockEntity> IMPROVED_ENERGY_PIPE = null;
    @ObjectHolder(Pipes.ID + ":advanced_energy_pipe")
    public static final BlockEntityType<EnergyPipeBlockEntity> ADVANCED_ENERGY_PIPE = null;
    @ObjectHolder(Pipes.ID + ":elite_energy_pipe")
    public static final BlockEntityType<EnergyPipeBlockEntity> ELITE_ENERGY_PIPE = null;
    @ObjectHolder(Pipes.ID + ":ultimate_energy_pipe")
    public static final BlockEntityType<EnergyPipeBlockEntity> ULTIMATE_ENERGY_PIPE = null;
}
