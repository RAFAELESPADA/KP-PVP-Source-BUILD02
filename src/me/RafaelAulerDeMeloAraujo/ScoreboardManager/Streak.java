package me.RafaelAulerDeMeloAraujo.ScoreboardManager;



	import java.util.HashMap;
	import java.util.Map;
	import org.bukkit.Bukkit;
	import org.bukkit.ChatColor;
	import org.bukkit.EntityEffect;
	import org.bukkit.Server;
	import org.bukkit.Sound;
	import org.bukkit.entity.Player;
	import org.bukkit.event.EventHandler;
	import org.bukkit.event.Listener;
	import org.bukkit.event.entity.PlayerDeathEvent;
	import org.bukkit.plugin.PluginManager;
	import org.bukkit.plugin.java.JavaPlugin;
	import org.bukkit.potion.PotionEffect;
	import org.bukkit.potion.PotionEffectType;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.Main;

	public class Streak   implements Listener
	 {
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public Streak() {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }
	
	  public void onEnable()
	  {
	    
	  }
	  
	  public static Map<String, Integer> killstreak = new HashMap();
	  
	  @EventHandler
	  public void playerdeath(PlayerDeathEvent ev)
	  {
	    Player p = ev.getEntity();
	    if ((p.getKiller() instanceof Player))
	    {
	    	 
	      Player killer = p.getKiller();
	      if ((Join.game.contains(killer)))
	 	    
	      p.sendMessage(ChatColor.RED + "Your killstreak has been destroyed by " + ChatColor.YELLOW + killer.getName());
	      addtokillstreak(killer);
	      this.killstreak.put(p.getName(), Integer.valueOf(0));
	    }
	  }
	  
	  
	  public void addtokillstreak(Player killer)
	  {
	    String name = killer.getName();
	    if (this.killstreak.containsKey(name))
	    {
	      int kills = ((Integer)this.killstreak.get(name)).intValue();
	      kills++;
	      this.killstreak.put(name, Integer.valueOf(kills));
	      
	      killer.sendMessage(ChatColor.GREEN + "You are on " + ChatColor.RED + Integer.toString(kills) + ChatColor.GREEN + " Killstreak.");
	      if (kills == 100)
	      {
	        Bukkit.broadcastMessage(String.valueOf( ChatColor.GREEN+ killer.getName() + 
	          ChatColor.DARK_GREEN + " is on a 100 killstreak!"));
	        killer.sendMessage(ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-100") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-100"));
	      }
	      if (kills == 80)
	      {
	        Bukkit.broadcastMessage(ChatColor.GREEN+ killer.getName() + 
	          ChatColor.DARK_GREEN+ " is on a 80 killstreak!");
	        killer.sendMessage(ChatColor.GOLD+ "You win " + Main.customization.getDouble("KS-80") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-80"));
	      }
	      if (kills == 65)
	      {
	        Bukkit.broadcastMessage(ChatColor.GREEN+ killer.getName() + 
	          ChatColor.DARK_GREEN + " is on a 65 killstreak!");
	        killer.sendMessage(ChatColor.GOLD +  "You win " + Main.customization.getDouble("KS-65") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-65"));
	      }
	      if (kills == 50)
	      {
	        Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + 
	          ChatColor.DARK_RED + " is on a 50 killstreak!");
	        killer.sendMessage(ChatColor.GOLD +  "You win " + Main.customization.getDouble("KS-50") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-50"));
	      }
	      if (kills == 30)
	      {
	        Bukkit.broadcastMessage( ChatColor.GREEN+ killer.getName() + 
	          ChatColor.RED+  " is on a 30 killstreak!");
	        killer.sendMessage(ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-30") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-30"));
	      }
	      if (kills == 20)
	      {
	        Bukkit.broadcastMessage(ChatColor.GREEN + killer.getName() + 
	          ChatColor.RED +  " is on a 20 kill streak!");
	        killer.sendMessage(ChatColor.GOLD + "You win " + Main.customization.getDouble("KS-20") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-20"));
	      }
	      if (kills == 10)
	      {
	        Bukkit.broadcastMessage(String.valueOf( ChatColor.YELLOW + killer.getName() + 
	          ChatColor.YELLOW +  " is on a 10 kill streak"));
	        killer.sendMessage(ChatColor.GOLD+  "You win " + Main.customization.getDouble("KS-10") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-10"));
	      }
	      if (kills == 5)
	      {
	        Bukkit.broadcastMessage(String.valueOf( ChatColor.GREEN + killer.getName() + 
	          ChatColor.GREEN +  " is on a 5 kill streak"));
	        killer.sendMessage(ChatColor.GOLD+  "You win " + Main.customization.getDouble("KS-5") + " Coins!");
	        Coins.addCoins(killer.getName(), Main.customization.getDouble("KS-5"));
	      }
	    
	    if (kills == 1 && Join.game.contains(killer))
	    {
	      this.killstreak.put(name, Integer.valueOf(1));
	      killer.playSound(killer.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
	      killer.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " You're on a " + ChatColor.RED + "1" + ChatColor.WHITE + " Killstreak.");
	    }
	  }
	}
	 }

