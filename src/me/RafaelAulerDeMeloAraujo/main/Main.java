/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.logging.Logger;
/*     */ import me.RafaelAulerDeMeloAraujo.BStatsSystem.Metrics;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Commands;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.AirmanFly;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.CommandsSounds;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.ConfigUtils;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Fisherman;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.InteractEvent;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.JoinSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.LeaveSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.NoDrops;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.NoExplosion;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Soup;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.SoupSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Switcher;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.ThrowTnt;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.WallClamber;

/*     */ import me.RafaelAulerDeMeloAraujo.PluginHooks.PlaceHolderAPIHook;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreBoardHelper;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Scoreboard;
/*     */ import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Basic;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Critical;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.DesifireCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Dublejump;

/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.GladCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Kangaroo;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Monk;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.MonkCMD;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Naruto;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.NewKitMenu;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Ninja;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Snail;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Sponge;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Stomper;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.StomperKITCOMMAND;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Thor;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.ThorKITCOMMAND;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimeLord;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimelordCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Vampire;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Viper;
import me.RafaelAulerDeMeloAraujo.Updater.SpigotUpdater;
/*     */ import me.RafaelAulerDeMeloAraujo.X1.SetX1;
/*     */ import me.RafaelAulerDeMeloAraujo.X1.X1;


/*     */ import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
/*     */
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.command.PluginCommand;
/*     */ import org.bukkit.configuration.InvalidConfigurationException;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.configuration.file.FileConfigurationOptions;
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;

/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
/*     */ import org.bukkit.potion.PotionEffect;
/*     */ import org.bukkit.potion.PotionEffectType;
/*     */ import org.bukkit.scheduler.BukkitRunnable;



/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JavaPlugin
/*     */   implements Listener
/*     */ {
/*  77 */   public static String pluginName = "KP-PVP";
/*     */   private Main pl;
/*     */   
/*     */   public static Main getInstance()
/*     */   {
/*  82 */     return instance;
/*     */   }
/*     */   
/*     */   public static Main getInstace()
/*     */   {
/*  87 */     return instance;
/*     */   }
/*     */   private Server server = Bukkit.getServer();
/*  90 */   public static final String instance2 = null;
/*     */   public static Object instancs;
/*     */   public static Logger log;
/*  93 */   public static File customizationf = new File("plugins/KP-PVP", "settings.yml");
/*     */   public YamlConfiguration cf;
/*  93 */   public static File messagesf = new File("plugins/KP-PVP", "messages.yml");
/*     */   
/*     */   public static Plugin plugin;
/*     */   public static Main instance;
/*     */   private static ConfigUtils cH;
/*  98 */   public static File file_x1 = new File("plugins/KP-PVP", "1v1.yml");
/*     */   
/*     */   public static Main getPlugin()
/*     */   {
/* 102 */     return instance;
/*     */   }
/*     */   
/*     */   public void onEnable()
/*     */   {
	try
    {
      new SpigotUpdater(this, 50969);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
/* 107 */     getLogger().info("KP-PVP plugin is now enable [By zEnderX5_]");
/* 108 */     getLogger().info("Website: http://bit.ly/2kC345B");
/* 109 */     Metrics metrics = new Metrics(this);

metrics.addCustomChart(new Metrics.DrilldownPie("serverAddress", () -> {
	Map<String, Map<String, Integer>> map = new HashMap<>();
	Map<String, Integer> entry = new HashMap<>();
	
	if (getConfig().getBoolean("SendIPAddressData")) entry.put(server.getIp(), 1);
	else entry.put("Hidden", 1);
	
	map.put("Port " + server.getPort(), entry);
	
	return map;
}));
metrics.addCustomChart(new Metrics.SimplePie("ScoreBoard_Enabled", new Callable<String>() {
    @Override
    public String call() throws Exception {
        return getConfig().getString("ScoreBoardEnable");
    }
}));




/* 111 */     if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI"))
/*     */     {
/* 113 */       getLogger().info("Hooking into PlaceHolderAPI");
/* 114 */       new PlaceHolderAPIHook(this).hook();
/* 115 */       getLogger().info("PlaceHolderAPI Hooked Sucefully");
/*     */     }
 

	

	

		

				
/* 117 */     this.pm = Bukkit.getPluginManager();
/* 118 */     registerEvents();
/* 119 */     registerCommands();

/* 121 */     instance = this;
/* 122 */     plugin = this;
/*     */     
/* 124 */     cH = new ConfigUtils();
/*     */     
/* 126 */     File cf = new File(getDataFolder(), "config.yml");
/* 127 */     if (!cf.exists()) {
/* 128 */       saveResource("config.yml", false);
/*     */     }
/* 130 */     this.cf1 = new File(getDataFolder(), "config.yml");
/* 131 */     if (!file_x1.exists()) {
/* 132 */       saveResource("1v1.yml", false);
/*     */     }
/* 134 */     if (!customizationf.exists()) {
/* 135 */       saveResource("settings.yml", false);
/*     */     }
/* 134 */     if (!messagesf.exists()) {
/* 135 */       saveResource("messages.yml", false);
/*     */     }
/*     */     try
/*     */     {
/* 139 */       cfg_x1.load(file_x1);
messages.load(messagesf);

/* 140 */       customization.load(customizationf);
/*     */     }
/*     */     catch (IOException|InvalidConfigurationException e1)
/*     */     {
/* 144 */       System.out.println(e1.getMessage());
/*     */     }

/* 146 */     if ((Bukkit.getVersion().contains("1.9")) || (Bukkit.getVersion().contains("1.10")) || (Bukkit.getVersion().contains("1.11")) || (Bukkit.getVersion().contains("1.12")) || (Bukkit.getVersion().contains("1.13")))
/*     */     {
/* 148 */       getConfig().options().copyDefaults(true);
/* 149 */       getConfig().options().copyHeader(true);
/* 150 */       saveConfig();
/* 151 */       Bukkit.getConsoleSender().sendMessage("The server is using a 1.9 or higher minecraft version");
/* 152 */       Bukkit.getConsoleSender().sendMessage("Altering config sounds to 1.9 Sounds...");
/* 153 */       getConfig().set("Sound.Kit", "ENTITY_ITEM_PICKUP");
/* 154 */       getConfig().set("Sound.ShopMenu", "BLOCK_CHEST_OPEN");
/* 155 */       getConfig().set("Sound.KitUse", "ENTITY_ENDERDRAGON_HURT");
/* 156 */       getConfig().set("Sound.Soup", "ENTITY_GENERIC_EAT");
/* 157 */       getConfig().set("Sound.Fisherman", "ENTITY_ENDERMEN_TELEPORT");
/* 158 */       getConfig().set("Sound.Spiderman", "ENTITY_SLIME_JUMP");
/* 159 */       getConfig().set("Sound.Respawn", "ENTITY_PLAYER_LEVELUP");
/* 160 */       getConfig().set("Sound.Join", "ENTITY_PLAYER_LEVELUP");
/* 161 */       getConfig().set("Sound.KitMenu", "BLOCK_WOODEN_DOOR_CLOSE");
/* 162 */       getConfig().set("Sound.SpongeUse", "ENTITY_ENDERMEN_TELEPORT");
/* 163 */       getConfig().set("Sound.BowlDrop", "ENTITY_ITEM_PICKUP");
/* 164 */       getConfig().set("Sound.ErrorMessage", "ENTITY_ARROW_HIT_PLAYER");
/* 165 */       getConfig().set("Sound.SucefullMessage", "ENTITY_EXPERIENCE_ORB_PICKUP");
/* 166 */       getConfig().set("Sound.NoPermissionMessage", "ENTITY_WITHER_SHOOT");
/* 167 */       getConfig().set("Sound.SwitcherShoot", "ENTITY_ENDERMEN_TELEPORT");
/* 168 */       getConfig().set("Sound.Timelord", "ENTITY_WITHER_SPAWN");
/*     */       
/* 170 */       getConfig().set("Sound.Stomper", "ENTITY_FIREWORK_BLAST");
/* 171 */       getConfig().set("Sound.NarutoAbility", "ENTITY_BLAZE_DEATH");
/* 172 */       getConfig().set("Sound.CommandsSounds", "UI_BUTTON_CLICK");
/* 173 */       getConfig().set("Sound.ShopMenu-Click", "ENTITY_PLAYER_LEVELUP");
/* 174 */       getConfig().set("Sound.Streak", "ENTITY_PLAYER_LEVELUP");
/* 175 */       getConfig().set("Sound.Airman-Fly", "ENTITY_ENDERMEN_SCREAM");
/* 176 */       getConfig().set("Sound.DoubleJump-Ability", "ENTITY_FIREWORK_BLAST");
/* 177 */       getConfig().set("Sound.StomperDamage", "BLOCK_ANVIL_LAND");
/* 178 */       Bukkit.getConsoleSender().sendMessage("Done! All Sounds have been modified to 1.9 Sounds.");
/*     */     }
/*     */   
/*     */   new BukkitRunnable()
{
    public void run()
    {
     
      for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
      
      
      {
        Player p = arrayOfPlayer;
        if (Join.game.contains(p.getName()) && (Main.getInstace().getConfig().getString("ScoreBoardEnable").equalsIgnoreCase("true")))  {
        	Scoreboard.createScoreBoard(p);
        	 if (!Join.game.contains(p.getName()) && (ScoreBoardHelper.hasScore(p)))  {
          ScoreBoardHelper.removeScore(p);
        }
      }
    }
    }}.runTaskTimer(this, 20L, 60L);}
/*     */ 
/*     */ 
/*     */   public ConfigUtils getConfigHandler()
/*     */   {
/* 186 */     return cH;
/*     */   }
/*     */   
/*     */   private void registerCommands()
/*     */   {
/* 191 */     getCommand("kitreload").setExecutor(new Reload(this));
/* 192 */     getCommand("coins").setExecutor(new Commands(this));
/* 193 */     getCommand("kitcredits").setExecutor(new KitCredits(this));
/* 194 */     getCommand("dev").setExecutor(new Dev(this));
/* 195 */     getCommand("ksc").setExecutor(new BSC());
         
/* 196 */     getCommand("kpstats").setExecutor(new Stats());
/* 197 */     getCommand("kp").setExecutor(new KITPVP());
/* 198 */     getCommand("adminmode").setExecutor(new AdminMode(this));
/*     */     
/* 200 */     getCommand("rektf58942kka").setExecutor(new AntiBugCommand());
/* 201 */     getCommand("kpvp").setExecutor(new Kits(this));
/* 202 */     getCommand("freezer").setExecutor(new Kits(this));
/* 203 */     getCommand("basic").setExecutor(new Basic(this));
/* 204 */     getCommand("airman").setExecutor(new Kits(this));
/* 205 */     getCommand("fisherman").setExecutor(new Kits(this));
/* 206 */     getCommand("archer").setExecutor(new Kits(this));
/* 207 */     getCommand("tank").setExecutor(new Kits(this));
/* 208 */     getCommand("pyro").setExecutor(new Kits(this));
/* 209 */     getCommand("kthor").setExecutor(new ThorKITCOMMAND(this));
getCommand("kvampire").setExecutor(new Vampire(this));
/* 210 */     getCommand("switcher").setExecutor(new Kits(this));
/* 211 */     getCommand("viper").setExecutor(new Viper(this));
/* 212 */     getCommand("snail").setExecutor(new Snail(this));
/* 213 */     getCommand("warper").setExecutor(new Kits(this));
/* 214 */     getCommand("jumper").setExecutor(new Kits(this));
/* 215 */     getCommand("wasp").setExecutor(new Kits(this));
/* 216 */     getCommand("cactus").setExecutor(new Kits(this));
/* 217 */     getCommand("bomber").setExecutor(new Kits(this));
/* 218 */     getCommand("spiderman").setExecutor(new Kits(this));
/* 219 */     getCommand("stats").setExecutor(new Stats());
/* 220 */     getCommand("kpstats").setExecutor(new KPStats());
/* 221 */     getCommand("kitmenu").setExecutor(new Menu(this));
/* 222 */     getCommand("kitpvp").setExecutor(new Join());
/*     */     
/*     */ 
/* 225 */     getCommand("kpkits").setExecutor(new Menu(this));
/* 226 */     getCommand("kpshop").setExecutor(new Shop(this));
/* 227 */     getCommand("kploja").setExecutor(new Shop(this));
/* 228 */     getCommand("shopmenu").setExecutor(new Shop(this));
/* 229 */     getCommand("kpkitmenu").setExecutor(new NewKitMenu(this));
/* 230 */     getCommand("kitsc").setExecutor(new StaffChat(this));
/* 231 */     getCommand("kpkit").setExecutor(new Menu(this));
/* 232 */     getCommand("kpsetspawn").setExecutor(new kpsetspawn());
/* 233 */     getCommand("stomper").setExecutor(new StomperKITCOMMAND(this));
/* 234 */     getCommand("gladiator").setExecutor(new GladCMD(this));
/* 235 */     getCommand("deshfire").setExecutor(new DesifireCMD(this));
/* 236 */     getCommand("ninja").setExecutor(new Ninja(this));
/* 237 */   
/* 238 */     getCommand("kangaroo").setExecutor(new Kangaroo(this));
/* 239 */     getCommand("timelord").setExecutor(new TimelordCMD(this));
/* 240 */     getCommand("doublejump").setExecutor(new Dublejump(this));
/* 241 */     getCommand("kitclear").setExecutor(new Kits(this));
/* 242 */     getCommand("skit").setExecutor(new Skit());
              getCommand("kpkills").setExecutor(new Kills());
/* 243 */     getCommand("critical").setExecutor(new Critical(this));
/* 244 */     getCommand("kitpvp").setExecutor(new Join(this));
/* 245 */     getCommand("naruto").setExecutor(new Naruto(this));
/* 246 */     getCommand("monk").setExecutor(new MonkCMD(this));
/* 247 */     getCommand("set1v1").setExecutor(new SetX1());
/*     */   }
/*     */   
/*     */   private void registerEvents()
/*     */   {
/* 252 */     this.pm.registerEvents(new ThrowTnt(this), this);
/* 253 */     this.pm.registerEvents(new Dublejump(this), this);
/* 254 */     this.pm.registerEvents(new Monk(this), this);
/* 255 */     this.pm.registerEvents(new InteractEvent(this), this);
/* 256 */     this.pm.registerEvents(new NewKitMenu(this), this);
/* 257 */     this.pm.registerEvents(new Sponge(this), this);
/* 258 */     this.pm.registerEvents(new Naruto(this), this);
/* 259 */     this.pm.registerEvents(new Critical(this), this);
/* 260 */     this.pm.registerEvents(new BlockCommands(this), this);
/* 261 */     this.pm.registerEvents(new Menu(this), this);
/* 262 */     this.pm.registerEvents(new NoBreakEvent(), this);
/* 263 */     this.pm.registerEvents(new Fisherman(this), this);
/* 264 */     this.pm.registerEvents(new Switcher(), this);
              this.pm.registerEvents(new Vampire(this), this);
/* 265 */     this.pm.registerEvents(new Viper(this), this);
/* 266 */     this.pm.registerEvents(new SoupSign(), this);
/* 267 */     this.pm.registerEvents(new Deshfire(), this);
/* 268 */     this.pm.registerEvents(new Thor(this), this);
/* 269 */     this.pm.registerEvents(new Ninja(this), this);
/* 270 */     this.pm.registerEvents(new JoinSign(this), this);
/* 271 */     this.pm.registerEvents(new LeaveSign(this), this);
/* 272 */     this.pm.registerEvents(new Kangaroo(this), this);
/* 273 */     this.pm.registerEvents(new AdminMode(this), this);
             
/* 274 */     this.pm.registerEvents(new TimeLord(this), this);
/* 275 */     this.pm.registerEvents(new Soup(this), this);
/* 276 */     this.pm.registerEvents(new NoDrops(this), this);
/* 277 */     this.pm.registerEvents(new NoHunger(), this);
/* 278 */     this.pm.registerEvents(new Gladiator(), this);
/* 279 */     this.pm.registerEvents(new Join(this), this);
/* 280 */     this.pm.registerEvents(new Shop(this), this);
/* 281 */     this.pm.registerEvents(new Stomper(this), this);
/* 282 */     this.pm.registerEvents(new Snail(this), this);
/* 283 */     this.pm.registerEvents(new X1(this), this);
/* 284 */     this.pm.registerEvents(new Streak(), this);
/* 285 */     this.pm.registerEvents(new NoExplosion(), this);
/* 286 */     this.pm.registerEvents(new AntiDeathDrop(this), this);
/* 287 */     this.pm.registerEvents(new WallClamber(this), this);
/* 288 */     this.pm.registerEvents(new SoupSign(), this);
/* 289 */     this.pm.registerEvents(new CommandsSounds(this), this);
/* 290 */     this.pm.registerEvents(new AirmanFly(this), this);
/* 291 */     this.pm.registerEvents(new NewKitMenu(this), this);
}
/*     */     
/* 293 *
/*     */   @EventHandler
/*     */   public void playerKill(EntityDeathEvent evt)
/*     */   {
/* 313 */     File f = new File("plugins/KP-PVP/Stats/stats.yml");
/* 314 */     YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
/* 315 */     if ((evt instanceof PlayerDeathEvent))
/*     */     {
/* 317 */       getLogger().info("Recognised player death");
/* 318 */       PlayerDeathEvent event = (PlayerDeathEvent)evt;
/* 319 */       Player dead = event.getEntity();
/* 320 */       Player killer = dead.getKiller();
/* 321 */       getLogger().info("Dead: " + dead.getDisplayName());
/* 322 */       if ((killer instanceof Player))
/*     */       {
/* 324 */         getLogger().info("Killer recognised as a player.");
/* 325 */         Player murderer = killer;
/* 326 */         getLogger().info("Killer: " + murderer.getName());
/*     */         
/* 328 */         int streak = yamlFile.getInt("players." + murderer.getName() + ".streak");
/*     */         
/* 330 */         int newStreak = streak + 1;
/* 331 */         yamlFile.set("players." + murderer.getName() + ".streak", Integer.valueOf(newStreak));
/*     */       }
/*     */       try
/*     */       {
/* 335 */         yamlFile.save(f);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 339 */         e.printStackTrace();
/*     */       }
/* 341 */       getLogger().info("Set and saved stats.");
/*     */     }
/*     */   }
/*     */   
/*     */   public static void Funcionou(Player p) {}
/*     */   
/*     */   public static void darEfeito(Player p, PotionEffectType tipo, int duracao, int level)
/*     */   {
/* 349 */     p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
/*     */   }
/*     */   
/*     */   public void save()
/*     */   {
/*     */     try
/*     */     {
/* 356 */       this.cf.save(this.cf1);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 360 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/* 364 */   public static FileConfiguration cfg_x1 = YamlConfiguration.loadConfiguration(file_x1);
public static FileConfiguration messages = YamlConfiguration.loadConfiguration(messagesf);
/* 365 */   public static FileConfiguration customization = YamlConfiguration.loadConfiguration(customizationf);
/*     */   private File cf1;
/*     */   FileConfiguration config;
/*     */   private PluginManager pm;
/*     */   
/*     */   public boolean IsOnKitPvP(String name)
/*     */   {
/* 372 */     return Join.game.contains(name);
/*     */   }
/*     */ 
public void onDisable()
{
  ConsoleCommandSender cmd = Bukkit.getConsoleSender();
  cmd.sendMessage(" ");
  cmd.sendMessage("    §7KP-PVP Version " + Main.getInstance().getDescription().getVersion() + " has been disabled");
  cmd.sendMessage("    §cAuthor: §EzEnderX5_ , Rafael Auler    ");
  cmd.sendMessage("    §cThank you for use the plugin §a=D    ");
  cmd.sendMessage(" ");
 
  }
}



/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
