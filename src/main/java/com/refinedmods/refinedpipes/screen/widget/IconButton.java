package com.refinedmods.refinedpipes.screen.widget;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import com.refinedmods.refinedpipes.Pipes;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class IconButton extends Button {
    private static final ResourceLocation RESOURCE = new ResourceLocation(Pipes.MODID, "textures/gui/extractor_attachment.png");

    private final IconButtonPreset preset;
    private int overlayTexX;
    private int overlayTexY;

    public IconButton(int x, int y, IconButtonPreset preset, int overlayTexX, int overlayTexY, Component text, OnPress onPress) {
        super(Button.builder(text, onPress).pos(x, y).size(preset.getWidth(), preset.getHeight()));

        this.preset = preset;
        this.overlayTexX = overlayTexX;
        this.overlayTexY = overlayTexY;
    }

    public void setOverlayTexX(int overlayTexX) {
        this.overlayTexX = overlayTexX;
    }

    @Override
    protected void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, this.alpha);
        RenderSystem.enableBlend();
        RenderSystem.enableDepthTest();
        int y = preset.getYTexNormal();
        if (!active) {
            y = preset.getYTexDisabled();
        } else if (isHovered) {
            y = preset.getYTexHover();
        }
        guiGraphics.blit(RESOURCE, this.getX(), this.getY(), preset.getXTex(), y, this.width, this.height, 256, 256);

        // Fiddling with -1 to remove the blue border
        guiGraphics.blit(RESOURCE, this.getX() + 1, this.getY() + 1, overlayTexX + 1, overlayTexY + 1, this.width - 2, this.height - 2, 256, 256);
        guiGraphics.setColor(1.0F, 1.0F, 1.0F, 1.0F);

    }
}
