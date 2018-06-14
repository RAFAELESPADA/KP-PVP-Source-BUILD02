package me.RafaelAulerDeMeloAraujo.PluginHooks;

import org.bukkit.entity.Player;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;
import me.clip.placeholderapi.external.EZPlaceholderHook;

public class PlaceHolderAPIHook extends EZPlaceholderHook {
	private Main plugin;
	
	public PlaceHolderAPIHook(Main plugin) {
		super(plugin, "kp-pvp");
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	public String onPlaceholderRequest(Player p, String indentifier) {
		
	
		if (indentifier.equals("player_kills")) {
			return String.valueOf(AntiDeathDrop.GetKills(p));
	}
		if (p == null) {
			return "";
		}
		
		
	if (indentifier.equals("player_deaths")) {
		return String.valueOf(AntiDeathDrop.GetDeaths(p));
}
	
		if (indentifier.equals("players_count_total")) {
			return String.valueOf(Join.game.size());
		}
		
		if (indentifier.equals("player_streak")) {
			 int kills = ((Integer)Streak.killstreak.get(p.getName())).intValue();
			return Integer.toString(kills);
		}
		if (indentifier.equals("player_is_on_kitpvp")) {
			 return String.valueOf(plugin.IsOnKitPvP(p.getName()) ? "Yes" : "No");
			
		}
		if (indentifier.equals("player_kit")) {
			 return Habilidade.getAbility(p);
			
		}
		
		return null;
		
		

		
}

	
}
