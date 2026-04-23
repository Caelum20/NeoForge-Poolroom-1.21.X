package net.caelum.poolmod.block;

import net.caelum.poolmod.PoolMod;
import net.caelum.poolmod.block.custom.EraserBlock;
import net.caelum.poolmod.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PumpkinBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(PoolMod.MOD_ID);

    public static final DeferredBlock<Block> LIMINALGAE_BLOCK = registerBlock("liminalgae_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(.2f)
                    .sound(SoundType.GRASS)
                    .randomTicks()
                    .noOcclusion()
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
            ));
    public static final DeferredBlock<Block> LC_POOLTILE_BLOCK = registerBlock("lc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
            ));
    public static final DeferredBlock<Block> RC_POOLTILE_BLOCK = registerBlock("rc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
            ));
    public static final DeferredBlock<Block> UC_POOLTILE_BLOCK = registerBlock("uc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
            ));
    public static final DeferredBlock<Block> DC_POOLTILE_BLOCK = registerBlock("dc_pooltile_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
            ));
    public static final DeferredBlock<Block> ABYSSTEEL_BLOCK = registerBlock("abyssteel_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f)
                    .sound(SoundType.LODESTONE)
                    .requiresCorrectToolForDrops()
            ));
    public static final DeferredBlock<Block> CHALK_VOID_POOLTILE_BLOCK = registerBlock("cv_pooltile_block",
            () -> new EraserBlock(BlockBehaviour.Properties.of()
                    .strength(-1f)
                    .sound(SoundType.DEEPSLATE_TILES)
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
