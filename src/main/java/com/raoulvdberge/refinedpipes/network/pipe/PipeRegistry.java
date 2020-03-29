package com.raoulvdberge.refinedpipes.network.pipe;

import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class PipeRegistry {
    public static final PipeRegistry INSTANCE = new PipeRegistry();

    private final Map<ResourceLocation, PipeFactory> factories = new HashMap<>();

    private PipeRegistry() {
    }

    public void addFactory(ResourceLocation id, PipeFactory factory) {
        factories.put(id, factory);
    }

    @Nullable
    public PipeFactory getFactory(ResourceLocation id) {
        return factories.get(id);
    }
}