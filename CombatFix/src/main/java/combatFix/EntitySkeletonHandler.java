package combatFix;

import java.lang.reflect.Field;

import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

/*
 * Special thanks to Asie, who mentioned that coremodding is horrendously hard and that--if done right--reflections can be easier.
 * Also, obligatory "asie-sempai noticed me kawaii uguu~".
 */


public class EntitySkeletonHandler
{
	int hasPrintedVars = 0;
	@SubscribeEvent
	void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		Class<?> arrowAttackClass = null;
		try {
			arrowAttackClass = Class.forName("net.minecraft.entity.ai.EntityAIArrowAttack");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] arrowVars = arrowAttackClass.getFields();
		if(hasPrintedVars == 0)
		{
			System.out.println("Getting skeleton arrow variables!");
			for(int i = 0; i < arrowVars.length; i++)
			{
				System.out.println(arrowVars[i]);
			}
			hasPrintedVars = 1;
		}
	}
}