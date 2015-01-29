package combatFix;

import java.lang.reflect.Method;
import java.util.HashMap;

import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;

@Mod(modid = CombatFixMain.MODID, version = CombatFixMain.VERSION)
public class CombatFixMain
{
    public static final String MODID = "combatfix";
    public static final String VERSION = "1.2";
    int hasPrintedVars = 0;
    public static HashMap<String, Integer> attackTimer = new HashMap<String, Integer>();
    public static HashMap<String, Integer> guardTimer = new HashMap<String, Integer>();
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		MinecraftForge.EVENT_BUS.register(new EntityAttackHandler());
		MinecraftForge.EVENT_BUS.register(new EntitySkeletonHandler());
		Class<?> arrowAttackClass = null;
		try {
			arrowAttackClass = Class.forName("net.minecraft.entity.ai.EntityAIArrowAttack");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Method[] arrowMethods = arrowAttackClass.getMethods();
		String arrowUpdateMethod = arrowMethods[1].getName()
		if(hasPrintedVars == 0)
		{
			System.out.println("Getting skeleton arrow methods!");
			for(int i = 0; i < arrowMethods.length; i++)
			{
				System.out.println("Method "+i+":"+arrowMethods[i].toString());
			}
			hasPrintedVars = 1;
		}
    }
}
