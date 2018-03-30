/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
/*    */ 
/*    */ import java.util.ArrayList;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
/*    */ import me.RafaelAulerDeMeloAraujo.X1.X1;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.block.Action;
/*    */ import org.bukkit.event.player.PlayerInteractEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class InteractEvent implements org.bukkit.event.Listener
/*    */ {
/*    */   public static ArrayList<String> aocaixa;
/*    */   private Main main;
/*    */   
/*    */   public InteractEvent(Main main)
/*    */   {
/* 21 */     this.main = main;
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onBauKit(PlayerInteractEvent e) {
/* 26 */     Player p = e.getPlayer();
/* 27 */     if ((p.getItemInHand().getType().equals(Material.EMERALD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lShop Menu"))) {
/* 28 */       e.setCancelled(true);
/* 29 */       if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
/* 30 */         p.openInventory(me.RafaelAulerDeMeloAraujo.main.Shop.shop);
/* 31 */         p.playSound(p.getLocation(), org.bukkit.Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 1.0F, 1.0F);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void onKit(PlayerInteractEvent e) {
/* 38 */     Player p = e.getPlayer();
/* 39 */     if ((p.getItemInHand().getType().equals(Material.BOOK)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aKit menu §7(Right click)"))) {
/* 40 */       e.setCancelled(true);
/* 41 */       if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
/* 42 */         org.bukkit.Bukkit.dispatchCommand(p, "kpkitmenu");
/*    */       }
/*    */     }
/*    */   }
/*    */   @EventHandler
/*    */   public void onStats(PlayerInteractEvent e) {
/* 38 */     Player p = e.getPlayer();
/* 39 */     if ((p.getItemInHand().getType().equals(Material.NAME_TAG)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§aYour Stats §7(Right click)"))) {
/* 40 */       e.setCancelled(true);
/* 41 */       if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
/* 42 */            p.sendMessage("§b");
/*    */         int kills = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
/* 24 */         int deaths = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
                 p.sendMessage("§4§l\u2605 §e§lYour Stats §a§l" + p.getName() + " §4§l\u2605");
                 p.sendMessage("");
/* 28 */         p.sendMessage("§bKills §8\u279C§e " + kills);
/* 29 */         p.sendMessage("§bDeaths §8\u279C§e " + deaths);
/*    */         
/* 31 */         p.sendMessage("§bCoins §8\u279C§e " + Coins.getCoins(p.getName()));
/* 32 */         p.sendMessage("§bStreak §8\u279C§e " + Streak.killstreak.get(p.getName()));
/* 33 */         p.sendMessage("§b");
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   @EventHandler
/*    */   public void v1(PlayerInteractEvent e) {
/* 49 */     Player p = e.getPlayer();
/* 50 */     if ((p.getItemInHand().getType().equals(Material.BLAZE_ROD)) && (p.getItemInHand().getItemMeta().hasDisplayName()) && (p.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("§eJOIN 1V1"))) {
/* 51 */       e.setCancelled(true);
/* 52 */       if ((e.getAction() == Action.RIGHT_CLICK_AIR) || (e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
/* 53 */         X1.entrar1v1(p);
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\Listeners\InteractEvent.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
