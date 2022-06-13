package xyz.code2828.chemc.tarnishable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.tag.TagKey;

public class TarnishableMiningToolItem extends MiningToolItem implements Tarnishable
{
	public ItemConvertible nextItem;
	public int tarnishTick;

	public TarnishableMiningToolItem(float attackDamage, float attackSpeed, ToolMaterial material,
			TagKey<Block> effectiveBlocks, Settings settings, ItemConvertible nextItem, int tarnishTick)
	{
		super(attackDamage, attackSpeed, material, effectiveBlocks, settings);
		this.nextItem = nextItem;
		this.tarnishTick = tarnishTick;
	}

	@Override
	public ItemConvertible getNextItem()
	{ return nextItem; }

	@Override
	public int getTarnishTick()
	{ return tarnishTick; }

	@Override
	public void setNextItem(ItemConvertible ic)
	{
		nextItem = ic;

	}

}
