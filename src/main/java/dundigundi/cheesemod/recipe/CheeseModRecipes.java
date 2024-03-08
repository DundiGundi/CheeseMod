package dundigundi.cheesemod.recipe;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.item.CheeseModItems;
import dundigundi.cheesemod.item.ItemToolKnife;
import net.minecraft.core.block.Block;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.data.DataLoader;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.RecipeGroup;
import net.minecraft.core.data.registry.recipe.RecipeNamespace;
import net.minecraft.core.data.registry.recipe.RecipeSymbol;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCrafting;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import turniplabs.halplibe.helper.RecipeBuilder;
import turniplabs.halplibe.util.RecipeEntrypoint;

public class CheeseModRecipes implements RecipeEntrypoint {
	public static final RecipeNamespace CHEESEMOD = new RecipeNamespace();
	public static final RecipeGroup<RecipeEntryCrafting<?, ?>> WORKBENCH = new RecipeGroup<>(new RecipeSymbol(new ItemStack(Block.workbench)));
	@Override
	public void onRecipesReady() {
		Registries.ITEM_GROUPS.register("cheesemod:knife", Registries.stackListOf());
		for (int i = 0; i < CheeseModItems.knife.getMaxDamage(); i++) {
			ItemStack j = CheeseModItems.knife.getDefaultStack();
			j.setMetadata(i);
			Registries.ITEM_GROUPS.getItem("cheesemod:knife").add(j);
		}
		CHEESEMOD.register("workbench", WORKBENCH );
		Registries.RECIPES.register("cheesemod", CHEESEMOD);
		DataLoader.loadRecipes("/assets/cheesemod/recipes/workbench/recipes.json");
		//LookupFuelFurnace.instance.addFuelEntry(CheeseModItems.brownCoal.id, 800); igy kell fuelt hozzáadni :)
	}

}
