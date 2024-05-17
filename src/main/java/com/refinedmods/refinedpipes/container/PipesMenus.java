package com.refinedmods.refinedpipes.container;

import com.refinedmods.refinedpipes.Pipes;
import com.refinedmods.refinedpipes.container.ExtractorAttachmentContainerMenu;
import com.refinedmods.refinedpipes.container.factory.ExtractorAttachmentContainerFactory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class PipesMenus {

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, Pipes.MODID);

    public static final RegistryObject<MenuType<ExtractorAttachmentContainerMenu>> EXTRACTOR_ATTACHMENT = register("extractor_attachment", new ExtractorAttachmentContainerFactory());



    private static<T extends AbstractContainerMenu> RegistryObject<MenuType<T>> register(String name, MenuType.MenuSupplier<T> menu) {
        return MENU_TYPES.register(name, () -> new MenuType<>(menu, FeatureFlags.VANILLA_SET));
    }

}
