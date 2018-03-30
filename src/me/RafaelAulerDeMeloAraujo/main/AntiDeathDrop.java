/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.ConsoleCommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.player.PlayerRespawnEvent;
/*     */ import org.bukkit.plugin.Plugin;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AntiDeathDrop
/*     */   implements Listener
/*     */ {
/*     */   private Main main;
/*     */   
/*     */   public AntiDeathDrop(Main main)
/*     */   {
/*  31 */     this.main = main;
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void onDeath(PlayerRespawnEvent e)
/*     */   {
/*  38 */     if (((e.getPlayer() instanceof Player)) && ((e.getPlayer().getKiller() instanceof Player))) {
/*  39 */       Player p = e.getPlayer();
/*  40 */       Player k = p.getKiller();
/*     */       
/*     */  TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), this.main.getConfig().getString("Title.DeathTitle"), this.main.getConfig().getString("Title.DeathSubTitle").replaceAll("%player%", k.getName()));
/*  43 */       if ((this.main.getConfig().getString("RespawnSound").equalsIgnoreCase("true")) && (Join.game.contains(p.getName()))) {
/*  44 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Respawn")), 1.0F, 1.0F);

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
/*     */   @EventHandler
/*     */   public void onDeath(PlayerDeathEvent e)
/*     */   {
/*  62 */     e.setDeathMessage("");
/*  63 */     if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
/*  64 */       Player p = e.getEntity();
/*  65 */       Player k = p.getKiller();
/*  66 */       if (Join.game.contains(p.getName())) {
/*  67 */         Join.game.contains(k.getName());
/*     */         
/*  69 */         e.getDrops().clear();
/*  70 */         e.setDeathMessage("");
/*  71 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Death.Tell").replace("&", "§").replaceAll("%player%", k.getName()));
/*  72 */         k.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Kill.Tell").replace("&", "§").replaceAll("%player%", p.getName()));
/*  73 */         Coins.addCoins(k.getName(), Main.customization.getDouble("Earned-Coins-Per-Kill"));
/*  74 */         Coins.removeCoins(p.getName(), Main.customization.getDouble("Lost-Coins-Per-Death"));
/*  75 */         Coins.saveCoins();
/*  76 */         Coins.loadCoins();
/*  77 */        
/*  78 */         int mortes = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*  83 */         Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".mortes", Integer.valueOf(mortes + 1));
/*     */         
/*     */ 
/*     */ 
/*  87 */         int kills = Main.plugin.getConfig().getInt("status." + k.getName().toLowerCase() + ".kills");
/*     */         
/*     */ 
/*  90 */         Main.plugin.getConfig().set("status." + k.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
/*  91 */         Main.plugin.saveConfig();
/*  92 */         Bukkit.getConsoleSender().sendMessage("§e" + p.getName() + " has been killed by " + k.getName() + " on kitpvp");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       }
/* 100 */       else if (((this.main.getConfig().getString("CustomKillAndDeathMessage").equalsIgnoreCase("true")) && (Join.game.contains(p.getName()))) || (Join.game.contains(k.getName()))) {
/* 101 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Death").replace("&", "§").replaceAll("%player%", k.getName()));
/* 102 */         k.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kill").replace("&", "§").replaceAll("%player%", p.getName()));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int GetKills(Player p)
/*     */   {
/* 112 */     return Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
/*     */   }
/*     */   
/* 115 */   public static int GetDeaths(Player p) { return Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"); }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\AntiDeathDrop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
