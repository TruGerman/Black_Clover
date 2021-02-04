package animecenter.blackclover.magic;

import animecenter.blackclover.util.helpers.LazyHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

//how the fuck did I even write this
public class MagicOverlayRenderer 
{
	public static MagicOverlayRenderer instance = new MagicOverlayRenderer();
	private EntityPlayer player;
	
	public void setPlayer(EntityPlayer player)
	{
		this.player = player;
	}
	
	@SubscribeEvent
	public void refreshMana(RenderGameOverlayEvent event)
	{
		if (event.isCancelable() || event.getType() != RenderGameOverlayEvent.ElementType.EXPERIENCE) 
		{
            return;
        }
		Minecraft mc = Minecraft.getMinecraft();
		if(!mc.isGamePaused() && player != null)
		{
			if(LazyHelper.isManaActive(player))
			{
				//egh why does it not scale with the gui?
				int x = 375;
				int y = 0;
				GlStateManager.disableLighting();
				x = mc.fontRenderer.drawString("Mana: ", x, y, 0xffffffff);
				x = mc.fontRenderer.drawString(Integer.toString(player.getEntityData().getInteger("bcMana")), x, y, 7777);
			}
		}
	}
	
}
