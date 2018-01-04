package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.main.Main;



public class Critical 
implements Listener, CommandExecutor
{
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Critical(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }

	@EventHandler
	  public void dano(EntityDamageByEntityEvent e)
	  {
	    if (((e.getEntity() instanceof Player)) && ((e.getDamager() instanceof Player)))
	    {
	      Player p = (Player)e.getEntity();
	      Player d = (Player)e.getDamager();
	      if (Habilidade.getAbility(d) == "Critical")
	      {
	        Random r = new Random();
	        int c = r.nextInt(100);
	        if (c <= 10)
	        {
	          e.setDamage(e.getDamage() + 4.0D);
	          p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, Material.REDSTONE_BLOCK, 10);
	          d.sendMessage(ChatColor.RED + "You give a critical hit on player " + ChatColor.DARK_RED + p.getName());
	          p.sendMessage(ChatColor.RED + "You receive a critical hit from " + ChatColor.DARK_RED + d.getName());
	        }
	      }
	    }
	  }
	    
	   {
		   
	   }
		   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
				 /*     */   

			  Player p = (Player)sender;
	  if (cmd.getName().equalsIgnoreCase("critical"))
	  {
		 
	    if (!p.hasPermission("kitpvp.kit.critical"))
	    {
	    	p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
	      return true;
	    }
	    if (!Join.game.contains(p.getName()))
        {
            p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to choose this kit!");
            return true;
        }
	  
	    if (Habilidade.ContainsAbility(p)) { 
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
	    
	    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Critical").replace("&", "§"));
	    Habilidade.setAbility(p, "Critical");
	    p.getInventory().addItem(new ItemStack[] { dima });
	    
	    
	    
	    
	    for (int i = 0; i <= 34; i++) {
	      p.getInventory().addItem(new ItemStack[] { sopa });
	      
	    }
	    
	  }
	  if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
		  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Critical").replace("&", "§"));
		  /*     */       }
		  /*  96 */       return false; }{
	  
	}
	
{
}
}