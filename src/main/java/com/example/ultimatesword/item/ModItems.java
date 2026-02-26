package com.example.ultimatesword.item;

import com.example.ultimatesword.ExampleMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);

    public static final RegistryObject<Item> ULTIMATE_SWORD =
            ITEMS.register("ultimate_sword", UltimateSwordItem::new);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
