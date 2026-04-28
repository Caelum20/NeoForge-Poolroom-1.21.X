package net.caelum.poolmod.datagen;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, PoolMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.ABYSSTEEL_BLOCK);

        blockWithItem(ModBlocks.LIMINALGAE_BLOCK);

        blockWithItem(ModBlocks.POOLTILE_BLOCK );
        blockWithItem(ModBlocks.DC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.LC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.RC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.UC_POOLTILE_BLOCK);
        blockWithItem(ModBlocks.CV_POOLTILE_BLOCK);
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
