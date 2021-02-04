package animecenter.blackclover.proxy;

import animecenter.blackclover.guis.GuiGrimoireFire;
import animecenter.blackclover.magic.MagicType;
import animecenter.blackclover.util.Constants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy
{
	@Override
	public void registerModel(Item item, int metadata) 
	{
		ModelLoader.setCustomModelResourceLocation(item, metadata, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
	
	@Override
	public void openGrimoireGui(int id, int level, MagicType type) 
	{
		switch(id)
		{
			case(Constants.GUI_GRIMOIRE_FIRE):
			{
				
				Minecraft.getMinecraft().addScheduledTask(() -> Minecraft.getMinecraft().displayGuiScreen(new GuiGrimoireFire(type, level)));
			}
		}
	}
	
	
}
