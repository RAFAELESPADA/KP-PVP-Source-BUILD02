/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Effect;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.block.BlockFace;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.EventPriority;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.entity.EntityDamageEvent;
/*    */ import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
/*    */ import org.bukkit.event.entity.PlayerDeathEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.event.player.PlayerQuitEvent;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class Sponge
/*    */   implements Listener
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public Sponge(Main main)
/*    */   {
/* 31 */     this.main = main;
/* 32 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 37 */   public static ArrayList<String> naotomardanoqueda = new ArrayList<String>();
/*    */   
/*    */   @EventHandler(priority=EventPriority.MONITOR)
/*    */   public void aoBlocoJump(PlayerMoveEvent e)
/*    */   {
/* 42 */     Player p = e.getPlayer();
/* 43 */     if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE) && (Join.game.contains(p.getName())))
/*    */     {
/* 45 */       Location loc = e.getTo().getBlock().getLocation();
/* 46 */       Vector v = p.getVelocity().setY(4).multiply(2);
/* 47 */       p.setVelocity(v);
/* 48 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SpongeUse")), 1.0F, 1.0F);
/*    */       
/* 50 */       p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, null);
/* 51 */       naotomardanoqueda.add(p.getName());
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */   @EventHandler
/*    */   public void onFall(EntityDamageEvent e)
/*    */   {
/* 59 */     if ((e.getEntity() instanceof Player))
/*    */     {
/* 61 */       Player p = (Player)e.getEntity();
/* 62 */       if ((e.getCause().equals(EntityDamageEvent.DamageCause.FALL)) && (naotomardanoqueda.contains(p.getName())))
/*    */       {
/*    */ 
/* 65 */         e.setCancelled(true);
/* 66 */         naotomardanoqueda.remove(p.getName());
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   @EventHandler
/*    */   public void aoMorrer(PlayerDeathEvent e)
/*    */   {
/* 76 */     Player p = e.getEntity();
/* 77 */     if (naotomardanoqueda.contains(p.getName())) {
/* 78 */       naotomardanoqueda.remove(p.getName());
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void aoSair(PlayerQuitEvent e) {
/* 84 */     Player p = e.getPlayer();
/* 85 */     if (naotomardanoqueda.contains(p.getName())) {
/* 86 */       naotomardanoqueda.remove(p.getName());
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler(priority=EventPriority.MONITOR)
/*    */   public void aoBlocoJumpPraFrente(PlayerMoveEvent e) {
/* 92 */     Player p = e.getPlayer();
/* 93 */     if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL) {
/* 94 */       Location loc = e.getTo().getBlock().getLocation();
/* 95 */       Vector v = p.getLocation().getDirection().multiply(4).setY(1);
/* 96 */       p.setVelocity(v);
/* 97 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SpongeUse")), 6.0F, 1.0F);
/* 98 */       p.playEffect(loc, Effect.MAGIC_CRIT, null);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Sponge.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
