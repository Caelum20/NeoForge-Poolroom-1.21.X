package net.caelum.poolmod.item;

import net.caelum.poolmod.PoolMod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PoolMod.MOD_ID);

    public static final DeferredItem<Item> LIMINALGAE_LEAF = ITEMS.register("liminalgae_leaf",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> LIMINALGAE_SHARD = ITEMS.register("liminalgae_shard",
            () -> new Item(new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
