package dundigundi.bunnomod.blocks;

import dundigundi.bunnomod.BunnoMod;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import dundigundi.bunnomod.BunnoModConfig;


public class BunnoModBlocks {
	public static final String MOD_ID = BunnoMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private int nextBlockID(String blockName) {
		return BunnoModConfig.cfg.getInt("Block IDs." + blockName);
	}

	//Blocks
	public static Block brownCoalStone;
	public static Block brownCoalBasalt;
	public static Block brownCoalLimestone;
	public static Block brownCoalGranite;

	private void pickaxeLevels() {
		ItemToolPickaxe.miningLevels.put(brownCoalStone, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalBasalt, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalLimestone, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalGranite, 1);
	}


	public void initializeBlocks() {

		BlockBuilder oreBuilder = new BlockBuilder(MOD_ID)
				.setBlockSound(BlockSounds.STONE)
				.setResistance(3f)
				.setHardness(3f)
				.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		brownCoalStone = oreBuilder
				.setTextures("brownCoal_stone.png")
				.build(new BlockBrownCoal("brownCoal.stone", nextBlockID("brownCoalStone"), Material.stone));
		brownCoalBasalt = oreBuilder
				.setTextures("brownCoal_basalt.png")
				.build(new BlockBrownCoal("brownCoal.basalt", nextBlockID("brownCoalBasalt"), Material.stone));
		brownCoalLimestone = oreBuilder
				.setTextures("brownCoal_limestone.png")
				.build(new BlockBrownCoal("brownCoal.limestone", nextBlockID("brownCoalLimestone"), Material.stone));
		brownCoalGranite = oreBuilder
				.setTextures("brownCoal_granite.png")
				.build(new BlockBrownCoal("brownCoal.granite", nextBlockID("brownCoalGranite"), Material.stone));

		pickaxeLevels();
	}
}
