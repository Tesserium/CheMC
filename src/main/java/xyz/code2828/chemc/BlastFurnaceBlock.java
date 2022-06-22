package xyz.code2828.chemc;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlastFurnaceBlock extends BlockWithEntity
{

	public BlastFurnaceBlock(Settings settings)
	{
		super(settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
	{
		return new BlastFurnaceBlockEntity(pos, state);
	}

	@Override
	public BlockRenderType getRenderType(BlockState state)
	{
		// With inheriting from BlockWithEntity this defaults to INVISIBLE, so we need
		// to change that!
		return BlockRenderType.MODEL;
	}

	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type)
	{
		return checkType(type, CheMC.BLAST_FURNACE_BE,
				(world1, pos, state1, be) -> BlastFurnaceBlockEntity.tick(world1, pos, state1, be));
	}

}
