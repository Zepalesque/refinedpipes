package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.Pipes;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class BaseBlockItem extends BlockItem {
    public BaseBlockItem(RegistryObject<? extends Block> block) {
        super(block.get(), new Item.Properties());
    }
}
