package dundigundi.bunnomod.recipe;

import dundigundi.bunnomod.block.BunnoModBlocks;
import dundigundi.bunnomod.item.BunnoModItems;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesCheeseMaker {
	private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

	public RecipesCheeseMaker() {
		addRecipe(BunnoModItems.salt.id, new ItemStack(BunnoModItems.cheeseBlock, 1));
	}

	public static void addRecipe(int input, ItemStack output) {
		recipeList.put(input, output);
	}

	public ItemStack getRecipeResult(int i) {
		return recipeList.get(i);
	}

	public HashMap<Integer, ItemStack> getRecipeList() {
		return recipeList;
	}
}
