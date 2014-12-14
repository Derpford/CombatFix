package combatFix;

import java.util.HashMap;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = CombatFixMain.MODID, version = CombatFixMain.VERSION)
public class CombatFixMain
{
    public static final String MODID = "combatfix";
    public static final String VERSION = "1.2";
    
    public static HashMap<String, Integer> attackTimer = new HashMap<String, Integer>();
    public static HashMap<String, Integer> guardTimer = new HashMap<String, Integer>();
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		MinecraftForge.EVENT_BUS.register(new EntityAttackHandler());
    }
}
