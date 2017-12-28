/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
/*    */ import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ 
/*    */ public class NoDrops implements org.bukkit.event.Listener
/*    */ {
	private Main main;
	
		/*     */   
/*    */   public NoDrops(Main main) {}
/*    */   
/*    */   @org.bukkit.event.EventHandler
/*    */   public void nodrop(PlayerDropItemEvent e)
/*    */   {
/* 16 */     if ((e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) || (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) ||  (e.getItemDrop().getItemStack().getType() == Material.IRON_FENCE) || (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) ||  (e.getItemDrop().getItemStack().getType() == Material.WATCH) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.BOW) || (e.getItemDrop().getItemStack().getType() == Material.SNOW_BALL) || (e.getItemDrop().getItemStack().getType() == Material.IRON_CHESTPLATE) || (e.getItemDrop().getItemStack().getType() == Material.IRON_HELMET) || (e.getItemDrop().getItemStack().getType() == Material.IRON_LEGGINGS) || (e.getItemDrop().getItemStack().getType() == Material.IRON_BOOTS) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_HELMET) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_CHESTPLATE) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_LEGGINGS) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_BOOTS) || (e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_HELMET)  || (e.getItemDrop().getItemStack().getType() == Material.MUSHROOM_SOUP) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.EMERALD) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_HELMET) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_CHESTPLATE) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_LEGGINGS) || (e.getItemDrop().getItemStack().getType() == Material.DIAMOND_BOOTS) || (e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_HELMET) || (e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_CHESTPLATE) || (e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_LEGGINGS) || (e.getItemDrop().getItemStack().getType() == Material.CHAINMAIL_BOOTS) || (e.getItemDrop().getItemStack().getType() == Material.LEATHER_CHESTPLATE) || (e.getItemDrop().getItemStack().getType() == Material.LEATHER_LEGGINGS) || (e.getItemDrop().getItemStack().getType() == Material.LEATHER_BOOTS) || (e.getItemDrop().getItemStack().getType() == Material.BLAZE_ROD) || (e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD) || (e.getItemDrop().getItemStack().getType() == Material.BOOK) || (e.getItemDrop().getItemStack().getType() == Material.LEATHER_HELMET)) {
/* 17 */       e.setCancelled(true);
/*    */  }  else {
/* 19 */       e.setCancelled(false);
e.getPlayer().playSound(e.getPlayer().getLocation(), org.bukkit.Sound.ENTITY_ITEM_PICKUP, 2.0F, 2.0F);
/*    */     }
}

/*    */   
/*    */ 
@EventHandler
public void onPlayerPickupItema(PlayerPickupItemEvent paramPlayerPickupItemEvent)
{
	if (paramPlayerPickupItemEvent.getItem().getItemStack().getType() == Material.BOWL)
	{
    paramPlayerPickupItemEvent.setCancelled(true); }
    else 
  	  paramPlayerPickupItemEvent.setCancelled(false);  
  }
}

