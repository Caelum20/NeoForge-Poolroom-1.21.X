package net.caelum.poolmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RedstoneTorchBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;

import javax.annotation.Nullable;

public class AbysssteelBulbBlock extends Block {
    public static final MapCodec<AbysssteelBulbBlock> CODEC = simpleCodec(AbysssteelBulbBlock::new);
    public static final BooleanProperty LIT;

    public MapCodec<AbysssteelBulbBlock> codec() {
        return CODEC;
    }

    public AbysssteelBulbBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState((BlockState) this.defaultBlockState().setValue(LIT, false));
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return (BlockState) this.defaultBlockState().setValue(LIT, context.getLevel().hasNeighborSignal(context.getClickedPos()));
    }

    protected void neighborChanged(BlockState state, Level level, BlockPos pos, BlockPos fromPos, Boolean isMoving) {
        if(!level.isClientSide) {
            boolean flag = (Boolean) state.getValue(LIT);
            if(flag != level.hasNeighborSignal(pos)) {
                if(flag) {
                    level.scheduleTick(pos, this, 4);
                } else {
                    level.setBlock(pos, (BlockState) state.cycle(LIT), 2);
                }
            }
        }
    }

    protected void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if((Boolean) state.getValue(LIT) && !level.hasNeighborSignal(pos)) {
            level.setBlock(pos, (BlockState) state.cycle(LIT), 2);
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{LIT});
    }

    static {
        LIT = RedstoneTorchBlock.LIT;
    }
}
