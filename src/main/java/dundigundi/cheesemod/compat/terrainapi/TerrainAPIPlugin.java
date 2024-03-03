package dundigundi.cheesemod.compat.terrainapi;

import dundigundi.cheesemod.CheeseMod;
import useless.terrainapi.api.TerrainAPI;

public class TerrainAPIPlugin implements TerrainAPI {
	@Override
	public String getModID() {
		return CheeseMod.MOD_ID;
	}

	@Override
	public void onInitialize() {
		new OverworldInitialization().init();
	}
}
