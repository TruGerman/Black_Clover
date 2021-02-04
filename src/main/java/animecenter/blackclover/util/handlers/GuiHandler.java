package animecenter.blackclover.util.handlers;

import animecenter.blackclover.util.Constants;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler 
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
			case Constants.GUI_GRIMOIRE_FIRE:
			{
			return null;
			}

		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		switch(ID) 
		{
			case Constants.GUI_GRIMOIRE_FIRE: 
			{
			/*	if(player.getHeldItemMainhand().getItem() instanceof GrimoireBaseV2) return new GuiGrimoireFire(((GrimoireBaseV2)player.getHeldItemMainhand().getItem()).getMagicType(), player);
				if(player.getHeldItemOffhand().getItem() instanceof GrimoireBaseV2) return new GuiGrimoireFire(((GrimoireBaseV2)player.getHeldItemOffhand().getItem()).getMagicType(), player);
			*/return null;
			} //absolutely rolled, get outplayed forge
		}
		return null;
	}

}
