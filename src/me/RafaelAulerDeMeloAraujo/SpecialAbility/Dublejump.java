package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import me.RafaelAulerDeMeloAraujo.main.Main;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class Dublejump
  implements Listener, CommandExecutor
  {
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Dublejump(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }
{
	
}
  @EventHandler
  public void onPlayerToggleFly(PlayerToggleFlightEvent e)
  {
    Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump"))
    {
      if (p.getGameMode() == GameMode.CREATIVE) {
        return;
      }
      e.setCancelled(true);
      p.setFlying(false);
      p.setAllowFlight(false);
      Location loc = p.getLocation();
      if (!p.isSneaking())
      {
        p.setFallDistance(-3.0F);
        Vector vector = p.getEyeLocation().getDirection();
        vector.multiply(0.6F);
        vector.setY(1.0F);
        p.setVelocity(vector);
      }
      else
      {
        p.setFallDistance(-3.0F);
        Vector vector = p.getEyeLocation().getDirection();
        vector.multiply(1.35F);
        vector.setY(0.66D);
        p.setVelocity(vector);
      }
      loc.getWorld().playSound(loc, Sound.ENTITY_FIREWORK_BLAST, 1.0F, 0.2F);
      p.getWorld().playEffect(p.getLocation(), Effect.COLOURED_DUST, 80);
    }
  }
  
  @EventHandler
  public void onDamage(EntityDamageEvent event)
  {
    Entity e = event.getEntity();
    if ((e instanceof Player))
    {
      Player player = (Player)e;
      if ((Habilidade.getAbility(player).equalsIgnoreCase("DoubleJump")) && ((event.getEntity() instanceof Player)) && (event.getCause() == EntityDamageEvent.DamageCause.FALL)) {
        event.setDamage(2.0D);
      }
    }
  }
  
  @EventHandler
  public void onPlayerMove(PlayerMoveEvent e)
  {
    Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump"))
    {
      if (p.getGameMode() == GameMode.CREATIVE) {
        return;
      }
      if ((p.isOnGround()) && (!p.getAllowFlight())) {
        p.setAllowFlight(true);
      }
    }
  }
  
  @EventHandler
  public void aomorrer(PlayerDeathEvent e)
  {
    Player p = e.getEntity();
    if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump")) {
      p.setAllowFlight(false);
    }
  }
  
  @EventHandler
  public void aomorrer(PlayerQuitEvent e)
  {
    Player p = e.getPlayer();
    if (Habilidade.getAbility(p).equalsIgnoreCase("DoubleJump")) {
      p.setAllowFlight(false);
    }
  }


    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
   	 /*     */   

    Player p = (Player)sender;

    if (cmd.getName().equalsIgnoreCase("doublejump"))
    {
    	  if (!Join.game.contains(p.getName()))
          {
              p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
              return true;
          }
    	 if (!p.hasPermission("kitpvp.kit.doublejump"))
 	    {
 	    	p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
 	      return true;
 	    }
    
    
           if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
             p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
            return true;
          }
           p.getInventory().clear();
           ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
           ItemMeta souperaa = dima.getItemMeta();
           souperaa.setDisplayName("§cSword");
           dima.setItemMeta(souperaa);
           ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
           ItemMeta sopas = sopa.getItemMeta();
           sopas.setDisplayName("§6Soup");
           sopa.setItemMeta(sopas);

           
           ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
           
           ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
           
           ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
           
           ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
           
           p.getInventory().setHelmet(capacete0);
           p.getInventory().setChestplate(peitoral0);
           p.getInventory().setLeggings(calca0);
           p.getInventory().setBoots(Bota0);
           Habilidade.setAbility(p, "DoubleJump");
      p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "DoubleJump").replace("&", "§"));
     
      p.getInventory().addItem(new ItemStack[] { dima });
     
      
      
      
      for (int i = 0; i <= 34; i++) {
        p.getInventory().addItem(new ItemStack[] { sopa });
        
      }
      
    }
    if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
   	  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "DoubleJump").replace("&", "§"));
   	  /*     */       }
   	  /*  96 */       return false; }{
    
   }
   }
