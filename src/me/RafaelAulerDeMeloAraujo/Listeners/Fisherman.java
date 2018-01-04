/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.Effect;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerFishEvent;
/*    */ 
/*    */ public class Fisherman implements org.bukkit.event.Listener
/*    */ {
/*    */   private Main main;
/*    */   
/*    */   public Fisherman(Main main)
/*    */   {
/* 17 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerHitFishingrodscorpion(PlayerFishEvent event)
/*    */   {


/* 23 */     Player player = event.getPlayer();
/* 24 */     if ((event.getCaught() instanceof Player)) {
/* 25 */       Player caught = (Player)event.getCaught();
/* 26 */       if (player.getItemInHand().getType() == Material.FISHING_ROD &&  ((Habilidade.getAbility(player) == "Fisherman"))) {
/* 27 */         player.getWorld().playEffect(player.getLocation().add(0.0D, 1.5D, 0.0D), Effect.MOBSPAWNER_FLAMES, 1);
/* 28 */         caught.teleport(player.getLocation());
/* 29 */         caught.playSound(caught.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Fisherman")), 1.0F, 1.0F);
/* 30 */         player.playSound(player.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Fisherman")), 1.0F, 1.0F);
/*    */       }
/*    */     }
 


}
}


