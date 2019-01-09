/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.X1.X1;

/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerKickEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Menu
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   private String[] args;
/*     */   
/*     */   public Menu(Main main)
/*     */   {
/*  62 */     this.main = main;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onJoin(PlayerJoinEvent e) {
/*  67 */     Player p = e.getPlayer();
/*     */     
/*     */ 
/*  70 */     Habilidade.removeAbility(p);
/*  71 */     Deshfire.Armadura.remove(p);
/*  72 */     Deshfire.Armadura2.remove(p);
/*  73 */     Deshfire.cooldownm.remove(p);
/*  74 */     Join.game.remove(p.getName());
/*  75 */     Cooldown.remove(p);
/*     */     
/*     */ 
/*     */ 
/*  79 */     Streak.killstreak.put(p.getName(), Integer.valueOf(0));
/*     */     
/*  81 */     World world = p.getWorld();
/*  82 */     p.teleport(world.getSpawnLocation());
/*     */     
/*  84 */     if (this.main.getConfig().getString("JoinItem.JoinSound").equalsIgnoreCase("true"))
/*  85 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Join")), 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void createButton(Material mat, Inventory inv, int Slot, String name, String lore) {
/*  89 */     ItemStack item = new ItemStack(mat);
/*     */     
/*  91 */     ItemMeta meta = item.getItemMeta();
/*  92 */     meta.setDisplayName(name);
/*  93 */     meta.setLore(Arrays.asList(new String[] { lore }));
/*  94 */     item.setItemMeta(meta);
/*  95 */     inv.setItem(Slot, item);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void onJoinr(PlayerJoinEvent e)
/*     */   {
/* 103 */     Player p = e.getPlayer();
/* 104 */     int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
/* 105 */     int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
/*     */     
/* 107 */     if ((kills == 0) && (deaths == 0)) {
/* 108 */       Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
/* 109 */       Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".mortes", Integer.valueOf(deaths + 1));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onLeave(PlayerQuitEvent e)
/*     */   {
/* 117 */     Player p = e.getPlayer();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 122 */     p.chat("/kitpvp leave");
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onLeave(PlayerKickEvent e)
/*     */   {
/* 128 */     Player p = e.getPlayer();
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 133 */     p.chat("/kitpvp leave");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void onFall(PlayerRespawnEvent e)
/*     */   {
/* 148 */     Player p = e.getPlayer();
/* 149 */     if (Join.game.contains(p.getName()))
/*     */     {
/*     */ 
/* 152 */       World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("SpawnD.World"));
/* 153 */       double x = Main.plugin.getConfig().getDouble("SpawnD.X");
/* 154 */       double y = Main.plugin.getConfig().getDouble("SpawnD.Y");
/* 155 */       double z = Main.plugin.getConfig().getDouble("SpawnD.Z");
/* 156 */       Location lobby = new Location(w, x, y, z);
/* 157 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("SpawnD.Pitch"));
/* 158 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("SpawnD.Yaw"));
/* 159 */       e.getRespawnLocation().setWorld(w);
/* 160 */       e.getRespawnLocation().setX(x);
/* 161 */       e.getRespawnLocation().setY(y);
/* 162 */       e.getRespawnLocation().setZ(z);
/* 163 */       e.getRespawnLocation().setPitch((float)Main.plugin.getConfig().getDouble("SpawnD.Pitch"));
/* 164 */       e.getRespawnLocation().setYaw((float)Main.plugin.getConfig().getDouble("SpawnD.Yaw"));
/*     */       
/*     */ 
/*     */ 
/* 168 */       p.getInventory().clear();
/*     */       
/*     */ 
/*     */ 
/*  94 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, Main.messages.getString("KitItemName").replace("&", "§"), Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
/*  95 */       ItemStack kits = new ItemStack(Material.EMERALD);
/*  96 */       ItemMeta kits2 = kits.getItemMeta();
/*  97 */       kits2.setDisplayName(Main.messages.getString("ShopItemName").replace("&", "§"));
/*  98 */       kits.setItemMeta(kits2);
/*  99 */       ItemStack st = new ItemStack(Material.BLAZE_ROD);
/* 100 */       ItemMeta st2 = st.getItemMeta();
/* 101 */       st2.setDisplayName(Main.messages.getString("1v1ItemName").replace("&", "§"));
/* 102 */       st.setItemMeta(st2);
ItemStack stats = new ItemStack(Material.NAME_TAG);
/* 227 */           ItemMeta stats2 = kits.getItemMeta();
/* 228 */           stats2.setDisplayName(Main.messages.getString("StatsItemName").replace("&", "§"));
/* 229 */           stats.setItemMeta(stats2);
p.getInventory().setItem(3, stats);
ItemStack stats1 = new ItemStack(Material.WOOD_SWORD);
/* 227 */           ItemMeta stats12 = kits.getItemMeta();
/* 228 */           stats12.setDisplayName(Main.messages.getString("ClickTestItemName").replace("&", "§"));
/* 229 */           stats1.setItemMeta(stats12);
p.getInventory().setItem(4, stats1);
/* 103 */       p.getInventory().addItem(new ItemStack[] { kits });
/* 104 */       p.getInventory().addItem(new ItemStack[] { st });
/*     */       
/*     */ 
/* 107 */       
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 187 */       p.setExp(0.0F);
/* 188 */       p.setExhaustion(20.0F);
/* 189 */       p.setFireTicks(0);
/* 190 */       p.setFoodLevel(20000);
/* 191 */       p.getInventory().setArmorContents(null);
/*     */       
/* 193 */       p.updateInventory();
/* 194 */       Habilidade.removeAbility(p);
/* 195 */       Deshfire.Armadura.remove(p);
/* 196 */       Deshfire.Armadura2.remove(p);
/* 197 */       Deshfire.cooldownm.remove(p);
/*     */       
/* 199 */       Cooldown.remove(p);
/*     */     }
/*     */     
/* 202 */     World world = p.getWorld();
/* 203 */     p.teleport(world.getSpawnLocation());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore)
/*     */   {
/* 237 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 238 */     ItemMeta meta = item.getItemMeta();
/* 239 */     meta.setDisplayName(displayName);
/* 240 */     meta.setLore(lore);
/* 241 */     item.setItemMeta(meta);
/* 242 */     return item;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void quickcommand(PlayerCommandPreprocessEvent e)
/*     */   {
/* 336 */     if ((e.getMessage().equalsIgnoreCase("/kitpvp kit")) && (Join.game.contains(e.getPlayer().getName()))) {
/* 337 */       e.setCancelled(true);
/* 338 */       Player p = e.getPlayer();
/* 339 */       p.chat("/kpkitmenu");
/*     */       
/* 341 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 343 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 344 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand1(PlayerCommandPreprocessEvent e)
/*     */   {
/* 352 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kits")) {
/* 353 */       e.setCancelled(true);
/* 354 */       Player p = e.getPlayer();
/* 355 */       p.chat("/kpkitmenu");
/* 356 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 358 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 359 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand2(PlayerCommandPreprocessEvent e)
/*     */   {
/* 367 */     if (e.getMessage().equalsIgnoreCase("/kitpvp kitmenu")) {
/* 368 */       e.setCancelled(true);
/* 369 */       Player p = e.getPlayer();
/* 370 */       p.chat("/kpkitmenu");
/* 371 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 373 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 374 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand3(PlayerCommandPreprocessEvent e)
/*     */   {
/* 382 */     if (e.getMessage().equalsIgnoreCase("/kpkits")) {
/* 383 */       e.setCancelled(true);
/* 384 */       Player p = e.getPlayer();
/* 385 */       p.chat("/kpkitmenu");
/*     */       
/*     */ 
/* 388 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 390 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 391 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void quickcommand4(PlayerCommandPreprocessEvent e)
/*     */   {
/* 400 */     if (e.getMessage().equalsIgnoreCase("/kpkit")) {
/* 401 */       e.setCancelled(true);
/* 402 */       Player p = e.getPlayer();
/* 403 */       p.chat("/kpkitmenu");
/* 404 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 406 */         e.getPlayer().sendMessage("§cYou must be in game to open kit menu!");
/* 407 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
@EventHandler
public void onBauKit(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.EMERALD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      p.openInventory(Shop.shop);
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}

@EventHandler
public void onKit(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.BOOK)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      Bukkit.dispatchCommand(p, "kpkitmenu");
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}
@EventHandler
public void onKit2(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.WOOD_SWORD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      ClickTest.StartClick(p);
    }
  }
}

@EventHandler
public void onStats(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.NAME_TAG)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      p.sendMessage("§b");
      int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
      int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
      p.sendMessage("§5§l\u279C §e§lYour Stats §a§l" + p.getName());
      p.sendMessage("");
      p.sendMessage("§bKills:§e " + kills);
      p.sendMessage("§bDeaths:§e " + deaths);
      
      p.sendMessage("§bCoins:§e " + Coins.getCoins(p.getName()));
      p.sendMessage("§bStreak:§e " + Streak.killstreak.get(p.getName()));
      p.sendMessage("§b");
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}

@EventHandler
public void v1(PlayerInteractEvent e)
{
  Player p = e.getPlayer();
  if ((p.getItemInHand().getType().equals(Material.BLAZE_ROD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && !Habilidade.ContainsAbility(p) && Join.game.contains(p.getName()))
  {
    e.setCancelled(true);
    if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK))
    {
      X1.entrar1v1(p);
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 12.0F, 1.0F);
    }
  }
}


/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
/*     */   {
/* 452 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
