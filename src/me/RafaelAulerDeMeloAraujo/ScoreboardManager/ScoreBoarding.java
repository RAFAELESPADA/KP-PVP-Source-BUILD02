package me.RafaelAulerDeMeloAraujo.ScoreboardManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.Main;
public class ScoreBoarding {

	public static ArrayList<String> score = new ArrayList();
	private static Main main;
	/*    */  
	/*    */  
	
		/*     */   
	
	File f = new File("plugins/KP-PVP/Stats/stats.yml");
	     YamlConfiguration yamlFile = YamlConfiguration.loadConfiguration(f);
	
             //           
public static void setScoreBoard(Player p)
{
  
  
  

 
  {
	  SimpleScoreboard scoreboard = new SimpleScoreboard(Main.getPlugin().getConfig().getString("ScorePrefix").replace("&", "§"));
    
    
	scoreboard.blankLine();
	
	
	
    scoreboard.add(String.valueOf(Main.getPlugin().getConfig().getString("ScoreArrowColor").replace("&", "§")) + "\u2794 " + String.valueOf(Main.getPlugin().getConfig().getString("ScoreKills").replace("&", "§")) + " " + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString()));
    scoreboard.add(String.valueOf(Main.getPlugin().getConfig().getString("ScoreArrowColor").replace("&", "§")) + "\u2794 " + String.valueOf(Main.getPlugin().getConfig().getString("ScoreDeaths").replace("&", "§")) + " " + Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString()));
    scoreboard.add(String.valueOf(Main.getPlugin().getConfig().getString("ScoreArrowColor").replace("&", "§")) + "\u2794 " + String.valueOf(Main.getPlugin().getConfig().getString("ScoreStreak").replace("&", "§")) + " " + Streak.killstreak.get(p.getName()));
    scoreboard.add(String.valueOf(Main.getPlugin().getConfig().getString("ScoreArrowColor").replace("&", "§")) + "\u2794 " + String.valueOf(Main.getPlugin().getConfig().getString("ScoreCoins").replace("&", "§")) + " " + Coins.getCoins(p.getName()));
    scoreboard.add(String.valueOf(Main.getPlugin().getConfig().getString("ScoreArrowColor").replace("&", "§")) + "\u2794 " + String.valueOf(Main.getPlugin().getConfig().getString("ScoreKit").replace("&", "§")) + " " + Habilidade.getAbility(p));
   
    

    scoreboard.blankLine();
    
    
    
    
    scoreboard.add("§c/togglescore");
    scoreboard.build();
   
    scoreboard.send(new Player[] { p });
  }
}

public static void removeScoreBoard(Player p)
{
  Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
  Objective o = score.registerNewObjective("tuts", "PvP");
  o.setDisplaySlot(DisplaySlot.SIDEBAR);
  o.setDisplayName("");
  p.setScoreboard(score);
}
}
