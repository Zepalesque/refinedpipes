package com.refinedmods.refinedpipes.item;

import com.refinedmods.refinedpipes.block.pipe.EnergyPipeBlock;
import com.refinedmods.refinedpipes.network.pipe.energy.EnergyPipeType;
import com.refinedmods.refinedpipes.util.StringUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.List;

public class EnergyPipeBlockItem extends BaseBlockItem {
    private final EnergyPipeType type;

    public EnergyPipeBlockItem(RegistryObject<EnergyPipeBlock> block) {
        super(block);

        this.type = block.get().getType();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltip, TooltipFlag flag) {
        super.appendHoverText(stack, level, tooltip, flag);

        tooltip.add(Component.translatable("misc.refinedpipes.tier", Component.translatable("enchantment.level." + type.getTier())).withStyle(ChatFormatting.YELLOW));

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.energy_pipe.capacity",
            Component.literal(StringUtil.formatNumber(type.getCapacity()) + " FE").withStyle(ChatFormatting.WHITE)
        ).withStyle(ChatFormatting.GRAY));

        tooltip.add(Component.translatable(
            "tooltip.refinedpipes.energy_pipe.transfer_rate",
            Component.literal(StringUtil.formatNumber(type.getTransferRate()) + " FE/t").withStyle(ChatFormatting.WHITE)
        ).withStyle(ChatFormatting.GRAY));
    }
}
