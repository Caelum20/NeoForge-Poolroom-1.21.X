package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.SlabBlock;
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
        ResourceLocation texture = modLoc("block/abyssteel_grate");
        ModelFile bottom = models().slab("abyssteel_slab", texture, texture, texture).renderType("cutout");
        ModelFile top = models().slabTop("abyssteel_slab_top", texture, texture, texture).renderType("cutout");
        ModelFile doubleSlab = models().cubeAll("abyssteel_slab_top", texture).renderType("cutout");
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
        slabBlock(ModBlocks.ABYSSTEEL_GRATE_SLAB.get(), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()));

        stairsBlockWithRenderType(ModBlocks.ABYSSTEEL_GRATE_STAIR.get(), blockTexture(ModBlocks.ABYSSTEEL_GRATE.get()), "cutout");
        slabBlock(ModBlocks.ABYSSTEEL_GRATE_SLAB.get(), bottom, top, doubleSlab);
        trapdoorBlockWithRenderType(ModBlocks.ABYSSTEEL_TRAPDOOR.get(), modLoc("block/abyssteel_trapdoor"), true,"translucent");

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
