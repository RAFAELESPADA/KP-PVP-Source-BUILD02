     package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.Arrays;
import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ 
import org.bukkit.Sound;
import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ 
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
/*     */ import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.X1.X1;

/*     */ 
/*     */ public class Menu implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*  30 */   

private String[] args;




/*     */   
	

/*  57 */     
/*  58 */     
/*     */   
/*     */   
/*     */   public Menu(Main main) {
/*  69 */     this.main = main;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  74 */    Player p = e.getPlayer();


                Habilidade.removeAbility(p);
                Deshfire.Armadura.remove(p);
                Deshfire.Armadura2.remove(p);
                Deshfire.cooldownm.remove(p);
                Join.game.remove(p.getName());
                Cooldown.remove(p);
                /*  

                	/*     */   
                Streak.killstreak.put(p.getName(), Integer.valueOf(0));
               
                World world = p.getWorld();
                	  p.teleport(world.getSpawnLocation());
                
/*  90 */       if (this.main.getConfig().getString("JoinItem.JoinSound").equalsIgnoreCase("true")) {
/*  91 */         p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.Join")), 1.0F, 1.0F);
/*     */       }
                }
public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore)  {
	/* 140 */     ItemStack item = new ItemStack(mat);
	 
	/* 141 */     ItemMeta meta = item.getItemMeta();
	/* 142 */     meta.setDisplayName(name);
	/* 143 */     meta.setLore(( Arrays.asList(new String[] { lore })));
	/* 144 */     item.setItemMeta(meta);
	/* 145 */     inv.setItem(Slot, item);

	return;
}
/*     */   @EventHandler
/*     */   public void onJoinr(PlayerJoinEvent e) {
	  
	      
	Player p = e.getPlayer();
	 int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
	 int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
	
	if (kills == 0 && deaths == 0) {
		Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
		Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".mortes", Integer.valueOf(deaths + 1));
	}
	}

/*     */     
/*     */   
/*     */   @EventHandler
/*     */   public void onLeave(PlayerQuitEvent e) {
/*  74 */     Player p = e.getPlayer();


              
               
                p.chat("/kitpvp leave");
               
}

/*     */   @EventHandler
/*     */   public void onLeave(PlayerKickEvent e) {
/*  74 */     Player p = e.getPlayer();


              
               
                p.chat("/kitpvp leave");
}
/*     */   
/*     */   

/*     */   


	 


/*    */   @EventHandler
/*    */   public void onFall(PlayerRespawnEvent e) {
/*    */   
	
/* 15 */   Player p = e.getPlayer();  
	if (Join.game.contains(p.getName())) { 
     
		
		World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
		  double x =  Main.plugin.getConfig().getDouble("Spawn.X");
		    double y = Main.plugin.getConfig().getDouble("Spawn.Y");
		    double z = Main.plugin.getConfig().getDouble("Spawn.Z");
		    Location lobby = new Location(w, x, y, z);
		    lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
		    lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
		e.getRespawnLocation().setWorld(w);
		e.getRespawnLocation().setX(x);
		e.getRespawnLocation().setY(y);
		e.getRespawnLocation().setZ(z);
		e.getRespawnLocation().setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
		e.getRespawnLocation().setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	


  p.getInventory().clear();
 
    
       
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
    p.getInventory().setArmorContents(null);
        
          p.updateInventory();
          Habilidade.removeAbility(p);
          Deshfire.Armadura.remove(p);
          Deshfire.Armadura2.remove(p);
          Deshfire.cooldownm.remove(p);
         
          Cooldown.remove(p);
	}
           {
        	  World world = p.getWorld();
        	  p.teleport(world.getSpawnLocation());
     return;
	}
}
	




     

/*    */   


/*     */   
/*     */   

		
		{

}
	







/*     */   
/*     */   

/*     */   
/*     */   private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore) {
/* 131 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 132 */     ItemMeta meta = item.getItemMeta();
/* 133 */     meta.setDisplayName(displayName);
/* 134 */     meta.setLore(lore);
/* 135 */     item.setItemMeta(meta);
/* 136 */     return item;
/*     */   }
/*     */   


{
	
}

	 

   
/*     */   
/*     */  


		    		 
		      
		      
		      
		    


                      
              
              





		     
		     
		    


		  
		      
		    


                      
		   
		   
/*     */     
                




              























 





 






             

/*     */   {
	
}
/*     */   @EventHandler
/*     */   public void quickcommand(PlayerCommandPreprocessEvent e) {
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kit") && (Join.game.contains(e.getPlayer().getName()))) {
/* 257 */       e.setCancelled(true);
Player p = e.getPlayer();
/* 258 */         p.chat("/kpkitmenu");

if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
/*     */     }
}
/*     */   }

/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand1(PlayerCommandPreprocessEvent e) {
/* 264 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kits")) {
/* 265 */       e.setCancelled(true);
/* 266 */        Player p = e.getPlayer();
/* 258 */         p.chat("/kpkitmenu");
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
/*     */     }
/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand2(PlayerCommandPreprocessEvent e) {
/* 272 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kitmenu")) {
/* 273 */       e.setCancelled(true);
/* 274 */         Player p = e.getPlayer();
/* 258 */         p.chat("/kpkitmenu");
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
}


/*     */   @EventHandler
/*     */   public void quickcommand3(PlayerCommandPreprocessEvent e) {
/* 272 */     if (e.getMessage().equalsIgnoreCase("/kpkits")) {
/* 273 */       e.setCancelled(true);
/* 274 */        Player p = e.getPlayer();
/* 258 */         p.chat("/kpkitmenu");


if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }

}

/*     */     
/*     */   @EventHandler
/*     */   public void quickcommand4(PlayerCommandPreprocessEvent e) {
/* 272 */     if (e.getMessage().equalsIgnoreCase("/kpkit")) {
/* 273 */       e.setCancelled(true);
/* 274 */      Player p = e.getPlayer();
/* 258 */         p.chat("/kpkitmenu");
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
}
}	
/*     */     }

/*     */





/* 272 */   





/*     */   

/*     */     
/*     */   
/*     */   

	

	




 {
}
{
	
}
	
	
{
	
}


@Override
public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}
}
