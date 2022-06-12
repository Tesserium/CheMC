package xyz.code2828.chemc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.code2828.chemc.items.ChemistryItem;
import xyz.code2828.chemc.tarnishable.Tarnishable;
import xyz.code2828.chemc.tarnishable.TarnishableAxeItem;
import xyz.code2828.chemc.tarnishable.TarnishablePickaxeItem;
import xyz.code2828.chemc.toolclasses._AxeItem;
import xyz.code2828.chemc.toolclasses._HoeItem;
import xyz.code2828.chemc.toolclasses._PickaxeItem;
import xyz.code2828.chemc.toolclasses._SwordItem;

public class CheMC implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("chemc");
	public static final ChemistryItem TRIIRONTETRAOXIDE_INGOT = new ChemistryItem(
			new FabricItemSettings().group(ItemGroup.MISC), 3);
	public static final ChemistryItem TRIIRONTETRAOXIDE_DUST = new ChemistryItem(
			new FabricItemSettings().group(ItemGroup.MISC), 6);
//	public static final _PickaxeItem COPPER_PX = new _PickaxeItem(CheMCMaterial.COPPER,
//			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _PickaxeItem TRIIRONTETRAOXIDE_PX = new _PickaxeItem(CheMCMaterial.TRIIRONTETRAOXIDE,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _AxeItem TRIIRONTETRAOXIDE_AX = new _AxeItem(CheMCMaterial.TRIIRONTETRAOXIDE, 9.5F, 0,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _HoeItem TRIIRONTETRAOXIDE_HO = new _HoeItem(CheMCMaterial.TRIIRONTETRAOXIDE, -4, 0.0F,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _SwordItem TRIIRONTETRAOXIDE_SW = new _SwordItem(CheMCMaterial.TRIIRONTETRAOXIDE,
			new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final _PickaxeItem COMPLETELY_RUSTED_IRON_PX = new _PickaxeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishablePickaxeItem HEAVILY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.HEAVILY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS),
			COMPLETELY_RUSTED_IRON_PX, 24000);
	public static final TarnishablePickaxeItem MODERATELY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS),
			HEAVILY_RUSTED_IRON_PX, 32000);
	public static final TarnishablePickaxeItem MILDLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MILDLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS),
			MODERATELY_RUSTED_IRON_PX, 36000);
	public static final TarnishablePickaxeItem SLIGHTLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.SLIGHTLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), MILDLY_RUSTED_IRON_PX,
			40000);
	public static final TarnishablePickaxeItem UNRUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.UNRUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_PX,
			42000);
	public static final _AxeItem COMPLETELY_RUSTED_IRON_AX = new _AxeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON, 8.5F, 0,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishableAxeItem HEAVILY_RUSTED_IRON_AX = new TarnishableAxeItem(
			CheMCMaterial.HEAVILY_RUSTED_IRON, 8.6F, 0, new FabricItemSettings().group(ItemGroup.TOOLS),
			COMPLETELY_RUSTED_IRON_AX, 32000);
	public static final TarnishableAxeItem MODERATELY_RUSTED_IRON_AX = new TarnishableAxeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, 8.7F, 0, new FabricItemSettings().group(ItemGroup.TOOLS),
			HEAVILY_RUSTED_IRON_AX, 36000);
	public static final TarnishableAxeItem MILDLY_RUSTED_IRON_AX = new TarnishableAxeItem(
			CheMCMaterial.MILDLY_RUSTED_IRON, 8.8F, 0, new FabricItemSettings().group(ItemGroup.TOOLS),
			MODERATELY_RUSTED_IRON_AX, 42000);
	public static final TarnishableAxeItem SLIGHTLY_RUSTED_IRON_AX = new TarnishableAxeItem(
			CheMCMaterial.SLIGHTLY_RUSTED_IRON, 8.9F, 0, new FabricItemSettings().group(ItemGroup.TOOLS),
			MILDLY_RUSTED_IRON_AX, 45000);
	public static final TarnishableAxeItem UNRUSTED_IRON_AX = new TarnishableAxeItem(CheMCMaterial.UNRUSTED_IRON, 9.0F,
			0, new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_AX, 48000);

	public void registerI(ItemConvertible item, String unlocalizedName) {
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName), item.asItem());
	}

	@Override
	public void onInitialize() {
		registerI(TRIIRONTETRAOXIDE_INGOT, "triirontetraoxide_ingot");
		registerI(TRIIRONTETRAOXIDE_DUST, "triirontetraoxide_dust");
		registerI(TRIIRONTETRAOXIDE_PX, "triirontetraoxide_pickaxe");
		registerI(TRIIRONTETRAOXIDE_SW, "triirontetraoxide_sword");
		registerI(TRIIRONTETRAOXIDE_HO, "triirontetraoxide_hoe");
		registerI(TRIIRONTETRAOXIDE_AX, "triirontetraoxide_axe");
		registerI(UNRUSTED_IRON_PX, "unrusted_iron_pickaxe");
		registerI(SLIGHTLY_RUSTED_IRON_PX, "slightly_rusted_iron_pickaxe");
		registerI(MILDLY_RUSTED_IRON_PX, "mildly_rusted_iron_pickaxe");
		registerI(MODERATELY_RUSTED_IRON_PX, "moderately_rusted_iron_pickaxe");
		registerI(HEAVILY_RUSTED_IRON_PX, "heavily_rusted_iron_pickaxe");
		registerI(COMPLETELY_RUSTED_IRON_PX, "completely_rusted_iron_pickaxe");
		registerI(UNRUSTED_IRON_AX, "unrusted_iron_axe");
		registerI(SLIGHTLY_RUSTED_IRON_AX, "slightly_rusted_iron_axe");
		registerI(MILDLY_RUSTED_IRON_AX, "mildly_rusted_iron_axe");
		registerI(MODERATELY_RUSTED_IRON_AX, "moderately_rusted_iron_axe");
		registerI(HEAVILY_RUSTED_IRON_AX, "heavily_rusted_iron_axe");
		registerI(COMPLETELY_RUSTED_IRON_AX, "completely_rusted_iron_axe");
//		registerI(COPPER_PX, "copper_pickaxe");
	}

}

/*
 * `net.minecraft.item.Item.inventoryTick(ItemStack, World, Entity, int,
 * boolean)` exists, however only players call it, and modded inventories may or
 * may not. 
 * To solve this 
 * 1. store a timestamp in NBT 
 * 2. In the inventoryTick override check if World.getTime() is greater than or equal to this timestamp
 * 3. If yes, replace the stack with the oxidised version using the entity and slot index parameters 
 * 4. Additionally, if an item has no oxidation timestamp,
 * generate one
 * 
 * Unfortunately it's not possible to have the stack oxidise while in a
 * non-ticking inventory, but with this approach the oxidation state will be
 * corrected as soon as it enters a ticking inventory.
 * 
 * For 2 you'll need to
 * 1. instanceof check for PlayerEntity
 * 2. Cast so you can use PlayerEntity.getInventory() 
 * 3. Call Inventory.setStack() using that
 *
 * Additionally similar approach with InventoryOwner might catch some modded entities, if they happen to tick their inventories
 * I've had reason to write an entity that does that before
 */
