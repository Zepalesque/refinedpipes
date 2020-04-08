package com.raoulvdberge.refinedpipes.message;

import com.raoulvdberge.refinedpipes.network.NetworkManager;
import com.raoulvdberge.refinedpipes.network.pipe.attachment.Attachment;
import com.raoulvdberge.refinedpipes.network.pipe.attachment.extractor.ExtractorAttachment;
import com.raoulvdberge.refinedpipes.network.pipe.attachment.extractor.RedstoneMode;
import com.raoulvdberge.refinedpipes.tile.PipeTileEntity;
import com.raoulvdberge.refinedpipes.util.DirectionUtil;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class ChangeRedstoneModeMessage {
    private final BlockPos pos;
    private final Direction direction;
    private final RedstoneMode redstoneMode;

    public ChangeRedstoneModeMessage(BlockPos pos, Direction direction, RedstoneMode redstoneMode) {
        this.pos = pos;
        this.direction = direction;
        this.redstoneMode = redstoneMode;
    }

    public static void encode(ChangeRedstoneModeMessage message, PacketBuffer buf) {
        buf.writeBlockPos(message.pos);
        buf.writeByte(message.direction.ordinal());
        buf.writeByte(message.redstoneMode.ordinal());
    }

    public static ChangeRedstoneModeMessage decode(PacketBuffer buf) {
        BlockPos pos = buf.readBlockPos();
        Direction direction = DirectionUtil.safeGet(buf.readByte());
        RedstoneMode redstoneMode = RedstoneMode.get(buf.readByte());

        return new ChangeRedstoneModeMessage(pos, direction, redstoneMode);
    }

    public static void handle(ChangeRedstoneModeMessage message, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            TileEntity tile = ctx.get().getSender().world.getTileEntity(message.pos);

            if (tile instanceof PipeTileEntity) {
                Attachment attachment = ((PipeTileEntity) tile).getAttachmentManager().getAttachment(message.direction);

                if (attachment instanceof ExtractorAttachment) {
                    ((ExtractorAttachment) attachment).setRedstoneMode(message.redstoneMode);

                    NetworkManager.get(tile.getWorld()).markDirty();
                }
            }
        });

        ctx.get().setPacketHandled(true);
    }

}
