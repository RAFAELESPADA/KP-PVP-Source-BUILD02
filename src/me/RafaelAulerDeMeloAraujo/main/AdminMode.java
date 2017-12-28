package me.RafaelAulerDeMeloAraujo.main;




import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;



public class AdminMode implements CommandExecutor, Listener {
	
	public static ArrayList<String> admin = new ArrayList<>();
	public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> savearmor = new HashMap<String, ItemStack[]>();
	
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bYou need to be a player");
			return true;
		}
		if (!(sender.hasPermission("kitpvp.adminmode"))) {
			sender.sendMessage("§cYou dont have the permission kitpvp.adminmode");
			return true;
		}
		Player p = (Player)sender;
		if (args.length == 0) {
           if (!admin.contains(p.getName())) {
           p.sendMessage("§b§lYou enter in adminmode!");
           
           for (Player s : Bukkit.getOnlinePlayers()) {
        	   if (!s.hasPermission("kitpvp.adminmode")) {
        	       s.hidePlayer(p);
                   }
                }
		        p.setGameMode(GameMode.CREATIVE);
	            admin.add(p.getName());
	            saveinv.put(p.getName(), p.getInventory().getContents());
	            savearmor.put(p.getName(), p.getInventory().getArmorContents());
		        p.setAllowFlight(true);
		        p.getInventory().clear();
			    
			    ItemStack estrela = new ItemStack(Material.SLIME_BALL);
			    ItemMeta estrelameta = estrela.getItemMeta();
			    estrelameta.setDisplayName("§a§lQuick Change!");
			    estrela.setItemMeta(estrelameta);
			    
			    
			    
			    ItemStack barra = new ItemStack(Material.IRON_FENCE);
			    ItemMeta barrameta = barra.getItemMeta();
			    barrameta.setDisplayName("§a§lJail!");
			    barra.setItemMeta(barrameta);
			    
			    
			    
			    ItemStack etiqueta = new ItemStack(Material.FEATHER);
			    ItemMeta etiquetameta = etiqueta.getItemMeta();
			    etiquetameta.setDisplayName("§a§lNo Fall Test!");
			    etiqueta.setItemMeta(etiquetameta);
			    
			    ItemStack kb = new ItemStack(Material.STICK);
			    ItemMeta kbmeta = kb.getItemMeta();
				kbmeta.addEnchant(Enchantment.KNOCKBACK, 10, true);
			    kbmeta.setDisplayName("§a§lAntiKnock Test!");
			    kb.setItemMeta(kbmeta);
			    
			    ItemStack kb1 = new ItemStack(Material.CLAY_BRICK);
			    ItemMeta kbmeta1 = kb1.getItemMeta();
				
			    kbmeta1.setDisplayName("§b§lInfo Player!");
			    kb1.setItemMeta(kbmeta1);
			    
			    p.getInventory().setItem(0, kb);
			    
			    p.getInventory().setItem(2, estrela);
			    p.getInventory().setItem(4, etiqueta);
			    p.getInventory().setItem(6, barra);
			    p.getInventory().setItem(8, kb1);
			    
			   
			    
			    
			    p.updateInventory();
			    
		     } else {
		    	 p.sendMessage("§a§lYou leave the admin mode!");
		    	 p.setHealth(20);
		    	 p.getInventory().clear();
		    	 admin.remove(p.getName());
		           for (Player s : Bukkit.getOnlinePlayers()) {
		        	   if (!s.hasPermission("kitpvp.adminmode")) {
		        	       s.showPlayer(p);
		         }
		       }
		           p.setGameMode(GameMode.SURVIVAL);
		           p.getInventory().setContents(saveinv.get(p.getName()));
		           p.getInventory().setArmorContents(savearmor.get(p.getName()));
		     }
		    }
		return false;
   }
	
	
	
	public static int getMaterial(Player p, Material m) {
		int value = 0;
		for (ItemStack item : p.getInventory().getContents()) {
			if (item != null && item.getType() == m && item.getAmount() > 0) {
				value += item.getAmount();
				
			}
		}
		return value;
	}
	
	  
	  @EventHandler
	  public void onInteractPlayerSlimeFun(PlayerInteractEvent e)
	  {
	    final Player p = e.getPlayer();
	    if ((admin.contains(p.getName())) && (
	      (e.getAction() == Action.RIGHT_CLICK_BLOCK) || (e.getAction() == Action.RIGHT_CLICK_AIR)))
	    {
	      if (p.getItemInHand().getType() == Material.SLIME_BALL)
	      {
	        p.chat("/adminmode");
	        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
	        {
	          public void run()
	          {
	            p.chat("/adminmode");
	          }
	        }, 10L);
	      }
	    }
	  }
	  @EventHandler
	  public void onPlayerInfo(PlayerInteractEntityEvent e)
	  {
	    Player p = e.getPlayer();
	    if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.CLAY_BRICK))
	    {
	      Player p1 = (Player)e.getRightClicked();
	      Damageable hp = p1;
	     	
        	String kitpvp = ("§aYes");
        	String nokitpvp = ("§cNo");
        	p.sendMessage("§b§lKITPVP INFORMATION OF: §6§l" + p1.getName());
        	   if (Join.game.contains(p1.getName()))
        	   {
        	       p.sendMessage(String.valueOf("§cPlayer is on kitpvp? " + kitpvp));
        	   }
        	       else {
        	    	   p.sendMessage(String.valueOf("§cPlayer is on kitpvp? " + nokitpvp));   
        	       }
        	       
        	   }
	   
	   
    	 if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.CLAY_BRICK))
    		
 	    {
    		 Player p1 = (Player)e.getRightClicked();
        	 
   	      Damageable hp = p1;
   	      /* 149 */      int kills = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p1.getName().toLowerCase()).append(".kills").toString());
   	    	/* 130 */       int deaths = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p1.getName().toLowerCase()).append(".mortes").toString());
	      p.sendMessage("§eHealth: §c§l" + (int)hp.getHealth());
	      
	      p.sendMessage("§eGamemode: §c§l" + p1.getGameMode());
	      p.sendMessage("§eKitPvP Kills: §c§l" + kills);
	      p.sendMessage("§eKitPvP Deaths: §c§l" + deaths);
	      p.sendMessage("§eKitPvP Coins: §c§l" + Coins.getCoins(p1.getName()));
	      p.sendMessage("§eKitPvP Kit: §c§l" + Habilidade.getAbility(p1));
	      p.sendMessage("§eIs Flying? §c§l" + p1.isFlying());
	      
	      @SuppressWarnings("unused")
		Player target = null;
	      p.sendMessage("§eIp: §c§l" + p1.getAddress().getHostName());
	    }
	  }
	  
	@EventHandler
	public void ClickOpeninventory(PlayerInteractEntityEvent e) {
		if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.AIR && admin.contains(e.getPlayer().getName())) {
			Player t = (Player)e.getRightClicked();
			e.getPlayer().openInventory(t.getInventory());
		}
	}
	  @EventHandler
	  public void onAdminArena(PlayerInteractEntityEvent event)
	  {
	    Player p = event.getPlayer();
	    if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.IRON_FENCE))
	    {
	      Player p1 = (Player)event.getRightClicked();
	      if (p1 != null)
	      {
	        p1.getLocation().add(0.0D, 13.0D, 0.0D).getBlock().setType(Material.BEDROCK);
	        p1.getLocation().add(0.0D, 11.0D, 1.0D).getBlock().setType(Material.BEDROCK);
	        p1.getLocation().add(1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
	        p1.getLocation().add(0.0D, 11.0D, -1.0D).getBlock().setType(Material.BEDROCK);
	        p1.getLocation().add(-1.0D, 11.0D, 0.0D).getBlock().setType(Material.BEDROCK);
	        p1.getLocation().add(0.0D, 10.0D, 0.0D).getBlock().setType(Material.BEDROCK);
	        p1.teleport(p1.getLocation().add(0.0D, 11.0D, -0.05D));
	        p.sendMessage("§aYou jail the player " + p1.getName());
	      }
	    }
	  }

@EventHandler
public void onAdminNoFall(PlayerInteractEntityEvent event)
{
  Player p = event.getPlayer();
  if ((admin.contains(p.getName())) && (p.getItemInHand().getType() == Material.FEATHER))
  {
    Player p1 = (Player)event.getRightClicked();
    if (p1 != null)
    {
      p1.getLocation().add(0.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
      p1.getLocation().add(0.0D, 40.0D, 1.0D).getBlock().setType(Material.AIR);
      p1.getLocation().add(1.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
      p1.getLocation().add(0.0D, 40.0D, -1.0D).getBlock().setType(Material.AIR);
      p1.getLocation().add(-1.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
      p1.getLocation().add(0.0D, 40.0D, 0.0D).getBlock().setType(Material.AIR);
      p1.teleport(p1.getLocation().add(0.0D, 11.0D, -0.05D));
    }
  }
}
}
