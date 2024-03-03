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
		RecipeBuilder.Shaped(MOD_ID, "B", "S")
				.addInput('B', CheeseModItems.brownCoal)
				.addInput('S', Item.stick)
				.create("torchBrownCoal", Block.torchCoal.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID, "CCC", "CCC", "CCC")
						.addInput('C', CheeseModItems.cheeseSlice)
						.create("blockOfCheese", CheeseModBlocks.blockOfCheese.getDefaultStack());
		LookupFuelFurnace.instance.addFuelEntry(CheeseModItems.brownCoal.id, 800);
	}

}
