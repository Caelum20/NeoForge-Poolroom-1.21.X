package net.caelum.poolmod.item;

import net.caelum.poolmod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier STEEL = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_STEEL_TOOL,
            1000, 4, 3, 14, () -> Ingredient.of(ModItems.ABYSSTEEL));
}
