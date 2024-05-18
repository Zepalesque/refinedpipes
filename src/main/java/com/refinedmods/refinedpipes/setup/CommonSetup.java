package com.refinedmods.refinedpipes.setup;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.block.PipesBlocks;
import com.refinedmods.refinedpipes.blockentity.EnergyPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.FluidPipeBlockEntity;
import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import com.refinedmods.refinedpipes.container.factory.ExtractorAttachmentContainerFactory;
import com.refinedmods.refinedpipes.network.NetworkManager;
import com.refinedmods.refinedpipes.network.NetworkRegistry;
import com.refinedmods.refinedpipes.network.energy.EnergyNetworkFactory;
import com.refinedmods.refinedpipes.network.fluid.FluidNetworkFactory;
import com.refinedmods.refinedpipes.network.item.ItemNetwork;
import com.refinedmods.refinedpipes.network.item.ItemNetworkFactory;
import com.refinedmods.refinedpipes.network.pipe.PipeTypes;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipe;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeFactory;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipe;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeFactory;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipe;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeFactory;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeType;
import com.refinedmods.refinedpipes.network.pipe.transport.callback.ItemBounceBackTransportCallback;
import com.refinedmods.refinedpipes.network.pipe.transport.callback.ItemInsertTransportCallback;
import com.refinedmods.refinedpipes.network.pipe.transport.callback.ItemPipeGoneTransportCallback;
import com.refinedmods.refinedpipes.network.pipe.transport.callback.TransportCallbackFactoryRegistry;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.common.extensions.IForgeMenuType;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;

public final class CommonSetup {

    private CommonSetup() {
    }

    @SubscribeEvent
    public static void onConstructMod(FMLConstructModEvent e) {
        NetworkRegistry.INSTANCE.addFactory(ItemNetwork.TYPE, new ItemNetworkFactory());

        for (FluidPipeType pipeType : FluidPipeType.values()) {
            NetworkRegistry.INSTANCE.addFactory(pipeType.getNetworkType(), new FluidNetworkFactory(pipeType));
        }

        for (EnergyPipeType pipeType : EnergyPipeType.values()) {
            NetworkRegistry.INSTANCE.addFactory(pipeType.getNetworkType(), new EnergyNetworkFactory(pipeType));
        }

        TransportCallbackFactoryRegistry.INSTANCE.addFactory(ItemInsertTransportCallback.ID, ItemInsertTransportCallback::of);
        TransportCallbackFactoryRegistry.INSTANCE.addFactory(ItemBounceBackTransportCallback.ID, ItemBounceBackTransportCallback::of);
        TransportCallbackFactoryRegistry.INSTANCE.addFactory(ItemPipeGoneTransportCallback.ID, ItemPipeGoneTransportCallback::of);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent e) {
        Pipes.NETWORK.register();
    }

    @SubscribeEvent
    public static void onLevelTick(TickEvent.LevelTickEvent e) {
        if (!e.level.isClientSide && e.phase == TickEvent.Phase.END) {
            NetworkManager.get(e.level).getNetworks().forEach(n -> n.update(e.level));
        }
    }
}
