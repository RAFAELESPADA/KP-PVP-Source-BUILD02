package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import me.RafaelAulerDeMeloAraujo.X1.X1;
import me.RafaelAulerDeMeloAraujo.main.ItemAPI;
import me.RafaelAulerDeMeloAraujo.main.Main;





public class Join implements CommandExecutor, Listener {

	public static HashMap<String, ItemStack[]> saveinv = new HashMap<String, ItemStack[]>();
	public static HashMap<String, ItemStack[]> savearmor = new HashMap<String, ItemStack[]>();
	public static HashMap<String, Location> saveworld = new HashMap<String, Location>();






{
	
}
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Join(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 }
	 public Join() {
		    


	


	 /*     */   }
	 
	 HashMap<String, Location> maps = new HashMap();	 
	 public static ArrayList<String> game = new ArrayList();
	 List<String> commands = Arrays.asList(new String[] { "admin", "list", "create", "delete", "1v1", "score", "setspawn", "join", "leave", "reset", "coins", "setchallenge", "kit", "kitunlocker", "resetkit", "stats", "reload", "info" });
	 

	 /*     */   private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore) {
		 /* 131 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
		 /* 132 */     ItemMeta meta = item.getItemMeta();
		 /* 133 */     meta.setDisplayName(displayName);
		 /* 134 */     meta.setLore(lore);
		 /* 135 */     item.setItemMeta(meta);
		 /* 136 */     return item;
		 /*     */   }
	 public boolean onCommand(final CommandSender sender, Command cmd, String commandLabel, final String[] args)
	  {
	    if ((commandLabel.equalsIgnoreCase("kitpvp")))
	    {
	      if (args.length == 0)
	      {
	        sender.sendMessage(ChatColor.DARK_AQUA + " ----------" + ChatColor.AQUA + " KP-PVP COMMANDS " + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + "----------");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Main command");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "join" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Join the kitpvp!");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "leave" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Leave the kitpvp!");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "kits" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Open kit menu!");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "shop" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Open shop menu!");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "1v1" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Join kitpvp 1v1!");
	       
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "score" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Toggle scoreboard on or off");
	        sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kp" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "View command list");
	        sender.sendMessage(ChatColor.DARK_AQUA + " --------------------------");
	        return true;
	      }
	      if (!this.commands.contains(args[0].toLowerCase()))
	      {
	        sender.sendMessage(ChatColor.DARK_AQUA + "Unknown command");
	        return true;
	      }
	      if (args[0].equalsIgnoreCase("join"))
	      {
	        if ((sender instanceof Player))
	        {
	          Player p = (Player)sender;
	        
	          
	            p.sendMessage((String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou join on the kitpvp"));
	            p.sendMessage((String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eType /kitpvp to view commands"));
	            
	           
	           
	            
	           this.game.add(p.getName());
	           World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
	           double x =  Main.plugin.getConfig().getDouble("Spawn.X");
	             double y = Main.plugin.getConfig().getDouble("Spawn.Y");
	             double z = Main.plugin.getConfig().getDouble("Spawn.Z");
	             Location lobby = new Location(w, x, y, z);
	             saveworld.put(p.getName(), p.getLocation());
	             saveinv.put(p.getName(), p.getInventory().getContents());
		         savearmor.put(p.getName(), p.getInventory().getArmorContents());
		         
	             lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
	             lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	              p.getInventory().clear();
	              
	             
	              p.teleport(lobby);
	              
	              
		            p.getInventory().clear();
		              p.getInventory().setArmorContents(null);
		       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, "§aKit menu §7(Right click)", Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
		        ItemStack kits = new ItemStack(Material.EMERALD);
		        ItemMeta kits2 = kits.getItemMeta();
		        kits2.setDisplayName("§b§lShop Menu");
		        kits.setItemMeta(kits2);
		        p.getInventory().addItem(kits);  
		       
		       
		       
		      
	              p.setExp(0.0F);
	              p.setExhaustion(20.0F);
	              p.setFireTicks(0);
	             p.setFoodLevel(20000);
	             
	              {
	            	
	        	        	
	              
	          }
	          }
	        }
	      }
	     {
		
	  }

		return false;
	

		
}

/*     */   @EventHandler
/*     */   public boolean quickcommand(PlayerCommandPreprocessEvent e) {
	Player p = e.getPlayer();
	
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kitpvp leave") && (Join.game.contains(e.getPlayer().getName()))) {
/* 257 */       e.setCancelled(true);
/* 258 */       Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());Join.game.remove(p.getName());Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());
Join.game.remove(p.getName());



Habilidade.removeAbility(p);
  Deshfire.Armadura.remove(p);
  Deshfire.Armadura2.remove(p);
  Deshfire.cooldownm.remove(p);
  
  Join.game.remove(p.getName());
  
  
  

  Cooldown.remove(p);
  p.sendMessage((String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §aYou leave the kitpvp"));
p.getInventory().clear();
p.teleport(saveworld.get(p.getName()));
p.getInventory().setContents(saveinv.get(p.getName()));
p.getInventory().setArmorContents(savearmor.get(p.getName()));
p.updateInventory();
   
}

return false;
}


/*     */   @EventHandler
/*     */   public boolean quickcommand7(PlayerCommandPreprocessEvent e) {
	Player p = e.getPlayer();
	
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kitpvp 1v1") && (Join.game.contains(e.getPlayer().getName()))) {
/* 257 */       e.setCancelled(true);
X1.entrar1v1(p);
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to join 1v1!");
	e.setCancelled(true);
}

}
return false;
}

/*     */   @EventHandler
/*     */   public boolean quickcommand74(PlayerCommandPreprocessEvent e) {
	Player p = e.getPlayer();
	
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kitpvp score") && (Join.game.contains(e.getPlayer().getName()))) {
	p.performCommand("togglescore");
/* 257 */       e.setCancelled(true);
}
return false;
}
}

