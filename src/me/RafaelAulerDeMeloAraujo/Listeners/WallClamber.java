/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import me.RafaelAulerDeMeloAraujo.main.ParticleKitPvP;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.server.v1_10_R1.EnumParticle;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.util.Vector;
/*    */ 
/*    */ public class WallClamber implements org.bukkit.event.Listener
/*    */ {
/*    */   private Main main;
/*    */   Main plugin;
/* 23 */   List<Player> FlyCooldown = new ArrayList();
/* 24 */   List<Player> TogglePlayersCooldown = new ArrayList();
/*    */   
/*    */   public WallClamber(Main main) {
/* 27 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onWall(PlayerInteractEvent e)
/*    */   {
/* 33 */     Player p = e.getPlayer();
/* 34 */     Action a = e.getAction();
/* 35 */     if ((a.equals(Action.RIGHT_CLICK_BLOCK)) && (p.getItemInHand().getType() == Material.DIAMOND_SWORD) && (Habilidade.getAbility(p).equalsIgnoreCase("Spiderman"))) {
/* 36 */       Vector v2 = p.getLocation().getDirection().multiply(0.0D).setY(1.0D);
/* 37 */       Location loc = p.getLocation();
/* 38 */       ParticleKitPvP.sendParticle(EnumParticle.valueOf(this.main.getConfig().getString("Effect.Spiderman")), loc, 0.5F, 0.5F, 0.5F, 0.07F, 20);
/* 39 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Spiderman")), 500.0F, 500.0F);
/* 40 */       p.setVelocity(v2);
/*    */     }
/*    */   }
/*    */ }


