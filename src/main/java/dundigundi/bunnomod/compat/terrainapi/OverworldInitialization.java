package dundigundi.bunnomod.compat.terrainapi;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.block.BunnoModBlocks;
import dundigundi.bunnomod.world.WorldFeatureSaltBlock;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.generation.overworld.api.ChunkDecoratorOverworldAPI;
import useless.terrainapi.initialization.BaseInitialization;

public class OverworldInitialization extends BaseInitialization {
	private final String MOD_ID = BunnoMod.MOD_ID;

	@Override
	protected void initValues() {

	}

	@Override
	protected void initStructure() {

	}

	@Override
	protected void initOre() {
		ChunkDecoratorOverworldAPI.oreFeatures.addManagedOreFeature(MOD_ID, BunnoModBlocks.brownCoalStone, 16, 20, 1, true);
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
