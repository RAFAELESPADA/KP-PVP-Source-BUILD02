/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
/*    */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
/*    */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class AirmanFly implements Listener
/*    */ {
/*    */   Main plugin;
/* 27 */   List<Player> FlyCooldown = new ArrayList();
/* 28 */   List<Player> TogglePlayersCooldown = new ArrayList();
/*    */   private Main main;
/*    */   
/* 31 */   public AirmanFly(Main main) { this.main = main; }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void onWall2(PlayerInteractEvent e)
/*    */   {
/* 37 */     final Player p = e.getPlayer();
/* 38 */     Action a = e.getAction();
/* 39 */     if (((a.equals(Action.RIGHT_CLICK_AIR)) || (a.equals(Action.RIGHT_CLICK_BLOCK))) && (p.getItemInHand().getType() == Material.FEATHER) && (!this.FlyCooldown.contains(p)) && 
/* 40 */       (Habilidade.getAbility(p) == "Airman")) {
/* 41 */       if (Cooldown.add(p)) {
/* 42 */         API.MensagemCooldown(p);
/* 43 */         return;
/*    */       }
/* 45 */       Cooldown.add(p, 3);
/* 46 */       Vector v2 = p.getLocation().getDirection().multiply(2.0D).setY(1.0D);
/* 47 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 0.0D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 48 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 0.5D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 49 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Airman-Fly")), 500.0F, 500.0F);
/* 50 */       p.getWorld().playEffect(p.getLocation().add(0.0D, 1.5D, 0.0D), Effect.FIREWORKS_SPARK, 1);
/* 51 */       p.setVelocity(v2);
/* 52 */       org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*    */       {
/*    */         public void run() {
/* 55 */           p.sendMessage(API.fimcooldown(p));
/*    */         }
/* 57 */       }, 60L);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\Listeners\AirmanFly.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
