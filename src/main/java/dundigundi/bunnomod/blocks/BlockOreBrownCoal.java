package dundigundi.bunnomod.blocks;


import dundigundi.bunnomod.items.BunnoModItems;
import net.minecraft.core.block.Block;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.block.material.Material;
import net.minecraft.core.enums.EnumDropCause;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;

public class BlockOreBrownCoal extends Block {
	public BlockOreBrownCoal(String key, int id, Material material) {
		super(key, id, material);
	}

	@Override
	public ItemStack[] getBreakResult(World world, EnumDropCause dropCause, int x, int y, int z, int meta, TileEntity tileEntity) {
		switch (dropCause) {
			case SILK_TOUCH:
			case PICK_BLOCK:
				return new ItemStack[]{new ItemStack(this)};
			case PROPER_TOOL:
				return new ItemStack[]{new ItemStack(BunnoModItems.oreBrownCoal, 1)};
			default:
				return null;
		}
	}
}
