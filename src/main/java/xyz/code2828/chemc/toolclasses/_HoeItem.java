package xyz.code2828.chemc.toolclasses;

import net.minecraft.item.HoeItem;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;

public class _HoeItem extends HoeItem {

	public _HoeItem(ToolMaterial material, float attackSpeed, Settings settings) {
		super(material, (int) (0 - Math.ceil(material.getAttackDamage())), attackSpeed, settings);
	}
}
