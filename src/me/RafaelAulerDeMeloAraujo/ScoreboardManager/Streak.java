/*     */ package me.RafaelAulerDeMeloAraujo.ScoreboardManager;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
import net.md_5.bungee.api.chat.BaseComponent;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Sound;
import org.bukkit.World;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Streak
/*     */   implements Listener
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Streak()
/*     */   {
/*  31 */     this.main = this.main;
/*  32 */     plugin = this.main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*  40 */   public static Map<String, Integer> killstreak = new HashMap();
/*     */   
/*     */   public void onEnable() {}
/*     */   
/*     */   @EventHandler
/*  45 */   public void playerdeath(PlayerDeathEvent ev) { Player p = ev.getEntity();
/*  46 */     if ((p.getKiller() instanceof Player))
/*     */     {
/*     */ 
/*  49 */       Player killer = p.getKiller();
/*  50 */       if (Join.game.contains(killer))
/*     */       {
/*  52 */         p.sendMessage(API.NomeServer + "" + ChatColor.RED + "Your killstreak has been destroyed by " + ChatColor.YELLOW + killer.getName()); }
/*  53 */       addtokillstreak(killer);
/*  54 */       killstreak.put(p.getName(), Integer.valueOf(0));
/*     */     }
/*     */   }
/*     
*/  

/*     */ 
/*     */   public void addtokillstreak(Player killer)
/*     */   {
/*  61 */     String name = killer.getName();
/*  62 */     if (killstreak.containsKey(name))
/*     */     {
/*  64 */       int kills = ((Integer)killstreak.get(name)).intValue();
/*  65 */       kills++;
/*  66 */       killstreak.put(name, Integer.valueOf(kills));
/*     */       
/*  68 */       killer.sendMessage(API.NomeServer + "" + ChatColor.GREEN + "You are on " + ChatColor.RED + Integer.toString(kills) + ChatColor.GREEN + " Killstreak.");
/*  69 */       if (kills == 100)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 100 killstreak!", killer.getWorld());
/*  73 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-100") + " Coins!");
/*  74 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-100"));
/*     */       }
/*  76 */       if (kills == 90)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 90 killstreak!", killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-90") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-90"));
/*     */       }
/*  76 */       if (kills == 80)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 80 killstreak!", killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-80") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-80"));
/*     */       }
if (kills == 70)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 70 killstreak!", killer.getWorld());
/*  80 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-70") + " Coins!");
/*  81 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-70"));
/*     */       }
/*  83 */       if (kills == 65)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 65 killstreak!", killer.getWorld());
/*  87 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-65") + " Coins!");
/*  88 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-65"));
/*     */       }
/*  83 */       if (kills == 60)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 60 killstreak!", killer.getWorld());
/*  87 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-60") + " Coins!");
/*  88 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-60"));
/*     */       }
/*  90 */       if (kills == 50)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 50 killstreak!", killer.getWorld());
/*  94 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-50") + " Coins!");
/*  95 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-50"));
/*     */       }
if (kills == 40)
/*     */       {
/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
/*  93 */           ChatColor.DARK_RED + " is on a 40 killstreak!", killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-40"));
/*     */       }
/*  97 */       if (kills == 30)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 30 killstreak!", killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-30") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
/*     */       }
/*  97 */       if (kills == 25)
/*     */       {
	
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 25 killstreak!", killer.getWorld());
/* 101 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-25") + " Coins!");
/* 102 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-25"));
/*     */       }
/* 104 */       if (kills == 20)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 20 killstreak!", killer.getWorld());
/* 108 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-20") + " Coins!");
/* 109 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-20"));
/*     */       }
/* 104 */       if (kills == 15)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 15 killstreak!", killer.getWorld());
/* 108 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-15") + " Coins!");
/* 109 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-15"));
/*     */       }
/* 111 */       if (kills == 10)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 10 killstreak!", killer.getWorld());
/* 115 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-10") + " Coins!");
/* 116 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-10"));
/*     */       }
/* 118 */       if (kills == 5)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 5 killstreak!", killer.getWorld());
/* 122 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-5") + " Coins!");
/* 123 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-5"));
/*     */       }
/* 118 */       if (kills == 3)
/*     */       {
	/*  99 */         broadcast(API.NomeServer + "" + ChatColor.GREEN + killer.getName() + 
			/*  93 */           ChatColor.DARK_RED + " is on a 3 killstreak!" , killer.getWorld());
/* 122 */         killer.sendMessage(API.NomeServer + "" + ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-3") + " Coins!");
/* 123 */         Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-3"));
/*     */       }
/*     */       
/* 126 */       if ((kills == 1) && (Join.game.contains(killer)))
/*     */       {
/* 128 */         killstreak.put(name, Integer.valueOf(1));
/* 129 */         killer.playSound(killer.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Streak")), 3.0F, 1.0F);
/* 130 */         killer.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " You're on a " + ChatColor.RED + "1" + ChatColor.WHITE + " Killstreak.");
/*     */       }
/*     */     }
/*     */   }
/*     */ 

  public void broadcast(String text, World w){
    for(Player p: w.getPlayers()){
        p.sendMessage(text);
        p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Streak")), 3.0F, 1.0F);
    }
  }}
/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\ScoreboardManager\Streak.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
