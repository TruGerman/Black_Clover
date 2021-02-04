package animecenter.blackclover.util.helpers;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public final class LazyHelper 
{

	public static boolean isManaActive(EntityPlayer player) 
	{
		NBTTagCompound tag = player.getEntityData();
		return tag.hasKey("bcManaActive");
	}
	
	public static boolean canRegenerateMana(EntityPlayer player) 
	{
		NBTTagCompound tag = player.getEntityData();
		return tag.getBoolean("bcManaRegen");
	}
	
	public static int getLevel(EntityPlayer player)
	{
		if(player.getEntityData().hasKey("bclevel"))
		{
		return player.getEntityData().getInteger("bcLevel");
		}
		return 0;
	}
	//what the fuck even is this 
	//update 5 days later: I just took another look and this makes even less sense now
	public static String getPlayer(long id, World world)
	{
		return world.getPlayerEntityByUUID(new UUID(id, id)).getName();
	}
	//TODO this
	///WIP
	public static int getCenter()
	{
		return 0;
	}
	
	
}
