package com.refinedmods.refinedpipes.item.creativetab;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.PipesItems;
import com.refinedmods.refinedpipes.block.PipesBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class MainCreativeModeTab extends CreativeModeTab {
    public MainCreativeModeTab() {
        super(Pipes.ID);
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(PipesBlocks.BASIC_ITEM_PIPE.get());
    }
}
