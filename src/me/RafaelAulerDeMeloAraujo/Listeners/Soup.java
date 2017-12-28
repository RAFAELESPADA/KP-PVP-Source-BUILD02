/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;

/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */
/*    */ 
/*    */ public class Soup implements Listener
/*    */ {
/*    */   private Main main;
/* 18 */   public int vida = 6;
/* 19 */   public int fome = 6;
/*    */   
/*    */   public Soup(Main main) {
/* 22 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void UsarSopa(PlayerInteractEvent e) {
/* 27 */     if (e.getItem() == null) {
/* 28 */       return;
/*    */     }
/* 30 */     if (e.getItem().getType() == Material.MUSHROOM_SOUP) {
/* 31 */       e.setCancelled(true);
/* 32 */       Player p = e.getPlayer();
/* 33 */       if (p.getHealth() < 20.0D) {
/* 34 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Soup")), 1.0F, 1.0F);
/* 35 */         
/* 36 */         
/* 37 */         p.setHealth(p.getHealth() + this.vida >= 20.0D ? 20.0D : p.getHealth() + this.vida);
/* 38 */         e.getItem().setType(Material.BOWL);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


