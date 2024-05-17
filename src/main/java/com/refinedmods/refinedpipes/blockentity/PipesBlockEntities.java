package com.refinedmods.refinedpipes.blockentity;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.block.PipesBlocks;
import com.refinedmods.refinedpipes.blockentity.EnergyPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.FluidPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PipesBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Pipes.MODID);

    public static final RegistryObject<BlockEntityType<ItemPipeBlockEntity>> BASIC_ITEM_PIPE = BLOCK_ENTITIES.register(ItemPipeType.BASIC.getId().getPath(), () -> BlockEntityType.Builder.<ItemPipeBlockEntity>of((pos, state) -> new ItemPipeBlockEntity(pos, state, ItemPipeType.BASIC), PipesBlocks.BASIC_ITEM_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ItemPipeBlockEntity>> IMPROVED_ITEM_PIPE = BLOCK_ENTITIES.register(ItemPipeType.IMPROVED.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new ItemPipeBlockEntity(pos, state, ItemPipeType.IMPROVED), PipesBlocks.IMPROVED_ITEM_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<ItemPipeBlockEntity>> ADVANCED_ITEM_PIPE = BLOCK_ENTITIES.register(ItemPipeType.ADVANCED.getId().getPath(), () ->BlockEntityType.Builder.<ItemPipeBlockEntity>of((pos, state) -> new ItemPipeBlockEntity(pos, state, ItemPipeType.ADVANCED), PipesBlocks.ADVANCED_ITEM_PIPE.get()).build(null));

    public static final RegistryObject<BlockEntityType<FluidPipeBlockEntity>> BASIC_FLUID_PIPE = BLOCK_ENTITIES.register(FluidPipeType.BASIC.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new FluidPipeBlockEntity(pos, state, FluidPipeType.BASIC), PipesBlocks.BASIC_FLUID_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<FluidPipeBlockEntity>> IMPROVED_FLUID_PIPE = BLOCK_ENTITIES.register(FluidPipeType.IMPROVED.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new FluidPipeBlockEntity(pos, state, FluidPipeType.IMPROVED), PipesBlocks.IMPROVED_FLUID_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<FluidPipeBlockEntity>> ADVANCED_FLUID_PIPE = BLOCK_ENTITIES.register(FluidPipeType.ADVANCED.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new FluidPipeBlockEntity(pos, state, FluidPipeType.ADVANCED), PipesBlocks.ADVANCED_FLUID_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<FluidPipeBlockEntity>> ELITE_FLUID_PIPE = BLOCK_ENTITIES.register(FluidPipeType.ELITE.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new FluidPipeBlockEntity(pos, state, FluidPipeType.ELITE), PipesBlocks.ELITE_FLUID_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<FluidPipeBlockEntity>> ULTIMATE_FLUID_PIPE = BLOCK_ENTITIES.register(FluidPipeType.ULTIMATE.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new FluidPipeBlockEntity(pos, state, FluidPipeType.ULTIMATE), PipesBlocks.ULTIMATE_FLUID_PIPE.get()).build(null));

    public static final RegistryObject<BlockEntityType<EnergyPipeBlockEntity>> BASIC_ENERGY_PIPE = BLOCK_ENTITIES.register(EnergyPipeType.BASIC.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new EnergyPipeBlockEntity(pos, state, EnergyPipeType.BASIC), PipesBlocks.BASIC_ENERGY_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyPipeBlockEntity>> IMPROVED_ENERGY_PIPE = BLOCK_ENTITIES.register(EnergyPipeType.IMPROVED.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new EnergyPipeBlockEntity(pos, state, EnergyPipeType.IMPROVED), PipesBlocks.IMPROVED_ENERGY_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyPipeBlockEntity>> ADVANCED_ENERGY_PIPE = BLOCK_ENTITIES.register(EnergyPipeType.ADVANCED.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new EnergyPipeBlockEntity(pos, state, EnergyPipeType.ADVANCED), PipesBlocks.ADVANCED_ENERGY_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyPipeBlockEntity>> ELITE_ENERGY_PIPE = BLOCK_ENTITIES.register(EnergyPipeType.ELITE.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new EnergyPipeBlockEntity(pos, state, EnergyPipeType.ELITE), PipesBlocks.ELITE_ENERGY_PIPE.get()).build(null));
    public static final RegistryObject<BlockEntityType<EnergyPipeBlockEntity>> ULTIMATE_ENERGY_PIPE = BLOCK_ENTITIES.register(EnergyPipeType.ULTIMATE.getId().getPath(), () ->BlockEntityType.Builder.of((pos, state) -> new EnergyPipeBlockEntity(pos, state, EnergyPipeType.ULTIMATE), PipesBlocks.ULTIMATE_ENERGY_PIPE.get()).build(null));


}
