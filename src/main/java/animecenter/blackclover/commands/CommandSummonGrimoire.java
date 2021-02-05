package animecenter.blackclover.commands;

import java.util.ArrayList;
import java.util.List;

import animecenter.blackclover.items.GrimoireBaseV2;
import animecenter.blackclover.items.ModItems;
import animecenter.blackclover.util.Constants;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.server.MinecraftServer;

public class CommandSummonGrimoire extends CommandBase 
{
	
	private List<String> aliases = new ArrayList<String>();

	public CommandSummonGrimoire() 
	{
		this.aliases.add(Constants.MODID);
		this.aliases.add("summon");
	}
	
	@Override
	public List<String> getAliases() 
	{
		return this.aliases;
	}
	
	@Override
	public String getName() 
	{
		return "summon";
	}

	@Override
	public String getUsage(ICommandSender sender) 
	{
		return "summon";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(sender instanceof EntityPlayerMP)
		{
			EntityPlayerMP player = (EntityPlayerMP) sender;
			if(player.getEntityData().hasKey("isGrimoireOwner"))
			{
			NBTTagCompound tag = new NBTTagCompound();
			tag.setLong("bcGrimoireOwner", player.getPersistentID().getMostSignificantBits());
			tag.setLong("bcGrimoireOwner2", player.getPersistentID().getLeastSignificantBits());
			ItemStack stack = new ItemStack(ModItems.test_grimoire);
			stack.setTagCompound(tag);
			player.addItemStackToInventory(stack);
			}
		}
	}

}
