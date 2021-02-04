package animecenter.blackclover.items;

import java.util.ArrayList;
import java.util.List;

import animecenter.blackclover.util.Constants;
import net.minecraft.item.Item;

public class ModItems 
{

	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final GrimoireFire test_grimoire = new GrimoireFire("test_grimoire");
	public static final DebugItem debug_item = new DebugItem("debug_item", Constants.MAIN_TAB);
	
}
