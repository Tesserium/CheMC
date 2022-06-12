package xyz.code2828.chemc;

import java.util.function.Supplier;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

public enum CheMCMaterial implements ToolMaterial {
	COPPER(MiningLevels.IRON, 240, 4.8F, 1.9F, 17, () -> {
		return Ingredient.ofItems(Items.COPPER_INGOT);
	}), TRIIRONTETRAOXIDE(MiningLevels.NETHERITE, 1868, 7.0F, 2.1F, 7, () -> {
		return Ingredient.ofItems(CheMC.TRIIRONTETRAOXIDE_INGOT);
	}),
	UNRUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability(), ToolMaterials.IRON.getMiningSpeedMultiplier(),
			ToolMaterials.IRON.getAttackDamage(), ToolMaterials.IRON.getEnchantability(), () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			}),
	SLIGHTLY_RUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability() * 5 / 6,
			ToolMaterials.IRON.getMiningSpeedMultiplier() - 0.1F, ToolMaterials.IRON.getAttackDamage() - 0.1F,
			ToolMaterials.IRON.getEnchantability() - 1, () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			}),
	MILDLY_RUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability() * 4 / 5,
			ToolMaterials.IRON.getMiningSpeedMultiplier() - 0.3F, ToolMaterials.IRON.getAttackDamage() - 0.2F,
			ToolMaterials.IRON.getEnchantability() - 2, () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			}),
	MODERATELY_RUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability() * 3 / 4,
			ToolMaterials.IRON.getMiningSpeedMultiplier() - 0.6F, ToolMaterials.IRON.getAttackDamage() - 0.28F,
			ToolMaterials.IRON.getEnchantability() - 3, () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			}),
	HEAVILY_RUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability() * 2 / 3,
			ToolMaterials.IRON.getMiningSpeedMultiplier() - 1.0F, ToolMaterials.IRON.getAttackDamage() - 0.34F,
			ToolMaterials.IRON.getEnchantability() - 5, () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			}),
	COMPLETELY_RUSTED_IRON(MiningLevels.IRON, ToolMaterials.IRON.getDurability() * 1 / 2,
			ToolMaterials.IRON.getMiningSpeedMultiplier() - 1.5F, ToolMaterials.IRON.getAttackDamage() - 0.38F,
			ToolMaterials.IRON.getEnchantability() - 8, () -> {
				return ToolMaterials.IRON.getRepairIngredient();
			});

	private final int miningLevel;
	private final int itemDurability;
	private final float miningSpeed;
	private final float attackDamage;
	private final int enchantability;
	private final Lazy repairIngredient;

	private CheMCMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
			int enchantability, Supplier repairIngredient) {
		this.miningLevel = miningLevel;
		this.itemDurability = itemDurability;
		this.miningSpeed = miningSpeed;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairIngredient = new Lazy(repairIngredient);
	}

	public int getDurability() {
		return this.itemDurability;
	}

	public float getMiningSpeedMultiplier() {
		return this.miningSpeed;
	}

	public float getAttackDamage() {
		return this.attackDamage;
	}

	public int getMiningLevel() {
		return this.miningLevel;
	}

	public int getEnchantability() {
		return this.enchantability;
	}

	public Ingredient getRepairIngredient() {
		return (Ingredient) this.repairIngredient.get();
	}

}
