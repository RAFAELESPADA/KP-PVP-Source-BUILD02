package me.RafaelAulerDeMeloAraujo.main;



import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.Listener;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;

import org.bukkit.*;

public class Stats implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        /* 21 */     if (cmd.getName().equalsIgnoreCase("stats")) {
			
		    {
            if (args.length == 0) {
            	/* 149 */      int kills = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".kills").toString());
            	/* 130 */       int deaths = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(p.getName().toLowerCase()).append(".mortes").toString());
            	
            	p.sendMessage("§b");
                
            	p.sendMessage("§bKills §8\u27a1§e " + kills);
            	p.sendMessage("§bDeaths §8\u27a1§e " + deaths);
            	
            	p.sendMessage("§bCoins §8\u27a1§e " + Coins.getCoins(p.getName()));
            	p.sendMessage("§bStreak §8\u27a1§e " + me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak.killstreak.get(p.getName()));
            	p.sendMessage("§b");
                return true;
            }
           
            if (args.length > 0 && args.length < 2 && p.hasPermission("kitpvp.stats.see.other")) {
            	  final Player t = Bukkit.getServer().getPlayer(args[0]);
                if (t != null) {
                	/* 149 */      int kills = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(t.getName().toLowerCase()).append(".kills").toString());
                	/* 130 */       int deaths = Main.plugin.getConfig().getInt(new StringBuilder("status.").append(t.getName().toLowerCase()).append(".mortes").toString());
                    p.sendMessage("§b");
                    p.sendMessage("§bPlayer §8\u27a1§e " + t.getName());
                	p.sendMessage("§bKills §8\u27a1§e " + kills);
                	p.sendMessage("§bDeaths §8\u27a1§e " + deaths);
                	
                	p.sendMessage("§bCoins §8\u27a1§e " + Coins.getCoins(t.getName()));
                	p.sendMessage("§bStreak §8\u27a1§e " + me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak.killstreak.get(t.getName()));
                	p.sendMessage("§b");
                    return true;
                }
            }
          
            }
        
        return false;
    
		
}
		return false;
}
}


