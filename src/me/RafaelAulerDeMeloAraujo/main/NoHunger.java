/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.entity.FoodLevelChangeEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

/*    */ 
/*    */ public class NoHunger implements Listener
/*    */ {
	  
/*    */   
/*    */   
/*    */   @EventHandler
/*    */   public void onFall(FoodLevelChangeEvent e) {
/*    */   
	if (!(e.getEntity() instanceof Player)) {
        return;
    }
	Player p = (Player) e.getEntity();
/* 15 */     
/* 16 */     if ((Join.game.contains(p.getName()) && (Main.getInstace().getConfig().getString("DisableHungerOnKitPvP").equalsIgnoreCase("true")))) 
/* 17 */       e.setCancelled(true);


if ((!Join.game.contains(p.getName())))
	 e.setCancelled(false);
/*    */     
}



/*    */   

{
}
}




