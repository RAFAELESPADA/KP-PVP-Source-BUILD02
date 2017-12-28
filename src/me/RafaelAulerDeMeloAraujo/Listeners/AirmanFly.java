package me.RafaelAulerDeMeloAraujo.Listeners;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class AirmanFly implements org.bukkit.event.Listener
/*    */ {
/*    */   Main plugin;
/* 21 */   List<Player> FlyCooldown = new ArrayList();
/* 22 */   List<Player> TogglePlayersCooldown = new ArrayList();
/*    */   
/*    */   public AirmanFly(Main instance) {
/* 25 */     this.plugin = instance;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onWall2(PlayerInteractEvent e)
/*    */   {
/* 31 */     final Player p = e.getPlayer();
/* 32 */     Action a = e.getAction();
/* 33 */     if (((a.equals(Action.RIGHT_CLICK_AIR)) || (a.equals(Action.RIGHT_CLICK_BLOCK))) && (p.getItemInHand().getType() == Material.FEATHER) && (!this.FlyCooldown.contains(p) && 
		 ((Habilidade.getAbility(p) == "Airman")))) {
/* 34 */       this.FlyCooldown.add(p);
/* 35 */       Vector v2 = p.getLocation().getDirection().multiply(2.0D).setY(1.0D);
/* 36 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 37 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 38 */       p.playSound(p.getLocation(), org.bukkit.Sound.ENTITY_ENDERDRAGON_FLAP, 500.0F, 500.0F);
/* 39 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 1.5D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 40 */       p.setVelocity(v2);
/* 41 */       org.bukkit.Bukkit.getScheduler().scheduleAsyncDelayedTask(this.plugin, new Runnable()
/*    */       {
/*    */         public void run()
/*    */         {
/* 45 */           AirmanFly.this.FlyCooldown.remove(p);
/*    */         }
/* 47 */       }, 60L);
/*    */     }
/*    */   }
/*    */ }


