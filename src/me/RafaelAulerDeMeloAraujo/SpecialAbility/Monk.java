/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Random;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.Listener;
/*    */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Monk
/*    */   implements Listener
/*    */ {
/*    */   public static Main plugin;
/*    */   
/*    */   public Monk(Main main)
/*    */   {
/* 30 */     plugin = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void monk(PlayerInteractEntityEvent e)
/*    */   {
/* 36 */     ItemStack item = e.getPlayer().getItemInHand();
/* 37 */     if ((Habilidade.getAbility(e.getPlayer()) == "Monk") && 
/* 38 */       ((e.getRightClicked() instanceof Player)) && 
/* 39 */       (item.getTypeId() == API.monkItemId)) {
/* 40 */       long lastUsed = 0L;
/* 41 */       if (API.monkStaff.containsKey(item)) {
/* 42 */         lastUsed = ((Long)API.monkStaff.get(item)).longValue();
/*    */       }
/*    */       
/* 45 */       if (lastUsed + 1000 * API.cooldownmonk > System.currentTimeMillis()) {
/* 46 */         e.getPlayer().sendMessage(String.format(API.monkCooldownMessage, 
/* 47 */           new Object[] { Long.valueOf(-((System.currentTimeMillis() - (lastUsed + 1000 * API.cooldownmonk)) / 1000L)) }));
/*    */       } else {
/* 49 */         PlayerInventory inv = ((Player)e.getRightClicked()).getInventory();
/* 50 */         int slot = new Random().nextInt(API.sendThroughInventory ? 36 : 9);
/* 51 */         ItemStack replaced = inv.getItemInHand();
/* 52 */         if (replaced == null)
/* 53 */           replaced = new ItemStack(0);
/* 54 */         ItemStack replacer = inv.getItem(slot);
/* 55 */         if (replacer == null)
/* 56 */           replacer = new ItemStack(0);
/* 57 */         inv.setItemInHand(replacer);
/* 58 */         inv.setItem(slot, replaced);
/* 59 */         API.monkStaff.put(item, Long.valueOf(System.currentTimeMillis()));
/* 60 */         e.getPlayer().sendMessage("§6You used your ability!");
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\Monk.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
