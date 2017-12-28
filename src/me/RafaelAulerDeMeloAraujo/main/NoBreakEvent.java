package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;



public class NoBreakEvent implements Listener {


@EventHandler
public void aoconstruir(final BlockPlaceEvent e) {
	
    final Player p = e.getPlayer();
    if (Join.game.contains(p.getName()) && (!p.hasPermission("kitpvp.build")))   
    	
        e.setCancelled(true);
    else
    	e.setCancelled(false);
    }
   
	
@EventHandler
public void aoconstruir2(final BlockBreakEvent e) {
	final Player p = e.getPlayer();
	  if (Join.game.contains(p.getName()) && (!p.hasPermission("kitpvp.build")))   
	    	
	        e.setCancelled(true);
	    else
	    	e.setCancelled(false);
	    }
}

