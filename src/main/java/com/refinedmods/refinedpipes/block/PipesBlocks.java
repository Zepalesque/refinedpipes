package com.refinedmods.refinedpipes.block;

import com.google.common.base.Supplier;
import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.PipesItems;
import com.refinedmods.refinedpipes.block.pipe.EnergyPipeBlock;
import com.refinedmods.refinedpipes.block.pipe.FluidPipeBlock;
import com.refinedmods.refinedpipes.block.pipe.ItemPipeBlock;
import com.refinedmods.refinedpipes.item.EnergyPipeBlockItem;
import com.refinedmods.refinedpipes.item.FluidPipeBlockItem;
import com.refinedmods.refinedpipes.item.ItemPipeBlockItem;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeType;
import com.refinedmods.refinedpipes.network.pipe.shape.PipeShapeCache;
import com.refinedmods.refinedpipes.network.pipe.shape.PipeShapeFactory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class PipesBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Pipes.ID);
    public static final DeferredRegister<Item> ITEMS = PipesItems.ITEMS;

    private static final PipeShapeCache PIPE_SHAPE_CACHE = new PipeShapeCache(new PipeShapeFactory());

    public static RegistryObject<ItemPipeBlock> BASIC_ITEM_PIPE = register("basic_item_pipe",
            () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.BASIC), ItemPipeBlockItem::new);

    public static RegistryObject<ItemPipeBlock> IMPROVED_ITEM_PIPE = register("improved_item_pipe",
            () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.IMPROVED), ItemPipeBlockItem::new);

    public static RegistryObject<ItemPipeBlock> ADVANCED_ITEM_PIPE = register("advanced_item_pipe",
            () -> new ItemPipeBlock(PIPE_SHAPE_CACHE, ItemPipeType.ADVANCED), ItemPipeBlockItem::new);

    public static RegistryObject<FluidPipeBlock> BASIC_FLUID_PIPE = register("basic_fluid_pipe",
            () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.BASIC), FluidPipeBlockItem::new);

    public static RegistryObject<FluidPipeBlock> IMPROVED_FLUID_PIPE = register("improved_fluid_pipe",
            () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.IMPROVED), FluidPipeBlockItem::new);

    public static RegistryObject<FluidPipeBlock> ADVANCED_FLUID_PIPE = register("advanced_fluid_pipe",
            () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ADVANCED), FluidPipeBlockItem::new);

    public static RegistryObject<FluidPipeBlock> ELITE_FLUID_PIPE = register("elite_fluid_pipe",
            () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ELITE), FluidPipeBlockItem::new);

    public static RegistryObject<FluidPipeBlock> ULTIMATE_FLUID_PIPE = register("ultimate_fluid_pipe",
            () -> new FluidPipeBlock(PIPE_SHAPE_CACHE, FluidPipeType.ULTIMATE), FluidPipeBlockItem::new);

    public static RegistryObject<EnergyPipeBlock> BASIC_ENERGY_PIPE = register("basic_energy_pipe",
            () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.BASIC), EnergyPipeBlockItem::new);


    public static RegistryObject<EnergyPipeBlock> IMPROVED_ENERGY_PIPE = register("improved_energy_pipe",
            () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.IMPROVED), EnergyPipeBlockItem::new);

    public static RegistryObject<EnergyPipeBlock> ADVANCED_ENERGY_PIPE = register("advanced_energy_pipe",
            () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ADVANCED), EnergyPipeBlockItem::new);

    public static RegistryObject<EnergyPipeBlock> ELITE_ENERGY_PIPE = register("elite_energy_pipe",
            () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ELITE), EnergyPipeBlockItem::new);

    public static RegistryObject<EnergyPipeBlock> ULTIMATE_ENERGY_PIPE = register("ultimate_energy_pipe",
            () -> new EnergyPipeBlock(PIPE_SHAPE_CACHE, EnergyPipeType.ULTIMATE), EnergyPipeBlockItem::new);

    private static <T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block, Function<RegistryObject<T>, Item> item) {
        RegistryObject<T> obj = PipesBlocks.BLOCKS.register(name, block);
        ITEMS.register(name, () -> item.apply(obj));
        return obj;
    }
}
