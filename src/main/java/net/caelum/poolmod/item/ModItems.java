package net.caelum.poolmod.item;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.item.custom.ChalkItem;
import net.caelum.poolmod.item.custom.FuelItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(PoolMod.MOD_ID);

    public static final DeferredItem<Item> POOLFISH = ITEMS.register("poolfish",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.POOLFISH)
            ));
    public static final DeferredItem<Item> CHALK_DUST = ITEMS.register("chalk_dust",
            () -> new Item(new Item.Properties()
            ));
    public static final DeferredItem<Item> ABYSSTEEL = ITEMS.register("abyssteel_ingot",
            () -> new Item(new Item.Properties()
            ));

    public static final DeferredItem<Item> CHALK = ITEMS.register("chalk",
            () -> new ChalkItem(new Item.Properties().durability(64)
            ));

    public static final DeferredItem<Item> LIMINALGAE_BUD = ITEMS.register("liminalgae_bud",
            () -> new Item(new Item.Properties()
                    .food(ModFoodProperties.LIMINALGAE_BUD)) {
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.poolmod.liminalgae_leaf"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            }
            );

    public static final DeferredItem<Item> LIMINALGAE_LEAF = ITEMS.register("liminalgae_leaf",
            () -> new FuelItem(new Item.Properties(), 1200
            ));
    public static final DeferredItem<Item> CHALK_FUEL = ITEMS.register("chalk_fuel",
            () -> new FuelItem(new Item.Properties(), 2400
            ));

    public static final DeferredItem<PickaxeItem> ABYSSTEEL_PICKAXE = ITEMS.register("abyssteel_pickaxe",
            () -> new PickaxeItem(ModToolTiers.STEEL, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.STEEL, 1f, -2.8f))
            ));

    public static final DeferredItem<ArmorItem> DIVING_SUIT = ITEMS.register("diving_suit",
            () -> new ArmorItem(ModArmorMaterials.ABYSSTEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new  Item.Properties().durability(ArmorItem.Type.BODY.getDurability(-1))
            ));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
