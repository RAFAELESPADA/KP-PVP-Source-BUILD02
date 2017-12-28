/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.entity.TNTPrimed;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class ThrowTnt implements Listener
/*    */ {
/*    */   public ThrowTnt(Main main) {}
/*    */   
/*    */   @EventHandler
/*    */   public void onPlayerInteract(PlayerInteractEvent event)
/*    */   {
/* 25 */     Player player = event.getPlayer();
/* 26 */     Player p = event.getPlayer();
/* 27 */     Action a = event.getAction();
/* 28 */     World world = player.getWorld();
/* 29 */     double speedFactor = 1.5D;
/* 30 */     Location handLocation = player.getLocation();
/* 31 */     handLocation.setY(handLocation.getY() + 1.0D);
/* 32 */     Vector direction = handLocation.getDirection();
/* 33 */     Entity entity = null;
/* 34 */     if (((a.equals(Action.RIGHT_CLICK_AIR)) || (a.equals(Action.RIGHT_CLICK_BLOCK))) && (p.getItemInHand().getType() == Material.TNT)) {
/* 35 */       entity = world.spawn(handLocation, TNTPrimed.class);
/* 36 */       entity.setVelocity(direction.multiply(speedFactor));
/* 37 */       player.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.TNT, 1) });
/*    */     }
/*    */   }
/*    */ }

