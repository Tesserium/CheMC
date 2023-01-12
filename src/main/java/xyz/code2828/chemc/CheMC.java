package xyz.code2828.chemc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.client.item.UnclampedModelPredicateProvider;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryEntryList;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BuiltinBiomes;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreConfiguredFeatures;
import net.minecraft.world.gen.feature.OreFeature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
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
	 * BE = blockentity; F = feature; PP = pack of powder; U = fuel;
	 * OV = overworld; CF = configured feature; SF = structure feature;
	 * CS = configured structure feature; PF = placed feature;
	 * SO = stone ore; DO = deepslate ore; NO = nether ore; EO = end ore
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger("chemc");
	public static final Item BRUH = new Item(new FabricItemSettings().group(ItemGroup.MISC));

	public static void registerModel()
	{
		ModelPredicateProviderRegistry.register(BRUH, new Identifier("chemc", "bruh_bruh"), new UnclampedModelPredicateProvider()
		{
			public float unclampedCall(ItemStack itemStack, @Nullable ClientWorld clientWorld, @Nullable LivingEntity livingEntity, int i)
			{
				return 0.0F;
			}
		});
	}

	public void registerI(ItemConvertible item, String unlocalizedName)
	{
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName), item.asItem());
	}

	public void registerB(Block block, String unlocalizedName, ItemGroup iGroup)
	{
		Registry.register(Registry.BLOCK, new Identifier("chemc", unlocalizedName), block);
		Registry.register(Registry.ITEM, new Identifier("chemc", unlocalizedName), new BlockItem(block, new FabricItemSettings().group(iGroup)));
	}

	public void registerU(ItemConvertible ic, int burnTick)
	{
		FuelRegistry.INSTANCE.add(ic, burnTick);
	}

	public void registerO(ConfiguredFeature<?, ?> cf, PlacedFeature pf, String unlocalizedName)
	{
		Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier("chemc", unlocalizedName), cf);
		Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier("chemc", unlocalizedName), pf);
		BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES,
				RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("chemc", unlocalizedName)));
	}

	public BlockEntityType<?> registerBE(BlockEntityType<?> blockEntity, Block block, String unlocalizedName)
	{
		return null;
//		return blockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("chemc", unlocalizedName),
//				FabricBlockEntityTypeBuilder.create(BlastFurnaceBlockEntity::new, block).build(null));
	}

	public void registerBM()
	{}

	public void registerSF()
	{}

	@Override
	public void onInitialize()
	{
		// registers
		registerItems();
		registerBlocks();
		registerOreFeatures();
		registerFuels();
		registerBlockEntities();
	}

	public void registerItems()
	{
		registerI(BRUH, "bruh");
	}

	public void registerBlocks()
	{
		//
	}

	public void registerOreFeatures()
	{
		//
	}

	public void registerFuels()
	{
		//
	}

	@SuppressWarnings("unchecked")
	public void registerBlockEntities()
	{
//		BLAST_FURNACE_BE = (BlockEntityType<BlastFurnaceBlockEntity>) registerBE(BLAST_FURNACE_BE, BLAST_FURNACE, "blast_furnace");
	}

}
