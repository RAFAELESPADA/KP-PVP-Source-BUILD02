package me.RafaelAulerDeMeloAraujo.ScoreboardManager;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.main.Main;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class Status
  implements Listener
{
  @EventHandler
  void aoLogar(PlayerJoinEvent evento)
  {
    Player jogador = evento.getPlayer();
    if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null)
    {
      Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", Integer.valueOf(0));
      Main.plugin.saveConfig();
    }
    if (Main.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null)
    {
      Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", Integer.valueOf(0));
      Main.plugin.saveConfig();
    }
  }
  
  @EventHandler
  void aoMatar(PlayerDeathEvent evento)
  {
    if ((evento.getEntity().getKiller() instanceof Player))
    {
      Player jogador = evento.getEntity().getKiller();
      
      int kills = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
      Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", Integer.valueOf(kills + 1));
      Main.plugin.saveConfig();
     
    }
  }
  
  @EventHandler
  void aoMorrer(PlayerDeathEvent evento)
  {
    if ((evento.getEntity() instanceof Player))
    {
      Player jogador = evento.getEntity();
      
      int mortes = Main.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
      Main.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", Integer.valueOf(mortes + 1));
      Main.plugin.saveConfig();
      Deshfire.cooldownm.remove(jogador);
      Deshfire.armadura.remove(jogador);
      Gladiator.lutando.remove(jogador);
      Gladiator.gladgladiator.remove(jogador);
    }
  }
  
  public static int getKills(Player p)
  {
    return Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills");
  }
}