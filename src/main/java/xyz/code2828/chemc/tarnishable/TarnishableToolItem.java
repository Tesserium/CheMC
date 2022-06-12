package xyz.code2828.chemc.tarnishable;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;

public class TarnishableToolItem extends ToolItem implements Tarnishable {
	public TarnishableToolItem(ToolMaterial material, Settings settings, ItemConvertible nextItem, int tarnishT) {
		super(material, settings);
		this.nextItem = nextItem;
		this.tarnishTick = tarnishT;
	}

	public ItemConvertible nextItem;
	public int tarnishTick;

	@Override
	public ItemConvertible getNextItem() {
		return nextItem;
	}

	@Override
	public int getTarnishTick() {
		return tarnishTick;
	}

	@Override
	public void setNextItem(ItemConvertible ic) {
		nextItem=ic;
		
	}

}
