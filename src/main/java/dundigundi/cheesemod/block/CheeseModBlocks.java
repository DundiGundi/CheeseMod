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

	//salt
	public static Block oreSaltStone;
	public static Block oreSaltBasalt;
	public static Block oreSaltLimestone;
	public static Block oreSaltGranite;
	public static Block blockSalt;

	//Food
	public static Block blockOfCheese;

	//Machines
	public static Block cheeseMaker;

	private void pickaxeLevels() {
		ItemToolPickaxe.miningLevels.put(oreSaltStone, 1);
		ItemToolPickaxe.miningLevels.put(oreSaltBasalt, 1);
		ItemToolPickaxe.miningLevels.put(oreSaltLimestone, 1);
		ItemToolPickaxe.miningLevels.put(oreSaltGranite, 1);
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

		oreSaltStone = oreBuilder
				.setTextures("oreSalt_stone.png")
				.build(new BlockOreSalt("ore.salt.stone", nextBlockID("oreSaltStone"), Material.stone));
		oreSaltBasalt = oreBuilder
				.setTextures("oreSalt_basalt.png")
				.build(new BlockOreSalt("ore.salt.basalt", nextBlockID("oreSaltBasalt"), Material.stone));
		oreSaltLimestone = oreBuilder
				.setTextures("oreSalt_limestone.png")
				.build(new BlockOreSalt("ore.salt.limestone", nextBlockID("oreSaltLimestone"), Material.stone));
		oreSaltGranite = oreBuilder
				.setTextures("oreSalt_granite.png")
				.build(new BlockOreSalt("ore.salt.granite", nextBlockID("oreSaltGranite"), Material.stone));
		blockSalt = sandBuilder
				.setTextures("block_salt.png")
				.build(new BlockSalt("block.salt", nextBlockID("blockSalt")));

		blockOfCheese = cheeseBuilder
				.build(new BlockBlockofCheese("blockOfCheese", nextBlockID("blockOfCheese"))
						.withDisabledStats()
						.withDisabledNeighborNotifyOnMetadataChange()
						.withTags(BlockTags.BROKEN_BY_FLUIDS, CheeseModTags.CUTTABLE_BY_KNIFE, BlockTags.NOT_IN_CREATIVE_MENU));
		cheeseMaker = machineBuilder
				.setTextures("cheeseMakerSides.png")
				.setTopTexture("cheeseMakerTop.png")
				.build(new BlockCheeseMaker("cheeseMaker", nextBlockID("cheeseMaker"), Material.wood));

		registerGUIs();
		initializeTiles();
		pickaxeLevels();
	}
}
