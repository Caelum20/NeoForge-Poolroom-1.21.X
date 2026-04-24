package net.caelum.poolmod.item;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PoolMod.MOD_ID);

    public static final Supplier<CreativeModeTab> POOLROOMS_LAYER_ONE_TAB = CREATIVE_MODE_TAB.register("poolrooms_layer_one_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.POOLTILE_BLOCK.get()))
                    .title(Component.translatable("creativetab.poolmod.poolrooms_layer_one"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.POOLTILE_BLOCK);
                        output.accept(ModBlocks.DC_POOLTILE_BLOCK);
                        output.accept(ModBlocks.LC_POOLTILE_BLOCK);
                        output.accept(ModBlocks.RC_POOLTILE_BLOCK);
                        output.accept(ModBlocks.UC_POOLTILE_BLOCK);
                        output.accept(ModBlocks.CHALK_VOID_POOLTILE_BLOCK);
                        output.accept(ModBlocks.LIMINALGAE_BLOCK);
                        output.accept(ModItems.LIMINALGAE_LEAF);
                        output.accept(ModItems.LIMINALGAE_BUD);
                        output.accept(ModItems.POOLFISH);
                        output.accept(ModItems.CHALK);
                        output.accept(ModItems.CHALK_DUST);
                        output.accept(ModItems.CHALK_FUEL);
                    }).build());
    public static final Supplier<CreativeModeTab> POOLROOMS_LAYER_TWO_TAB = CREATIVE_MODE_TAB.register("poolrooms_layer_two_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LIMINALGAE_LEAF.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, "poolrooms_layer_one_tab"))
                    .title(Component.translatable("creativetab.poolmod.poolrooms_layer_two"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.LIMINALGAE_BLOCK);
                        output.accept(ModBlocks.LIMINALGAE_BULB);
                        output.accept(ModItems.LIMINALGAE_LEAF);
                        output.accept(ModItems.LIMINALGAE_BUD);
                        output.accept(ModItems.CHALK);
                        output.accept(ModItems.CHALK_DUST);
                        output.accept(ModItems.CHALK_FUEL);
                    }).build());
    public static final Supplier<CreativeModeTab> POOLROOMS_DEEP_LAYER_TAB = CREATIVE_MODE_TAB.register("poolrooms_deep_layer_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.ABYSSTEEL_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID,"poolrooms_layer_two_tab"))
                    .title(Component.translatable("creativetab.poolmod.poolrooms_deep_layer"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ABYSSTEEL_BLOCK);
                        output.accept(ModBlocks.LIMINALGAE_BULB);
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
