/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
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
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
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
/* 152 */       World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
/* 153 */       double x = Main.plugin.getConfig().getDouble("Spawn.X");
/* 154 */       double y = Main.plugin.getConfig().getDouble("Spawn.Y");
/* 155 */       double z = Main.plugin.getConfig().getDouble("Spawn.Z");
/* 156 */       Location lobby = new Location(w, x, y, z);
/* 157 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
/* 158 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
/* 159 */       e.getRespawnLocation().setWorld(w);
/* 160 */       e.getRespawnLocation().setX(x);
/* 161 */       e.getRespawnLocation().setY(y);
/* 162 */       e.getRespawnLocation().setZ(z);
/* 163 */       e.getRespawnLocation().setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
/* 164 */       e.getRespawnLocation().setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
/*     */       
/*     */ 
/*     */ 
/* 168 */       p.getInventory().clear();
/*     */       
/*     */ 
/*     */ 
/* 172 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, "§aKit menu §7(Right click)", Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
/* 173 */       ItemStack kits = new ItemStack(Material.EMERALD);
/* 174 */       ItemMeta kits2 = kits.getItemMeta();
/* 175 */       kits2.setDisplayName("§b§lShop Menu");
/* 176 */       kits.setItemMeta(kits2);
/* 177 */       p.getInventory().addItem(new ItemStack[] { kits });
/* 178 */       ItemStack st = new ItemStack(Material.BLAZE_ROD);
/* 179 */       ItemMeta st2 = st.getItemMeta();
/* 180 */       st2.setDisplayName("§eJOIN 1V1");
/* 181 */       st.setItemMeta(st2);
ItemStack stats = new ItemStack(Material.NAME_TAG);
/* 227 */           ItemMeta stats2 = kits.getItemMeta();
/* 228 */           stats2.setDisplayName("§aYour Stats §7(Right click)");
/* 229 */           stats.setItemMeta(stats2);
p.getInventory().addItem(new ItemStack[] { st });
/* 182 */       p.getInventory().setItem(3, stats);
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
