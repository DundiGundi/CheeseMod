package dundigundi.bunnomod.world;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.block.BunnoModBlocks;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.world.World;
import net.minecraft.core.world.generate.feature.WorldFeature;
import net.minecraft.core.world.generate.feature.WorldFeatureClay;
import net.minecraft.core.world.generate.feature.WorldFeatureSponge;

import java.util.Random;

public class WorldFeatureSaltBlock extends WorldFeatureSponge {
	public WorldFeatureSaltBlock(){
		super();
	}
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		if (world.getBlockId(x, y - 1, z) != Block.fluidWaterStill.id) {
			return false;
		} else {
			for(int l = 0; l < 16; ++l) {
				int i1 = x + random.nextInt(8) - random.nextInt(8);

				int k1;
				for(k1 = z + random.nextInt(8) - random.nextInt(8); world.getBlockId(i1, y - 1, k1) == Block.fluidWaterStill.id; --y) {
				}

				if ((world.getBlockId(i1, y - 1, k1) == Block.sand.id || world.getBlockId(i1, y - 1, k1) == Block.dirt.id) && world.getBlockId(i1, y + 1, k1) != 0) {
					world.setBlockRaw(i1, y, k1, BunnoModBlocks.blockSalt.id);
				}
			}
			return true;
		}
	}
}
