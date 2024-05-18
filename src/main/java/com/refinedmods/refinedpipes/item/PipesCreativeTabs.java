package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.block.PipesBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class PipesCreativeTabs {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Pipes.MODID);
    public static RegistryObject<CreativeModeTab> REFINED_PIPES = CREATIVE_TABS.register(Pipes.MODID, () ->
            CreativeModeTab.builder().icon(() -> new ItemStack(PipesBlocks.BASIC_ITEM_PIPE.get()))
                    .title(Component.translatable("itemGroup.refinedpipes")).displayItems((parameters, output) -> {
                        output.accept(PipesBlocks.BASIC_ITEM_PIPE.get());
                        output.accept(PipesBlocks.IMPROVED_ITEM_PIPE.get());
                        output.accept(PipesBlocks.ADVANCED_ITEM_PIPE.get());

                        output.accept(PipesBlocks.BASIC_FLUID_PIPE.get());
                        output.accept(PipesBlocks.IMPROVED_FLUID_PIPE.get());
                        output.accept(PipesBlocks.ADVANCED_FLUID_PIPE.get());
                        output.accept(PipesBlocks.ELITE_FLUID_PIPE.get());
                        output.accept(PipesBlocks.ULTIMATE_FLUID_PIPE.get());

                        output.accept(PipesBlocks.BASIC_ENERGY_PIPE.get());
                        output.accept(PipesBlocks.IMPROVED_ENERGY_PIPE.get());
                        output.accept(PipesBlocks.ADVANCED_ENERGY_PIPE.get());
                        output.accept(PipesBlocks.ELITE_ENERGY_PIPE.get());
                        output.accept(PipesBlocks.ULTIMATE_ENERGY_PIPE.get());

                        output.accept(PipesItems.BASIC_EXTRACTOR_ATTACHMENT.get());
                        output.accept(PipesItems.IMPROVED_EXTRACTOR_ATTACHMENT.get());
                        output.accept(PipesItems.ADVANCED_EXTRACTOR_ATTACHMENT.get());
                        output.accept(PipesItems.ELITE_EXTRACTOR_ATTACHMENT.get());
                        output.accept(PipesItems.ULTIMATE_EXTRACTOR_ATTACHMENT.get());
                    }).build());
}
