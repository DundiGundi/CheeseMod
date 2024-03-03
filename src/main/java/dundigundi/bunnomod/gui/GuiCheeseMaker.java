package dundigundi.bunnomod.gui;

import dundigundi.bunnomod.block.entity.TileEntityCheeseMaker;
import net.minecraft.client.gui.GuiContainer;
import net.minecraft.core.block.entity.TileEntityBlastFurnace;
import net.minecraft.core.block.entity.TileEntityFurnace;
import net.minecraft.core.lang.I18n;
import net.minecraft.core.player.inventory.InventoryPlayer;
import org.lwjgl.opengl.GL11;

public class GuiCheeseMaker extends GuiContainer {
	private final TileEntityCheeseMaker tileEntity;
	I18n i18n = I18n.getInstance();

	public GuiCheeseMaker(InventoryPlayer inventory, TileEntityCheeseMaker tileEntity) {
		super(new ContainerCheeseMaker(inventory, tileEntity));
		this.tileEntity = tileEntity;
		this.xSize = 176;
	}

	@Override
	protected void drawGuiContainerForegroundLayer() {
		I18n i18n = I18n.getInstance();
		this.fontRenderer.drawString("Cheese Maker", 60, 6, 4210752);
		this.fontRenderer.drawString("Inventory", 8, this.ySize - 96 + 3, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f) {
		int texture = mc.renderEngine.getTexture("/assets/bunnomod/gui/cheeseMaker.png");
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		mc.renderEngine.bindTexture(texture);

		int scrnX = (width - xSize) / 2;
		int scrnY = (height - ySize) / 2;
		drawTexturedModalRect(scrnX, scrnY, 0, 0, xSize, ySize);

		int cheeseMakerTime =  tileEntity.maxCheeseMakerTime == 0 ? 0 : tileEntity.currentCheeseMakerTime * 12 / tileEntity.maxCheeseMakerTime;
		drawTexturedModalRect(scrnX + 96, scrnY + 35, 177, 0, cheeseMakerTime, 16); //pos of the arrow that keeps growing with cheeseMakerTime
	}

	@Override
	public void drawScreen(int x, int y, float renderPartialTicks) {
		super.drawScreen(x, y, renderPartialTicks);
	}
}
