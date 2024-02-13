package dundigundi.bunnomod.recipe;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.block.BunnoModBlocks;
import dundigundi.bunnomod.item.BunnoModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class BunnoModRecipes implements RecipeEntrypoint {
	public static String MOD_ID = BunnoMod.MOD_ID;
	@Override
	public void onRecipesReady() {
		RecipeBuilder.Shaped(MOD_ID, "B", "S")
				.addInput('B', BunnoModItems.brownCoal)
				.addInput('S', Item.stick)
				.create("torchBrownCoal", Block.torchCoal.getDefaultStack());
		RecipeBuilder.Shaped(MOD_ID, "CCC", "CCC", "CCC")
						.addInput('C', BunnoModItems.cheeseSlice)
						.create("blockOfCheese", BunnoModBlocks.blockOfCheese.getDefaultStack());
		LookupFuelFurnace.instance.addFuelEntry(BunnoModItems.brownCoal.id, 800);
	}
}
