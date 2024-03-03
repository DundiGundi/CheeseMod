package dundigundi.cheesemod.compat.terrainapi;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.world.WorldFeatureSaltBlock;
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
		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(MOD_ID, CheeseModBlocks.brownCoalStone, 16, 20, 1, true);
	}

	@Override
	protected void initRandom() {
		ChunkDecoratorOverworldAPI.randomFeatures.addFeature(new WorldFeatureSaltBlock(), 1, -1, 6,
				new Biome[]{Biomes.OVERWORLD_SWAMPLAND, Biomes.OVERWORLD_SWAMPLAND_MUDDY, Biomes.OVERWORLD_BIRCH_FOREST, Biomes.OVERWORLD_RETRO, Biomes.OVERWORLD_MEADOW, Biomes.OVERWORLD_FOREST, Biomes.OVERWORLD_RAINFOREST, Biomes.OVERWORLD_BOREAL_FOREST, Biomes.OVERWORLD_SEASONAL_FOREST, Biomes.OVERWORLD_TAIGA, Biomes.OVERWORLD_SHRUBLAND});
	}

	@Override
	protected void initBiome() {

	}
}
