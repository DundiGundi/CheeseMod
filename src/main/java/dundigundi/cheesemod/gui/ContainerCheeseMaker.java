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
	private int currentCheeseMakerTime = 0;
	InventoryPlayer inventory;
	TileEntityCheeseMaker tileEntity;

	public ContainerCheeseMaker(InventoryPlayer inventory, TileEntityCheeseMaker tileEntity) {
		this.inventory = inventory;
		this.tileEntity = tileEntity;
		addSlot(new Slot(tileEntity, 0, 18, 54)); //milk bucket slot
		addSlot(new Slot(tileEntity, 1, 53, 58)); //rennet slot
		addSlot(new Slot(tileEntity, 2, 80, 58)); //salt slot
		addSlot(new Slot(tileEntity, 3, 107, 58)); //bacterium slot
		addSlot(new Slot(tileEntity, 4, 80, 13)); // produced good slot

		for(int xSlot = 0; xSlot < 3; ++xSlot)
			for (int ySlot = 0; ySlot < 9; ++ySlot)
				addSlot(new Slot(inventory, ySlot + xSlot * 9 + 9, 8 + ySlot * 18, 84 + xSlot * 18));

		for(int hotbar = 0; hotbar < 9; ++hotbar)
			addSlot(new Slot(inventory, hotbar, 8 + hotbar * 18, 142));
	}

	@Override
	public List<Integer> getTargetSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
		if (slot.id >= 0 && slot.id <= 4) {
			return this.getSlots(5, 36, false);
		}
		if (slot.id >= 5 && slot.id <= 40) {
			if (target == 1) {
				return this.getSlots(0, 4, false);
			}
			if (target == 2) {
				return this.getSlots(4, 1, false);
			}
			if (slot.id <= 31) {
				return this.getSlots(32, 9, false);
			}
			if (slot.id >= 32) {
				return this.getSlots(5, 27, false);
			}
		}
		return null;
	}

	@Override
	public void updateInventory() {
		super.updateInventory();

		for(ICrafting crafter : this.crafters) {

			if (this.currentCheeseMakerTime != tileEntity.currentCheeseMakerTime)
				crafter.updateCraftingInventoryInfo(this, 0, tileEntity.currentCheeseMakerTime);
		}
		this.currentCheeseMakerTime = this.tileEntity.currentCheeseMakerTime;
	}

	@Override
	public List<Integer> getMoveSlots(InventoryAction action, Slot slot, int target, EntityPlayer player) {
		if (slot.id >= 0 && slot.id <= 3) {
			return this.getSlots(0, 4, false);
		}
		if (slot.id == 4) {
			return this.getSlots(4, 1, false);
		}
		if (action == InventoryAction.MOVE_ALL) {
			if (slot.id >= 5 && slot.id <= 31) {
				return this.getSlots(5, 27, false);
			}
			if (slot.id >= 32 && slot.id <= 40) {
				return this.getSlots(32, 9, false);
			}
		}
		if (action == InventoryAction.MOVE_SIMILAR && slot.id >= 5 && slot.id <= 40) {
			return this.getSlots(5, 36, false);
		}
		return null;
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
