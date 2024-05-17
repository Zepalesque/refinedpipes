package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.network.pipe.attachment.Attachments;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PipesItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pipes.MODID);

    public static final RegistryObject<AttachmentItem> BASIC_EXTRACTOR_ATTACHMENT =
            ITEMS.register("basic_extractor_attachment", () -> new AttachmentItem(Attachments.BASIC));

    public static final RegistryObject<AttachmentItem> IMPROVED_EXTRACTOR_ATTACHMENT =
            ITEMS.register("improved_extractor_attachment", () -> new AttachmentItem(Attachments.IMPROVED));

    public static final RegistryObject<AttachmentItem> ADVANCED_EXTRACTOR_ATTACHMENT =
            ITEMS.register("advanced_extractor_attachment", () -> new AttachmentItem(Attachments.ADVANCED));

    public static final RegistryObject<AttachmentItem> ELITE_EXTRACTOR_ATTACHMENT =
            ITEMS.register("elite_extractor_attachment", () -> new AttachmentItem(Attachments.ELITE));

    public static final RegistryObject<AttachmentItem> ULTIMATE_EXTRACTOR_ATTACHMENT =
            ITEMS.register("ultimate_extractor_attachment", () -> new AttachmentItem(Attachments.ULTIMATE));

}
