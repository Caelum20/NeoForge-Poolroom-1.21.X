package net.caelum.poolmod.block;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.custom.AbysssteelBulbBlock;
import net.caelum.poolmod.block.custom.EraserBlock;
import net.caelum.poolmod.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PoolMod.MOD_ID);

    private static boolean never(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return false;
    }

    public static final DeferredBlock<Block> LIMINALGAE_BLOCK = registerBlock("liminalgae_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.2f)
                    .sound(SoundType.GRASS)
                    .randomTicks()
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ));

    public static final DeferredBlock<Block> FLOWERING_LIMINALGAE_BLOCK = registerBlock("flowering_liminalgae_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.2f)
                    .sound(SoundType.GRASS)
                    .randomTicks()
                    .noOcclusion()
                    .isViewBlocking(ModBlocks::never)
            ));
    public static final DeferredBlock<Block> LIMINALGAE_BULB = registerBlock("liminalgae_bulb",
            () -> new Block(BlockBehaviour.Properties.of()
                    .instabreak()
                    .lightLevel(p_50872_ -> 15)
                    .sound(SoundType.GRASS)
            ));
    public static final DeferredBlock<Block> POOLTILE_BLOCK = registerBlock("pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));
    public static final DeferredBlock<Block> LC_POOLTILE_BLOCK = registerBlock("lc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));
    public static final DeferredBlock<Block> RC_POOLTILE_BLOCK = registerBlock("rc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));
    public static final DeferredBlock<Block> UC_POOLTILE_BLOCK = registerBlock("uc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));
    public static final DeferredBlock<Block> DC_POOLTILE_BLOCK = registerBlock("dc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));
    public static final DeferredBlock<Block> CV_POOLTILE_BLOCK = registerBlock("cv_pooltile_block",
            () -> new EraserBlock(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));

    public static final DeferredBlock<StairBlock> POOLTILE_STAIR = registerBlock("pooltile_stair",
            () -> new StairBlock(ModBlocks.POOLTILE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(-1f)
                            .sound(SoundType.DEEPSLATE_TILES)
                            .noLootTable()
            ));

    public static final DeferredBlock<SlabBlock> POOLTILE_SLAB = registerBlock("pooltile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
                    .noLootTable()
            ));

    public static final DeferredBlock<Block> ABYSSTEEL_GRATE = registerBlock("abyssteel_grate",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<StairBlock> ABYSSTEEL_GRATE_STAIR = registerBlock("abyssteel_grate_stair",
            () -> new StairBlock(ModBlocks.ABYSSTEEL_GRATE.get().defaultBlockState(),
                        BlockBehaviour.Properties.of()
                            .strength(4f)
                            .sound(SoundType.METAL)
                            .requiresCorrectToolForDrops()
            ));

    public static final DeferredBlock<Block> ABYSSTEEL_BULB_BLOCK = registerBlock("abyssteel_bulb_block",
            () -> new AbysssteelBulbBlock(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(AbysssteelBulbBlock.CLICKED) ? 15 : 0)
            ));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
