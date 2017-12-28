package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import me.RafaelAulerDeMeloAraujo.main.Main;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import org.bukkit.util.Vector;

public class Stomper
  implements Listener
{
	  @EventHandler(priority=EventPriority.HIGH)
	  public void onPlayerStomp(EntityDamageEvent e)
	  {
	    if (!(e.getEntity() instanceof Player)) {
	      return;
	    }
	    Player p = (Player)e.getEntity();
	    if (e.getCause() == EntityDamageEvent.DamageCause.FALL)
	    {
	      if (Habilidade.getAbility(p).equalsIgnoreCase("Stomper")) {
	      {
	        for (Entity ent : p.getNearbyEntities(2.0D, 2.0D, 2.0D)) {
	          if ((ent instanceof Player))
	          {
	            Player plr = (Player)ent;
	            if (e.getDamage() <= 4.0D)
	            {
	              e.setCancelled(true);
	              return;
	            }
	            if (plr.isSneaking())
	            {
	              plr.damage(6.0D, p);
	              plr.sendMessage(ChatColor.GRAY + "You have been stomped by: " + ChatColor.AQUA + p.getName());
	            }
	            else
	            {
	              plr.damage(e.getDamage(), p);
	              plr.sendMessage(ChatColor.GRAY + "You have been stomped by: " + ChatColor.AQUA + p.getName());
	              plr.damage(p.getFallDistance());
	            }
	          }
	        }
	        e.getEntity().getLocation().getWorld().playSound(e.getEntity().getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0F, 1.0F);
	        e.setDamage(4.0D);
	        return;
	      }
	     
	    }
	    }
	  }
	  
	
  @EventHandler
  public void BotaStomper(PlayerInteractEvent e)
  {
    final Player p = e.getPlayer();
    if ((e.getPlayer().getItemInHand().getType() == Material.DIAMOND) && (Habilidade.getAbility(p).equalsIgnoreCase("Stomper")) && ((e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)))
    {
      e.setCancelled(true);
      p.updateInventory();
      if (Cooldown.add(p))
      {
    	API.MensagemCooldown(p);
        return;
      }
      Vector vector = p.getEyeLocation().getDirection();
      vector.multiply(0.0F);
      vector.setY(10.0F);
      p.setVelocity(vector);
      Location loc = p.getLocation();
      p.getWorld().playSound(loc, Sound.ENTITY_FIREWORK_BLAST_FAR, 2.0F, 2.0F);
      Cooldown.add(p, 30);
      Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
      {
        public void run()
        {
        	p.sendMessage(API.fimcooldown(p));
          Cooldown.remove(p);
        }
      }, 600L);
    }
  }

@EventHandler
public void onDrop(PlayerDropItemEvent event)
{
  if (event.getItemDrop().getItemStack().getType() == Material.DIAMOND)
    event.setCancelled(true);
  
}
}
