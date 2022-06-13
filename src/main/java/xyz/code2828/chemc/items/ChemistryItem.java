package xyz.code2828.chemc.items;

import net.minecraft.item.Item;
import xyz.code2828.chemc.ChemistryProperties;

public class ChemistryItem extends Item
{
	public ChemistryItem(Settings settings, int splitN)
	{
		super(settings);
		split = splitN;
	}

	public final int split;
	/*
	 * split=0: block				(1/1 of a block)
	 * split=1: ingot				(1/9 of a block)
	 * split=2: nugget/grains		(1/81 of a block)
	 * split=3: grain/powder 		(1/729 of a block)
	 * split=4: dust				(1/6561 of a block)
	 */

	// TODO add any preferred properties, such as formula
	ChemistryProperties cps;
}
