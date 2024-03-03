package dundigundi.bunnomod.block.entity;

import com.mojang.nbt.CompoundTag;
import com.mojang.nbt.ListTag;
import dundigundi.bunnomod.block.BlockCheeseMaker;
import dundigundi.bunnomod.block.BunnoModBlocks;
import dundigundi.bunnomod.recipe.RecipesCheeseMaker;
import net.minecraft.core.block.entity.TileEntity;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.player.inventory.IInventory;

public class TileEntityCheeseMaker extends TileEntity implements IInventory {
	private final RecipesCheeseMaker recipes = new RecipesCheeseMaker();
	private boolean makingCheese = false;
	public int currentCheeseMakerTime = 0;
	public int maxCheeseMakerTime = 400;
	public int currentMilkAmount = 0;
	public int maxMilkAmount = 4;
	protected ItemStack[] contents = new ItemStack[3];

	public String getInvName() {
		return "CheeseMaker";
	}

	public TileEntityCheeseMaker() {
	}

	@Override
	public int getSizeInventory() {
		return contents.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return contents[i];
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		if (contents[i] != null) {
			if (contents[i].stackSize <= j) {
				ItemStack itemstack = contents[i];
				contents[i] = null;
				return itemstack;
			} else {
				ItemStack splitStack = contents[i].splitStack(j);
				if (contents[i].stackSize <= 0) {
					contents[i] = null;
				}

				return splitStack;
			}
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemStack) {
		contents[i] = itemStack;
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
			itemStack.stackSize = getInventoryStackLimit();

		onInventoryChanged();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityPlayer) {
		if (worldObj.getBlockTileEntity(x, y, z) != this)
			return false;

		return entityPlayer.distanceToSqr(x + 0.5f, y + 0.5f, z + 0.5f) <= 64;
	}

	@Override
	public void sortInventory() {

	}

	@Override
	public void onInventoryChanged() {
		if (contents[0] != null){
			if (contents[0].getItem() == Item.bucketMilk && currentMilkAmount < maxMilkAmount){
				++currentMilkAmount;
				contents[0] = new ItemStack(Item.bucket);
			}
		}
		super.onInventoryChanged();
	}

	@Override
	public void tick() {
		super.tick();
		if (currentCheeseMakerTime > maxCheeseMakerTime)
			currentCheeseMakerTime = 0;

		boolean cheeseMakerUpdated = false;

		if (worldObj.getBlockId(x, y, z) == BunnoModBlocks.cheeseMaker.id &&
				currentCheeseMakerTime == 0 &&
				contents[1] == null) {
			BlockCheeseMaker.updateBlockState(true, worldObj, x, y, z);
			cheeseMakerUpdated = true;
		}

		if (canProduce()) {
			++currentCheeseMakerTime;
			makingCheese = true;

			if (currentCheeseMakerTime == maxCheeseMakerTime) {
				currentCheeseMakerTime = 0;
				produceItem();
				makingCheese = false;
				cheeseMakerUpdated = true;
			}
		} else {
			currentCheeseMakerTime = 0;
			makingCheese = false;
		}

		if (cheeseMakerUpdated)
			onInventoryChanged();

		if (makingCheese)
			worldObj.notifyBlockChange(x, y, z, BunnoModBlocks.cheeseMaker.id);
	}

	@Override
	public void writeToNBT(CompoundTag CompoundTag) {
		super.writeToNBT(CompoundTag);
		CompoundTag.putInt("CheeseMakerTime", currentCheeseMakerTime);

		ListTag listTag = new ListTag();
		for (int i = 0; i < contents.length; i++) {
			if (contents[i] != null) {
				CompoundTag compoundTag2 = new CompoundTag();

				compoundTag2.putInt("Slot", i);
				contents[i].writeToNBT(compoundTag2);
				listTag.addTag(compoundTag2);
			}
		}
		CompoundTag.put("Items", listTag);
	}

	@Override
	public void readFromNBT(CompoundTag CompoundTag) {
		super.readFromNBT(CompoundTag);
		currentCheeseMakerTime = CompoundTag.getInteger("CheeseMakerTime");

		ListTag listTag = CompoundTag.getList("Items");

		contents = new ItemStack[getSizeInventory()];
		for (int i = 0; i < listTag.tagCount(); i++) {
			CompoundTag compoundTag2 = (com.mojang.nbt.CompoundTag) listTag.tagAt(i);
			int slot = compoundTag2.getInteger("Slot");

			if (slot >= 0 && slot < contents.length)
				contents[slot] = ItemStack.readItemStackFromNbt(compoundTag2);
		}
	}

	private boolean isProducible(ItemStack itemStack) {
		return recipes.getRecipeList().containsKey(itemStack.getItem().id);
	}

	private boolean canProduce() {
		if (contents[1] != null && contents[1].getItem() != null && currentMilkAmount != 0) {
			if (isProducible(contents[1])) {
				ItemStack resultStack = recipes.getRecipeResult(contents[1].getItem().id);

				return contents[2] == null || contents[2].getItem() == resultStack.getItem() &&
						contents[2].stackSize + resultStack.stackSize <= resultStack.getMaxStackSize();
			}
		}
		return false;
	}

	private void produceItem() {
		if (canProduce()) {
			ItemStack itemStack = recipes.getRecipeResult(contents[1].getItem().id);

			if (contents[2] == null)
				contents[2] = itemStack.copy();
			else
			if (contents[2].itemID == itemStack.itemID)
				contents[2].stackSize += itemStack.stackSize;

			--contents[1].stackSize;
			--currentMilkAmount;

			if (contents[1].stackSize <= 0)
				contents[1] = null;
		}
	}

}
