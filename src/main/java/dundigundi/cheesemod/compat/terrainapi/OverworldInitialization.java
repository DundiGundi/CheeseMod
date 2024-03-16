package dundigundi.cheesemod.compat.terrainapi;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.world.WorldFeatureSaltLake;
import dundigundi.cheesemod.world.WorldFeatureScallionPlant;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;
import useless.terrainapi.initialization.BaseInitialization;

public class OverworldInitialization extends BaseInitialization {
	private final String MOD_ID = CheeseMod.MOD_ID;

	@Override
	protected void initValues() {

	}

	@Override
	protected void initStructure() {

	}

	@Override
	protected void initOre() {
		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(MOD_ID, CheeseModBlocks.oreSaltStone, 4, 10, 1, true);
	}

	@Override
	protected void initRandom() {
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureScallionPlant(), 1, -1, 1,
				new Biome[]{Biomes.OVERWORLD_BIRCH_FOREST, Biomes.OVERWORLD_RETRO, Biomes.OVERWORLD_MEADOW, Biomes.OVERWORLD_FOREST, Biomes.OVERWORLD_SEASONAL_FOREST});
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureSaltLake(), 1, -1, 1,
				new Biome[]{Biomes.OVERWORLD_DESERT});
	}

	@Override
	protected void initBiome() {

	}
}
