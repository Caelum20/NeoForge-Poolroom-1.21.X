package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PoolMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ABYSSTEEL_GRATE);
        blockWithItem(ModBlocks.LIMINALGAE_BLOCK);
        blockWithItem(ModBlocks.FLOWERING_LIMINALGAE_BLOCK);
        blockWithItem(ModBlocks.POOLTILE_BLOCK);
        blockWithItem(ModBlocks.CV_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.UC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.LC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.DC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.RC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.ABYSSTEEL_BULB_BLOCK);

        stairsBlock(ModBlocks.POOLTILE_STAIR.get(), blockTexture(ModBlocks.POOLTILE_BLOCK.get()));
        slabBlock(ModBlocks.POOLTILE_SLAB.get(), blockTexture(ModBlocks.POOLTILE_BLOCK.get()), blockTexture(ModBlocks.POOLTILE_BLOCK.get()));

        stairsBlock(ModBlocks.ABYSSTEEL_GRATE_STAIR.get(), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()));
        slabBlock(ModBlocks.ABYSSTEEL_GRATE_SLAB.get(), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()));
        trapdoorBlockWithRenderType(ModBlocks.ABYSSTEEL_TRAPDOOR.get(), modLoc("block/abyssteel_trapdoor"), true,"cutout");

        blockItem(ModBlocks.ABYSSTEEL_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.ABYSSTEEL_GRATE_SLAB);
        blockItem(ModBlocks.ABYSSTEEL_GRATE_STAIR);

        blockItem(ModBlocks.POOLTILE_SLAB);
        blockItem(ModBlocks.POOLTILE_STAIR);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("poolmod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("poolmod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
