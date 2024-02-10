package dundigundi.bunnomod.compat.terrainapi;

import dundigundi.bunnomod.BunnoMod;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {
	@Override
	public String getModID() {
		return BunnoMod.MOD_ID;
	}

	@Override
	public void onInitialize() {
		new OverworldInitialization().init();
	}
}
