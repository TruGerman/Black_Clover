package animecenter.blackclover.containers;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;

//TODO all of this
public abstract class ContainerGrimoireBase extends GuiContainer 
{

	public ContainerGrimoireBase(Container inventorySlotsIn) 
	{
		super(inventorySlotsIn);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		
	}
}
