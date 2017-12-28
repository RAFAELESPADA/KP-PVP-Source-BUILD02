package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.RafaelAulerDeMeloAraujo.main.Main;

	

	
public class Kangaroo  implements Listener, CommandExecutor {
private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Kangaroo(Main main) {
/*  27 */     this.main = main;
/*  28 */     plugin = main;

/*     */   }
{}
	
	 
@SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<String> tempo = new ArrayList();
  @SuppressWarnings({ "unchecked", "rawtypes" })
ArrayList<String> naofugir = new ArrayList();
	   @EventHandler
	   public void pular(PlayerInteractEvent event)
	   {
		  
	     Player p = event.getPlayer();
	     if ((p.getItemInHand().getType() == Material.FIREWORK) && 
	    		 ((Habilidade.getAbility(p) == "Kangaroo")))
	     {
	       event.setCancelled(true);
	       if (Gladiator.lutando.containsKey(p.getName())) {
               p.sendMessage(String.valueOf("§cYou enter in a gladiator arena! You win a Speed Effect"));
               
               Main.darEfeito(p, PotionEffectType.SPEED, 10, 2);
               
           }
	        else {
               event.setCancelled(true);
	       Vector vector = p.getEyeLocation().getDirection();
	       if (!this.naofugir.contains(p.getName()))
	       {
	         if (!this.tempo.contains(p.getName()))
	         {
	           this.tempo.add(p.getName());
	           if (!p.isSneaking())
	           {
	             p.setFallDistance(-1.0F);
	             vector.multiply(0.5F);
	             vector.setY(1.0D);
	             p.setVelocity(vector);
	           }
	           else
	           {
	             p.setFallDistance(-1.0F);
	             vector.multiply(1.5F);
	             vector.setY(0.5D);
	             p.setVelocity(vector);
	           }
	         }
	       }
	       else if (!this.tempo.contains(p.getName()))
	       {
	         this.tempo.add(p.getName());
	         p.setFallDistance(0.0F);
	         vector.multiply(0.0F);
	         vector.setY(0.0D);
	         p.setVelocity(vector);
	       }
	      
	       if (this.naofugir.contains(p.getName())) {
	         p.sendMessage("§cYou cannot use this kit while in PvP!");
	       }
	     }
	     }
	   }
	   
	   @EventHandler
	   public void onDamageds(EntityDamageEvent event)
	   {
	     Entity e = event.getEntity();
	     if ((e instanceof Player))
	     {
	       Player player = (Player)e;
	       if (((event.getEntity() instanceof Player)) && 
	         (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	         (player.getInventory().contains(Material.FIREWORK)) && 
	         (event.getDamage() >= 7.0D)) {
	         event.setDamage(7.0D);
	       }
	     }
	   }
	   
	   @EventHandler
	   public void removertempo(PlayerMoveEvent event)
	   {
	     Player p = event.getPlayer();
	     if (this.tempo.contains(p.getName()))
	     {
	       Block b = p.getLocation().getBlock();
	       if ((b.getType() != Material.AIR) || (b.getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
	         this.tempo.remove(p.getName());
	       }
	     }
	   }
	   
	   @EventHandler
	   public void adicionartempo(EntityDamageByEntityEvent event)
	   {
	     if (!(event.getEntity() instanceof Player)) {
	       return;
	     }
	     final Player kangaroo = (Player)event.getEntity();
	     if ((event.getDamager() instanceof Player))
	     {
	       Player p = (Player)event.getDamager();
	       if (((kangaroo instanceof Player)) && ((p instanceof Player)) && 
	         (kangaroo.getInventory().contains(Material.FIREWORK)))
	       {
	         this.naofugir.add(kangaroo.getName());
	         Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getInstance(), new Runnable()
	         {
	           public void run()
	           {
	             Kangaroo.this.naofugir.remove(kangaroo.getName());
	           }
	         }, 60L);
	       }
	     }
	   }
	 


	  @EventHandler
	  public void onDrop(PlayerDropItemEvent event)
	  {
	    if (event.getItemDrop().getItemStack().getType() == Material.FIREWORK)
	      event.setCancelled(true);
	  }

	  @EventHandler
	  public void onDamage(EntityDamageEvent event)
	  {
	    Entity e = event.getEntity();
	    if ((e instanceof Player))
	    {
	      Player player = (Player)e;
	      if (((event.getEntity() instanceof Player)) && 
	        (event.getCause() == EntityDamageEvent.DamageCause.FALL) && 
	        (player.getInventory().contains(Material.FIREWORK)) && 
	        (event.getDamage() >= 12.0D))
	        event.setDamage(12.0D);
	    }
	  }
	  public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
	  {
	    Player p = (Player)sender;
	    ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	    ItemMeta souperaa = dima.getItemMeta();
	    souperaa.setDisplayName("§cSword");
	    dima.setItemMeta(souperaa);
	    ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	    ItemMeta sopas = sopa.getItemMeta();
	    sopas.setDisplayName("§6Soup");
	    sopa.setItemMeta(sopas);
	    ItemStack monk = new ItemStack(Material.FIREWORK);
	    ItemMeta ims = monk.getItemMeta();
	    ims.setDisplayName("§bDouble-Jump");
	    monk.setItemMeta(ims);

	  
	    
	    if (cmd.equalsIgnoreCase("kangaroo")) {
	    	if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
	            p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
	            p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
	           return true;
	         }
	      if (!p.hasPermission("kitpvp.kangaroo")) {
	    	  p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
	        return true;
	      }
	      p.getInventory().clear();
	      p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Kangaroo").replace("&", "§"));
	      p.setGameMode(GameMode.ADVENTURE);
	      
	      Habilidade.setAbility(p, "Kangaroo");
	      ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
		    
		    ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
		    
		    ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
		    
		    ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
		    
		    p.getInventory().setHelmet(capacete0);
		    p.getInventory().setChestplate(peitoral0);
		    p.getInventory().setLeggings(calca0);
		    p.getInventory().setBoots(Bota0);
	      p.getInventory().addItem(new ItemStack[] { dima });
	      p.getInventory().addItem(new ItemStack [] { monk });
	      
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	       
	      }
	    }
	    if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
	  	  /*  94 */        p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Kangaroo").replace("&", "§"));
	  	  /*     */       }
	  	  /*  96 */       return false; }{
	    
	  }
	}