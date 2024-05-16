package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.block.pipe.FluidPipeBlock;
import com.refinedmods.refinedpipes.network.pipe.fluid.FluidPipeType;
import com.refinedmods.refinedpipes.util.StringUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class FluidPipeBlockItem extends BaseBlockItem {
    private final FluidPipeType type;

    public FluidPipeBlockItem(RegistryObject<FluidPipeBlock> block) {
        super(block);

        this.type = block.get().getType();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(Component.translatable("misc.refinedpipes.tier", Component.translatable("enchantment.level." + type.getTier())).withStyle(ChatFormatting.YELLOW));

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.fluid_pipe.capacity",
            Component.literal(StringUtil.formatNumber(type.getCapacity()) + " mB").withStyle(ChatFormatting.WHITE)
        ).withStyle(ChatFormatting.GRAY));

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.fluid_pipe.transfer_rate",
            Component.literal(StringUtil.formatNumber(type.getTransferRate()) + " mB/t").withStyle(ChatFormatting.WHITE)
        ).withStyle(ChatFormatting.GRAY));
    }
}
