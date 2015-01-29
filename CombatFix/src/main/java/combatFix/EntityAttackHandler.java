package combatFix;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemSword;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityAttackHandler {

	@SubscribeEvent
	public void onAttackEntityEvent(AttackEntityEvent event) //When the player is attacking...
	{
		String PlayerName = event.entityPlayer.getDisplayName();
		if(!CombatFixMain.attackTimer.containsKey(PlayerName)) //If the player's timer isn't initialized...
		{
			CombatFixMain.attackTimer.put(PlayerName, 0); //Set the timer.
		}
		if(CombatFixMain.attackTimer.get(PlayerName) == 0) //If the player's timer is at zero, we can set it back to 15
		{
			CombatFixMain.attackTimer.put(PlayerName, 10);
		}
		
	}
	
	@SubscribeEvent
	public void onLivingAttackEvent(LivingAttackEvent event) //When an entity is attacked...
	{
		if(event.source.getEntity() != null) //If it's from an entity
		{
			Entity attacker = event.source.getEntity(); //Figure out who attacked
			if(attacker instanceof EntityPlayer) //If it was a player
			{
				int time = CombatFixMain.attackTimer.get(((EntityPlayer) attacker).getDisplayName()); //Get their combat timer
				System.out.println("Attacker's Timer: " + time);
				if(time > 0 && time < 9) //Can't attack before the timer's over!
				{
					event.setCanceled(true); //This attack didn't count, I want a do-over!
				}
			}
			if(event.entityLiving instanceof EntityPlayer)
			{
				String name = ((EntityPlayer) event.entityLiving).getDisplayName();
				World world = ((EntityPlayer) event.entityLiving).worldObj;
				if(CombatFixMain.guardTimer.get(name) < 10 && CombatFixMain.guardTimer.get(name) != 0)
				{
					world.playSoundAtEntity(attacker, "minecraft:random.anvil_land", 1, 1);
					attacker.attackEntityFrom(DamageSource.causeMobDamage(event.entityLiving), 0);
					event.setCanceled(true);
				}
			}
		}
	}
	
	@SubscribeEvent
	public void onPlayerBlock(PlayerUseItemEvent.Tick event)
	{
		if(event.item.getItem() instanceof ItemSword) //If the player's blocking with a sword, instead of using some other tool
		{
			String name = event.entityPlayer.getDisplayName();
			CombatFixMain.guardTimer.put(name, CombatFixMain.guardTimer.get(name) + 1);
			System.out.println("Defender's Timer: " + CombatFixMain.guardTimer.get(name));
		}
	}
	
	/*@SubscribeEvent
	public void onPlayerStopBlocking(PlayerUseItemEvent.Stop event)
	{
		String name = event.entityPlayer.getDisplayName();
		CombatFixMain.guardTimer.put(name, 0);
	}*/
	
	@SubscribeEvent
	public void onLivingUpdateEvent(LivingUpdateEvent event)
	{
		if(event.entityLiving instanceof EntityPlayer) //If it's a player
		{
			String PlayerName = ((EntityPlayer) event.entityLiving).getDisplayName(); //Get their name
			if(!CombatFixMain.attackTimer.containsKey(PlayerName)) //Check if they've got a timer
			{
				CombatFixMain.attackTimer.put(PlayerName, 0); //Set it at zero if they do.
			}
			if(CombatFixMain.attackTimer.get(PlayerName) > 0) //If their timer's running
			{
				CombatFixMain.attackTimer.put(PlayerName, CombatFixMain.attackTimer.get(PlayerName)-1); //Decrement the timer.
			}
			
			if(!CombatFixMain.guardTimer.containsKey(PlayerName)) //Check if they've got a timer
			{
				CombatFixMain.guardTimer.put(PlayerName, 0); //Set it at zero if they do.
			}
			if(CombatFixMain.guardTimer.get(PlayerName) > 0 && !((EntityPlayer) event.entityLiving).isBlocking()) //If their timer's running
			{
				CombatFixMain.guardTimer.put(PlayerName, CombatFixMain.guardTimer.get(PlayerName)-1); //Decrement the timer.
			}
		}
	}
}
