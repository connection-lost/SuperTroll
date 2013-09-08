package me.crafter.mc.supertroll;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

public class TrollClass implements Runnable{

	public SuperTroll plugin;
	
	public TrollClass(SuperTroll plugin){
		this.plugin = plugin;
	}
	
	@Override
	public void run() {
		for (Player x:plugin.get2()){
			if (!x.isOnline()){
				plugin.get2().remove(x);
				break;
			}
			x.removePotionEffect(PotionEffectType.CONFUSION);
			x.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 160, 2));
		}
		for (Player x:plugin.get3()){
			if (!x.isOnline()){
				plugin.get3().remove(x);
				break;
			}
			x.removePotionEffect(PotionEffectType.BLINDNESS);
			x.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 160, 2));
		}
		for (final Player x:plugin.get6()){
			if (!x.isOnline()){
				plugin.get6().remove(x);
				break;
			}
			final BukkitTask thetask = Bukkit.getServer().getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					x.damage(0D);
				}

			}, 0L, 10L);
			Bukkit.getServer().getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					thetask.cancel();
				}
			}, 51L);
		}
		for (final Player x:plugin.get8()){
			if (!x.isOnline()){
				plugin.get8().remove(x);
				break;
			}
			final BukkitTask thetask = Bukkit.getServer().getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					for (int count = 0; count<9; count++){
						x.playEffect(x.getLocation(),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(1,2,-1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(-1,2,-1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(1,2,1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(-1,2,1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(1,1,-1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(-1,1,-1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(1,1,1),Effect.POTION_BREAK, count);
						x.playEffect(x.getLocation().add(-1,1,1),Effect.POTION_BREAK, count);
					}
				}

			}, 0L, 4L);
			Bukkit.getServer().getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					thetask.cancel();
				}
			}, 59L);
		}
		for (final Player x:plugin.get9()){
			if (!x.isOnline()){
				plugin.get9().remove(x);
				break;
			}
			
			final BukkitTask thetask = Bukkit.getServer().getScheduler().runTaskTimer(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					x.getWorld().playSound(x.getLocation(), Sound.PORTAL, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.EXPLODE, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.GHAST_CHARGE, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.GHAST_DEATH, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.GHAST_SCREAM, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.GHAST_SCREAM2, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.ENDERMAN_HIT, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.ENDERMAN_SCREAM, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.ZOMBIE_IDLE, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.SPIDER_IDLE, 50, 1);
					x.getWorld().playSound(x.getLocation(), Sound.IRONGOLEM_HIT, 50, 1);
				}

			}, 0L, 20L);
			Bukkit.getServer().getScheduler().runTaskLater(Bukkit.getPluginManager().getPlugin("SuperTroll") , new Runnable() {
				public void run(){
					thetask.cancel();
				}
			}, 59L);
			
		}
		
	}

}
