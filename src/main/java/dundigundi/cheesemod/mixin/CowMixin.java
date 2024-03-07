package dundigundi.cheesemod.mixin;

import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.EntityItem;
import net.minecraft.core.entity.animal.EntityAnimal;
import net.minecraft.core.entity.animal.EntityCow;
import net.minecraft.core.item.Item;
import net.minecraft.core.world.World;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(value = EntityCow.class, remap = false)
public class CowMixin  extends EntityAnimal {
	private Random random = new Random();

	public CowMixin(World world) {
		super(world);
	}

	@Inject(method = "dropFewItems", at = @At("HEAD"))
	public void dropRennet(CallbackInfo ci){
		int i = random.nextInt(3);
		if (i == 0){
			spawnAtLocation(CheeseModItems.salt.id, 1);
		}
	}

}
