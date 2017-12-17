package me.badbones69.envoy.controllers;

import java.util.ArrayList;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class FireworkDamageAPI implements Listener {
	
	private Plugin plugin;
	private static ArrayList<Entity> fireworks = new ArrayList<Entity>();
	
	public FireworkDamageAPI(Plugin plugin) {
		this.plugin = plugin;
	}
	
	/**
	 * 
	 * @return All the active fireworks.
	 */
	public static ArrayList<Entity> getFireworks() {
		return fireworks;
	}
	
	/**
	 * 
	 * @param firework The firework you want to add.
	 */
	public static void addFirework(Entity firework) {
		fireworks.add(firework);
	}
	
	/**
	 * 
	 * @param firework The firework you are removing.
	 */
	public static void removeFirework(Entity firework) {
		if(fireworks.contains(firework)) {
			fireworks.remove(firework);
		}
	}
	
	@EventHandler
	public void fireworkDamageEvent(EntityDamageByEntityEvent e) {
		Entity fw = e.getDamager();
		if (fireworks.contains(fw)) {
			e.setCancelled(true);
		}
	}
}
