package dundigundi.cheesemod.world;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.block.CheeseModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureClay;
import net.minecraft.core.world.generate.feature.WorldFeatureSponge;

import java.util.Random;

public class WorldFeatureSaltBlock extends WorldFeature {
	public WorldFeatureSaltBlock(){
		super();
	}
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		return false;
	}
}
