package me.RafaelAulerDeMeloAraujo.Coins;





import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands
  implements CommandExecutor
{
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
    Player p = (Player)sender;
    Coins.loadCoins();
    if (label.equalsIgnoreCase("coins")) {
      if ((sender instanceof Player))
      {
        if (args.length == 0)
        {
          p.sendMessage("§eYou have: §6" + Coins.getCoins(p.getName()) + " §eCoins");
          p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
          
          return true;
        }
        if (args[0].equalsIgnoreCase("set"))
        {
          if (!p.hasPermission("kitpvp.coins.set"))
          {
            p.sendMessage("§cYou dont have the permissions kitpvp.coins.set");
            p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 10.0F, 30.0F);
            return true;
          }
          if (args.length == 2)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (t == null)
            {
              p.sendMessage("§cThis player is offline");
              p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
              return true;
            }
          }
          if (args.length == 3)
          {
            Player t = Bukkit.getPlayer(args[1]);
            double amount = 0.0D;
            try
            {
              amount = Double.parseDouble(args[2]);
            }
            catch (Exception localException) {}
            Coins.setCoins(t.getName(), amount);
            t.sendMessage( ChatColor.GOLD + "New balance! do /coins to view it");
            t.playSound(t.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
            p.sendMessage(ChatColor.GOLD + "Updated " + t.getName() + "'s balance");
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
            return true;
          }
          if (args.length != 3)
          {
            p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins set <Player> <Amount>");
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
          }
        }
        if (args[0].equalsIgnoreCase("add"))
        {
          if (!p.hasPermission("kitpvp.coins.add"))
          {
        	  p.sendMessage("§cYou dont have the permissions kitpvp.coins.add");
            p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 10.0F, 30.0F);
            return true;
          }
          if (args.length == 2)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (t == null)
            {
             p.sendMessage("§cThis player is offline");
              p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
              return true;
            }
          }
          if (args.length == 3)
          {
            Player t = Bukkit.getPlayer(args[1]);
            double amount = 0.0D;
            try
            {
              amount = Double.parseDouble(args[2]);
            }
            catch (Exception localException1) {}
            Coins.addCoins(t.getName(), amount);
            t.sendMessage("§e" + amount + " §aCoins have been give to You!");
            t.playSound(t.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
            p.sendMessage("§eYou give " + amount + " Coins To the Player " + t.getName());
            p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
            return true;
          }
          if (args.length != 3)
          {
        	  p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins add <Player> <Amount>");
              p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
          }
        }
        if (args[0].equalsIgnoreCase("remove"))
        {
          if (!p.hasPermission("kitpvp.coins.remove"))
          {
            p.sendMessage(ChatColor.DARK_RED + "You don't have the permission kitpvp.coins.remove!");
            p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 10.0F, 30.0F);
            return true;
          }
          if (args.length == 2)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (t == null)
            {
            	p.sendMessage("§cThis player is offline");
                p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
              return true;
            }
          }
          if (args.length == 3)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (Coins.getCoins(t.getName()).doubleValue() != 0.0D)
            {
              double amount = 0.0D;
              try
              {
                amount = Double.parseDouble(args[2]);
              }
              catch (Exception localException2) {}
              Coins.removeCoins(t.getName(), amount);
              t.sendMessage("§c" + amount + " §eCoins has been removed from your account");
              t.playSound(t.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
              p.sendMessage("§eYou removed " + amount + " From this player");
              p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
              return true;
            }
            p.sendMessage(ChatColor.RED + "User does not have enought coins to have this amount removed!");
            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
            if (args.length != 3)
            {
            	p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins remove <Player> <Amount>");
              p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
            }
          }
        }
        if (args[0].equalsIgnoreCase("pay"))
        {
          if (args.length == 2)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (t == null)
            {
            	p.sendMessage("§cThis player is offline");
                p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
              return true;
            }
          }
          if (args.length == 3)
          {
            Player t = Bukkit.getPlayer(args[1]);
            if (Coins.getCoins(p.getName()).doubleValue() != 0.0D)
            {
              double amount = 0.0D;
              try
              {
                amount = Double.parseDouble(args[2]);
              }
              catch (Exception localException3) {}
              Coins.removeCoins(p.getName(), amount);
              Coins.addCoins(t.getName(), amount);
              p.playSound(p.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
              p.sendMessage(ChatColor.GOLD + "You pay " + amount + "Coins to the player" + t.getName());
              t.playSound(t.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10.0F, 30.0F);
              t.sendMessage(ChatColor.GOLD + " The player " + t.getName() + " Pay you some coins");
              t.sendMessage(ChatColor.GOLD + " " + amount + " Coins has been added to your account!");
              return true;
            }
            p.sendMessage(ChatColor.DARK_RED + " You dont have this coins amount to pay!");
            p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
          }
          if (args.length != 3) {
        	  p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins pay <Player> <Amount>");
          }
        }
        if ((!args[0].equalsIgnoreCase("set")) && (!args[0].equalsIgnoreCase("add")) && (!args[0].equalsIgnoreCase("remove")) && (!args[0].equalsIgnoreCase("pay")))
        {
        	p.sendMessage(ChatColor.DARK_RED + "Invalid Command! Use /coins add/remove/set/pay.");
          p.playSound(p.getLocation(), Sound.ENTITY_ARROW_HIT, 10.0F, 30.0F);
        }
      }
      else
      {
        p.sendMessage(ChatColor.GREEN + "You are a console?!");
      }
    }
    return false;
  }
}
