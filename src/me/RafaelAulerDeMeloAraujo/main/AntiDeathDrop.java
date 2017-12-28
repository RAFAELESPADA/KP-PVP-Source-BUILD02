/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.server.v1_10_R1.EnumParticle;
/*    */ import org.bukkit.Bukkit;
import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Sound;
import org.bukkit.World;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerRespawnEvent;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

/*    */ 
/*    */ public class AntiDeathDrop
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public AntiDeathDrop(Main main)
/*    */   {
/* 22 */     this.main = main;
/*    */   }

/*    */   
/*    */   @EventHandler
/*    */   public void onDeath(PlayerRespawnEvent e)
/*    */   {
/* 28 */     if (((e.getPlayer() instanceof Player)) && ((e.getPlayer().getKiller() instanceof Player))) {
/* 29 */       Player p = e.getPlayer();
/* 30 */       Player k = p.getKiller();
/* 31 */       if (this.main.getConfig().getString("CustomDeathTitleMessage").equalsIgnoreCase("true") && (Join.game.contains(p.getName()))) {
/* 32 */         p.sendTitle(this.main.getConfig().getString("Title.DeathTitle").replace("&", "§").replaceAll("%player%", k.getName()), this.main.getConfig().getString("Title.DeathSubTitle").replace("&", "§").replaceAll("%player%", k.getName()));
/* 33 */         if (this.main.getConfig().getString("RespawnParticle").equalsIgnoreCase("true")) {
/* 34 */           Location loc = p.getLocation();
/* 35 */           ParticleKitPvP.sendParticle(EnumParticle.valueOf(this.main.getConfig().getString("Effect.Respawn")), loc, 0.5F, 0.5F, 0.5F, 0.07F, 20);
/*    */         }
/* 37 */         if (this.main.getConfig().getString("RespawnSound").equalsIgnoreCase("true") && (Join.game.contains(p.getName()))) {
/* 38 */           p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Respawn")), 1.0F, 1.0F);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */   


	
	 
/*    */     


/*    */   
/*    */   
/*    */   @EventHandler
/*    */   public void onDeath(PlayerDeathEvent e) {
	
/* 53 */     e.setDeathMessage("");
/* 54 */     if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player))) {
/* 55 */       Player p = e.getEntity();
/* 56 */       Player k = p.getKiller();
if (Join.game.contains(p.getName())) {
	if (Join.game.contains(k.getName())) {
}
/* 57 */       e.getDrops().clear();
/* 58 */       e.setDeathMessage("");
p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Death.Tell").replace("&", "§").replaceAll("%player%", k.getName()));
/* 64 */           k.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Kill.Tell").replace("&", "§").replaceAll("%player%", p.getName()));
               Coins.addCoins(k.getName(), Main.customization.getDouble("Earned-Coins-Per-Kill"));
               Coins.removeCoins(p.getName(), Main.customization.getDouble("Lost-Coins-Per-Death"));
               Coins.saveCoins();
               Coins.loadCoins();

               
               Bukkit.getConsoleSender().sendMessage("§e" + p.getName() + " has been killed by " + k.getName() + " on kitpvp");
}
               else {
/* 59 */       if (this.main.getConfig().getString("CustomKillAndDeathMessage").equalsIgnoreCase("true")&& (Join.game.contains(p.getName())) || (Join.game.contains(k.getName())))  { {
/* 60 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Death").replace("&", "§").replaceAll("%player%", k.getName()));
/* 61 */         k.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kill").replace("&", "§").replaceAll("%player%", p.getName()));
/* 62 */        
/* 63 */           
/* 65 */           
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */   }
{
}

/*    */ 


}
