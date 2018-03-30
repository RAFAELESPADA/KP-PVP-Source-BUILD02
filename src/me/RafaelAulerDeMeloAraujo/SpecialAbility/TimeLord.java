/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.event.player.PlayerMoveEvent;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.scheduler.BukkitScheduler;
/*    */ 
/*    */ public class TimeLord implements org.bukkit.event.Listener
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public TimeLord(Main main)
/*    */   {
/* 22 */     this.main = main;
/* 23 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/* 28 */   public static ArrayList<String> playercongelados = new ArrayList();
/*    */   
/*    */   @EventHandler
/*    */   public void onTimerLord(PlayerInteractEvent e)
/*    */   {
/* 33 */     final Player p = e.getPlayer();
/* 34 */     if ((Habilidade.getAbility(p).equalsIgnoreCase("TimeLord")) && ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) && (p.getInventory().getItemInHand().getType() == org.bukkit.Material.WATCH)) {
/* 35 */       if (Cooldown.add(p)) {
/* 36 */         API.MensagemCooldown(p);
/* 37 */         return;
/*    */       }
/* 39 */       Cooldown.add(p, 15);
/* 40 */       p.sendMessage(String.valueOf(API.NomeServer) + "§f§lYou freeze the players around you!");
/* 41 */       for (final Entity pertos : p.getNearbyEntities(5.0D, 5.0D, 5.0D)) {
/* 42 */         playercongelados.add(((Player)pertos).getName());
/* 43 */         ((Player)pertos).sendMessage(String.valueOf(API.NomeServer) + "§aYou have been frozen by a TimeLord");
/* 44 */         ((Player)pertos).playSound(pertos.getLocation(), this.main.getConfig().getString("Sound.Timelord"), 1.0F, 1.0F);
/* 45 */         org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*    */         {
/*    */           public void run() {
/* 48 */             TimeLord.playercongelados.remove(((Player)pertos).getName());
/* 49 */             ((Player)pertos).sendMessage(String.valueOf(API.NomeServer) + "§aYou are unfrozen");
/*    */           }
/* 51 */         }, 160L);
/*    */       }
/* 53 */       org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable()
/*    */       {
/*    */         public void run() {
/* 56 */           p.sendMessage(API.fimcooldown(p));
/*    */         }
/* 58 */       }, 400L);
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onTimerLordado(PlayerMoveEvent e) {
/* 64 */     Player p = e.getPlayer();
/* 65 */     if (playercongelados.contains(p.getName())) {
/* 66 */       e.setTo(p.getLocation());
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void TirarTimelord(EntityDamageByEntityEvent e) {
/* 72 */     if (!(e.getEntity() instanceof Player)) {
/* 73 */       return;
/*    */     }
/* 75 */     if (!(e.getDamager() instanceof Player)) {
/* 76 */       return;
/*    */     }
/* 78 */     Player p = (Player)e.getEntity();
/* 79 */     Player s = (Player)e.getDamager();
/* 80 */     if ((Habilidade.getAbility(s).equalsIgnoreCase("TimeLord")) && (s.getInventory().getItemInHand() != null)) {
/* 81 */       playercongelados.remove(p.getName());
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\TimeLord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
