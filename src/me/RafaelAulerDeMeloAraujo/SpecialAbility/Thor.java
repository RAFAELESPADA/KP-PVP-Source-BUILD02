package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import org.bukkit.event.player.*;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.Main;


import org.bukkit.event.block.*;

import java.util.*;

import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;



public class Thor implements Listener
{

	public Main plugin;
	  
	  public Thor(Main main)
	  {
	    plugin = main;
	  }
	  
	  public static ArrayList<String> cooldown = new ArrayList();
	
	  @EventHandler
	  public void onPlayerThor(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    
	    if (e.getAction() != Action.RIGHT_CLICK_BLOCK) {
	      return;
	    }
	    if ((p.getItemInHand().getType() == Material.GOLD_AXE) && 
	    		(Habilidade.getAbility(p) == "Thor"))
	    {
	    	  if (Cooldown.add(p))
	          {
	    		  e.setCancelled(true);
	        	API.MensagemCooldown(p);
	            return;
	          }
	      
	      e.setCancelled(true);
 Block b = e.getClickedBlock();
	      
	      World w = p.getWorld();
	     
	      final Location loc = w.getHighestBlockAt(b.getLocation()).getLocation();
          p.getWorld().strikeLightning(loc);
	      
	      Cooldown.add(p , 5);
	      Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable()
	      {
	        public void run()
	        {
	        	  Cooldown.remove(p);
	          p.sendMessage(API.fimcooldown);
	        }
	      }, 100L);
	    }
	  }

@EventHandler
public void OnBlock(BlockIgniteEvent e) {
	
	if (e.getCause() == IgniteCause.LIGHTNING) 
		e.setCancelled(true);
			else   
		e.setCancelled(false);
	}
	{
}






@EventHandler
public void OnBlockBB(EntityDamageEvent e) {
	  if (!(e.getEntity() instanceof Player)) {
          return;
      }
	final Player p = (Player) e.getEntity();
	if ((Habilidade.getAbility(p) == "Thor") && e.getCause() == EntityDamageEvent.DamageCause.LIGHTNING) {
		e.setCancelled(true);
	} else  
			e.setCancelled(false);
		
	}
}
