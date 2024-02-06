package dundigundi.bunnomod.items;

import com.mojang.nbt.Tag;
import dundigundi.bunnomod.BunnoMod;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.sound.block.BlockSounds;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.block.tag.BlockTags;
import net.minecraft.core.crafting.LookupFuelFurnace;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemCoal;
import net.minecraft.core.item.tag.ItemTags;
import net.minecraft.core.item.tool.ItemToolPickaxe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.helper.BlockBuilder;
import turniplabs.halplibe.helper.ItemHelper;
import turniplabs.halplibe.util.GameStartEntrypoint;


public class BunnoModItems {
	public static final String MOD_ID = BunnoMod.MOD_ID;
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	//Ore
	public static Item oreBrownCoal;

	public void initializeItems() {
		int startingItemId = 16600;

		oreBrownCoal = ItemHelper.createItem(MOD_ID, new Item(startingItemId++), "ore.brownCoal", "oreBrownCoal.png");
	}
}
