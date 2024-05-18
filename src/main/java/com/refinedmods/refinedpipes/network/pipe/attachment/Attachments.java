package com.refinedmods.refinedpipes.network.pipe.attachment;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.network.pipe.attachment.extractor.ExtractorAttachmentFactory;
import com.refinedmods.refinedpipes.network.pipe.attachment.extractor.ExtractorAttachmentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;

import javax.annotation.Nullable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Attachments {

    public static AttachmentFactory get(ResourceLocation resourceLocation) {
        return FACTORY_REGISTRY.get().getValue(resourceLocation);
    }

    public static ResourceLocation getKey(AttachmentFactory factory) {
        return FACTORY_REGISTRY.get().getKey(factory);
    }

    public static final DeferredRegister<AttachmentFactory> FACTORIES = DeferredRegister.create(Pipes.Keys.ATTACHMENT_FACTORY, Pipes.MODID);
    public static final Supplier<IForgeRegistry<AttachmentFactory>> FACTORY_REGISTRY = FACTORIES.makeRegistry(RegistryBuilder::new);

    public static final RegistryObject<ExtractorAttachmentFactory> BASIC = FACTORIES.register(ExtractorAttachmentType.BASIC.getId().getPath(), () -> new ExtractorAttachmentFactory(ExtractorAttachmentType.BASIC));
    public static final RegistryObject<ExtractorAttachmentFactory> IMPROVED = FACTORIES.register(ExtractorAttachmentType.IMPROVED.getId().getPath(), () -> new ExtractorAttachmentFactory(ExtractorAttachmentType.IMPROVED));
    public static final RegistryObject<ExtractorAttachmentFactory> ADVANCED = FACTORIES.register(ExtractorAttachmentType.ADVANCED.getId().getPath(), () -> new ExtractorAttachmentFactory(ExtractorAttachmentType.ADVANCED));
    public static final RegistryObject<ExtractorAttachmentFactory> ELITE = FACTORIES.register(ExtractorAttachmentType.ELITE.getId().getPath(), () -> new ExtractorAttachmentFactory(ExtractorAttachmentType.ELITE));
    public static final RegistryObject<ExtractorAttachmentFactory> ULTIMATE = FACTORIES.register(ExtractorAttachmentType.ULTIMATE.getId().getPath(), () -> new ExtractorAttachmentFactory(ExtractorAttachmentType.ULTIMATE));
/*
    public static final Attachments INSTANCE = new Attachments();

    private final Map<ResourceLocation, AttachmentFactory> factories = new HashMap<>();

    private Attachments() {
    }

    public Collection<AttachmentFactory> all() {
        return factories.values();
    }

    public void addFactory(ResourceLocation id, AttachmentFactory type) {
        if (factories.containsKey(id)) {
            throw new RuntimeException("Cannot register duplicate attachment factory " + id.toString());
        }

        factories.put(id, type);
    }

    @Nullable
    public AttachmentFactory getFactory(ResourceLocation id) {
        return factories.get(id);
    }*/
}
