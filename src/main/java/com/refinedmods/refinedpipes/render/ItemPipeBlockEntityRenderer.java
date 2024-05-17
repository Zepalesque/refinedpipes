package com.refinedmods.refinedpipes.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import com.refinedmods.refinedpipes.blockentity.ItemPipeBlockEntity;
import com.refinedmods.refinedpipes.network.pipe.transport.ItemTransportProps;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;

public class ItemPipeBlockEntityRenderer implements BlockEntityRenderer<ItemPipeBlockEntity> {
    @Override
    @SuppressWarnings("deprecation")
    public void render(ItemPipeBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource bufferType, int combinedLight, int combinedOverlay) {
        for (ItemTransportProps prop : blockEntity.getProps()) {
            Direction dir = prop.getDirection();

            double pipeLength = 1D;

            if (prop.isFirstPipe()) {
                pipeLength = 1.25D; // Every transport starts in the center to go to the next center. But for the first pipe we start from the beginning, so it's a bit longer.
                // [X][X][X]
                // X = A center
                // []= The pipe casing
                // For the first pipe we start at [, not X. So hence the 1.5
            }

            if (prop.isLastPipe()) {
                pipeLength = 0.25D; // Every transport starts in the center to go to the next center. But for the last pipe we only want to go to the end part, not the "next" center.
                // [X][X][Y]</>
                // X/Y= A center
                // [] = The pipe casing
                // For the last pipe we start at Y, and go to ]. We don't want to go to /.
            }

            double maxTicksInPipe = (double) prop.getMaxTicksInPipe() * pipeLength;

            double v = (((double) prop.getProgress() + partialTicks) / maxTicksInPipe) * pipeLength;

            if (prop.isFirstPipe() && v < 0.25) {
                dir = prop.getInitialDirection(); // Get the item out first
            }

            if (prop.isFirstPipe()) {
                v -= 0.25D; // Every transport starts in the center. For the first pipe, we want to start from the beginning. Remove the centering.
            }

            // If the next pipe is gone..
            if (v > 0.25 && blockEntity.getLevel().isEmptyBlock(blockEntity.getBlockPos().relative(prop.getDirection()))) {
                continue;
            }

            v = Math.min(1F, v);

            poseStack.pushPose();

            poseStack.translate(
                0.5 + (dir.getStepX() * v),
                0.5 + (dir.getStepY() * v),
                0.5 + (dir.getStepZ() * v)
            );
            poseStack.mulPose(Axis.YP.rotation((float) ((Minecraft.getInstance().level.getGameTime() / 25D) % (Math.PI * 2) + (partialTicks / 25D))));
            poseStack.scale(0.5F, 0.5F, 0.5F);

            Minecraft.getInstance().getItemRenderer().renderStatic(
                prop.getStack(),
                    ItemDisplayContext.FIXED,
                combinedLight,
                combinedOverlay,
                poseStack,
                bufferType,
                blockEntity.getLevel(),
                0
            );

            poseStack.popPose();
        }
    }
}
