package xyz.code2828.chemc.tarnishable;

import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Vanishable;

public interface Tarnishable extends Vanishable
{
	ItemConvertible getNextItem();

	int getTarnishTick();

	void setNextItem(ItemConvertible ic);

}

/*
 * After ItemStack.class line 336, inject:
 * IF itemstack.item is an instance of Tarnishable then
 *     new ItemStack newitemstack;
 *     newitemstack.count=1;
 *     newitemstack.item=itemstack.item.nextItem;
 *     currentslot.itemstack=newitemstack
 */
