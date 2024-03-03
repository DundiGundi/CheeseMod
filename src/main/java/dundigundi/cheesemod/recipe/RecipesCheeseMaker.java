package dundigundi.cheesemod.recipe;

import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.item.ItemStack;

import java.util.HashMap;

public class RecipesCheeseMaker {
	private static final HashMap<Integer, ItemStack> recipeList = new HashMap<>();

	public RecipesCheeseMaker() {
		addRecipe(CheeseModItems.salt.id, new ItemStack(CheeseModItems.cheeseBlock, 1));
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
