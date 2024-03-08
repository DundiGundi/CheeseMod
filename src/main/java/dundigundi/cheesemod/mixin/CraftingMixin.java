package dundigundi.cheesemod.mixin;

import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.data.registry.Registries;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntityCow;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = ItemStack.class, remap = false)
public class CraftingMixin {

	@Inject(method = "onCrafting", at = @At("HEAD"))
	public void dropStomach(CallbackInfo ci){
		
	}

}
