package dundigundi.cheesemod.block;

import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.CheeseModTags;
import dundigundi.cheesemod.block.entity.TileEntityCheeseMaker;
import dundigundi.cheesemod.gui.ContainerCheeseMaker;
import dundigundi.cheesemod.gui.GuiCheeseMaker;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sunsetsatellite.catalyst.Catalyst;
import sunsetsatellite.catalyst.core.util.MpGuiEntry;
import turniplabs.halplibe.helper.BlockBuilder;
import dundigundi.cheesemod.CheeseModConfig;
import turniplabs.halplibe.helper.EntityHelper;


public class CheeseModBlocks {
	public static final String MOD_ID = CheeseMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private int nextBlockID(String blockName) {
		return CheeseModConfig.cfg.getInt("Block IDs." + blockName);
	}

	//Coal
	public static Block brownCoalStone;
	public static Block brownCoalBasalt;
	public static Block brownCoalLimestone;
	public static Block brownCoalGranite;

	//Sandlike
	public static Block blockSalt;

	//Food
	public static Block blockOfCheese;

	//Machines
	public static Block cheeseMaker;

	private void pickaxeLevels() {
		ItemToolPickaxe.miningLevels.put(brownCoalStone, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalBasalt, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalLimestone, 1);
		ItemToolPickaxe.miningLevels.put(brownCoalGranite, 1);
	}
	private void registerGUIs() {
		Catalyst.GUIS.register("CheeseMaker", new MpGuiEntry(TileEntityCheeseMaker.class, GuiCheeseMaker.class, ContainerCheeseMaker.class));
	}
	private void initializeTiles() {
		EntityHelper.Core.createTileEntity(TileEntityCheeseMaker.class, "CheeseMaker");
	}

	public void initializeBlocks() {

		BlockBuilder oreBuilder = new BlockBuilder(MOD_ID)
				.setBlockSound(BlockSounds.STONE)
				.setResistance(3f)
				.setHardness(3f)
				.setTags(BlockTags.MINEABLE_BY_PICKAXE);

		BlockBuilder cheeseBuilder = new BlockBuilder(MOD_ID)
				.setTopBottomTexture("blockOfCheeseTopBottom.png")
				.setSideTextures("blockOfCheeseSide.png")
				.setResistance(0.5f)
				.setHardness(0.5f);

		BlockBuilder sandBuilder = new BlockBuilder(MOD_ID)
				.setBlockSound(BlockSounds.SAND)
				.setResistance(0.5f)
				.setHardness(0.5f)
				.setTags(BlockTags.MINEABLE_BY_SHOVEL, BlockTags.CAVES_CUT_THROUGH);
		BlockBuilder machineBuilder = new BlockBuilder(MOD_ID)
				.setBlockSound(BlockSounds.WOOD)
				.setTextures(11, 3)
				.setResistance(2.5f)
				.setHardness(2.5f)
				.setTags(BlockTags.MINEABLE_BY_AXE);

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
		blockOfCheese = cheeseBuilder
				.build(new BlockBlockofCheese("blockOfCheese", nextBlockID("blockOfCheese"))
						.withDisabledStats()
						.withDisabledNeighborNotifyOnMetadataChange()
						.withTags(BlockTags.BROKEN_BY_FLUIDS, CheeseModTags.CUTTABLE_BY_KNIFE, BlockTags.NOT_IN_CREATIVE_MENU));
		blockSalt = sandBuilder
				.setTextures("block_salt.png")
				.build(new BlockSalt("block.salt", nextBlockID("blockSalt")));
		cheeseMaker = machineBuilder
				.setTextures("cheeseMakerSides.png")
				.setTopTexture("cheeseMakerTop.png")
				.build(new BlockCheeseMaker("cheeseMaker", nextBlockID("cheeseMaker"), Material.wood));
		registerGUIs();
		initializeTiles();
		pickaxeLevels();
	}
}
