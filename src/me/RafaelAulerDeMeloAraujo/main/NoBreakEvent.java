/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.BlockBreakEvent;
/*    */ import org.bukkit.event.block.BlockPlaceEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoBreakEvent
/*    */   implements Listener
/*    */ {
/*    */   @EventHandler
/*    */   public void aoconstruir(BlockPlaceEvent e)
/*    */   {
/* 19 */     Player p = e.getPlayer();
/* 20 */     if ((Join.game.contains(p.getName())) && (!p.hasPermission("kitpvp.build")))
/*    */     {
/* 22 */       e.setCancelled(true);
/*    */     } else {
/* 24 */       e.setCancelled(false);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void aoconstruir2(BlockBreakEvent e) {
/* 30 */     Player p = e.getPlayer();
/* 31 */     if ((Join.game.contains(p.getName())) && (!p.hasPermission("kitpvp.build")))
/*    */     {
/* 33 */       e.setCancelled(true);
/*    */     } else {
/* 35 */       e.setCancelled(false);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\NoBreakEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
