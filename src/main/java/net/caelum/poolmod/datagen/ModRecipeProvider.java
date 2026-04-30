package net.caelum.poolmod.datagen;

import net.caelum.poolmod.block.ModBlocks;
import net.caelum.poolmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LIMINALGAE_BLOCK.get())
                .pattern("LL")
                .pattern("LL")
                .define('L', ModItems.LIMINALGAE_LEAF.asItem())
                .unlockedBy("has_liminalgae_leaf", has(ModItems.LIMINALGAE_LEAF)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CHALK.get())
                .pattern(" CC")
                .pattern("CCC")
                .pattern("CC ")
                .define('C', ModItems.CHALK_DUST.asItem())
                .unlockedBy("has_chalk_dust", has(ModItems.CHALK_DUST)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.ABYSSTEEL_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.ABYSSTEEL.asItem())
                .unlockedBy("has_abyssteel", has(ModBlocks.ABYSSTEEL_BLOCK.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.ABYSSTEEL_PICKAXE.get())
                .pattern("AAA")
                .pattern(" S ")
                .pattern(" S ")
                .define('A', ModItems.ABYSSTEEL.asItem())
                .define('S', Items.STICK.asItem())
                .unlockedBy("has_abyssteel", has(ModBlocks.ABYSSTEEL_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CHALK_FUEL.get(), 4)
                .requires(ModItems.CHALK_DUST)
                .unlockedBy("has_chalk_dust", has(ModItems.CHALK_DUST)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ABYSSTEEL.get())
                .requires(ModBlocks.ABYSSTEEL_BLOCK)
                .unlockedBy("has_abyssteel", has(ModBlocks.ABYSSTEEL_BLOCK.get())).save(recipeOutput);
    }
}
