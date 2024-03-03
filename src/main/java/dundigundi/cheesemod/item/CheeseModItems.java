package dundigundi.cheesemod.item;


import dundigundi.cheesemod.CheeseMod;
import dundigundi.cheesemod.CheeseModConfig;
import dundigundi.cheesemod.block.CheeseModBlocks;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFoodStackable;
import net.minecraft.core.item.ItemPlaceable;
import net.minecraft.core.item.material.ToolMaterial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;


public class CheeseModItems {
	public static final String MOD_ID = CheeseMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	private int nextItemID(String itemName) {
		return CheeseModConfig.cfg.getInt("Item IDs." + itemName);
	}

	public static Item brownCoal;
	public static Item cheeseSlice;
	public static Item salt;
	public static Item knife;
	public static Item cheeseBlock;

	public void initializeItems() {

		brownCoal = ItemHelper.createItem(MOD_ID, new Item(nextItemID("brownCoal")), "brownCoal", "brownCoal.png");
		cheeseSlice = ItemHelper.createItem(MOD_ID, new ItemFoodStackable("cheeseSlice",nextItemID("cheeseSlice"), 1, false, 4), "cheeseSlice", "cheeseSlice.png");
		knife = ItemHelper.createItem(MOD_ID, new ItemToolKnife("knife", nextItemID("knife"), 2, ToolMaterial.wood), "knife", "knife.png");
		salt = ItemHelper.createItem(MOD_ID, new Item(nextItemID( "salt")), "salt", "salt.png");
		cheeseBlock = ItemHelper.createItem(MOD_ID, new ItemPlaceable("cheeseBlock", nextItemID("cheeseBlock"), CheeseModBlocks.blockOfCheese).setMaxStackSize(1), "cheeseBlock", "cheeseBlock.png");
	}
}