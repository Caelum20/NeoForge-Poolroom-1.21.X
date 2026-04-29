package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.ModBlocks;
import net.caelum.poolmod.block.custom.AbysssteelBulbBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PoolMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ABYSSTEEL_BLOCK);
        customLamp();

        blockWithItem(ModBlocks.LIMINALGAE_BLOCK);

        blockWithItem(ModBlocks.POOLTILE_BLOCK);
        stairsBlock(ModBlocks.POOLTILE_STAIR.get(), blockTexture(ModBlocks.POOLTILE_BLOCK.get()));
        slabBlock(ModBlocks.POOLTILE_SLAB.get(), blockTexture(ModBlocks.POOLTILE_BLOCK.get()), blockTexture(ModBlocks.POOLTILE_BLOCK.get()));
        blockWithItem(ModBlocks.DC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.LC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.RC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.UC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.CV_POOLTILE_BLOCK);

        blockItem(ModBlocks.POOLTILE_STAIR);
        blockItem(ModBlocks.POOLTILE_SLAB);
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.ABYSSTEEL_BULB_BLOCK.get()).forAllStates(state -> {
            if(state.getValue(AbysssteelBulbBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("abyssteel_bulb_block_on",
                        ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, "block/" + "abyssteel_bulb_block_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("abyssteel_bulb_block_off",
                        ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, "block/" + "abyssteel_bulb_block_off")))};
            }
        });
        simpleBlockItem(ModBlocks.ABYSSTEEL_BULB_BLOCK.get(), models().cubeAll("abyssteel_bulb_block_on",
                ResourceLocation.fromNamespaceAndPath(PoolMod.MOD_ID, "block/" + "abyssteel_bulb_block_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("poolmod:block/" + deferredBlock.getId().getPath())
        );
    }
    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("poolmod:block/" + deferredBlock.getId().getPath() + appendix)
        );
    }
}
