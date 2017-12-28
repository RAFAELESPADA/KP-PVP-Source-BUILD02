package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
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
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.RafaelAulerDeMeloAraujo.main.Main;



public class Ninja 
implements Listener, CommandExecutor

{
	private Main main;
	/*     */   static Main plugin;
	/*     */   
	/*     */   public Ninja(Main main) {
	/*  27 */     this.main = main;
	/*  28 */     plugin = main;

	/*     */   }
	  public static List<Player> cooldownbk = new ArrayList();
		public static HashMap<Player, Player> a = new HashMap();
		
		  @EventHandler
		  public void dano(EntityDamageByEntityEvent e)
		  {
		    if (((e.getDamager() instanceof Player)) && ((e.getEntity() instanceof Player)))
		    {
			      Player p = (Player)e.getDamager();
			      Player p2 = (Player)e.getEntity();
		    	if(Habilidade.getAbility(p) == "Ninja"){
		        a.put(p, p2);
		        return;
		      }
		    }
		  }
		  
		  @EventHandler
		  public void shift(PlayerToggleSneakEvent e){
		    final Player p = e.getPlayer();
		    Player p2 = a.get(p);
		    if(Habilidade.getAbility(p) == "Ninja"){
		    	if(p2.isDead()){
		    		return;
		    	}
		    	if(cooldownbk.contains(p)){
		    		return;
		    	}
		          if (p2.getLocation().distance(p.getLocation()) < 120.0D){
		            p.teleport(p2.getLocation());
		            cooldownbk.add(p);
		            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, new Runnable() {
						
						@Override
						public void run() {
							cooldownbk.remove(p);
						}
					}, 7 * 20L);
		            return;
		          }else{
		        	  p.sendMessage("§cThe last player that you hurt are very distant!");
		        	  return;
		          }
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
		    
		    ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
		    
		    ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
		    
		    ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
		    
		    ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
		    
		  
		    
		    if (cmd.equalsIgnoreCase("ninja")) {
		    	if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
		            p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
		            p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
		           return true;
		         }
		      if (!p.hasPermission("kitpvp.ninja")) {
		    	  p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
		        return true;
		      }
		      
		      p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Ninja").replace("&", "§"));
		      p.setGameMode(GameMode.ADVENTURE);
		      p.getInventory().clear();
		      Habilidade.setAbility(p, "Ninja");
		      
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
			  	  /*  94 */        p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Ninja").replace("&", "§"));
			  	  /*     */       }
			  	  /*  96 */       return false; }{
		    
		  }
		}
