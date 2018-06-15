/*     */ package me.RafaelAulerDeMeloAraujo.X1;
/*     */ 
/*     */ import java.util.ArrayList;
import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Player.Spigot;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerJoinEvent;
/*     */ import org.bukkit.event.player.PlayerKickEvent;
/*     */ import org.bukkit.event.player.PlayerQuitEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.scheduler.BukkitRunnable;
/*     */ import org.bukkit.scheduler.BukkitScheduler;
/*     */ 
/*     */ public class X1 implements Listener
/*     */ {
	/*     */   private Main main;
	/*     */   
	/*     */ 
	/*     */ 
	/*     */   static Main plugin;
	/*     */   
	/*     */ 
	/*     */ 
	/*     */ 
	/*     */   public X1(Main main)
	/*     */   {
	/*  61 */     this.main = main;
	/*  62 */     plugin = main;
	/*     */   }

/*     */   
/*     */ 
/*  47 */   public static Map<String, String> convites = new HashMap();
/*  48 */   public static Map<String, String> lutadores = new HashMap();
/*  49 */   public static ArrayList<Player> hide = new ArrayList();
/*  50 */   public static ArrayList<Player> inx1 = new ArrayList();
/*     */   
/*     */   public static void sair1v1(Player p) {
/*  53 */     p.getInventory().clear();
/*  54 */     inx1.remove(p);
/*  55 */     Join.game.add(p.getName());
/*  56 */     org.bukkit.World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
/*  57 */     double x = Main.plugin.getConfig().getDouble("Spawn.X");
/*  58 */     double y = Main.plugin.getConfig().getDouble("Spawn.Y");
/*  59 */     double z = Main.plugin.getConfig().getDouble("Spawn.Z");
/*  60 */     Location lobby = new Location(w, x, y, z);
/*  61 */     lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
/*  62 */     lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
/*  63 */     p.getInventory().clear();
/*  64 */     p.teleport(lobby);
/*  65 */     p.getInventory().setLeggings(new ItemStack(Material.AIR));
/*  66 */     p.getInventory().setBoots(new ItemStack(Material.AIR));
/*  67 */     ItemStack shop = new ItemStack(Material.BOOK);
/*  68 */     ItemMeta shop2 = shop.getItemMeta();
/*  69 */     shop2.setDisplayName( Main.messages.getString("KitItemName").replace("&", "§"));
/*  70 */     shop.setItemMeta(shop2);

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
p.getInventory().setItem(0 , shop);
p.getInventory().setItem(1 , kits);
p.getInventory().setItem(2 , st);

/*     */       
/*     */ 
/* 107 */       p.updateInventory();
/*  83 */     Habilidade.removeAbility(p);
/*  84 */     p.setHealth(20.0D);
/*     */     
/*     */ 
/*  87 */     p.updateInventory();
/*  88 */     p.sendMessage(Main.messages.getString("1v1Leave").replace("&", "§"));

TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(20), Integer.valueOf(10), "§aYou leave the 1v1", "");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public static void entrar1v1(Player p)
/*     */   {
/*  97 */     inx1.add(p);
/*  98 */     p.teleport(new Location(p.getWorld(), Main.cfg_x1.getDouble("x1.coords.spawn.x"), 
/*  99 */       Main.cfg_x1.getDouble("x1.coords.spawn.y"), Main.cfg_x1.getDouble("x1.coords.spawn.z")));
/* 100 */     p.getInventory().clear();
/* 101 */     p.getInventory().setArmorContents(null);
/*     */     
/* 103 */     ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
/* 104 */     ItemMeta v12 = v1.getItemMeta();
/* 105 */     v12.setDisplayName("§eRight Click on someone to challenge him!");
/* 106 */     v1.setItemMeta(v12);
/* 107 */     ItemStack rd1 = new ItemStack(Material.REDSTONE);
/* 108 */     ItemMeta rd12 = rd1.getItemMeta();
/* 109 */     rd12.setDisplayName("§cLeave");
/* 110 */     rd1.setItemMeta(rd12);
/*     */     
/* 112 */     p.getInventory().setItem(0, v1);
/* 113 */     p.getInventory().setItem(8, rd1);
/*     */     
/* 115 */     Join.game.add(p.getName());
/* 116 */     p.setHealth(20.0D);
/* 117 */     p.setExp(0.0F);
/* 118 */     p.setLevel(0);
/* 119 */     Habilidade.setAbility(p, Main.cfg_x1.getString("x1.ability"));
/*     */   }
/*     */   
/*     */ 
/*     */   public static void set1v1(Player p)
/*     */   {
/* 125 */     p.getInventory().clear();
/* 126 */     p.getInventory().setArmorContents(null);
/* 127 */     ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
/* 128 */     ItemMeta souperaa = dima.getItemMeta();
/* 129 */     souperaa.setDisplayName("§cSword");
/* 130 */     dima.setItemMeta(souperaa);
/* 131 */     p.getInventory().addItem(new ItemStack[] { dima });
/* 132 */     p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/* 133 */     p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/* 134 */     p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 135 */     p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/*     */     
/* 137 */     ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 138 */     ItemMeta sopas = sopa.getItemMeta();
/* 139 */     sopas.setDisplayName("§6Soup");
/* 140 */     sopa.setItemMeta(sopas);
/* 141 */     for (int i = 0; i <= 7; i++) {
/* 142 */       p.getInventory().addItem(new ItemStack[] { sopa });
/* 143 */       p.updateInventory();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void aceitar(Player p1, Player p2)
/*     */   {
/* 152 */     p1.teleport(new Location(p1.getWorld(), Main.cfg_x1.getDouble("x1.coords.loc_1.x"), 
/* 153 */       Main.cfg_x1.getDouble("x1.coords.loc_1.y"), Main.cfg_x1.getDouble("x1.coords.loc_1.z"), 
/* 154 */       Float.valueOf((float)Main.cfg_x1.getDouble("x1.coords.loc_1.yaw")).floatValue(), Float.valueOf((float)Main.cfg_x1.getDouble("x1.coords.loc_1.pitch")).floatValue()));
/* 155 */     p2.teleport(new Location(p1.getWorld(), Main.cfg_x1.getDouble("x1.coords.loc_2.x"), 
/* 156 */       Main.cfg_x1.getDouble("x1.coords.loc_2.y"), Main.cfg_x1.getDouble("x1.coords.loc_2.z"), 
/* 157 */       Float.valueOf((float)Main.cfg_x1.getDouble("x1.coords.loc_2.yaw")).floatValue(), Float.valueOf((float)Main.cfg_x1.getDouble("x1.coords.loc_2.pitch")).floatValue()));
/*     */     
/* 159 */     set1v1(p1);
/* 160 */     set1v1(p2);
/* 161 */     lutadores.put(p1.getName(), p2.getName());
/* 162 */     lutadores.put(p2.getName(), p1.getName());
/* 163 */     convites.remove(p1.getName());
/* 164 */     for (Player pp : Bukkit.getOnlinePlayers()) {
/* 165 */       p1.hidePlayer(pp);
/*     */     }
/* 167 */     hide.add(p1);
/* 168 */     for (Player pp : Bukkit.getOnlinePlayers()) {
/* 169 */       p2.hidePlayer(pp);
/*     */     }
/* 171 */     hide.add(p2);
/* 172 */     p1.showPlayer(p2);
/* 173 */     p2.showPlayer(p1);
/* 174 */     p1.updateInventory();
/* 175 */     p2.updateInventory();
/* 176 */     p1.sendMessage(Main.cfg_x1.getString("x1.msg.invite_accept").replace("$player$", p2.getName()).replace("&", "§"));
/* 177 */     p2.sendMessage(Main.cfg_x1.getString("x1.msg.guest_accept").replace("$player$", p1.getName()).replace("&", "§"));
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void interact(PlayerInteractEvent e) {
/* 182 */     if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) && 
/* 183 */       (e.getAction().name().contains("RIGHT_CLICK")) && 
/* 184 */       (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE))) {
/* 185 */       sair1v1(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void entrar(PlayerJoinEvent e)
/*     */   {
/* 193 */     for (Player p : hide) {
/* 194 */       p.hidePlayer(e.getPlayer());
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void cmd(PlayerCommandPreprocessEvent e) {
/* 200 */     if (Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) {
/* 201 */       e.getPlayer().sendMessage(Main.cfg_x1.getString("x1.msg.no_cmd").replace("&", "§"));
/* 202 */       e.setCancelled(true);
/* 203 */       return;
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kick(PlayerQuitEvent e) {
/* 209 */     if (lutadores.containsKey(e.getPlayer().getName())) {
/* 210 */       Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
/* 211 */       Player perdedor = e.getPlayer();
/* 212 */       matou.sendMessage(Main.cfg_x1.getString("x1.msg.disconect"));
/* 213 */       hide.remove(perdedor);
/* 214 */       hide.remove(matou);
/* 215 */       for (Player pp : Bukkit.getOnlinePlayers()) {
/* 216 */         matou.showPlayer(pp);
/* 217 */         perdedor.showPlayer(pp);
/*     */       }
/* 219 */       entrar1v1(matou);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kick(PlayerKickEvent e) {
/* 225 */     if (lutadores.containsKey(e.getPlayer().getName())) {
/* 226 */       Player matou = Bukkit.getServer().getPlayerExact((String)lutadores.get(e.getPlayer().getName()));
/* 227 */       Player perdedor = e.getPlayer();
/* 228 */       matou.sendMessage(Main.cfg_x1.getString("x1.msg.disconect"));
/* 229 */       hide.remove(perdedor);
/* 230 */       hide.remove(matou);
/* 231 */       for (Player pp : Bukkit.getOnlinePlayers()) {
/* 232 */         matou.showPlayer(pp);
/* 233 */         perdedor.showPlayer(pp);
/*     */       }
/* 235 */       entrar1v1(matou);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void morrer(final PlayerDeathEvent e) {
/* 241 */     Player p = e.getEntity().getPlayer();
/* 242 */     Player k = p.getKiller();
/* 243 */     if (!Habilidade.getAbility(p).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability")))
/* 244 */       return;
/* 245 */     if ((e.getEntity() instanceof Player)) {
/* 246 */       p.spigot().respawn();
/* 247 */       p.setFireTicks(0);
/* 248 */       for (PotionEffect effect : p.getActivePotionEffects())
/* 249 */         p.removePotionEffect(effect.getType());
/*     */     }
/* 251 */     if (((p instanceof Player)) && ((k instanceof Player))) {
/* 252 */       p.spigot().respawn();
/* 253 */       p.setFireTicks(0);
/* 254 */       for (PotionEffect effect : p.getActivePotionEffects())
/* 255 */         p.removePotionEffect(effect.getType());
/*     */     }
/* 257 */     if (lutadores.containsKey(e.getEntity().getPlayer().getName()))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 280 */       new BukkitRunnable()
/*     */       {
/*     */         public void run()
/*     */         {
/* 262 */           Player matou = Bukkit.getServer()
/* 263 */             .getPlayerExact((String)X1.lutadores.get(e.getEntity().getPlayer().getName()));
/* 264 */           Player morreu = e.getEntity().getPlayer();
/* 265 */           morreu.spigot().respawn();
/* 266 */           X1.lutadores.remove(morreu.getName());
/* 267 */           X1.lutadores.remove(matou.getName());
/* 268 */           X1.hide.remove(matou);
/* 269 */           X1.hide.remove(morreu);
/* 270 */           X1.entrar1v1(matou);
/* 271 */           X1.entrar1v1(morreu);
/* 272 */           morreu.updateInventory();
/* 273 */           matou.updateInventory();
/* 274 */           for (Player online : Bukkit.getOnlinePlayers()) {
/* 275 */             morreu.showPlayer(online);
/* 276 */             matou.showPlayer(online);
/*     */           }
/*     */           
/*     */         }
/* 280 */       }.runTaskLater(Main.plugin, 5L);
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void InteractItem(PlayerInteractEntityEvent e)
/*     */   {
/* 287 */     if ((Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) && 
/* 288 */       ((e.getRightClicked() instanceof Player)) && 
/* 289 */       (e.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD)) {
/* 290 */       final Player p = e.getPlayer();
/* 291 */       Player target = (Player)e.getRightClicked();
/* 292 */       if (convites.containsKey(target.getName())) {
/* 293 */         if (((String)convites.get(target.getName())).equalsIgnoreCase(p.getName())) {
/* 294 */           aceitar(target, p);
/* 295 */         } else if (!convites.containsKey(p.getName())) {
/* 296 */           p.sendMessage(Main.cfg_x1.getString("§6x1.msg.invite").replace("$player$", target.getName()));
/* 297 */           target.sendMessage(
/* 298 */             Main.cfg_x1.getString("§6x1.msg.guest").replace("$player$", p.getName()));
/* 299 */           convites.put(p.getName(), target.getName());
/* 300 */           Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
/*     */           {
/*     */             public void run()
/*     */             {
/* 304 */               if (X1.convites.containsKey(p.getName())) {
/* 305 */                 X1.convites.remove(p.getName());
/*     */               }
/*     */             }
/* 308 */           }, 200L);
/*     */         } else {
/* 310 */           p.sendMessage(Main.cfg_x1.getString("x1.msg.invite_cooldown").replace("&", "§"));
/*     */         }
/* 312 */       } else if (!convites.containsKey(p.getName())) {
/* 313 */         p.sendMessage(Main.cfg_x1.getString("x1.msg.invite").replace("$player$", target.getName().replace("&", "§")));
/* 314 */         target.sendMessage(
/* 315 */           Main.cfg_x1.getString("x1.msg.guest").replace("$player$", p.getName().replace("&", "§")));
/* 316 */         convites.put(p.getName(), target.getName());
/* 317 */         Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable()
/*     */         {
/*     */           public void run()
/*     */           {
/* 321 */             if (X1.convites.containsKey(p.getName())) {
/* 322 */               X1.convites.remove(p.getName());
/*     */             }
/*     */           }
/* 325 */         }, 200L);
/*     */       } else {
/* 327 */         p.sendMessage(Main.cfg_x1.getString("x1.msg.invite_cooldown").replace("&", "§"));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private static ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore)
/*     */   {
/* 336 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 337 */     ItemMeta meta = item.getItemMeta();
/* 338 */     meta.setDisplayName(displayName);
/* 339 */     meta.setLore(lore);
/* 340 */     item.setItemMeta(meta);
/* 341 */     return item;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\X1\X1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
