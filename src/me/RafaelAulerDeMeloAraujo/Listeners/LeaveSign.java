package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;

@SuppressWarnings("unused")
public class LeaveSign
  implements Listener
{
  private Main plugin;
  
  public LeaveSign(Main main)
  {
    this.plugin = main;
  }
  
  public LeaveSign() {}
  
  @EventHandler
  public void onSignChange(SignChangeEvent e)
  {
    if (e.getLine(0).equalsIgnoreCase("[kp]") && (e.getLine(1).equalsIgnoreCase("leave")) && e.getPlayer().hasPermission("kitpvp.createsigns"))
    {
      e.setLine(0, "§4=-=()=-=");
      e.setLine(1, "§2Leave");
      e.setLine(2, "§bKitPvP!");
      e.setLine(3, "§4=-=()=-=");
    }
  }
  

  
  @EventHandler
  public void inv(PlayerInteractEvent e)
  {
	  Player p = e.getPlayer();
	  if ((e.getAction() == Action.RIGHT_CLICK_BLOCK) && (e.getClickedBlock() != null) && (
		      (e.getClickedBlock().getType() == Material.WALL_SIGN) || (e.getClickedBlock().getType() == Material.SIGN_POST)))
		    {
		      Sign s = (Sign)e.getClickedBlock().getState();
		      String[] lines = s.getLines();
		      if ((lines.length > 0) && (lines[0].equals("§4=-=()=-=")) && 
		        (lines.length > 1) && (lines[1].equals("§2Leave")) && 
		        (lines.length > 2) && (lines[2].equals("§bKitPvP!")) && 
		        (lines.length > 3) && (lines[3].equals("§4=-=()=-="))) {
		    	  p.chat("/kitpvp leave");
		      }
  }
  }
  }