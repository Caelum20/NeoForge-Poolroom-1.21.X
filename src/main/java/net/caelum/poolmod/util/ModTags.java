package net.caelum.poolmod.util;

import net.caelum.poolmod.PoolMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> DISSOLVABLE_ITEMS = createTag("dissolvable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, name));
        }
    }
}
