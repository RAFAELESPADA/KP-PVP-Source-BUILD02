package me.RafaelAulerDeMeloAraujo.main;


import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreBoarding;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

import java.util.ArrayList;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Score
  implements CommandExecutor, Listener
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    if (!(sender instanceof Player))
    {
      sender.sendMessage(String.valueOf("No console"));
      return true;
    }

    Player p = (Player)sender;
    if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf("§cYou are not in kitpvp to do this!"));
    return true;
}
    if (ScoreBoarding.score.contains(p.getName()))
    {
      ScoreBoarding.score.remove(p.getName());
      p.sendMessage(String.valueOf("§6\u27a1 §aScoreBoard is now on"));
    }
    else
    {
    	ScoreBoarding.score.add(p.getName());
    	p.sendMessage(String.valueOf("§6\u27a1 §cScoreBoard is now off"));
    }
    return false;
    

}
}