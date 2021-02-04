package animecenter.blackclover.containers;

import animecenter.blackclover.items.GrimoireFire;
import net.minecraft.entity.player.EntityPlayer;

public class ContainerTestGrimoire extends BaseContainer 
{

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) 
	{
		return playerIn.getHeldItemMainhand().getItem() instanceof GrimoireFire;
	}

}
