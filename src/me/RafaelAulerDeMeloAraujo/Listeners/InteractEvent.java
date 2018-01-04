package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

public class InteractEvent implements Listener {


@EventHandler
public void inte1(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType() == Material.BOOK) && (
  		(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit menu §7(Right click)"))) && Join.game.contains(p.getName()) && (	
     
    (e.getAction() == Action.RIGHT_CLICK_AIR) || 
    (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
  	p.chat("/kpkitmenu");
  }
  }
  @EventHandler
  public void inte2(PlayerInteractEvent e)
  {
    Player p = e.getPlayer();
    if ((p.getItemInHand().getType() == Material.EMERALD) && (
    		(p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lShop Menu"))) && Join.game.contains(p.getName()) && (	
       
      (e.getAction() == Action.RIGHT_CLICK_AIR) || 
      (e.getAction() == Action.RIGHT_CLICK_BLOCK))) {
    	p.chat("/kpshop");
    }
}
}
