package xyz.code2828.chemc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import xyz.code2828.chemc.tarnishable.TarnishableAxeItem;
import xyz.code2828.chemc.tarnishable.TarnishableHoeItem;
import xyz.code2828.chemc.tarnishable.TarnishablePickaxeItem;
import xyz.code2828.chemc.tarnishable.TarnishableShovelItem;
import xyz.code2828.chemc.toolclasses._AxeItem;
import xyz.code2828.chemc.toolclasses._HoeItem;
import xyz.code2828.chemc.toolclasses._PickaxeItem;
import xyz.code2828.chemc.toolclasses._ShovelItem;
import xyz.code2828.chemc.toolclasses._SwordItem;

public final class CheMC implements ModInitializer
{
	/*
	 * Abbreviations:
	 * SW = sword; PX = pickaxe; AX = axe; HO = hoe; SV = shovel;
	 * I = item; B = block; PD = powder; GS = grains; GR = grain;
	 * DS = dust; IG = ingot; NG = nugget; BM = biome; BI = blockitem;
	 * O = ore; BE = blockentity; F = feature; PP = pack of powder;
	 * MX = (something) mixed with (another thing)
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("chemc");
	public static final Item COAL_PP = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final Item COAL_MX_SIDERITE_PP = new Item(new FabricItemSettings().group(ItemGroup.MISC));
	public static final ChemistryItem DIIRONTRIOXIDE_PD = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC), 3);
	public static final ChemistryItem DIIRONTRIOXIDE_PP = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC), 2);
	public static final ChemistryItem SIDERITE_PD = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC), 3);
	public static final ChemistryItem SIDERITE_PP = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC), 2);
	public static final ChemistryItem TRIIRONTETRAOXIDE_IG = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC),
			2);
	public static final ChemistryItem TRIIRONTETRAOXIDE_DS = new ChemistryItem(new FabricItemSettings().group(ItemGroup.MISC),
			4);
	public static final _PickaxeItem TRIIRONTETRAOXIDE_PX = new _PickaxeItem(CheMCMaterial.TRIIRONTETRAOXIDE,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _AxeItem TRIIRONTETRAOXIDE_AX = new _AxeItem(CheMCMaterial.TRIIRONTETRAOXIDE, 9.5F, 0,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _HoeItem TRIIRONTETRAOXIDE_HO = new _HoeItem(CheMCMaterial.TRIIRONTETRAOXIDE, 0.0F,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _ShovelItem TRIIRONTETRAOXIDE_SV = new _ShovelItem(CheMCMaterial.TRIIRONTETRAOXIDE,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final _SwordItem TRIIRONTETRAOXIDE_SW = new _SwordItem(CheMCMaterial.TRIIRONTETRAOXIDE,
			new FabricItemSettings().group(ItemGroup.COMBAT));
	public static final _PickaxeItem COMPLETELY_RUSTED_IRON_PX = new _PickaxeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishablePickaxeItem HEAVILY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.HEAVILY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), COMPLETELY_RUSTED_IRON_PX,
			24000);
	public static final TarnishablePickaxeItem MODERATELY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), HEAVILY_RUSTED_IRON_PX,
			32000);
	public static final TarnishablePickaxeItem MILDLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.MILDLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), MODERATELY_RUSTED_IRON_PX,
			36000);
	public static final TarnishablePickaxeItem SLIGHTLY_RUSTED_IRON_PX = new TarnishablePickaxeItem(
			CheMCMaterial.SLIGHTLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), MILDLY_RUSTED_IRON_PX, 40000);
	public static final TarnishablePickaxeItem UNRUSTED_IRON_PX = new TarnishablePickaxeItem(CheMCMaterial.UNRUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_PX, 44000);
	public static final _ShovelItem COMPLETELY_RUSTED_IRON_SV = new _ShovelItem(CheMCMaterial.COMPLETELY_RUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishableShovelItem HEAVILY_RUSTED_IRON_SV = new TarnishableShovelItem(
			CheMCMaterial.HEAVILY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), COMPLETELY_RUSTED_IRON_SV,
			24000);
	public static final TarnishableShovelItem MODERATELY_RUSTED_IRON_SV = new TarnishableShovelItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), HEAVILY_RUSTED_IRON_SV,
			32000);
	public static final TarnishableShovelItem MILDLY_RUSTED_IRON_SV = new TarnishableShovelItem(
			CheMCMaterial.MILDLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), MODERATELY_RUSTED_IRON_SV,
			36000);
	public static final TarnishableShovelItem SLIGHTLY_RUSTED_IRON_SV = new TarnishableShovelItem(
			CheMCMaterial.SLIGHTLY_RUSTED_IRON, new FabricItemSettings().group(ItemGroup.TOOLS), MILDLY_RUSTED_IRON_SV, 40000);
	public static final TarnishableShovelItem UNRUSTED_IRON_SV = new TarnishableShovelItem(CheMCMaterial.UNRUSTED_IRON,
			new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_SV, 44000);
	public static final _AxeItem COMPLETELY_RUSTED_IRON_AX = new _AxeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON, 8.5F, -0.1F,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishableAxeItem HEAVILY_RUSTED_IRON_AX = new TarnishableAxeItem(CheMCMaterial.HEAVILY_RUSTED_IRON,
			8.6F, -0.08F, new FabricItemSettings().group(ItemGroup.TOOLS), COMPLETELY_RUSTED_IRON_AX, 32000);
	public static final TarnishableAxeItem MODERATELY_RUSTED_IRON_AX = new TarnishableAxeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, 8.7F, -0.06F, new FabricItemSettings().group(ItemGroup.TOOLS),
			HEAVILY_RUSTED_IRON_AX, 36000);
	public static final TarnishableAxeItem MILDLY_RUSTED_IRON_AX = new TarnishableAxeItem(CheMCMaterial.MILDLY_RUSTED_IRON,
			8.8F, -0.04F, new FabricItemSettings().group(ItemGroup.TOOLS), MODERATELY_RUSTED_IRON_AX, 42000);
	public static final TarnishableAxeItem SLIGHTLY_RUSTED_IRON_AX = new TarnishableAxeItem(CheMCMaterial.SLIGHTLY_RUSTED_IRON,
			8.9F, -0.02F, new FabricItemSettings().group(ItemGroup.TOOLS), MILDLY_RUSTED_IRON_AX, 45000);
	public static final TarnishableAxeItem UNRUSTED_IRON_AX = new TarnishableAxeItem(CheMCMaterial.UNRUSTED_IRON, 9.0F, 0,
			new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_AX, 48000);
	public static final _HoeItem COMPLETELY_RUSTED_IRON_HO = new _HoeItem(CheMCMaterial.COMPLETELY_RUSTED_IRON, -1.0F,
			new FabricItemSettings().group(ItemGroup.TOOLS));
	public static final TarnishableHoeItem HEAVILY_RUSTED_IRON_HO = new TarnishableHoeItem(CheMCMaterial.HEAVILY_RUSTED_IRON,
			-1.0F, new FabricItemSettings().group(ItemGroup.TOOLS), COMPLETELY_RUSTED_IRON_HO, 20000);
	public static final TarnishableHoeItem MODERATELY_RUSTED_IRON_HO = new TarnishableHoeItem(
			CheMCMaterial.MODERATELY_RUSTED_IRON, -1.0F, new FabricItemSettings().group(ItemGroup.TOOLS),
			HEAVILY_RUSTED_IRON_HO, 26000);
	public static final TarnishableHoeItem MILDLY_RUSTED_IRON_HO = new TarnishableHoeItem(CheMCMaterial.MILDLY_RUSTED_IRON,
			-1.0F, new FabricItemSettings().group(ItemGroup.TOOLS), MODERATELY_RUSTED_IRON_HO, 32000);
	public static final TarnishableHoeItem SLIGHTLY_RUSTED_IRON_HO = new TarnishableHoeItem(CheMCMaterial.SLIGHTLY_RUSTED_IRON,
			-1.0F, new FabricItemSettings().group(ItemGroup.TOOLS), MILDLY_RUSTED_IRON_HO, 36000);
	public static final TarnishableHoeItem UNRUSTED_IRON_HO = new TarnishableHoeItem(CheMCMaterial.UNRUSTED_IRON, -1.0F,
			new FabricItemSettings().group(ItemGroup.TOOLS), SLIGHTLY_RUSTED_IRON_HO, 40000);

	public void registerI(ItemConvertible item, String unlocalizedName)
	{
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName), item.asItem());
	}

	public void registerB(Block block, String unlocalizedName, ItemGroup iGroup)
	{
		Registry.register(Registry.BLOCK, new Identifier("chemc", unlocalizedName), block);
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName),
				new BlockItem(block, new FabricItemSettings().group(iGroup)));
	}

	public void registerO(OreBlock block, String unlocalizedName)
	{}

	public void registerB()
	{}

	@Override
	public void onInitialize()
	{
		registerI(COAL_PP, "coal_packofpowder");
		registerI(COAL_MX_SIDERITE_PP, "coal_mx_siderite_packofpowder");
		registerI(DIIRONTRIOXIDE_PD, "diirontrioxide_powder");
		registerI(DIIRONTRIOXIDE_PP, "diirontrioxide_packofpowder");
		registerI(SIDERITE_PD, "siderite_powder");
		registerI(SIDERITE_PP, "siderite_packofpowder");
		registerI(TRIIRONTETRAOXIDE_IG, "triirontetraoxide_ingot");
		registerI(TRIIRONTETRAOXIDE_DS, "triirontetraoxide_dust");
		registerI(TRIIRONTETRAOXIDE_PX, "triirontetraoxide_pickaxe");
		registerI(TRIIRONTETRAOXIDE_SW, "triirontetraoxide_sword");
		registerI(TRIIRONTETRAOXIDE_HO, "triirontetraoxide_hoe");
		registerI(TRIIRONTETRAOXIDE_AX, "triirontetraoxide_axe");
		registerI(TRIIRONTETRAOXIDE_SV, "triirontetraoxide_shovel");
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
		registerI(UNRUSTED_IRON_HO, "unrusted_iron_hoe");
		registerI(SLIGHTLY_RUSTED_IRON_HO, "slightly_rusted_iron_hoe");
		registerI(MILDLY_RUSTED_IRON_HO, "mildly_rusted_iron_hoe");
		registerI(MODERATELY_RUSTED_IRON_HO, "moderately_rusted_iron_hoe");
		registerI(HEAVILY_RUSTED_IRON_HO, "heavily_rusted_iron_hoe");
		registerI(COMPLETELY_RUSTED_IRON_HO, "completely_rusted_iron_hoe");
		registerI(UNRUSTED_IRON_SV, "unrusted_iron_shovel");
		registerI(SLIGHTLY_RUSTED_IRON_SV, "slightly_rusted_iron_shovel");
		registerI(MILDLY_RUSTED_IRON_SV, "mildly_rusted_iron_shovel");
		registerI(MODERATELY_RUSTED_IRON_SV, "moderately_rusted_iron_shovel");
		registerI(HEAVILY_RUSTED_IRON_SV, "heavily_rusted_iron_shovel");
		registerI(COMPLETELY_RUSTED_IRON_SV, "completely_rusted_iron_shovel");
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
 * 
 * -- Daomephsta, discord
 */
