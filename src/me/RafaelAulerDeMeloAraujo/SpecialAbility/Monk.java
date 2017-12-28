package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import me.RafaelAulerDeMeloAraujo.main.Main;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;


public class Monk 
implements Listener
{
	
public static Main plugin;

public Monk(Main main)
{
  plugin = main;
}

	@EventHandler
	  public void monk(PlayerInteractEntityEvent e)
	  {
	    ItemStack item = e.getPlayer().getItemInHand();
	    if ((Habilidade.getAbility(e.getPlayer()) == "Monk") && 
	      ((e.getRightClicked() instanceof Player)) && 
	      (item.getTypeId() == API.monkItemId)) {
	      long lastUsed = 0L;
	      if (API.monkStaff.containsKey(item)) {
	        lastUsed = ((Long)API.monkStaff.get(item)).longValue();
	      }
	      if (lastUsed + 1000 * API.cooldownmonk > 
	        System.currentTimeMillis()) {
	        e.getPlayer().sendMessage(String.format(API.monkCooldownMessage, 
	          new Object[] { Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * API.cooldownmonk)) / 1000L)) }));
	      } else {
	        PlayerInventory inv = ((Player)e.getRightClicked()).getInventory();
	        int slot = new Random().nextInt(API.sendThroughInventory ? 36 : 9);
	        ItemStack replaced = inv.getItemInHand();
	        if (replaced == null)
	          replaced = new ItemStack(0);
	        ItemStack replacer = inv.getItem(slot);
	        if (replacer == null)
	          replacer = new ItemStack(0);
	        inv.setItemInHand(replacer);
	        inv.setItem(slot, replaced);
	        API.monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
	        e.getPlayer().sendMessage("§6You used your ability!");
	      }
	    }
	  }
}
