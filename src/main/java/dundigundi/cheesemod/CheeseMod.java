package dundigundi.cheesemod;

import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.item.CheeseModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class CheeseMod implements ModInitializer, GameStartEntrypoint {
	public static String MOD_ID = "cheesemod";
	public static Logger logger = LoggerFactory.getLogger(MOD_ID);

	/*TODO
	content:
		salt blocks spawn in desert like a small lake
	bugfix:
	*/

	@Override
	public void onInitialize() {
		logger.info("Cheese Mod has been initialised!");
	}

	@Override
	public void beforeGameStart() {
		new CheeseModBlocks().initializeBlocks();
		new CheeseModItems().initializeItems();
	}

	@Override
	public void afterGameStart() {

	}
}
