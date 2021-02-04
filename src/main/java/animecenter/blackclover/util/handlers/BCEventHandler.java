package animecenter.blackclover.util.handlers;

import animecenter.blackclover.magic.MagicOverlayRenderer;
import animecenter.blackclover.util.helpers.LazyHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

@Mod.EventBusSubscriber
public class BCEventHandler
{
	@SubscribeEvent
	public static void updateMana(PlayerTickEvent event)
	{
		//TODO add level math
		int tick;
		EntityPlayer player = event.player;
		NBTTagCompound tag = player.getEntityData();
		if(!player.getEntityWorld().isRemote)
		{
			if(tag.hasKey("bcManaActive") && tag.getBoolean("bcManaActive"))
			{
				if(LazyHelper.canRegenerateMana(player))
				{
					int mana = tag.getInteger("bcMana");
					int cap =  tag.getInteger("bcManaCap");
					int level = tag.getInteger("bcLevel");
					if(mana<cap)
					{
						mana++;
						tag.setInteger("bcMana", mana);
					}
					MagicOverlayRenderer.instance.setPlayer(player);
				}
			}
		}
	}
	
	@SubscribeEvent
	public static void activateMana(PlayerEvent.LoadFromFile event)
	{
		if(event.getEntityLiving() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.getEntityLiving();
			NBTTagCompound tag = player.getEntityData();
			if(!tag.hasKey("bcManaActive"))
			{
				tag.setBoolean("bcManaActive", true);
				tag.setBoolean("bcManaRegen", true);
				tag.setInteger("bcMana", 0);
				tag.setInteger("bcManaCap", 1000);
				tag.setInteger("bcLevel", 1);
			}
		}
	}
	

}
