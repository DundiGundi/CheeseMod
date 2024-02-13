package dundigundi.bunnomod.item;

import dundigundi.bunnomod.BunnoModTags;
import dundigundi.bunnomod.block.BunnoModBlocks;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.item.material.ToolMaterial;
import net.minecraft.core.item.tool.ItemTool;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;

public class ItemToolKnife extends ItemTool {
	public ItemToolKnife(String name, int id, int damageDealt, ToolMaterial toolMaterial) {
		super(name, id, damageDealt, toolMaterial, BunnoModTags.CUTTABLE_BY_KNIFE);
		this.maxStackSize = 1;
		this.setMaxDamage(toolMaterial.getDurability());
	}
	public boolean onItemUse(ItemStack itemstack, EntityPlayer entityplayer, World world, int blockX, int blockY, int blockZ, Side side, double xPlaced, double yPlaced) {
		int id = world.getBlockId(blockX, blockY, blockZ);
		if (id == BunnoModBlocks.blockOfCheese.id){
			BunnoModBlocks.blockOfCheese.onBlockClicked(world, blockX, blockY, blockZ, entityplayer);
			return true;
		}else{
			return false;
		}
	}
}
