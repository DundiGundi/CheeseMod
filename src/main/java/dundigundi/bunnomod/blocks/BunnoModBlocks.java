package dundigundi.bunnomod.blocks;

import dundigundi.bunnomod.BunnoMod;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class BunnoModBlocks {
	public static final String MOD_ID = BunnoMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);


	//Blocks
	public static Block oreBrownCoalStone;

	private void pickaxeLevels() {
		ItemToolPickaxe.miningLevels.put(oreBrownCoalStone, 1);
	}


	public void initializeBlocks() {
		int startingBlockId = 2000;

		BlockBuilder oreBuilder = new BlockBuilder(MOD_ID)
				.setBlockSound(BlockSounds.STONE)
				.setResistance(3f)
				.setHardness(3f)
				.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		oreBrownCoalStone = oreBuilder
				.setTextures("oreBrownCoalStone.png")
				.build(new BlockOreBrownCoal("ore.brownCoal.stone", startingBlockId++, Material.stone));

		pickaxeLevels();
	}
}
