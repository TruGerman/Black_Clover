package animecenter.blackclover.util;

import animecenter.blackclover.creativetabs.GenericTab;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

public final class Constants 
{
	
//Mod
public static final String MODID = "blackclover";
public static final String VERSION = "0.0.1";
public static final String NAME = "Black Clover Mod";
public static final String MC_VERSION = "1.12.2";
public static final String CLIENT_PROXY = "animecenter.blackclover.proxy.ClientProxy";
public static final String SERVER_PROXY = "animecenter.blackclover.proxy.CommonProxy";
//Tabs
public static final GenericTab MAIN_TAB = new GenericTab("maintab", null);
public static final GenericTab GRIMOIRES = new GenericTab("grimoires", null);
//GUI
public static final int GUI_GRIMOIRE_FIRE = 1;
//Networking
public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("blackclover");

}
