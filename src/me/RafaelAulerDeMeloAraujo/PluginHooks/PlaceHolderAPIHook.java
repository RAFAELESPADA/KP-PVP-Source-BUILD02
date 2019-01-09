package me.RafaelAulerDeMeloAraujo.PluginHooks;

import java.util.ArrayList;
import java.util.Map;

import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.ScoreboardManager.Streak;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.AntiDeathDrop;
import me.RafaelAulerDeMeloAraujo.main.Main;
import me.clip.placeholderapi.external.EZPlaceholderHook;
import org.bukkit.entity.Player;

public class PlaceHolderAPIHook
  extends EZPlaceholderHook
{
  private Main plugin;
  
  public PlaceHolderAPIHook(Main plugin)
  {
    super(plugin, "kp-pvp");
    
    this.plugin = plugin;
  }
  
  public String onPlaceholderRequest(Player p, String indentifier)
  {
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
    if (indentifier.equals("player_streak"))
    {
      int kills = ((Integer)Streak.killstreak.get(p.getName())).intValue();
      return Integer.toString(kills);
    }
    if (indentifier.equals("player_coins")) {
        Double coins = Coins.getCoins(p.getName());
        return Double.toString(coins);
      }
    if (indentifier.equals("player_is_on_kitpvp")) {
      return String.valueOf(this.plugin.IsOnKitPvP(p.getName()) ? "Yes" : "No");
    }
    if (indentifier.equals("player_kit")) {
      return Habilidade.getAbility(p);
    }
   
    return null;
  }
}
