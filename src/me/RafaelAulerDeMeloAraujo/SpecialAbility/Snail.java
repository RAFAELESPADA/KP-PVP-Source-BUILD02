package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.main.Main;



public class Snail 
implements Listener, CommandExecutor
{
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Snail(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }
	@EventHandler
	  public void viper(EntityDamageByEntityEvent e)
	  {
	    if (((e.getDamager() instanceof Player)) && 
	      ((e.getEntity() instanceof LivingEntity)))
	    {
	      LivingEntity entity = (LivingEntity)e.getEntity();
	      Player p = (Player)e.getDamager();
	      if (Habilidade.getAbility(p).equalsIgnoreCase("Snail"))
	      {
	        Random rand = new Random();
	        int percent = rand.nextInt(100);
	        if (percent <= 33){
		          entity.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 160, 1));
	          return;
	        }
	        return;
	      }
	      return;
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
	    
	    
	    
	    if (cmd.equalsIgnoreCase("snail")) {
	    	if (Habilidade.ContainsAbility(p)) { 
	            p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
	            p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
	           return true;
	         }
	    	  if (!Join.game.contains(p.getName()))
	          {
	              p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
	              return true;
	          }
	      if (!p.hasPermission("kitpvp.kit.snail")) {
	    	  p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
	        return true;
	      }
	     
	      p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Snail").replace("&", "§"));
	      p.setGameMode(GameMode.ADVENTURE);
	      p.getInventory().clear();
	      Habilidade.setAbility(p, "Snail");
	      ItemStack capacete0 = new ItemStack(Material.LEATHER_HELMET);
		    
		    ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
		    
		    ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
		    
		    ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
		    
		    p.getInventory().setHelmet(capacete0);
		    p.getInventory().setChestplate(peitoral0);
		    p.getInventory().setLeggings(calca0);
		    p.getInventory().setBoots(Bota0);
	      p.getInventory().addItem(new ItemStack[] { dima });
	      
	      for (int i = 0; i <= 34; i++) {
	        p.getInventory().addItem(new ItemStack[] { sopa });
	        
	      }
	    }
	    if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
	  	  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Snail").replace("&", "§"));
	  	  /*     */       }
	  	  /*  96 */
		return false;      

	  }

{
}  
}

	  
