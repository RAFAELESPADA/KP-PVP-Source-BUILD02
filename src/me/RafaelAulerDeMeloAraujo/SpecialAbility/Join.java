/*     */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreBoardHelper;
/*     */ import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*     */ import me.RafaelAulerDeMeloAraujo.X1.X1;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.GameMode;
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
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginDescriptionFile;
/*     */ import org.bukkit.plugin.PluginManager;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Join
/*     */   implements CommandExecutor, Listener
/*     */ {
/*  43 */   public static HashMap<String, ItemStack[]> saveinv = new HashMap();
/*  44 */   public static HashMap<String, ItemStack[]> savearmor = new HashMap();
/*  45 */   public static HashMap<String, Location> saveworld = new HashMap();
/*  46 */   public static HashMap<String, GameMode> savegamemode = new HashMap();
/*     */   
/*     */ 
/*     */ 
/*     */   private Main main;
/*     */   
/*     */ 
/*     */ 
/*     */   static Main plugin;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public Join(Main main)
/*     */   {
/*  61 */     this.main = main;
/*  62 */     plugin = main;
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
/*  76 */   HashMap<String, Location> maps = new HashMap();
/*  77 */   public static ArrayList<String> game = new ArrayList();
/*  78 */   List<String> commands = Arrays.asList(new String[] { "admin", "list", "create", "delete", "1v1", "score", "setspawn", "join", "leave", "reset", "coins", "setchallenge", "kit", "kitunlocker", "resetkit", "stats", "reload", "update" });
/*     */   
/*     */   public Join() {}
/*     */   
/*  82 */   private ItemStack make(Material material, int amount, int shrt, String displayName, List<String> lore) { ItemStack item = new ItemStack(material, amount, (short)shrt);
/*  83 */     ItemMeta meta = item.getItemMeta();
/*  84 */     meta.setDisplayName(displayName);
/*  85 */     meta.setLore(lore);
/*  86 */     item.setItemMeta(meta);
/*  87 */     return item;
/*     */   }
/*     */   
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
/*  91 */     if (commandLabel.equalsIgnoreCase("kitpvp"))
/*     */     {
/*  93 */       if (args.length == 0)
/*     */       {

/* 106 */         sender.sendMessage(ChatColor.DARK_AQUA + "§m-----------" + ChatColor.AQUA + " KP-PVP COMMANDS " + ChatColor.DARK_AQUA + ChatColor.STRIKETHROUGH + "-------------");
/* 107 */         sender.sendMessage(ChatColor.DARK_AQUA + "§eCreated by zEnderX5_");
/* 108 */         sender.sendMessage("");
/* 109 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Main command");
/* 110 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "join" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Join the kitpvp!");
/* 111 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "leave" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Leave the kitpvp!");
/* 112 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "kits" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Open kit menu!");
/* 113 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "shop" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Open shop menu!");
/* 114 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "1v1" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Join kitpvp 1v1!");
/*     */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "clear" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Clear your kit and return to kitpvp spawn");                              
/* 116 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "info" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "Shows plugin info");
/* 117 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "update" + ChatColor.DARK_AQUA + " - " + ChatColor.RED + "Get a link to verify updates");
/* 118 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kitpvp " + ChatColor.GREEN + "reload" + ChatColor.DARK_AQUA + " - " + ChatColor.RED + "Reload config files");
/* 119 */         sender.sendMessage(ChatColor.DARK_AQUA + " - " + ChatColor.AQUA + "/kp" + ChatColor.DARK_AQUA + " - " + ChatColor.GRAY + "View the full command list");
/* 120 */         sender.sendMessage(ChatColor.DARK_AQUA + "§m------------------------------------------");
/* 101 */         ((Player)sender).playSound(((Player)sender).getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 4.0F, 2.0F);
/* 102 */         return true;
/*     */       }
/* 104 */       if (args[0].equalsIgnoreCase("info"))
/*     */       {
	/* 27 */       sender.sendMessage("§4§l\u274C §2§lCREDITS §f§lAND §e§lINFORMATION §4§l \u274C");
	/* 28 */       sender.sendMessage("§6\u279C §cPlugin Name: §eKP-PVP");
	/* 29 */       sender.sendMessage("§6\u279C §cPlugin Version: §e " + Main.getInstance().getDescription().getVersion());
	/* 30 */       sender.sendMessage("§6\u279C §cAuthor: §ezEnderX5_ , Rafael Auler");
	/* 31 */       sender.sendMessage("§6\u279C §cAuthor Channel: http://bit.ly/2kC345B");
	/* 32 */       sender.sendMessage("§6\u279C §cSpigot Profile: http://bit.ly/2j5qvnM");
	/* 33 */       sender.sendMessage("§6\u279C §cPlugin Page: http://bit.ly/2BZCtLE");
	/* 34 */       sender.sendMessage("§cThanks for use this plugin i really appreaciate IT");
	/* 35 */       sender.sendMessage("§cIf you like it consider giving a §e§l\u2605\u2605\u2605\u2605\u2605 §cReview");
	/* 36 */       sender.sendMessage("§cPS: §eSubscribe to my channel and follow me on Spigot Thanks! §9§l=)");
/* 121 */         ((Player)sender).playSound(((Player)sender).getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 10.0F, 2.0F);
/* 122 */         return true;
/*     */       }
/*     */       
/* 125 */       Player p = (Player)sender;
/* 126 */       if (args[0].equalsIgnoreCase("reload"))
/*     */       {
/* 128 */         if (!sender.hasPermission("kitpvp.reload")) {
/* 129 */           p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§"));
/* 130 */           p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 131 */           return true;
/*     */         }
/*     */         
/* 134 */         Plugin plugin = p.getServer().getPluginManager().getPlugin("KP-PVP");
/* 135 */         plugin.reloadConfig();
/* 136 */         p.getServer().getPluginManager().disablePlugin(plugin);
/* 137 */         p.getServer().getPluginManager().enablePlugin(plugin);
/* 138 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eThe plugin Config has been sucefully reloaded.");
/* 139 */         return true;
/*     */       }
/* 141 */       if (args[0].equalsIgnoreCase("update"))
/*     */       {
/* 143 */         if (!sender.hasPermission("kitpvp.admin")) {
/* 144 */           sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§"));
/* 145 */           ((Player)sender).playSound(((Player)sender).getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 146 */           return true;
/*     */         }
/*     */         
/* 149 */         sender.sendMessage("§c[KitPvP] §eThe plugin may has a update.");
/* 150 */         sender.sendMessage("§c[KitPvP] §eVerify it here.");
/* 151 */         sender.sendMessage("§c[KitPvP] §eYour version: " + Main.getInstance().getDescription().getVersion());
/* 152 */         sender.sendMessage("§c[KitPvP] §eIf your version is lower than the last update");
/* 153 */         sender.sendMessage("§c[KitPvP] §eYou should update your plugin");
/* 154 */         sender.sendMessage("§c[KitPvP] §eLink: http://bit.ly/2tIEzvJ");
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 159 */         ((Player)sender).playSound(((Player)sender).getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 2.0F, 2.0F);
/* 160 */         return true;
/*     */       }
/* 141 */       if (args[0].equalsIgnoreCase("clear"))
/*     */       {
	/*  58 */       if (!Join.game.contains(p.getName()))
	/*     */       {
	/*  60 */         p.sendMessage(String.valueOf("§cYou are not in kitpvp to do this!"));
	/*  61 */         return true;
	/*     */       }
	/*     */       
	/*  64 */       if (!sender.hasPermission("kitpvp.kitclear")) {
	/*  65 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
	/*  66 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
	/*  67 */         return true;
	/*     */       }
	/*  69 */       for (PotionEffect effect : p.getActivePotionEffects()) {
	/*  70 */         p.removePotionEffect(effect.getType());
	/*     */       }
	/*  72 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Clear").replace("&", "§"));
	/*  73 */       p.getInventory().clear();
	/*  74 */       p.getInventory().setHelmet(new ItemStack(Material.AIR));
	/*  75 */       p.getInventory().setChestplate(new ItemStack(Material.AIR));
	/*  76 */       Habilidade.removeAbility(p);
	/*  77 */       me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown.remove(p);
	/*  78 */       Deshfire.cooldownm.remove(p);
	/*  79 */       Deshfire.armadura.remove(p);
	/*  80 */       Gladiator.lutando.remove(p);
	/*  81 */       Gladiator.gladgladiator.remove(p);
	/*  82 */       org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
	/*  83 */       double x = Main.plugin.getConfig().getDouble("Spawn.X");
	/*  84 */       double y = Main.plugin.getConfig().getDouble("Spawn.Y");
	/*  85 */       double z = Main.plugin.getConfig().getDouble("Spawn.Z");
	/*  86 */       Location lobby = new Location(w, x, y, z);
	/*  87 */       lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
	/*  88 */       lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	/*  89 */       p.getInventory().clear();
	/*  90 */       p.teleport(lobby);
	/*     */       
	/*  92 */       p.getInventory().setLeggings(new ItemStack(Material.AIR));
	/*  93 */       p.getInventory().setBoots(new ItemStack(Material.AIR));
	/*  94 */       p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, "§aKit menu §7(Right click)", Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
	/*  95 */       ItemStack kits = new ItemStack(Material.EMERALD);
	/*  96 */       ItemMeta kits2 = kits.getItemMeta();
	/*  97 */       kits2.setDisplayName("§b§lShop Menu");
	/*  98 */       kits.setItemMeta(kits2);
	/*  99 */       ItemStack st = new ItemStack(Material.BLAZE_ROD);
	/* 100 */       ItemMeta st2 = st.getItemMeta();
	/* 101 */       st2.setDisplayName("§eJOIN 1V1");
	/* 102 */       st.setItemMeta(st2);
	ItemStack stats = new ItemStack(Material.NAME_TAG);
	/* 227 */           ItemMeta stats2 = kits.getItemMeta();
	/* 228 */           stats2.setDisplayName("§aYour Stats §7(Right click)");
	/* 229 */           stats.setItemMeta(stats2);
	p.getInventory().setItem(3, stats);
	/* 103 */       p.getInventory().addItem(new ItemStack[] { kits });
	/* 104 */       p.getInventory().addItem(new ItemStack[] { st });
	/*     */       
	/*     */ 
	/* 107 */       p.updateInventory();
/*     */         

/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 159 */         ((Player)sender).playSound(((Player)sender).getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 2.0F, 2.0F);
/* 160 */         return true;
/*     */       }
/* 162 */       if (!this.commands.contains(args[0].toLowerCase()))
/*     */       {
/* 164 */         sender.sendMessage(ChatColor.DARK_AQUA + String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eUnknown command");
/* 165 */         return true;
/*     */       }
/* 167 */       if (args[0].equalsIgnoreCase("join"))
/*     */       {
/* 169 */         if ((sender instanceof Player))
/*     */         {
/* 171 */           if (game.contains(sender.getName()))
/*     */           {
/* 173 */             sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§") + "§cYou are already on kitpvp!"));
/* 174 */             return true;
/*     */           }
/*     */           
/*     */ 
/*     */ 
/* 179 */           p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + String.valueOf(this.main.getConfig().getString("Message.KitPvpJoin-Message").replace("&", "§")));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 185 */           game.add(p.getName());
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 

}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 200 */           World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
/* 201 */           double x = Main.plugin.getConfig().getDouble("Spawn.X");
/* 202 */           double y = Main.plugin.getConfig().getDouble("Spawn.Y");
/* 203 */           double z = Main.plugin.getConfig().getDouble("Spawn.Z");
/* 204 */           Location lobby = new Location(w, x, y, z);
/* 205 */           saveworld.put(p.getName(), p.getLocation());
/* 206 */           saveinv.put(p.getName(), p.getInventory().getContents());
/* 207 */           savearmor.put(p.getName(), p.getInventory().getArmorContents());
/* 208 */           savegamemode.put(p.getName(), p.getGameMode());
/*     */           
/*     */ 
/* 211 */           lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
/* 212 */           lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
/* 213 */           p.getInventory().clear();
/*     */           
/*     */ 
/* 216 */           p.teleport(lobby);
/*     */           
/*     */ 
/* 219 */           p.getInventory().clear();
/* 220 */           p.getInventory().setArmorContents(null);
/* 221 */           p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, "§aKit menu §7(Right click)", Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
/* 222 */           ItemStack st = new ItemStack(Material.BLAZE_ROD);
/* 223 */           ItemMeta st2 = st.getItemMeta();
/* 224 */           st2.setDisplayName("§eJOIN 1V1");
/* 225 */           st.setItemMeta(st2);
/* 226 */           ItemStack kits = new ItemStack(Material.EMERALD);
/* 227 */           ItemMeta kits2 = kits.getItemMeta();
/* 228 */           kits2.setDisplayName("§b§lShop Menu");
/* 229 */           kits.setItemMeta(kits2);
ItemStack stats = new ItemStack(Material.NAME_TAG);
/* 227 */           ItemMeta stats2 = kits.getItemMeta();
/* 228 */           stats2.setDisplayName("§aYour Stats §7(Right click)");
/* 229 */           stats.setItemMeta(stats2);
p.getInventory().setItem(3, stats);
/* 182 */       
/* 230 */           p.getInventory().addItem(new ItemStack[] { kits });

/* 231 */           p.getInventory().addItem(new ItemStack[] { st });
/*     */           
/*     */ 

/*     */ 
/* 235 */           p.setExp(0.0F);
/* 236 */           p.setExhaustion(20.0F);
/* 237 */           p.setFireTicks(0);
/* 238 */           p.setFoodLevel(20000);
/* 239 */           TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(10), this.main.getConfig().getString("Title.JoinTitle"), this.main.getConfig().getString("Title.JoinSubTitle"));

}

}


/*     */         
/*     */       
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 247 */       return false;
/*     */    }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 260 */

/*     */   
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public boolean quickcommand(PlayerCommandPreprocessEvent e)
/*     */   {
/* 269 */     Player p = e.getPlayer();
/*     */     
/* 271 */     if ((e.getMessage().equalsIgnoreCase("/kitpvp leave")) && (game.contains(e.getPlayer().getName()))) {
/* 272 */       e.setCancelled(true);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 279 */       Habilidade.removeAbility(p);
/* 280 */       Deshfire.Armadura.remove(p);
/* 281 */       Deshfire.Armadura2.remove(p);
/* 282 */       Deshfire.cooldownm.remove(p);
/* 283 */       game.remove(p.getName());
/* 284 */       game.remove(p.getName());
/* 285 */       game.remove(p.getName());
/* 286 */       game.remove(p.getName());
/* 287 */       game.remove(p.getName());
/* 288 */       game.remove(p.getName());
/* 289 */       game.remove(p.getName());
/* 290 */       game.remove(p.getName());
/* 291 */       game.remove(p.getName());
/* 292 */       game.remove(p.getName());
/* 293 */       game.remove(p.getName());
/* 294 */       game.remove(p.getName());game.remove(p.getName());
/* 295 */       game.remove(p.getName());
/* 296 */       game.remove(p.getName());
/* 297 */       game.remove(p.getName());
/*     */       ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);
ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);ScoreBoardHelper.removeScore(p);
/*     */ 
/*     */ 
/*     */ 
/* 302 */       Cooldown.remove(p);
/* 303 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + String.valueOf(this.main.getConfig().getString("Message.KitPvpLeave-Message").replace("&", "§")));
/* 304 */       p.getInventory().clear();
/* 305 */       p.teleport((Location)saveworld.get(p.getName()));
/* 306 */       p.getInventory().setContents((ItemStack[])saveinv.get(p.getName()));
/* 307 */       p.setGameMode((GameMode)savegamemode.get(p.getName()));
/* 308 */       p.getInventory().setArmorContents((ItemStack[])savearmor.get(p.getName()));
/*     */       p.chat("/featherboard off");
p.chat("/featherboard on");
/*     */   TitleAPI.sendTitle(p, Integer.valueOf(10), Integer.valueOf(30), Integer.valueOf(10), this.main.getConfig().getString("Title.LeaveTitle"), this.main.getConfig().getString("Title.LeaveSubTitle"));
/* 311 */       p.updateInventory();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 316 */     return false;
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public boolean quickcommand7(PlayerCommandPreprocessEvent e)
/*     */   {
/* 322 */     Player p = e.getPlayer();
/*     */     
/* 324 */     if ((e.getMessage().equalsIgnoreCase("/kitpvp 1v1")) && (game.contains(e.getPlayer().getName()))) {
/* 325 */       e.setCancelled(true);
/* 326 */       X1.entrar1v1(p);
/* 327 */       if (!game.contains(e.getPlayer().getName()))
/*     */       {
/* 329 */         e.getPlayer().sendMessage("§cYou must be in game to join 1v1!");
/* 330 */         e.setCancelled(true);
/*     */       }
/*     */     }
/*     */     
/* 334 */     return false;
/*     */   }
/*     */   

/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Join.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
