package dundigundi.bunnomod.items;


import dundigundi.bunnomod.BunnoMod;
import net.minecraft.core.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.ItemHelper;


public class BunnoModItems {
	public static final String MOD_ID = BunnoMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Ore
	public static Item oreBrownCoal;

	public void initializeItems() {
		int startingItemId = 16600;

		oreBrownCoal = ItemHelper.createItem(MOD_ID, new Item(startingItemId++), "brownCoal", "brownCoal.png");
	}
}
