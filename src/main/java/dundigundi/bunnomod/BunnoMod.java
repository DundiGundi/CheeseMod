package dundigundi.bunnomod;

import dundigundi.bunnomod.blocks.BunnoModBlocks;
import dundigundi.bunnomod.items.BunnoModItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class BunnoMod implements ModInitializer, GameStartEntrypoint, RecipeEntrypoint {
	public static String MOD_ID = "bunnomod";
	public static Logger logger = LoggerFactory.getLogger(MOD_ID);

	//to complete
	//make world generation happen
	//?
	//profit
	//cheese item, eatable block cheese like cake(craftable from 9 cheese slice), cheese making block
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

	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(MOD_ID, "B", "S")
				.addInput('B', BunnoModItems.oreBrownCoal)
				.addInput('S', Item.stick)
				.create("torchBrownCoal", Block.torchCoal.getDefaultStack());
		LookupFuelFurnace.instance.addFuelEntry(BunnoModItems.oreBrownCoal.id, 1600);
	}
}
