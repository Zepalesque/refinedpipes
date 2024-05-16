package com.refinedmods.refinedpipes;

import com.refinedmods.refinedpipes.item.AttachmentItem;
import com.refinedmods.refinedpipes.item.BaseBlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.registries.RegistryObject;

public class PipesItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Pipes.ID);


    public static final RegistryObject<AttachmentItem> BASIC_EXTRACTOR_ATTACHMENT =
            ITEMS.register("blueberry_pie", () -> new Item(new Item.Properties().food(ReduxFoods.BLUEBERRY_PIE)));



    @ObjectHolder(Pipes.ID + ":basic_extractor_attachment")
    public static final AttachmentItem BASIC_EXTRACTOR_ATTACHMENT = null;
    @ObjectHolder(Pipes.ID + ":improved_extractor_attachment")
    public static final AttachmentItem IMPROVED_EXTRACTOR_ATTACHMENT = null;
    @ObjectHolder(Pipes.ID + ":advanced_extractor_attachment")
    public static final AttachmentItem ADVANCED_EXTRACTOR_ATTACHMENT = null;
    @ObjectHolder(Pipes.ID + ":elite_extractor_attachment")
    public static final AttachmentItem ELITE_EXTRACTOR_ATTACHMENT = null;
    @ObjectHolder(Pipes.ID + ":ultimate_extractor_attachment")
    public static final AttachmentItem ULTIMATE_EXTRACTOR_ATTACHMENT = null;
}
