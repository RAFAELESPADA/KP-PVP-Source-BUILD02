/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.AirmanFly;
import me.RafaelAulerDeMeloAraujo.Listeners.ConfigUtils;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Fisherman;
import me.RafaelAulerDeMeloAraujo.Listeners.InteractEvent;
import me.RafaelAulerDeMeloAraujo.Listeners.JoinSign;
import me.RafaelAulerDeMeloAraujo.Listeners.LeaveSign;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.NoDrops;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Soup;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.Switcher;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.ThrowTnt;
/*     */ import me.RafaelAulerDeMeloAraujo.Listeners.WallClamber;
import me.RafaelAulerDeMeloAraujo.PluginHooks.PlaceHolderAPIHook;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Basic;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Critical;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.DesifireCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Dublejump;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.GladCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Kangaroo;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Monk;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.MonkCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Naruto;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.NewKitMenu;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Ninja;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Snail;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Sponge;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Stomper;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.StomperKITCOMMAND;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Thor;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.ThorKITCOMMAND;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimeLord;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.TimelordCMD;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Viper;
import me.RafaelAulerDeMeloAraujo.X1.SetX1;
import me.RafaelAulerDeMeloAraujo.X1.X1;
import me.RafaelAulerDeMeloAraujo.BStatsSystem.Metrics;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.Coins.Commands;
import me.RafaelAulerDeMeloAraujo.Listeners.SoupSign;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreBoarding;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.main.Stats;


/*     */ import java.io.File;
/*     */ import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/*     */ 
/*     */ import org.bukkit.Bukkit;
/*     */
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
/*     */ 
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ 
/*     */ import org.bukkit.configuration.file.YamlConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.Plugin;

/*     */ import org.bukkit.plugin.PluginManager;
/*     */ import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Main
/*     */   extends JavaPlugin
/*     */   implements Listener

/*     */ {
	 public static String pluginName = "KP-PVP";	
/*     */    {
}
public static Main getInstance() {
    return Main.instance;
} {
	
}
private Main pl;
public static Main getInstace() {
		return instance;
	}
/*  36 */   public static final String instance2 = null;
/*     */   public static Object instancs;
public static Logger log;




public static File customizationf = new File("plugins/KP-PVP", "settings.yml");;
public YamlConfiguration cf;
public static Plugin plugin;
public static Main instance;
private static ConfigUtils cH;
public static File file_x1 = new File("plugins/KP-PVP", "1v1.yml");
public static FileConfiguration cfg_x1;
public static FileConfiguration customization;

private File cf1;
public static Main getPlugin() {
    return Main.instance;
} {
  
}
FileConfiguration config;
/*     */   private PluginManager pm;
/*     */   
/*     */   

/*     */   
/*     */   public void onEnable() {
/*  45 */     getLogger().info("KP-PVP plugin is now enable [By zEnderX5_]");
              getLogger().info("Website: http://bit.ly/2kC345B");
              Metrics metrics = new Metrics(this);
              if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            	  getLogger().info("Hooking into PlaceHolderAPI");
              new PlaceHolderAPIHook(this).hook();
              getLogger().info("PlaceHolderAPI Hooked Sucefully");
              }

              
        		


                this.pm = Bukkit.getPluginManager();
                /*  48 */     registerEvents();
                /*  49 */     registerCommands();
                /*  50 */     


                
                instance = this;
                plugin = this;





                
                cH = new ConfigUtils();
               
                
                 
          		File cf = new File(getDataFolder(), "config.yml");
        		if (!cf.exists())
        			saveResource("config.yml", false);
        		cf1 = new File(getDataFolder(), "config.yml");
        		if (!file_x1.exists()) {
        			saveResource("1v1.yml", false);
        		}
        		if (!customizationf.exists()) {
        			saveResource("settings.yml", false);
        		}
        		try {
        			
        			cfg_x1.load(file_x1);
        			customization.load(customizationf);
        			
        		} catch (IOException | InvalidConfigurationException e1) {
        			System.out.println(e1.getMessage());
        		}
              }
          		
          		






      	    
      	    



public ConfigUtils getConfigHandler()
{
  return cH;
}
            
             
                  
                 
                  
 
/*     */   private void registerCommands() {
	 getCommand("kitreload").setExecutor(new Reload(this));
	    getCommand("coins").setExecutor(new Commands());
	    getCommand("kitcredits").setExecutor(new KitCredits());
	    getCommand("dev").setExecutor(new Dev());
	    getCommand("ksc").setExecutor(new BSC());
	    getCommand("kpstats").setExecutor(new Stats());
	    getCommand("kp").setExecutor(new KITPVP());
	    getCommand("adminmode").setExecutor(new AdminMode());
	   
	    getCommand("rektf58942kka").setExecutor(new AntiBugCommand());
	    getCommand("kpvp").setExecutor(new Kits(this));
	    getCommand("freezer").setExecutor(new Kits(this));
	    getCommand("basic").setExecutor(new Basic(this));
	    getCommand("airman").setExecutor(new Kits(this));
	    getCommand("fisherman").setExecutor(new Kits(this));
	    getCommand("archer").setExecutor(new Kits(this));
	    getCommand("tank").setExecutor(new Kits(this));
	    getCommand("pyro").setExecutor(new Kits(this));
	    getCommand("kthor").setExecutor(new ThorKITCOMMAND(this));
	    getCommand("switcher").setExecutor(new Kits(this));
	    getCommand("viper").setExecutor(new Viper(this));
	    getCommand("snail").setExecutor(new Snail(this));
	    getCommand("warper").setExecutor(new Kits(this));
	    getCommand("jumper").setExecutor(new Kits(this));
	    getCommand("wasp").setExecutor(new Kits(this));
	    getCommand("cactus").setExecutor(new Kits(this));
	    getCommand("bomber").setExecutor(new Kits(this));
	    getCommand("spiderman").setExecutor(new Kits(this));
	    getCommand("stats").setExecutor(new Stats());
	    getCommand("kpstats").setExecutor(new KPStats());
	    getCommand("kitmenu").setExecutor(new Menu(this));
	    getCommand("kitpvp").setExecutor(new KPStats());
	    getCommand("kpkits").setExecutor(new Menu(this));
	    getCommand("kpshop").setExecutor(new Shop(this));
	    getCommand("kploja").setExecutor(new Shop(this));
	    getCommand("shopmenu").setExecutor(new Shop(this));
	    getCommand("kpkitmenu").setExecutor(new NewKitMenu());
	    getCommand("kitsc").setExecutor(new StaffChat());
	    getCommand("kpkit").setExecutor(new Menu(this));
	    getCommand("kpsetspawn").setExecutor(new kpsetspawn());
	    getCommand("stomper").setExecutor(new StomperKITCOMMAND(this));
	    getCommand("gladiator").setExecutor(new GladCMD(this));
	    getCommand("deshfire").setExecutor(new DesifireCMD(this));
	    getCommand("ninja").setExecutor(new Ninja(this));
	    getCommand("togglescore").setExecutor(new Score());
	    getCommand("kangaroo").setExecutor(new Kangaroo(this));
	    getCommand("timelord").setExecutor(new TimelordCMD(this));
	    getCommand("doublejump").setExecutor(new Dublejump(this));
	    getCommand("kitclear").setExecutor(new Kits(this));
	    getCommand("critical").setExecutor(new Critical(this));
	    getCommand("kitpvp").setExecutor(new Join(this));
	    getCommand("naruto").setExecutor(new Naruto(this));
	    getCommand("monk").setExecutor(new MonkCMD(this));
	    getCommand("set1v1").setExecutor(new SetX1());
/*     */   }
/*     */   
/*     */   private void registerEvents() {
/*  87 */     this.pm.registerEvents(new ThrowTnt(this), this);
this.pm.registerEvents(new Dublejump(this), this);
              this.pm.registerEvents(new Monk(this), this);
              this.pm.registerEvents(new InteractEvent(), this);
              this.pm.registerEvents(new NewKitMenu(), this);
              this.pm.registerEvents(new Sponge(), this);
              this.pm.registerEvents(new Naruto(this), this);
              this.pm.registerEvents(new Critical(this), this);
/*  88 */     this.pm.registerEvents(new Menu(this), this);
              this.pm.registerEvents(new NoBreakEvent(), this);
/*  89 */     this.pm.registerEvents(new Fisherman(this), this);
/*  90 */     this.pm.registerEvents(new Switcher(), this);
              this.pm.registerEvents(new Viper(this), this);
              this.pm.registerEvents(new SoupSign(), this);
              this.pm.registerEvents(new Deshfire(), this);
              this.pm.registerEvents(new Thor(this), this);
              this.pm.registerEvents(new Ninja(this), this);
              this.pm.registerEvents(new JoinSign(this), this);
              this.pm.registerEvents(new LeaveSign(this), this);
              this.pm.registerEvents(new Kangaroo(this), this);
              this.pm.registerEvents(new AdminMode(), this);
              this.pm.registerEvents(new TimeLord(), this);
/*  91 */     this.pm.registerEvents(new Soup(this), this);
/*  92 */     this.pm.registerEvents(new NoDrops(this), this);
              this.pm.registerEvents(new NoHunger(), this);
              this.pm.registerEvents(new Gladiator(), this);
              this.pm.registerEvents(new Join(this), this);
              this.pm.registerEvents(new Shop(this), this);
              this.pm.registerEvents(new Stomper(), this);
              this.pm.registerEvents(new Snail(this), this);
              this.pm.registerEvents(new X1(), this);
              this.pm.registerEvents(new Streak(), this);
              this.pm.registerEvents(new me.RafaelAulerDeMeloAraujo.Listeners.NoExplosion(), this);
/*  93 */     this.pm.registerEvents(new AntiDeathDrop(this), this);
/*  94 */     this.pm.registerEvents(new WallClamber(this), this);
              this.pm.registerEvents(new SoupSign(), this);
              
/*  95 */     this.pm.registerEvents(new AirmanFly(this), this);
/*     */   
/*     */   new BukkitRunnable()
{
    public void run()
    {
     
      for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
      
      
      {
        Player p = arrayOfPlayer;
        if (!ScoreBoarding.score.contains(p.getName()) && Join.game.contains(p.getName()))  {
          ScoreBoarding.setScoreBoard(p);
        } else {
          ScoreBoarding.removeScoreBoard(p);
        }
      }
    }
  }.runTaskTimer(this, 0L, 20L);}

/*     */   

/*     */   
/*     */   @EventHandler
/*     */   public void playerKill(EntityDeathEvent evt) {
/* 169 */     
/* 170 */     File f = new File("plugins/KP-PVP/Stats/stats.yml");
/* 171 */     YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
/* 172 */     if ((evt instanceof PlayerDeathEvent)) {
/* 173 */       getLogger().info("Recognised player death");
/* 174 */       PlayerDeathEvent event = (PlayerDeathEvent)evt;
/* 175 */       Player dead = event.getEntity();
/* 176 */       Player killer = dead.getKiller();
/* 177 */       getLogger().info("Dead: " + dead.getDisplayName());
/* 178 */      
/* 180 */       
/* 182 */       if ((killer instanceof Player)) {
/* 183 */         getLogger().info("Killer recognised as a player.");
/* 184 */         Player murderer = killer;
/* 185 */         getLogger().info("Killer: " + murderer.getName());
/* 186 */         
/* 187 */         int streak = yamlFile.getInt("players." + murderer.getName() + ".streak");
/* 188 */        
/* 189 */         int newStreak = streak + 1;
/* 190 */         yamlFile.set("players." + murderer.getName() + ".streak", Integer.valueOf(newStreak));
/* 191 */        
/*     */       }
/*     */       try {
/* 194 */         yamlFile.save(f);
/*     */       }
/*     */       catch (IOException e) {
/* 197 */         e.printStackTrace();
/*     */       }
/* 199 */       getLogger().info("Set and saved stats.");
/*     */     }
/*     */   }


public static void Funcionou(Player p) {

}

public static void darEfeito(final Player p, final PotionEffectType tipo, final int duracao, final int level) {
    p.addPotionEffect(new PotionEffect(tipo, 20 * duracao, level));
}   
  
	


public void save() {
	try {
		
		this.cf.save(this.cf1);
		

				
		
} catch (IOException e) {
	e.printStackTrace();
}
}


 static {
	 cfg_x1 = YamlConfiguration.loadConfiguration(Main.file_x1);
	 customization = YamlConfiguration.loadConfiguration(Main.customizationf);
 }

public boolean IsOnKitPvP(String name) {
	return Join.game.contains(name);
}
}
 



	
	









