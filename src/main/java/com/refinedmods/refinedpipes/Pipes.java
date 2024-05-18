package com.refinedmods.refinedpipes;

import com.refinedmods.refinedpipes.block.PipesBlocks;
import com.refinedmods.refinedpipes.blockentity.PipesBlockEntities;
import com.refinedmods.refinedpipes.config.ServerConfig;
import com.refinedmods.refinedpipes.container.PipesMenus;
import com.refinedmods.refinedpipes.item.PipesItems;
import com.refinedmods.refinedpipes.message.PipesPacketHandler;
import com.refinedmods.refinedpipes.network.pipe.PipeFactory;
import com.refinedmods.refinedpipes.network.pipe.PipeTypes;
import com.refinedmods.refinedpipes.network.pipe.attachment.AttachmentFactory;
import com.refinedmods.refinedpipes.network.pipe.attachment.Attachments;
import com.refinedmods.refinedpipes.setup.ClientSetup;
import com.refinedmods.refinedpipes.setup.CommonSetup;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Pipes.MODID)
public class Pipes {
    public static final String MODID = "refinedpipes";
    public static final PipesPacketHandler NETWORK = new PipesPacketHandler();
    public static final ServerConfig SERVER_CONFIG = new ServerConfig();

    public Pipes() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> {
            bus.register(ClientSetup.class);
        });

        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, SERVER_CONFIG.getSpec());

        PipesBlocks.BLOCKS.register(bus);
        PipesItems.ITEMS.register(bus);
        PipesBlockEntities.BLOCK_ENTITIES.register(bus);
        Attachments.FACTORIES.register(bus);
        PipesMenus.MENU_TYPES.register(bus);
        PipeTypes.FACTORIES.register(bus);

        bus.addListener(CommonSetup::onConstructMod);
        bus.addListener(CommonSetup::onCommonSetup);

        MinecraftForge.EVENT_BUS.addListener(CommonSetup::onLevelTick);
    }

    public static class Keys {
        public static final ResourceKey<Registry<AttachmentFactory>> ATTACHMENT_FACTORY = ResourceKey.createRegistryKey(new ResourceLocation(MODID, "attatchment_factory"));
        public static final ResourceKey<Registry<PipeFactory>> PIPE_TYPE = ResourceKey.createRegistryKey(new ResourceLocation(MODID, "pipe_type"));

    }
}
