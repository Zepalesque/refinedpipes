package com.refinedmods.refinedpipes.network.pipe.attachment.extractor;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.item.PipesItems;
import com.refinedmods.refinedpipes.config.ServerConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.RegistryObject;

public enum ExtractorAttachmentType {
    BASIC(1),
    IMPROVED(2),
    ADVANCED(3),
    ELITE(4),
    ULTIMATE(5);

    private final int tier;

    ExtractorAttachmentType(int tier) {
        this.tier = tier;
    }

    public static ExtractorAttachmentType get(byte b) {
        ExtractorAttachmentType[] v = values();

        if (b < 0 || b >= v.length) {
            return BASIC;
        }

        return v[b];
    }

    public int getTier() {
        return tier;
    }

    int getItemTickInterval() {
        return getConfig().getItemTickInterval();
    }

    int getFluidTickInterval() {
        return getConfig().getFluidTickInterval();
    }

    public int getItemsToExtract() {
        return getConfig().getItemsToExtract();
    }

    int getFluidsToExtract() {
        return getConfig().getFluidsToExtract();
    }

    public int getFilterSlots() {
        return getConfig().getFilterSlots();
    }

    public boolean getCanSetRedstoneMode() {
        return getConfig().getCanSetRedstoneMode();
    }

    public boolean getCanSetWhitelistBlacklist() {
        return getConfig().getCanSetWhitelistBlacklist();
    }

    public boolean getCanSetRoutingMode() {
        return getConfig().getCanSetRoutingMode();
    }

    public boolean getCanSetExactMode() {
        return getConfig().getCanSetExactMode();
    }

    private ServerConfig.ExtractorAttachment getConfig() {
        return switch (this) {
            case BASIC -> Pipes.SERVER_CONFIG.getBasicExtractorAttachment();
            case IMPROVED -> Pipes.SERVER_CONFIG.getImprovedExtractorAttachment();
            case ADVANCED -> Pipes.SERVER_CONFIG.getAdvancedExtractorAttachment();
            case ELITE -> Pipes.SERVER_CONFIG.getEliteExtractorAttachment();
            case ULTIMATE -> Pipes.SERVER_CONFIG.getUltimateExtractorAttachment();
        };
    }

    public ResourceLocation getId() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "basic_extractor");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "improved_extractor");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "advanced_extractor");
            case ELITE -> new ResourceLocation(Pipes.MODID, "elite_extractor");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "ultimate_extractor");
        };
    }

    RegistryObject<? extends ItemLike> getItem() {
        return switch (this) {
            case BASIC -> PipesItems.BASIC_EXTRACTOR_ATTACHMENT;
            case IMPROVED -> PipesItems.IMPROVED_EXTRACTOR_ATTACHMENT;
            case ADVANCED -> PipesItems.ADVANCED_EXTRACTOR_ATTACHMENT;
            case ELITE -> PipesItems.ELITE_EXTRACTOR_ATTACHMENT;
            case ULTIMATE -> PipesItems.ULTIMATE_EXTRACTOR_ATTACHMENT;
        };
    }

    ResourceLocation getModelLocation() {
        return switch (this) {
            case BASIC -> new ResourceLocation(Pipes.MODID, "block/pipe/attachment/extractor/basic");
            case IMPROVED -> new ResourceLocation(Pipes.MODID, "block/pipe/attachment/extractor/improved");
            case ADVANCED -> new ResourceLocation(Pipes.MODID, "block/pipe/attachment/extractor/advanced");
            case ELITE -> new ResourceLocation(Pipes.MODID, "block/pipe/attachment/extractor/elite");
            case ULTIMATE -> new ResourceLocation(Pipes.MODID, "block/pipe/attachment/extractor/ultimate");
        };
    }
}
