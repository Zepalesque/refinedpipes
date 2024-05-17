package com.refinedmods.refinedpipes.network.pipe.attachment.extractor;

public enum RoutingMode {
    NEAREST,
    FURTHEST,
    RANDOM,
    ROUND_ROBIN;

    public static RoutingMode get(byte b) {
        RoutingMode[] m = values();

        if (b < 0 || b >= m.length) {
            return NEAREST;
        }

        return m[b];
    }

    public RoutingMode next() {
        return switch (this) {
            case NEAREST -> FURTHEST;
            case FURTHEST -> RANDOM;
            case RANDOM -> ROUND_ROBIN;
            default -> NEAREST;
        };
    }
}
