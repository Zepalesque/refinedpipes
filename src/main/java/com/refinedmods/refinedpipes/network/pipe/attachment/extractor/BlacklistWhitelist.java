package com.refinedmods.refinedpipes.network.pipe.attachment.extractor;

public enum BlacklistWhitelist {
    BLACKLIST,
    WHITELIST;

    public static BlacklistWhitelist get(byte b) {
        BlacklistWhitelist[] v = values();

        if (b < 0 || b >= v.length) {
            return BLACKLIST;
        }

        return v[b];
    }

    public BlacklistWhitelist next() {
        return switch (this) {
            case BLACKLIST -> WHITELIST;
            case WHITELIST -> BLACKLIST;
        };
    }
}
