     package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ 
import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ 
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 



/*     */ 
/*     */

 public class Shop implements Listener, CommandExecutor
/*     */ {
/*     */   @SuppressWarnings("unused")
private Main main;

/*  30 */   public static Inventory shop = Bukkit.getServer().createInventory(null, 54, "Buy More Kits! :D");
/*     */  

/*     */   static {
/*  33 */    
/*  42 */     createButton(Material.DIAMOND_SWORD, shop, 0, "§6\u27a1 §cPvP", "§ePrice: 4500");
/*  43 */     createButton(Material.BOW, shop, 1, "§6\u27a1 §cArcher", "§ePrice: 3000");
/*  44 */     createButton(Material.FLINT_AND_STEEL, shop, 2, "§6\u27a1 §cPyro", "§ePrice: 6000");
/*  45 */     createButton(Material.DIAMOND_CHESTPLATE, shop, 3, "§6\u27a1 §cTank", "§ePrice: 7000");
/*  46 */     createButton(Material.SNOW_BALL, shop, 4, "§6\u27a1 §cSwitcher", "§ePrice: 6500");
/*  47 */     createButton(Material.MAGMA_CREAM, shop, 5, "§6\u27a1 §cJumper", "§ePrice: 8000");
/*  48 */     createButton(Material.CACTUS, shop, 6, "§6\u27a1 §cCactus", "§ePrice: 4000");
/*  49 */     createButton(Material.TNT, shop, 7, "§6\u27a1 §cBomber", "§ePrice: 9000");
/*  50 */     createButton(Material.ENDER_PEARL, shop, 8, "§6\u27a1 §cWarper", "§ePrice: 4000");
/*  51 */     
/*  52 */     
/*  54 */     createButton(Material.FISHING_ROD, shop, 9, "§6\u27a1 §cFisherman", "§ePrice: 5000");
/*  55 */     
              createButton(Material.IRON_BOOTS, shop, 10, "§6\u27a1 §cStomper", "§ePrice: 17500");
              createButton(Material.REDSTONE_BLOCK, shop, 11, "§6\u27a1 §cDeshfire", "§ePrice: 8500");
              createButton(Material.SPIDER_EYE, shop, 12, "§6\u27a1 §cViper", "§ePrice: 7000");
              createButton(Material.STRING, shop, 13, "§6\u27a1 §cSpiderman", "§ePrice: 6000");
              createButton(Material.IRON_FENCE, shop, 14, "§6\u27a1 §cGladiator", "§ePrice: 16000");
              createButton(Material.FIREWORK, shop, 15, "§6\u27a1 §cKangaroo", "§ePrice: 5000");
              createButton(Material.COAL, shop, 16, "§6\u27a1 §cNinja", "§ePrice: 6500");
              createButton(Material.WATCH, shop, 17, "§6\u27a1 §cTimelord", "§ePrice: 7000");
              createButton(Material.GOLDEN_APPLE, shop, 18, "§6\u27a1 §cCritical", "§ePrice: 8000");
              createButton(Material.BLAZE_ROD, shop, 19, "§6\u27a1 §cMonk", "§ePrice: 5000");
              createButton(Material.CHAINMAIL_BOOTS, shop, 20, "§6\u27a1 §cDoubleJump", "§ePrice: 9500");
              createButton(Material.GOLD_AXE, shop, 21, "§6\u27a1 §cThor", "§ePrice: 7000");
              createButton(Material.FERMENTED_SPIDER_EYE, shop, 22, "§6\u27a1 §cSnail", "§ePrice: 6000");
              createButton(Material.BLAZE_ROD, shop, 23, "§6\u27a1 §cWasp", "§ePrice: 6000");
              createButton(Material.NETHER_STAR, shop, 24, "§6\u27a1 §cNaruto", "§ePrice: 12500");
/*  56 */     createButton(Material.BARRIER, shop, 53, "§4§l\u2716 §cClose", "§bClose the menu!");
/*  57 */     
/*  58 */     
/*     */   }
/*     */   
/*     */   public Shop(Main main) {
/*  69 */     this.main = main;
/*     */   }

/*     */   
/*     */   private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
/* 140 */     ItemStack item = new ItemStack(mat);
/* 141 */     ItemMeta meta = item.getItemMeta();
/* 142 */     meta.setDisplayName(name);
/* 143 */     meta.setLore(Arrays.asList(new String[] { lore }));
/* 144 */     item.setItemMeta(meta);
/* 145 */     inv.setItem(Slot, item);
/*     */   }
@EventHandler
/*     */   public void quickcommand(PlayerCommandPreprocessEvent e) {
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kpshop")) {
/* 257 */       e.setCancelled(true);
/* 258 */       openMenu(e.getPlayer());
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
/*     */     }
/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand1(PlayerCommandPreprocessEvent e) {
/* 264 */     if (e.getMessage().equalsIgnoreCase("/kploja")) {
/* 265 */       e.setCancelled(true);
/* 266 */       openMenu(e.getPlayer());
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
/*     */     }
/*     */     
/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand2(PlayerCommandPreprocessEvent e) {
/* 272 */     if (e.getMessage().equalsIgnoreCase("/shopmenu")) {
/* 273 */       e.setCancelled(true);
/* 274 */       openMenu(e.getPlayer());
/*     */   if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
	e.getPlayer().closeInventory();
/*     */     }
}
/*     */   }
/*     */   @EventHandler
/*     */   public void quickcommand3(PlayerCommandPreprocessEvent e) {
/* 272 */     if (e.getMessage().equalsIgnoreCase("/kitpvp shop")) {
/* 273 */       e.setCancelled(true);
/* 274 */       openMenu(e.getPlayer());
/*     */   if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
/*     */     }
 
public void openMenu(Player p) {
/* 149 */     p.openInventory(shop);
              p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 12.0F, 12.0F);
/*     */   }
@EventHandler
public void kit(InventoryClickEvent e)
{
 
    Inventory inv = e.getInventory();
    
    if (inv.getTitle().equals(shop.getName()))
    {
      
      e.setCancelled(true);
    }
  }

 
 @EventHandler
	  public void warps(InventoryClickEvent e)
	  {
	   
	      Inventory inv = e.getInventory();
	      Player p = (Player)e.getWhoClicked();
	      if (inv.getTitle().equals("Buy More Kits! :D"))
	    	  
	      {
	        p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 5.0F, 5.0F);
	        e.setCancelled(true);
	       
	      }
	     
	      ItemStack clicked = e.getCurrentItem();
	  {
	  }
	  if (((inv.getName().equals(shop.getName())) && e.getCurrentItem() == null))
			return;
	  if (((inv.getName().equals(shop.getName()))  &&  e.getCurrentItem().getType()  == (Material.AIR)))
			return;
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER)) {
	      p.closeInventory();
	      p.sendMessage("§2§l\u2714 §aYou close the Shop Menu Successfully!");

	      }
	     
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BOW)) {
	          if (Coins.getCoins(p.getName())  >= 3000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.archer");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.archer local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.archer global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.archer");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.archer true");
	            p.sendMessage("§6\u27a1 §cYou buy the Archer kit §e-3000 coins");
	            Coins.removeCoins(p.getName(), 3000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 9000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.NETHER_STAR)) {
	          if (Coins.getCoins(p.getName())  >= 12500)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.naruto");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.naruto local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.naruto global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.naruto true");
	            p.sendMessage("§6\u27a1 §cYou buy the Naruto kit §e-12500 coins");
	            Coins.removeCoins(p.getName(), 12500);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 12500)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	 
	 
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_SWORD)) {
	          if (Coins.getCoins(p.getName())  >= 4500)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pvp");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pvp local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pvp global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pvp");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pvp true");
	            p.sendMessage("§6\u27a1 §cYou buy the PvP kit §e-3500 coins");
	            Coins.removeCoins(p.getName(), 4500);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 4500)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.COAL)) {
	          if (Coins.getCoins(p.getName())  >= 6500)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ninja");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.ninja local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.ninja global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ninja true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Ninja kit §e-6500 coins");
	            Coins.removeCoins(p.getName(), 6500);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 6500)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }

	      if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cMonk"))) {
	          if (Coins.getCoins(p.getName())  >= 5000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.monk");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.monk local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.monk global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.monk true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Monk kit §e-5000 coins");
	            Coins.removeCoins(p.getName(), 5000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 5000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cWasp"))) {
	          if (Coins.getCoins(p.getName())  >= 6000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.wasp");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.wasp local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.wasp global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.wasp");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.wasp true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Wasp kit §e-6000 coins");
	            Coins.removeCoins(p.getName(), 6000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 6000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_FENCE)) {
	          if (Coins.getCoins(p.getName())  >= 16000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.gladiator");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.gladiator local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.gladiator global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.gladiator true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Gladiator kit §e-16000 coins");
	            Coins.removeCoins(p.getName(), 16000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 16000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FIREWORK)) {
	          if (Coins.getCoins(p.getName())  >= 5000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.kangaroo");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.kangaroo local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.kangaroo global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.kangaroo");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.kangaroo true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Kangaroo kit §e-5000 coins");
	            Coins.removeCoins(p.getName(), 5000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 5000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.STRING)) {
	          if (Coins.getCoins(p.getName())  >= 6000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.spiderman");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.spiderman local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.spiderman global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.spiderman");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.spiderman true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the PvP kit §e-6000 coins");
	            Coins.removeCoins(p.getName(), 6000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 6000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SPIDER_EYE)) {
	          if (Coins.getCoins(p.getName())  >= 7000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.viper");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.viper local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.viper global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.viper true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Viper kit §e-7000 coins");
	            Coins.removeCoins(p.getName(), 7000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 7000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_AXE)) {
	          if (Coins.getCoins(p.getName())  >= 7000)
	          {
	        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.thor");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.thor local");
		        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.thor global");  
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thor");
	            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.thor true");
	            
	            p.sendMessage("§6\u27a1 §cYou buy the Thor kit §e-7000 coins");
	            Coins.removeCoins(p.getName(), 7000);
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	          
	          else if (Coins.getCoins(p.getName()) < 7000)
	          {
	            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
	            e.setCancelled(true);
	            p.closeInventory();
	          }
	        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER)) {
		      p.closeInventory();
		      p.sendMessage("§2§l\u2714 §aYou close the Shop Menu Successfully!");

		      }
		      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.REDSTONE_BLOCK)) {
		          if (Coins.getCoins(p.getName())  >= 8500)
		          {
		        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.deshfire");  
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.deshfire local");
			        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.deshfire global");  
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.deshfire");
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.deshfire true");
		            
		            p.sendMessage("§6\u27a1 §cYou buy the Deshfire kit §e-8500 coins");
		            Coins.removeCoins(p.getName(), 8500);
		            e.setCancelled(true);
		            p.closeInventory();
		          }
		          
		          else if (Coins.getCoins(p.getName()) < 8500)
		          {
		            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
		            e.setCancelled(true);
		            p.closeInventory();
		          }
		        }
	      if ((inv.getName().equals(shop.getName())) && (clicked.getType() == (null))) {
	    	  /* 204 */       e.setCancelled(true);
	    	  /* 205 */       p.closeInventory();
	    	  /* 206 */       
	    	  /* 207 */       return;
	    	  /*     */     }
	      {
	   {
		   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FLINT_AND_STEEL)) {
		          if (Coins.getCoins(p.getName())  >= 6000)
		          {
		        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pyro");  
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pyro local");
			        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pyro global");  
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pyro");
		            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pyro true");
		            
		            p.sendMessage("§6\u27a1 §cYou buy the Pyro kit §e-6000 coins");
		            Coins.removeCoins(p.getName(), 6000);
		            e.setCancelled(true);
		            p.closeInventory();
		          }
		          else if (Coins.getCoins(p.getName()) < 6000)
		          {
		            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
		            e.setCancelled(true);
		            p.closeInventory();
		          }
		        }
		   {
			   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FERMENTED_SPIDER_EYE)) {
			          if (Coins.getCoins(p.getName())  >= 6000)
			          {
			        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.snail");  
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.snail local");
				        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.snail global");  
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.snail true");
			            
			            p.sendMessage("§6\u27a1 §cYou buy the Snail kit §e-6000 coins");
			            Coins.removeCoins(p.getName(), 6000);
			            e.setCancelled(true);
			            p.closeInventory();
			          }
			          else if (Coins.getCoins(p.getName()) < 6000)
			          {
			            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
			            e.setCancelled(true);
			            p.closeInventory();
			          }
			        }
		   {
			   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
			          if (Coins.getCoins(p.getName())  >= 7000)
			          {
			        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.tank");  
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.tank local");
				        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.tank global");  
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.tank");
			            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.tank true");
			            
			            p.sendMessage("§6\u27a1 §cYou buy the Tank kit §e-7000 coins");
			            Coins.removeCoins(p.getName(), 7000);
			            e.setCancelled(true);
			            p.closeInventory();
			          }
			          else if (Coins.getCoins(p.getName()) < 7000)
			          {
			            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
			            e.setCancelled(true);
			            p.closeInventory();
			          }
			        }
			   {
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.WATCH)) {
				          if (Coins.getCoins(p.getName())  >= 7000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.timelord");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.timelord local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.timelord global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.timelord true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Timelord kit §e-7000 coins");
				            Coins.removeCoins(p.getName(), 7000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 7000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   {
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SNOW_BALL)) {
				          if (Coins.getCoins(p.getName())  >= 6000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.switcher");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.switcher local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.switcher global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.switcher");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.switcher true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Switcher kit §e-6000 coins");
				            Coins.removeCoins(p.getName(), 6000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 6000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.MAGMA_CREAM)) {
				          if (Coins.getCoins(p.getName())  >= 8000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.jumper");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.jumper local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.jumper global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jumper");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.jumper true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the JUMPER kit §e-8000 coins");
				            Coins.removeCoins(p.getName(), 8000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 8000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CACTUS)) {
				          if (Coins.getCoins(p.getName())  >= 4000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.cactus");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.cactus local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.cactus global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.cactus");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.cactus true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Cactus kit §e-4000 coins");
				            Coins.removeCoins(p.getName(), 4000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 4000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.TNT)) {
				          if (Coins.getCoins(p.getName())  >= 9000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.bomber");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.bomber local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.bomber global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.bomber");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.bomber true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Bomber kit §e-9000 coins");
				            Coins.removeCoins(p.getName(), 9000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 9000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ENDER_PEARL)) {
				          if (Coins.getCoins(p.getName())  >= 4000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.warper");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.warper local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.warper global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.warper");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.warper true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Warper kit §e-4000 coins");
				            Coins.removeCoins(p.getName(), 4000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 4000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLDEN_APPLE)) {
				          if (Coins.getCoins(p.getName())  >= 8000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.critical");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.critical local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.critical global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.critical");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.critical true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Critical kit §e-8000 coins");
				            Coins.removeCoins(p.getName(), 8000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 8000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FISHING_ROD)) {
				          if (Coins.getCoins(p.getName())  >= 5000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.fisherman");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.fisherman local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.fisherman global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fisherman");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.fisherman true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Fisherman kit §e-5000 coins");
				            Coins.removeCoins(p.getName(), 5000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 5000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ICE)) {
				          if (Coins.getCoins(p.getName())  >= 6000)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.freezer");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.freezer local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.freezer global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.freezer");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.freezer true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Freezer kit §e-5000 coins");
				            Coins.removeCoins(p.getName(), 6000);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 6000)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
				          if (Coins.getCoins(p.getName())  >= 9500)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.doublejump");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.doublejump local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.doublejump global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.doublejump true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the DoubleJump kit §e-9500 coins");
				            Coins.removeCoins(p.getName(), 9500);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 9500)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
				   if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_BOOTS)) {
				          if (Coins.getCoins(p.getName())  >= 17500)
				          {
				        	  Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.stomper");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.stomper local");
					        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.stomper global");  
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.stomper");
				            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.stomper true");
				            
				            p.sendMessage("§6\u27a1 §cYou buy the Stomper kit §e-17500 coins");
				            Coins.removeCoins(p.getName(), 17500);
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				          else if (Coins.getCoins(p.getName()) < 17500)
				          {
				            p.sendMessage("§4§l\u2716 You dont have Money to buy this kit!");
				            e.setCancelled(true);
				            p.closeInventory();
				          }
				        }
	   }
		   }
	   }
	      }
	      }
	      }
	      }
	  

	   

 
	        
@Override
public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}
  {
 ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)5);
	ItemMeta vidro2 = vidro.getItemMeta();
	vidro2.setDisplayName("§bIf you buy a kit you need to relog to receive them");
	vidro.setItemMeta(vidro2);
ItemStack[] arrayOfItemStack;
int descpyro1 = (arrayOfItemStack = shop.getContents()).length;
for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
{
ItemStack item = arrayOfItemStack[metapyro1];
if (item == null) {
shop.setItem(shop.firstEmpty(), vidro);
}
}
}
 }
