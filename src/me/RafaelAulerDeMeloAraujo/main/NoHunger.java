/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ 
/*    */ public class NoHunger implements Listener
/*    */ {
	   private Main main;
/*    */   public NoHunger(Main main) {}
/*    */   
/*    */   @EventHandler
/*    */   public void onFall(FoodLevelChangeEvent e) {
/*    */   
	
/* 15 */     
/* 16 */     if ((Main.plugin.getConfig().getString("DisableHunger").equalsIgnoreCase("true")) && (Join.game.contains(e.getEntity()))) 
/* 17 */       e.setCancelled(true);
else
	 e.setCancelled(false);
/*    */     }
/*    */   }
/*    */ 


