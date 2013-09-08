package me.crafter.mc.supertroll;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class TrollListener implements Listener {
	
	public SuperTroll plugin;
	
	public TrollListener(SuperTroll plugin){
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event)
	{
		if (!(event instanceof EntityDamageByEntityEvent)) return;
		EntityDamageByEntityEvent edbe = (EntityDamageByEntityEvent)event;
		if (!(edbe.getDamager() instanceof Player)) return;
		Player attacker = (Player)edbe.getDamager();
		if (plugin.get4().contains(attacker)){
			event.setCancelled(true);
			attacker.damage(event.getDamage());
		}
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if (plugin.get5().contains(event.getPlayer())){
			Player p = event.getPlayer();
			event.setCancelled(true);
			p.getWorld().createExplosion(event.getBlock().getX(),event.getBlock().getY(),event.getBlock().getZ(), 0.2F, false, false);
			p.damage(8D);
			for (int count=0; count<10; count++){
				p.playEffect(event.getBlock().getLocation(), Effect.MOBSPAWNER_FLAMES, 0);
			}
		}
	}
	
	

}
