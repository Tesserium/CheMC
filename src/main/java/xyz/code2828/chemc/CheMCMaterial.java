package xyz.code2828.chemc;

import java.util.function.Supplier;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum CheMCMaterial implements ToolMaterial
{
	COPPER(MiningLevels.IRON, 240, 4.8F, 1.9F, 17, () ->
	{
		return Ingredient.ofItems(Items.COPPER_INGOT);
	});

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy repairIngredient;

	private CheMCMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage, int enchantability, Supplier repairIngredient)
	{
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy(repairIngredient);
	}

	public int getDurability()
	{ return this.itemDurability; }

	public float getMiningSpeedMultiplier()
	{ return this.miningSpeed; }

	public float getAttackDamage()
	{ return this.attackDamage; }

	public int getMiningLevel()
	{ return this.miningLevel; }

	public int getEnchantability()
	{ return this.enchantability; }

	public Ingredient getRepairIngredient()
	{ return (Ingredient) this.repairIngredient.get(); }

}
