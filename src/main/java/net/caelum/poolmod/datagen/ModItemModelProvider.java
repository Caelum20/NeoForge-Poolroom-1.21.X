package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredItem;

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
        basicItem(ModItems.ABYSSTEEL.get());

        handHeldItem(ModItems.ABYSSTEEL_PICKAXE);
    }

    private ItemModelBuilder handHeldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
