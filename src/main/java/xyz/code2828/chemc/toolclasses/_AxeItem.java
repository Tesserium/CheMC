package xyz.code2828.chemc.toolclasses;

import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolMaterial;

public class _AxeItem extends AxeItem {

	public _AxeItem(ToolMaterial material, float topAttackDamage, float relativeAttackSpeed, Settings settings) {
		super(material, topAttackDamage - 1 - material.getAttackDamage(), -3.1F + relativeAttackSpeed, settings);
	}

}
