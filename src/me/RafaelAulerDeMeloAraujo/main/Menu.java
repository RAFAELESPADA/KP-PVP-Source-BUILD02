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
import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.potion.PotionEffectType;


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
/*  30 */   public static Inventory kitpvp = Bukkit.getServer().createInventory(null, 54, "Kit Menu");


/*     */   static {
/*  33 */     createButton(Material.WOOD_SWORD, kitpvp, 0, "§6\u27a1 §cBasic", "§aThe Basic and Stantard kit!");
/*  42 */     createButton(Material.DIAMOND_SWORD, kitpvp, 1, "§6\u27a1 §cPvP", "§aA stronger version of the Basic kit!");
/*  43 */     createButton(Material.BOW, kitpvp, 2, "§6\u27a1 §cArcher", "§aStarts with swords and bow and arrows!");
/*  44 */     createButton(Material.FLINT_AND_STEEL, kitpvp, 3, "§6\u27a1 §cPyro", "§aStart with fire sword and fire bow!");
/*  45 */     createButton(Material.DIAMOND_CHESTPLATE, kitpvp, 4, "§6\u27a1 §cTank", "§aStarts with diamond armor but are slow!");
/*  46 */     createButton(Material.SNOW_BALL, kitpvp, 5, "§6\u27a1 §cSwitcher", "§aThrow a snowball to change places with your enemy!");
/*  47 */     createButton(Material.MAGMA_CREAM, kitpvp, 6, "§6\u27a1 §cJumper", "§aJump all you can!");
/*  48 */     createButton(Material.CACTUS, kitpvp, 7, "§6\u27a1 §cCactus", "§aGet armor with thorns!");
/*  49 */     createButton(Material.TNT, kitpvp, 8, "§6\u27a1 §cBomber", "§aThrow tnt on your enemy!");
/*  50 */     createButton(Material.ENDER_PEARL, kitpvp, 9, "§6\u27a1 §cWarper", "§aStarts with swords and ender pearls!");
/*  51 */     createButton(Material.BLAZE_ROD, kitpvp, 10, "§6\u27a1 §cWasp", "§aStarts with sharp IV blaze rod!");
/*  52 */     createButton(Material.STRING, kitpvp, 11, "§6\u27a1 §cSpiderman", "§aCan wall clamber!");
/*  53 */     createButton(Material.FEATHER, kitpvp, 12, "§6\u27a1 §cAirman", "§aFly fly");
/*  54 */     createButton(Material.FISHING_ROD, kitpvp, 13, "§6\u27a1 §cFisherman", "§aCatch a big cod!");
/*  55 */     
              createButton(Material.IRON_BOOTS, kitpvp, 14, "§6\u27a1 §cStomper", "§aSmash your enemies!");
              createButton(Material.REDSTONE_BLOCK, kitpvp, 15, "§6\u27a1 §cDeshfire", "§aGot a boost and burn your enemies!");
              createButton(Material.SPIDER_EYE, kitpvp, 16, "§6\u27a1 §cViper", "§aHave a 33% chance to poison on each hit!");
              createButton(Material.IRON_FENCE, kitpvp, 17, "§6\u27a1 §cGladiator", "§aChallenge someone into a glass arena!");
              createButton(Material.FIREWORK, kitpvp, 18, "§6\u27a1 §cKangaroo", "§aDo double-jump with your firework!");
              createButton(Material.COAL, kitpvp, 19, "§6\u27a1 §cNinja", "§aSneak and you teleport to the last player that you hurt!");
              createButton(Material.WATCH, kitpvp, 20, "§6\u27a1 §cTimelord", "§aWith this kit you can freeze players with your Clock!");
              createButton(Material.GOLDEN_APPLE, kitpvp, 21, "§6\u27a1 §cCritical", "§aHave 10% chance to do more damage on each hit!");
              createButton(Material.BLAZE_ROD, kitpvp, 22, "§6\u27a1 §cMonk", "§aClick in you enemy with blaze hod to mix they inventory!");
              createButton(Material.CHAINMAIL_BOOTS, kitpvp, 23, "§6\u27a1 §cDoubleJump", "§aPress space two times to do a double jump!");
              createButton(Material.GOLD_AXE, kitpvp, 23, "§6\u27a1 §cThor", "§aThunderbolts with your axe and be immune to them!");

              createButton(Material.BOOK_AND_QUILL, kitpvp, 49, "§3§l\u27a1 §b§lTip", "§aWrite §e/kitpvp §ato view kitpvp commands!");
/*  56 */     createButton(Material.BARRIER, kitpvp, 53, "§4§l\u2716 §cClose", "§bClose the menu!");
/*  57 */     
/*  58 */     
/*     */   }
/*     */   
/*     */   public Menu(Main main) {
/*  69 */     this.main = main;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  74 */     Player p = e.getPlayer();


                Habilidade.removeAbility(p);
                Deshfire.Armadura.remove(p);
                Deshfire.Armadura2.remove(p);
                Deshfire.cooldownm.remove(p);
                Join.game.remove(p.getName());
                Cooldown.remove(p);
                Streak.killstreak.put(p.getName(), Integer.valueOf(0));
               
                World world = p.getWorld();
                	  p.teleport(world.getSpawnLocation());
                
/*  90 */       if (this.main.getConfig().getString("JoinItem.JoinSound").equalsIgnoreCase("true")) {
/*  91 */         p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.Join")), 1.0F, 1.0F);
/*     */       }
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
          else {
        	  World world = p.getWorld();
        	  p.teleport(world.getSpawnLocation());
     return;
	}
}
	




     

/*    */   


/*     */   
/*     */   
/*     */   @EventHandler
/*     */   public void onJoinKit(PlayerInteractEvent e)
/*     */   {
	Player p = e.getPlayer();
	if 	 ((p.getItemInHand().getType() == Material.BOOK) &&
			(
				
			  (	
					
	  (e.getAction() == Action.RIGHT_CLICK_AIR) || 
	  (e.getAction() == Action.RIGHT_CLICK_BLOCK)   && (Join.game.contains(p.getName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit menu §7(Right click)")))))) {
	  p.openInventory(Menu.kitpvp);
	}
	
	

		if 	 ((p.getItemInHand().getType() == Material.EMERALD) &&
				(
					
				  (	
						
		  (e.getAction() == Action.RIGHT_CLICK_AIR) || 
		  (e.getAction() == Action.RIGHT_CLICK_BLOCK)   && (Join.game.contains(p.getName()))))) {
		  p.openInventory(Shop.shop);
		}
		
		{

}

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
/*     */   private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
/* 140 */     ItemStack item = new ItemStack(mat);
/* 141 */     ItemMeta meta = item.getItemMeta();
/* 142 */     meta.setDisplayName(name);
/* 143 */     meta.setLore(Arrays.asList(new String[] { lore }));
/* 144 */     item.setItemMeta(meta);
/* 145 */     inv.setItem(Slot, item);
/*     */   }
/*     */   
/*     */   public void openMenu(Player p) {
/* 149 */     p.openInventory(kitpvp);
              p.playSound(p.getLocation(), Sound.BLOCK_CHEST_OPEN, 12.0F, 12.0F);
             
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void click(InventoryClickEvent e) 
{
/* 154 */     Player p = (Player)e.getWhoClicked();
/* 155 */     ItemStack clicked = e.getCurrentItem();
/* 156 */     Inventory inv = e.getInventory();



/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cAirman"))){
/* 164 */       e.setCancelled(true);
/* 165 */       p.closeInventory();
/* 166 */       p.performCommand("airman");
/* 167 */       return;
/*     */      }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cViper"))){
/* 164 */       e.setCancelled(true);
/* 165 */       p.closeInventory();
/* 166 */       p.performCommand("viper");
/* 167 */       return;
/*     */      }
/* 169 */    if  ((inv.getName().equals("Kit Menu")) && ((e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cSpiderman")))){
/* 158 */       e.setCancelled(true);
/* 159 */       p.closeInventory();
/* 160 */       p.performCommand("spiderman");

/* 161 */       return;

/*     */     }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cFreezer"))){

/* 170 */       e.setCancelled(true);
/* 171 */       p.closeInventory();
/* 172 */       p.performCommand("freezer");
/* 173 */       return;
/*     */      }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cThor"))){

/* 170 */       e.setCancelled(true);
/* 171 */       p.closeInventory();
/* 172 */       p.performCommand("kthor");
/* 173 */       return;
/*     */      }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (clicked.getType() == null)){

/* 170 */       e.setCancelled(true);
/* 171 */      
/* 173 */       return;
/*     */      }

	   

    
{
if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cBasic"))){
/* 176 */       e.setCancelled(true);
/* 177 */       p.closeInventory();
/* 178 */       p.performCommand("basic");
/* 179 */       return;
/*     */     }
if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cCritical"))){
/* 176 */       e.setCancelled(true);
/* 177 */       p.closeInventory();
/* 178 */       p.performCommand("critical");
/* 179 */       return;
/*     */     }
if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cFisherman"))){
/* 176 */       e.setCancelled(true);
/* 177 */       p.closeInventory();
/* 178 */       p.performCommand("fisherman");
/* 179 */       return;
/*     */     }
/* 181 */     if ((inv.getName().equals("Kit Menu")) && (clicked.getType() == Material.STAINED_GLASS_PANE)) {
/* 182 */       e.setCancelled(true);
/* 183 */       return;
/*     */     }
/* 185 */     if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cMonk"))){
/* 186 */       e.setCancelled(true);
/* 187 */       p.closeInventory();
/* 188 */       p.performCommand("monk");
/* 189 */       return;
/*     */     }
/* 185 */     if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cWasp"))){
/* 186 */       e.setCancelled(true);
/* 187 */       p.closeInventory();
/* 188 */       p.performCommand("wasp");
/* 189 */       return;
/*     */     }
/* 185 */      if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cTimelord"))){
/* 186 */       e.setCancelled(true);
/* 187 */       p.closeInventory();
/* 188 */       p.performCommand("timelord");
/* 189 */       return;
/*     */     }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cKangaroo"))){
/* 186 */       e.setCancelled(true);
/* 187 */       p.closeInventory();
/* 188 */       p.performCommand("kangaroo");
/* 189 */       return;
/*     */     }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cNinja"))){
/* 186 */       e.setCancelled(true);
/* 187 */       p.closeInventory();
/* 188 */       p.performCommand("ninja");
/* 189 */       return;
/*     */     }
/* 191 */    /* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cPvP"))){
/* 192 */       e.setCancelled(true);
/* 193 */       p.closeInventory();
/* 194 */       p.performCommand("kpvp");
/* 195 */       return;
/*     */     }
/* 197 */    /* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cWarper"))){
/* 198 */       e.setCancelled(true);
/* 199 */       p.closeInventory();
/* 200 */       p.performCommand("warper");
/* 201 */       return;
/*     */     }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cArcher"))){
	/* 204 */       e.setCancelled(true);
	/* 205 */       p.closeInventory();
	/* 206 */       p.performCommand("archer");
	/* 207 */       return;
	/*     */     }
{
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cGladiator"))){
/* 204 */       e.setCancelled(true);
/* 205 */       p.closeInventory();
/* 206 */       p.performCommand("gladiator");
/* 207 */       return;
/*     */     }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cDeshfire"))){
/* 204 */       e.setCancelled(true);
/* 205 */       p.closeInventory();
/* 206 */       p.performCommand("deshfire");
/* 207 */       return;
/*     */     }

/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cPyro"))){
/* 211 */         e.setCancelled(true);
/* 212 */         p.closeInventory();
/* 213 */         p.performCommand("Pyro");
/* 214 */         return;
/*     */       }
/* 216 */       /* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cTank"))){
/* 217 */         e.setCancelled(true);
/* 218 */         p.closeInventory();
/* 219 */         p.performCommand("Tank");
/* 220 */         return;
/*     */       }
/* 222 */      /* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cSwitcher"))){
/* 223 */         e.setCancelled(true);
/* 224 */         p.closeInventory();
/* 225 */         p.performCommand("Switcher");
/* 226 */         return;
/*     */       }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cJumper"))){
/* 229 */         e.setCancelled(true);
/* 230 */         p.closeInventory();
/* 231 */         p.performCommand("jumper");
/* 232 */         return;
/*     */       }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cDoubleJump"))){
/* 229 */         e.setCancelled(true);
/* 230 */         p.closeInventory();
/* 231 */         p.performCommand("doublejump");
/* 232 */         return;
/*     */       }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cCactus"))){
/* 235 */         e.setCancelled(true);
/* 236 */         p.closeInventory();
/* 237 */         p.performCommand("Cactus");
/* 238 */         return;
/*     */       }
/* 169 */    if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4§l\u2716 §cClose"))){
/* 241 */         e.setCancelled(true);
/* 242 */         p.closeInventory();
                  p.sendMessage("§2§l\u2714 §aYou close the Kit Menu Successfully!");
/* 243 */         return;
/*     */       }
if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cStomper"))){
/* 241 */         e.setCancelled(true);
                  p.performCommand("stomper");
/* 242 */         p.closeInventory();
/* 243 */         return;
/*     */       }
              if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a§k==="))) {
                e.setCancelled(true);
                	                  
                return;
                	      }
              if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§3§l\u27a1 §b§lTip"))) {
                  e.setCancelled(true);
                  	                  
                  return;
                  	      }
              if ((inv.getName().equals("Kit Menu")) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §cBomber"))){
/* 246 */         e.setCancelled(true);
/* 247 */         p.closeInventory();
/* 248 */         p.performCommand("bomber");
/* 249 */         return;
/*     */       }
/*     */     }
{
}
}
 }






             

/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand(PlayerCommandPreprocessEvent e) {
/* 256 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kit") && (Join.game.contains(e.getPlayer().getName()))) {
/* 257 */       e.setCancelled(true);
/* 258 */       openMenu(e.getPlayer());

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
/* 266 */       openMenu(e.getPlayer());
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
/* 274 */       openMenu(e.getPlayer());
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
/* 274 */       openMenu(e.getPlayer());
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
/* 274 */       openMenu(e.getPlayer());
if (!Join.game.contains(e.getPlayer().getName()))
{
	e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
	e.getPlayer().closeInventory();
/*     */     }
/*     */   }
}
/*     */     
/*     */   
/*     */   
/*     */   public boolean onCommand(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString) {
/* 279 */     return false;
/*     */   }
/*     */  {
	

	}
 {
	 ItemStack vidro = new ItemStack(Material.THIN_GLASS);
		ItemMeta vidro2 = vidro.getItemMeta();
		vidro2.setDisplayName("§a§k===");
		vidro.setItemMeta(vidro2);
ItemStack[] arrayOfItemStack;
int descpyro1 = (arrayOfItemStack = kitpvp.getContents()).length;
for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
{
  ItemStack item = arrayOfItemStack[metapyro1];
  if (item == null) {
	  kitpvp.setItem(kitpvp.firstEmpty(), vidro);
  }
}
}


 {
}
{
	
}
	
	
{

}
}
