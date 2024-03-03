package dundigundi.cheesemod.gui;

import dundigundi.cheesemod.block.entity.TileEntityCheeseMaker;
import net.minecraft.core.InventoryAction;
import net.minecraft.core.crafting.ICrafting;
import net.minecraft.core.entity.player.EntityPlayer;
import net.minecraft.core.player.inventory.Container;
import net.minecraft.core.player.inventory.InventoryPlayer;
import net.minecraft.core.player.inventory.slot.Slot;

import java.util.List;

public class ContainerCheeseMaker extends Container {
	private int milkBucketAmount = 0;
	private int currentCheeseMakerTime = 0;
	InventoryPlayer inventory;
	TileEntityCheeseMaker tileEntity;

	public ContainerCheeseMaker(InventoryPlayer inventory, TileEntityCheeseMaker tileEntity) {
		this.inventory = inventory;
		this.tileEntity = tileEntity;
		addSlot(new Slot(tileEntity, 0, 28, 55)); //milk bucket slot
		addSlot(new Slot(tileEntity, 1, 72, 35)); //salt slot
		addSlot(new Slot(tileEntity, 2, 128, 35)); // produced good slot

		for(int xSlot = 0; xSlot < 3; ++xSlot)
			for (int ySlot = 0; ySlot < 9; ++ySlot)
				addSlot(new Slot(inventory, ySlot + xSlot * 9 + 9, 8 + ySlot * 18, 84 + xSlot * 18));

		for(int hotbar = 0; hotbar < 9; ++hotbar)
			addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
	}

	@Override
	public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
		if (slot.id >= 3 && slot.id <= 39) {
			if (action != InventoryAction.MOVE_ALL) {
				if (target == 1) {
					return this.getSlots(0, 1, false);
				}

				if (target == 2) {
					return this.getSlots(1, 1, false);
				}
				if (slot.id >= 3 && slot.id <= 29) {
					return this.getSlots(30, 9, false);
				}

				if (slot.id >= 31 && slot.id <= 38) {
					return this.getSlots(3, 27, false);
				}
			}
		}
		if (slot.id >= 0 && slot.id <= 2) {
			return slot.id == 2 ? this.getSlots(3, 36, true) : this.getSlots(3, 36, false);
		} else {
			return null;
		}
	}

	@Override
	public void updateInventory() {
		super.updateInventory();

		for(ICrafting crafter : this.crafters) {

			if (this.currentCheeseMakerTime != tileEntity.currentCheeseMakerTime)
				crafter.updateCraftingInventoryInfo(this, 0, tileEntity.currentCheeseMakerTime);
		}
	}

	@Override
	public List<Integer> getMoveSlots(InventoryAction inventoryAction, Slot slot, int i, EntityPlayer entityPlayer) {
		if (slot.id >= 0 && slot.id <= 3) {
			return this.getSlots(slot.id, 1, false);
		} else {
			if (inventoryAction == InventoryAction.MOVE_ALL) {
				if (slot.id >= 3 && slot.id <= 30) {
					return this.getSlots(3, 27, false);
				}

				if (slot.id >= 30 && slot.id <= 38) {
					return this.getSlots(30, 9, false);
				}
			}

			return slot.id >= 3 && slot.id <= 38 ? this.getSlots(3, 36, false) : null;
		}
	}

	@Override
	public void updateClientProgressBar(int id, int value) {
		if (id == 0) {
			this.tileEntity.currentCheeseMakerTime = value;
		}
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer entityPlayer) {
		return this.tileEntity.canInteractWith(entityPlayer);
	}
}
