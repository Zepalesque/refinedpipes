package com.refinedmods.refinedpipes.network.pipe.attachment.extractor;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public enum RedstoneMode {
    IGNORED,
    HIGH,
    LOW;

    public static RedstoneMode get(byte b) {
        RedstoneMode[] m = values();

        if (b < 0 || b >= m.length) {
            return IGNORED;
        }

        return m[b];
    }

    public boolean isEnabled(Level level, BlockPos pos) {
        return switch (this) {
            case IGNORED -> true;
            case HIGH -> level.hasNeighborSignal(pos);
            case LOW -> !level.hasNeighborSignal(pos);
        };
    }

    public RedstoneMode next() {
        return switch (this) {
            case IGNORED -> HIGH;
            case HIGH -> LOW;
            case LOW -> IGNORED;
        };
    }
}
