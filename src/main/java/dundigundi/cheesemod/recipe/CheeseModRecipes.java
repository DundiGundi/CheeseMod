package dundigundi.cheesemod.recipe;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class CheeseModRecipes implements RecipeEntrypoint {
	public static String MOD_ID = CheeseMod.MOD_ID;
	@Override
	public void onRecipesReady() {
		//LookupFuelFurnace.instance.addFuelEntry(CheeseModItems.brownCoal.id, 800); igy kell fuelt hozzáadni :)
	}

}
