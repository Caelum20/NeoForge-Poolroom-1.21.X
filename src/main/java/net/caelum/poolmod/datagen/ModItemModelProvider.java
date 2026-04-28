package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PoolMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.LIMINALGAE_BUD.get());
        basicItem(ModItems.LIMINALGAE_LEAF.get());
        basicItem(ModItems.POOLFISH.get());
        basicItem(ModItems.CHALK.get());
        basicItem(ModItems.CHALK_DUST.get());
        basicItem(ModItems.CHALK_FUEL.get());
    }
}
