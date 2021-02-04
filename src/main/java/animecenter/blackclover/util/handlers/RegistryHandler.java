package animecenter.blackclover.util.handlers;

import animecenter.blackclover.BlackClover;
import animecenter.blackclover.blocks.ModBlocks;
import animecenter.blackclover.items.ModItems;
import animecenter.blackclover.magic.MagicOverlayRenderer;
import animecenter.blackclover.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

@Mod.EventBusSubscriber
public class RegistryHandler 
{
	
	 @SubscribeEvent
	    public static void registerItems(RegistryEvent.Register<Item> event)
	    {
	        event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	    }
	    
	    @SubscribeEvent
	    public static void registerBlocks(RegistryEvent.Register<Block> event) 
	    {
	    	event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));

	    }
	    
	    @SubscribeEvent
	    public static void onModelRegister(ModelRegistryEvent event)
	    {
	        for(Item item : ModItems.ITEMS)
	        {
	            if(item instanceof IHasModel)
	            {
	                ((IHasModel)item).registerModels();
	            }
	        }
	        
	        for(Block block : ModBlocks.BLOCKS)
			{
				if(block instanceof IHasModel)
				{
					((IHasModel)block).registerModels();
				}
			}
	    }
	
	
	public static void preInit()
	{
		MinecraftForge.EVENT_BUS.register(MagicOverlayRenderer.instance);
		
	}
	
	
	public static void init()
	{
		NetworkRegistry.INSTANCE.registerGuiHandler(BlackClover.instance, new GuiHandler());
		
	}
	
	
	public static void postInit()
	{
		
	}
	
	
}
