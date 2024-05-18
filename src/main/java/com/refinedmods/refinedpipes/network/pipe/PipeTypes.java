package com.refinedmods.refinedpipes.network.pipe;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

// TODO: Convert to DeferredRegister
public class PipeTypes {
    public static final PipeTypes INSTANCE = new PipeTypes();

    private final Map<ResourceLocation, PipeFactory> factories = new HashMap<>();

    private PipeTypes() {
    }

    public void addFactory(ResourceLocation id, PipeFactory factory) {
        if (factories.containsKey(id)) {
            throw new RuntimeException("Cannot register duplicate pipe factory " + id.toString());
        }

        factories.put(id, factory);
    }

    @Nullable
    public PipeFactory getFactory(ResourceLocation id) {
        return factories.get(id);
    }
}