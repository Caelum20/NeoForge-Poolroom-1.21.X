package net.caelum.poolmod.item.custom;

import net.caelum.poolmod.block.ModBlocks;
import net.caelum.poolmod.component.ModDataComponents;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.List;
import java.util.Map;


public class ChalkItem extends Item {
    private static final Map<Block, Block> MARKER_MAP =
            Map.of(
                    ModBlocks.POOLTILE_BLOCK.get(), ModBlocks.LC_POOLTILE_BLOCK.get(),
                    ModBlocks.LC_POOLTILE_BLOCK.get(), ModBlocks.UC_POOLTILE_BLOCK.get(),
                    ModBlocks.UC_POOLTILE_BLOCK.get(),ModBlocks.RC_POOLTILE_BLOCK.get(),
                    ModBlocks.RC_POOLTILE_BLOCK.get(), ModBlocks.DC_POOLTILE_BLOCK.get(),
                    ModBlocks.DC_POOLTILE_BLOCK.get(), ModBlocks.POOLTILE_BLOCK.get()
            );

    public ChalkItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        Block clickedBlock = level.getBlockState(context.getClickedPos()).getBlock();

        if(MARKER_MAP.containsKey(clickedBlock)) {
            if(!level.isClientSide()) {
                level.setBlockAndUpdate(context.getClickedPos(), MARKER_MAP.get(clickedBlock).defaultBlockState());

                context.getItemInHand().hurtAndBreak(1,((ServerLevel) level), context.getPlayer(),
                        item -> context.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND));

                level.playSound(null, context.getClickedPos(), SoundEvents.BRUSH_GENERIC, SoundSource.BLOCKS);

                context.getItemInHand().set(ModDataComponents.COORDINATES, context.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()) {
            tooltipComponents.add(Component.translatable("tooltip.poolmod.chalk.shift_down"));
        } else if(Screen.hasControlDown()) {
            tooltipComponents.add(Component.translatable("tooltip.poolmod.chalk.ctrl_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.poolmod.chalk"));
        }

        if(stack.get(ModDataComponents.COORDINATES) != null) {
            tooltipComponents.add(Component.literal("Last Block Marked at" + stack.get(ModDataComponents.COORDINATES)));
        }
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
