package xyz.code2828.chemc;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlastFurnaceBlock extends BlockWithEntity
{

	public BlastFurnaceBlock(Settings settings)
	{
		super(settings);
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

	@Override
	public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
	{
		PlayerInventory inv = player.getInventory();
		ItemStack is = inv.getMainHandStack();
		int slot = inv.getSlotWithStack(is);
		Item i = is.getItem();
		if (i == Items.CHARCOAL)
		{
			is.decrement(1);
			inv.setStack(slot, is);
			BlastFurnaceBlockEntity be = (BlastFurnaceBlockEntity) world.getBlockEntity(pos);
			be.setCharcoalPresent(true);
			if (!world.isClient())
			{
				player.sendMessage(Text.of("[Blast Furnace]: You inserted 1 charcoal into the furnace."));
			}
		}
		else if (i instanceof BlockItem)
		{
			Block b = ((BlockItem) i).getBlock();
			if (b instanceof OreBlock)
			{
				if (BlastFurnaceSmeltableOres.create().hasObject(b))
				{
					player.sendMessage(Text.of("You put in ore " + b.toString() + "."));
				}
			}
		}
		return ActionResult.SUCCESS;
	}

}
