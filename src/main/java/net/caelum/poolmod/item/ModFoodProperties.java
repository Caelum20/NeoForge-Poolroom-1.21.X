package net.caelum.poolmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties LIMINALGAE_BUD = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f)
            .effect(() -> new MobEffectInstance(MobEffects.WATER_BREATHING, 1800), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 1800), 1f)
            .build();
    public static final FoodProperties POOLFISH = new FoodProperties.Builder().nutrition(20).saturationModifier(1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 400), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONDUIT_POWER, 800), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 800), 1f)
            .build();
}
