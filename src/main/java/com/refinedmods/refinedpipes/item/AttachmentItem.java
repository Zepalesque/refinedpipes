package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.network.pipe.attachment.AttachmentFactory;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Supplier;

public class AttachmentItem extends Item {
    private final Lazy<AttachmentFactory> type;

    public AttachmentItem(Supplier<AttachmentFactory> type) {
        super(new Item.Properties());

        this.type = type::get;

//        this.setRegistryName(type.getItemId());
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        type.get().addInformation(tooltip);
    }

    public AttachmentFactory getFactory() {
        return type.get();
    }
}
