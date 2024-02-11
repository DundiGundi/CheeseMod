package dundigundi.bunnomod.blocks;

import dundigundi.bunnomod.BunnoMod;
import dundigundi.bunnomod.items.BunnoModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.block.BlockCake;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.Item;
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
	public int getBlockTextureFromSideAndMetadata(Side side, int data) {
		return data > 0 && side == Side.WEST ? TextureHelper.getOrCreateBlockTextureIndex(BunnoMod.MOD_ID, "blockOfCheeseSide.png") : this.atlasIndices[side.getId()];
	}
}
