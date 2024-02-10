package dundigundi.bunnomod.compat.terrainapi;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.blocks.BunnoModBlocks;
import net.minecraft.core.world.biome.Biome;
import net.minecraft.core.world.biome.Biomes;
import useless.terrainapi.generation.Parameters;
import useless.terrainapi.generation.overworld.OverworldFunctions;
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

	}

	@Override
	protected void initBiome() {

	}
}
