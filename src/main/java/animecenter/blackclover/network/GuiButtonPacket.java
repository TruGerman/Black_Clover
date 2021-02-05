package animecenter.blackclover.network;

import animecenter.blackclover.magic.Spell;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class GuiButtonPacket implements IMessage 
{
	
	private int spellCode;
	
	public GuiButtonPacket() 
	{
	}
	
	public GuiButtonPacket(int code)
	{
		this.spellCode = code;
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		//wait...I can't write strings? ah f...looks like I'll be needing the SpellMap after all...good thing I still have it
		buf.writeInt(spellCode);
	}
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.spellCode = buf.readInt();
	}
	
	public static class GuiButtonPacketHandler /*holy fuck that's a long name*/ implements IMessageHandler<GuiButtonPacket, IMessage> 
	{
		
		@Override
		public IMessage onMessage(GuiButtonPacket message, MessageContext ctx) 
		{
			EntityPlayer player = ctx.getServerHandler().player;
			player.getServer().addScheduledTask(() -> player.getHeldItem(player.getActiveHand()).getTagCompound().setString("bcLastMagic", Spell.getMap().get(message.spellCode).getName()));
			return null;
		}
		
	}

}
