package dundigundi.cheesemod.mixin;

import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.crafting.legacy.type.RecipeShapeless;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.data.registry.recipe.entry.RecipeEntryCraftingShapeless;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntityCow;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.InventoryCrafting;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = RecipeEntryCraftingShapeless.class, remap = false)
public class CraftingMixin {

	/**
	 * @author DundiGundi
	 * @reason wanted to reduce durability of knife on crafting
	 */
	@Overwrite
	public ItemStack[] onCraftResult(InventoryCrafting inventorycrafting) {
		ItemStack[] returnStack = new ItemStack[9];
		for (int i = 0; i < inventorycrafting.getSizeInventory(); ++i) {
			ItemStack itemStack = inventorycrafting.getStackInSlot(i);
			if (itemStack == null) continue;
			if (itemStack.getItem().id == CheeseModItems.knife.id){
				if (itemStack.getMetadata() < CheeseModItems.knife.getMaxDamage() - 1){
					itemStack.damageItem(1, null);
					continue;
				}
			}
			inventorycrafting.decrStackSize(i, 1);
			if (!itemStack.getItem().hasContainerItem()) continue;
			inventorycrafting.setInventorySlotContents(i, new ItemStack(itemStack.getItem().getContainerItem()));
		}
		return returnStack;
	}

}
