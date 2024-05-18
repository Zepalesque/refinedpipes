package com.refinedmods.refinedpipes.setup;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.block.PipesBlocks;
import com.refinedmods.refinedpipes.container.PipesMenus;
import com.refinedmods.refinedpipes.blockentity.PipesBlockEntities;
import com.refinedmods.refinedpipes.network.pipe.attachment.AttachmentFactory;
import com.refinedmods.refinedpipes.network.pipe.attachment.Attachments;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.network.pipe.item.ItemPipeType;
import com.refinedmods.refinedpipes.render.FluidPipeBlockEntityRenderer;
import com.refinedmods.refinedpipes.render.ItemPipeBlockEntityRenderer;
import com.refinedmods.refinedpipes.render.PipeBakedModel;
import com.refinedmods.refinedpipes.screen.ExtractorAttachmentScreen;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public final class ClientSetup {
    private static final Logger LOGGER = LogManager.getLogger(ClientSetup.class);

    private ClientSetup() {
    }

    @SubscribeEvent
    public static void registerSpecialModels(ModelEvent.RegisterAdditional ev) {
        for (AttachmentFactory factory : Attachments.FACTORY_REGISTRY.get().getValues()) {
            LOGGER.debug("Registering attachment model {}", factory.getModelLocation());

            ev.register(factory.getModelLocation());
        }

        for (String type : new String[]{"item", "fluid", "energy"}) {
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/basic/core"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/basic/extension"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/basic/extension_inverted"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/basic/straight"));

            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/improved/core"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/improved/extension"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/improved/extension_inverted"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/improved/straight"));

            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/advanced/core"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/advanced/extension"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/advanced/extension_inverted"));
            ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/advanced/straight"));

            if (type.equals("fluid") || type.equals("energy")) {
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/elite/core"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/elite/extension"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/elite/extension_inverted"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/elite/straight"));

                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/ultimate/core"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/ultimate/extension"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/ultimate/extension_inverted"));
                ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/" + type + "/ultimate/straight"));
            }
        }

        ev.register(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment"));
    }

    @SubscribeEvent
    @SuppressWarnings("deprecation")
    public static void onClientSetup(FMLClientSetupEvent e) {
        // Backup, resource packs appear to not work normally with these
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.BASIC_ITEM_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.IMPROVED_ITEM_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.ADVANCED_ITEM_PIPE.get(), RenderType.cutout());

        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.BASIC_FLUID_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.IMPROVED_FLUID_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.ADVANCED_FLUID_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.ELITE_FLUID_PIPE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(PipesBlocks.ULTIMATE_FLUID_PIPE.get(), RenderType.cutout());


        MenuScreens.register(PipesMenus.EXTRACTOR_ATTACHMENT.get(), ExtractorAttachmentScreen::new);

        BlockEntityRenderers.register(PipesBlockEntities.BASIC_ITEM_PIPE.get(), ctx -> new ItemPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.IMPROVED_ITEM_PIPE.get(), ctx -> new ItemPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.ADVANCED_ITEM_PIPE.get(), ctx -> new ItemPipeBlockEntityRenderer());

        BlockEntityRenderers.register(PipesBlockEntities.BASIC_FLUID_PIPE.get(), ctx -> new FluidPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.IMPROVED_FLUID_PIPE.get(), ctx -> new FluidPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.ADVANCED_FLUID_PIPE.get(), ctx -> new FluidPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.ELITE_FLUID_PIPE.get(), ctx -> new FluidPipeBlockEntityRenderer());
        BlockEntityRenderers.register(PipesBlockEntities.ULTIMATE_FLUID_PIPE.get(), ctx -> new FluidPipeBlockEntityRenderer());
    }


    @SubscribeEvent
    public static void onModelBake(ModelEvent.ModifyBakingResult e) {
        Map<ResourceLocation, BakedModel> attachmentModels = new HashMap<>();

        for (AttachmentFactory factory : Attachments.FACTORY_REGISTRY.get().getValues()) {
            attachmentModels.put(factory.getId(), e.getModels().get(factory.getModelLocation()));
        }

        Map<ResourceLocation, PipeBakedModel> pipeModels = new HashMap<>();

        pipeModels.put(ItemPipeType.BASIC.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/basic/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/basic/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/basic/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/basic/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(ItemPipeType.IMPROVED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/improved/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/improved/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/improved/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/improved/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(ItemPipeType.ADVANCED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/advanced/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/advanced/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/advanced/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/item/advanced/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(FluidPipeType.BASIC.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/basic/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/basic/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/basic/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/basic/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(FluidPipeType.IMPROVED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/improved/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/improved/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/improved/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/improved/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(FluidPipeType.ADVANCED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/advanced/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/advanced/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/advanced/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/advanced/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(FluidPipeType.ELITE.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/elite/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/elite/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/elite/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/elite/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(FluidPipeType.ULTIMATE.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/ultimate/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/ultimate/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/ultimate/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/fluid/ultimate/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(EnergyPipeType.BASIC.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/basic/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/basic/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/basic/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/basic/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(EnergyPipeType.IMPROVED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/improved/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/improved/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/improved/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/improved/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(EnergyPipeType.ADVANCED.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/advanced/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/advanced/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/advanced/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/advanced/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(EnergyPipeType.ELITE.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/elite/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/elite/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/elite/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/elite/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));
        pipeModels.put(EnergyPipeType.ULTIMATE.getId(), new PipeBakedModel(
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/ultimate/core")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/ultimate/extension")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/ultimate/extension_inverted")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/energy/ultimate/straight")),
            e.getModels().get(new ResourceLocation(Pipes.MODID + ":block/pipe/attachment/inventory_attachment")),
            attachmentModels
        ));

        on: for (ResourceLocation id : e.getModels().keySet()) {
            for (Entry<ResourceLocation, PipeBakedModel> entry : pipeModels.entrySet()) {
                if (isPipeModel(id, entry.getKey())) {
                    e.getModels().put(id, entry.getValue());
                    continue on;
                }
            }
        }
    }

    private static boolean isPipeModel(ResourceLocation modelId, ResourceLocation pipeId) {
        return modelId instanceof ModelResourceLocation
            && modelId.getNamespace().equals(Pipes.MODID)
            && modelId.getPath().equals(pipeId.getPath())
            && !((ModelResourceLocation) modelId).getVariant().equals("inventory");
    }
}
