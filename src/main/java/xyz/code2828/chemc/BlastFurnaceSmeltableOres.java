package xyz.code2828.chemc;

import net.minecraft.block.Block;

public final class BlastFurnaceSmeltableOres extends SimpleFinalArray<Block>
{
	protected BlastFurnaceSmeltableOres(Block[] arr)
	{
		super(arr);
	}
	public static BlastFurnaceSmeltableOres create()
	{
		Block[] arrr = {CheMC.GOETHITE, CheMC.DEEPSLATE_GOETHITE};
		return new BlastFurnaceSmeltableOres(arrr);
	}

}
