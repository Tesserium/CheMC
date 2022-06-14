package xyz.code2828.chemc;

import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.event.listener.GameEventListener;

// DON'T USE!
public abstract class AbstractIOBlock extends BlockWithEntity
{

	protected AbstractIOBlock(Settings settings)
	{
		super(settings);
		// TODO Auto-generated constructor stub
	}

	@Override
	public BlockEntity createBlockEntity(BlockPos pos, BlockState state)
	{
		return null;
	}

	@Override
	public BlockEntityTicker getTicker(World world, BlockState state, BlockEntityType type)
	{
		return null;
	}

	@Override
	public GameEventListener getGameEventListener(ServerWorld world, BlockEntity blockEntity)
	{
		return null;
	}

}
