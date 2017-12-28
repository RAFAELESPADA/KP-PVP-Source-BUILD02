package me.RafaelAulerDeMeloAraujo.SpecialAbility;
 
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;


import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.util.Vector;

import me.RafaelAulerDeMeloAraujo.main.Main;


public class Deshfire implements Listener {


	  public int boost = Integer.valueOf(6).intValue();
	  public static ArrayList<String> Deshfire = new ArrayList();
	  static ArrayList<String> fall = new ArrayList();
	  public static HashMap<String, ItemStack[]> Armadura = new HashMap();
	  public static HashMap<String, ItemStack[]> saveinv = new HashMap();
	  public static HashMap<String, ItemStack[]> armadura = new HashMap();
	  public static HashMap<String, ItemStack[]> Armadura2 = new HashMap();
	  public static List<Player> cooldownm = new ArrayList();
	  public static Main plugin; 

	@EventHandler
	  public void DeshClick(PlayerInteractEvent event)
	  {
	    int fire = Integer.valueOf(6).intValue();
	    
	    final Player p = event.getPlayer();
	    if ((event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK) && 
	    		(Habilidade.getAbility(p).equalsIgnoreCase("Deshfire")))
	    {
	      if ((event.getAction() == Action.LEFT_CLICK_AIR) || 
	        (event.getAction() == Action.LEFT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_BLOCK) || 
	        (event.getAction() == Action.RIGHT_CLICK_AIR)) {
	        event.setCancelled(true);
	      }
	      if (cooldownm.contains(p))
	      {
	        p.sendMessage("§c§lYou are in cooldown!");
	        return;
	      }
	      cooldownm.add(p);
	      fall.add(p.getName());
	      p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
	      p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
	      Location loc = p.getLocation();
	      for (Entity pertos : p.getNearbyEntities(8.0D, 8.0D, 8.0D)) {
	        if ((pertos instanceof Player))
	        {
	          Player perto = (Player)pertos;
	          ((Player)pertos).damage(10.0D);
	          pertos.setVelocity(new Vector(0.1D, 0.0D, 0.1D));
	          ((Player)pertos).setFireTicks(fire * 20);
	        }
	      }
	      ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
	      LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
	      kCapacete.setColor(Color.RED);
	      Capacete.setItemMeta(kCapacete);
	      Capacete.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	      ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
	      LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
	      kPeitoral.setColor(Color.RED);
	      Peitoral.setItemMeta(kPeitoral);
	      Peitoral.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	      ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
	      LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
	      kCalss.setColor(Color.RED);
	      Calss.setItemMeta(kCalss);
	      Calss.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	      ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
	      LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
	      kBota.setColor(Color.RED);
	      Bota.setItemMeta(kBota);
	      Bota.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 3);
	      Armadura.put(p.getName(), p.getInventory().getArmorContents());
	      
	      p.getInventory().setHelmet(Capacete);
	      p.getInventory().setChestplate(Peitoral);
	      p.getInventory().setLeggings(Calss);
	      p.getInventory().setBoots(Bota);
	      p.updateInventory();
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	        	 ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
	        	  
	        	  ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
	        	  
	        	  ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
	        	  
	        	  ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
	        	  p.getInventory().setHelmet(capacete0);
	        	  p.getInventory().setChestplate(peitoral0);
	        	  p.getInventory().setLeggings(calca0);
	        	  p.getInventory().setBoots(Bota0);
	          p.updateInventory();
	          fall.remove(p.getName());
	        }
	      }, 60L);
	      
	      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	      {
	        public void run()
	        {
	          cooldownm.remove(p);
	          
	          p.sendMessage("§3§oYou can use the Deshfire again!");
	          p.getWorld().playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 5.0F, 5.0F);
	        }
	      }, 700L);
	    }
	  }
	@EventHandler
	  public void onDrop(PlayerDropItemEvent event)
	  {
	    if (event.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK)
	      event.setCancelled(true);
	  }
}
