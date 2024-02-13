package dundigundi.bunnomod.block;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.item.BunnoModItems;
import net.minecraft.core.block.BlockCake;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.Side;
import net.minecraft.core.world.World;
import turniplabs.halplibe.helper.TextureHelper;

public class BlockBlockofCheese extends BlockCake {
	public BlockBlockofCheese(String key, int id) {
		super(key, id);
	}
	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		return dropCause != EnumDropCause.PICK_BLOCK && meta != 0 ? null : new ItemStack[]{new ItemStack(BunnoModBlocks.blockOfCheese)};
	}
	@Override
	public boolean blockActivated(World world, int x, int y, int z, EntityPlayer player) {
		this.eatCakeSlice(world, x, y, z, player);
		return true;
	}
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer player) {
		this.eatCakeSlice(world, x, y, z, player);
	}
	private void eatCakeSlice(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (entityplayer.inventory.getCurrentItem().itemID == BunnoModItems.knife.id){
			entityplayer.inventory.insertItem(new ItemStack(BunnoModItems.cheeseSlice),false);
			entityplayer.inventory.getCurrentItem().damageItem(1, entityplayer);
			int l = world.getBlockMetadata(i, j, k) + 1;
			if (l >= 6) {
				world.setBlockWithNotify(i, j, k, 0);
			} else {
				world.setBlockMetadataWithNotify(i, j, k, l);
				world.markBlockDirty(i, j, k);
			}
		} else{
			if (entityplayer.health < 20) {
				entityplayer.heal(2);
				int l = world.getBlockMetadata(i, j, k) + 1;
				if (l >= 6) {
					world.setBlockWithNotify(i, j, k, 0);
				} else {
					world.setBlockMetadataWithNotify(i, j, k, l);
					world.markBlockDirty(i, j, k);
				}
			}
		}

	}
	@Override
	public int getBlockTextureFromSideAndMetadata(Side side, int data) {
		return data > 0 && side == Side.WEST ? TextureHelper.getOrCreateBlockTextureIndex(BunnoMod.MOD_ID, "blockOfCheeseSide.png") : this.atlasIndices[side.getId()];
	}
}
