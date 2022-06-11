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
	public static final TarnishablePickaxeItem UNRUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.UNRUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), null, 42000);
	public static final TarnishablePickaxeItem SLIGHTLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.SLIGHTLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), null, 40000);
	public static final TarnishablePickaxeItem MILDLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MILDLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), null, 36000);
	public static final TarnishablePickaxeItem MODERATELY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), null, 32000);
	public static final TarnishablePickaxeItem HEAVILY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.HEAVILY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), null, 24000);
	public static final _PickaxeItem COMPLETELY_RUSTED_IRON_PX = new _PickaxeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS));

	public void registerI(ItemConvertible item, String unlocalizedName) {
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName), item.asItem());
	}

	public void setNI(Tarnishable tarnishableI, ItemConvertible nextItem) {
		tarnishableI.setNextItem(nextItem);
	}

	@Override
	public void onInitialize() {
		setNI(UNRUSTED_IRON_PX, SLIGHTLY_RUSTED_IRON_PX);
		setNI(SLIGHTLY_RUSTED_IRON_PX, MILDLY_RUSTED_IRON_PX);
		setNI(MILDLY_RUSTED_IRON_PX, MODERATELY_RUSTED_IRON_PX);
		setNI(MODERATELY_RUSTED_IRON_PX, HEAVILY_RUSTED_IRON_PX);
		setNI(HEAVILY_RUSTED_IRON_PX, COMPLETELY_RUSTED_IRON_PX);
		registerI(TRIIRONTETRAOXIDE_INGOT, "triirontetraoxide_ingot");
		registerI(TRIIRONTETRAOXIDE_DUST, "triirontetraoxide_dust");
		registerI(TRIIRONTETRAOXIDE_PX, "triirontetraoxide_pickaxe");
		registerI(TRIIRONTETRAOXIDE_SW, "triirontetraoxide_sword");
		registerI(TRIIRONTETRAOXIDE_HO, "triirontetraoxide_hoe");
		registerI(TRIIRONTETRAOXIDE_AX, "triirontetraoxide_axe");
		registerI(UNRUSTED_IRON_PX, "unrusted_iron_pickaxe");
		registerI(SLIGHTLY_RUSTED_IRON_PX, "slightly_rusted_iron_pickaxe");
		registerI(MODERATELY_RUSTED_IRON_PX, "moderately_rusted_iron_pickaxe");
		registerI(MILDLY_RUSTED_IRON_PX, "mildly_rusted_iron_pickaxe");
		registerI(HEAVILY_RUSTED_IRON_PX, "heavily_rusted_iron_pickaxe");
		registerI(COMPLETELY_RUSTED_IRON_PX, "completely_rusted_iron_pickaxe");
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
