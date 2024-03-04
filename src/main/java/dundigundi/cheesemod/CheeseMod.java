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

	/*
	to complete
	?
	profit
	content:
		complete salt overhaul: salt blocks spawn in desert like a small lake and in ore forms (reuse brown coal)
		more cheese ingredients:
			rennet(recipe, that uses the knife and the stomach of the cow that drops from killing a cow)
			starting culture(you need to cut grass or something plant-based to have a chance acquiring it)
			milk(obvious)
			salt(already completed)
			later herbs for other cheese types(can buff the player(???))
	bugfix:
		fixing inventory containers in cheesemaker (first hotbar not reacting with shift + lb)
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
