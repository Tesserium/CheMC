package xyz.code2828.chemc.items;

import net.minecraft.item.Item;
import xyz.code2828.chemc.ChemistryProperties;

public class ChemistryItem extends Item {
	public ChemistryItem(Settings settings, int splitN) {
		super(settings);
		split = splitN;
	}

	public final int split;
	/*
	 * split=0: block		(1/1 of a block)
	 * split=1: lump (?)	(1/8 of a block)
	 * split=2: large_ingot	(1/64 of a block)
	 * split=3: ingot		(1/512 of a block)
	 * split=4: nugget		(1/4096 of a block)
	 * split=5: dust		(1/32768 of a block)
	 */

	// TODO add any preferred properties, such as formula
	ChemistryProperties cps;
}
