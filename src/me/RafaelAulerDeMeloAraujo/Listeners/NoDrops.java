/*    */ package me.RafaelAulerDeMeloAraujo.Listeners;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*    */ 
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Material;
import org.bukkit.Sound;
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
/*    */   
@EventHandler
public void onPlayerDropItem(PlayerDropItemEvent paramPlayerPickupItemEvent)
{
	if (!Join.game.contains(paramPlayerPickupItemEvent.getPlayer().getName()))
		return;
	{
	if (Join.game.contains(paramPlayerPickupItemEvent.getPlayer().getName()))
	{
	if (paramPlayerPickupItemEvent.getItemDrop().getItemStack().getType() == Material.BOWL)
	{
    paramPlayerPickupItemEvent.setCancelled(false);
    paramPlayerPickupItemEvent.getPlayer().playSound(paramPlayerPickupItemEvent.getPlayer().getLocation(),Sound.ENTITY_ITEM_PICKUP, 10.0F, 30.0F);}
    else 
  	  paramPlayerPickupItemEvent.setCancelled(true);  
  }
	}
}
/*    */   
/*    */ 
@EventHandler
public void onPlayerPickupItem(PlayerPickupItemEvent paramPlayerPickupItemEvent)
{
	if (!Join.game.contains(paramPlayerPickupItemEvent.getPlayer().getName()))
		return;
	{
	if (Join.game.contains(paramPlayerPickupItemEvent.getPlayer().getName()))
	{
	if (paramPlayerPickupItemEvent.getItem().getItemStack().getType() == Material.BOWL || paramPlayerPickupItemEvent.getItem().getItemStack().getType() == Material.MUSHROOM_SOUP)
	{
    paramPlayerPickupItemEvent.setCancelled(false); }
    else 
  	  paramPlayerPickupItemEvent.setCancelled(true);  
  }
	}
}
}

