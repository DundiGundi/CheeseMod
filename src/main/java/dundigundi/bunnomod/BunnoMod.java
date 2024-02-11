package dundigundi.bunnomod;

import dundigundi.bunnomod.blocks.BunnoModBlocks;
import dundigundi.bunnomod.items.BunnoModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class BunnoMod implements ModInitializer, GameStartEntrypoint {
	public static String MOD_ID = "bunnomod";
	public static Logger logger = LoggerFactory.getLogger(MOD_ID);

	//to complete
	//?
	//profit
	//cheese making block
	//torch that signals the way (right click to change mode -> emits white particles, like one of the mods from 1.18 idk the name)

	@Override
	public void onInitialize() {
		logger.info("Bunno Mod has been initialised!");
	}

	@Override
	public void beforeGameStart() {
		new BunnoModBlocks().initializeBlocks();
		new BunnoModItems().initializeItems();
	}

	@Override
	public void afterGameStart() {

	}
}
