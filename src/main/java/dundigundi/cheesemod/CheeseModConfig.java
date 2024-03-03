package dundigundi.cheesemod;

import dundigundi.cheesemod.block.CheeseModBlocks;
import dundigundi.cheesemod.item.CheeseModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.item.Item;
import turniplabs.halplibe.util.ConfigUpdater;
import turniplabs.halplibe.util.TomlConfigHandler;
import turniplabs.halplibe.util.toml.Toml;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheeseModConfig {
	public static ConfigUpdater updater = ConfigUpdater.fromProperties();
	private static final Toml properties = new Toml("BunnoMod's TOML Config");
	public static TomlConfigHandler cfg;
	static {
		properties.addCategory("BunnoMod")
				.addEntry("cfgVersion", 5);

		properties.addCategory("World Gen")
				.addEntry("brownCoal", true);

		properties.addCategory("Block IDs");
		properties.addEntry("Block IDs.startingID", 2000);
		properties.addCategory("Item IDs");
		properties.addEntry("Item IDs.startingID", 16600);

		cfg = new TomlConfigHandler(updater, CheeseMod.MOD_ID, properties);

		int blockIDs = cfg.getInt("Block IDs.startingID");
		int itemIDs = cfg.getInt("Item IDs.startingID");

		List<Field> blockFields = Arrays.stream(CheeseModBlocks.class.getDeclaredFields()).filter((F)-> Block.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field blockField : blockFields) {
			properties.addEntry("Block IDs." + blockField.getName(), blockIDs++);
		}
		List<Field> itemFields = Arrays.stream(CheeseModItems.class.getDeclaredFields()).filter((F)-> Item.class.isAssignableFrom(F.getType())).collect(Collectors.toList());
		for (Field itemField : itemFields) {
			properties.addEntry("Item IDs." + itemField.getName(), itemIDs++);
		}

		cfg = new TomlConfigHandler(updater, CheeseMod.MOD_ID, properties);
	}
}
