package com.refinedmods.refinedpipes.network.pipe;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipe;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeFactory;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipe;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeFactory;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipe;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeFactory;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class PipeTypes {

    public static PipeFactory get(ResourceLocation resourceLocation) {
        return FACTORY_REGISTRY.get().getValue(resourceLocation);
    }

    public static ResourceLocation getKey(PipeFactory condition) {
        return FACTORY_REGISTRY.get().getKey(condition);
    }

    public static final DeferredRegister<PipeFactory> FACTORIES = DeferredRegister.create(Pipes.Keys.PIPE_TYPE, Pipes.MODID);
    public static final Supplier<IForgeRegistry<PipeFactory>> FACTORY_REGISTRY = FACTORIES.makeRegistry(RegistryBuilder::new);

    public static final RegistryObject<PipeFactory> ITEM = FACTORIES.register(ItemPipe.ID.getPath(), ItemPipeFactory::new);
    public static final RegistryObject<PipeFactory> FLUID = FACTORIES.register(FluidPipe.ID.getPath(), FluidPipeFactory::new);
    public static final RegistryObject<PipeFactory> ENERGY = FACTORIES.register(EnergyPipe.ID.getPath(), EnergyPipeFactory::new);

}
