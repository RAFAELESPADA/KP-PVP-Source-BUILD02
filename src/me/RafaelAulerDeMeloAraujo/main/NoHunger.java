/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ 
/*    */ public class NoHunger implements Listener
/*    */ {
	  
/*    */   public NoHunger(Main main) {}
/*    */   
/*    */   @EventHandler
/*    */   public void onFall(FoodLevelChangeEvent e) {
/*    */   
	if (!(e.getEntity() instanceof Player)) {
        return;
    }
/* 15 */     
/* 16 */     if ((Join.game.contains(e.getEntity()))) 
/* 17 */       e.setCancelled(true);
{
if ((!Join.game.contains(e.getEntity())))
	 e.setCancelled(false);
/*    */     }
}
/*    */   
/*    */ @EventHandler
public void damage2(final EntityDamageByEntityEvent e) {
    if (!(e.getEntity() instanceof Player)) {
        return;
    }
        if (!(e.getDamager() instanceof Player)) {
            return;
    }
    final Player p = (Player)e.getEntity();
    final Player k = (Player)e.getDamager();
    if (Join.game.contains(p) && (Join.game.contains(k))) 
        p.setFoodLevel(20);
    else
    	return;
    }
{
}
}



