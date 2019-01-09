package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;
import java.util.List;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.API;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class AntiDeathDrop
  implements Listener
{
  private Main main;
  
  public AntiDeathDrop(Main main)
  {
    this.main = main;
  }
  
  @EventHandler
  public void onDeath(PlayerRespawnEvent e)
  {
    if (((e.getPlayer() instanceof Player)) && ((e.getPlayer().getKiller() instanceof Player)))
    {
      Player p = e.getPlayer();
      Player k = p.getKiller();
      
      TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), this.main.getConfig().getString("Title.DeathTitle"), this.main.getConfig().getString("Title.DeathSubTitle").replaceAll("%player%", k.getName()));
      if ((this.main.getConfig().getString("RespawnSound").equalsIgnoreCase("true")) && (Join.game.contains(p.getName()))) {
        p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Respawn")), 1.0F, 1.0F);
      }
    }
  }
  
  @EventHandler
  public void onDeath(PlayerDeathEvent e)
  {
    e.setDeathMessage("");
    if (((e.getEntity() instanceof Player)) && ((e.getEntity().getKiller() instanceof Player)))
    {
      Player p = e.getEntity();
      Player k = p.getKiller();
      if (Join.game.contains(p.getName()))
      {
        Join.game.contains(k.getName());
        
        e.getDrops().clear();
        e.setDeathMessage("");
        p.sendMessage(String.valueOf("§8[§cKitPvP§8] §e" + Main.getInstace().getConfig().getString("Death.Tell").replaceAll("%player%", k.getName())));
        k.sendMessage(String.valueOf("§8[§cKitPvP§8] §e" + Main.getInstace().getConfig().getString("Kill.Tell").replaceAll("%player%", p.getName())));
        Coins.addCoins(k.getName(), Main.customization.getDouble("Earned-Coins-Per-Kill"));
        Coins.removeCoins(p.getName(), Main.customization.getDouble("Lost-Coins-Per-Death"));
        Coins.saveCoins();
        Coins.loadCoins();
        API.tirarEfeitos(p);

        
        int mortes = Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
        
        Main.plugin.getConfig().set("status." + p.getName().toLowerCase() + ".mortes", Integer.valueOf(mortes + 1));
        
        int kills = Main.plugin.getConfig().getInt("status." + k.getName().toLowerCase() + ".kills");
        
        Main.plugin.getConfig().set("status." + k.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
        Main.plugin.saveConfig();
        Bukkit.getConsoleSender().sendMessage("§e" + p.getName() + " has been killed by " + k.getName() + " on kitpvp");
      }
      else if (((this.main.getConfig().getString("CustomKillAndDeathMessage").equalsIgnoreCase("true")) && (Join.game.contains(p.getName()))) || (Join.game.contains(k.getName())))
      {
        p.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§ ")) + this.main.getConfig().getString("Message.Death").replace("&", "§ ").replaceAll("%player%", k.getName()));
        k.sendMessage(String.valueOf(Main.getInstace().getConfig().getString("Prefix").replace("&", "§ ")) + this.main.getConfig().getString("Message.Kill").replace("&", "§ ").replaceAll("%player%", p.getName()));
      }
    }
  }
  
  public static int GetKills(Player p)
  {
    return Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
  }
 
  
  public static int GetDeaths(Player p)
  {
    return Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes");
  }
}
