package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import me.RafaelAulerDeMeloAraujo.main.Main;;

public class StaffChat
implements Listener, CommandExecutor
{
	private Main main;
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
		 if (!(sender instanceof Player))
	      {
	        sender.sendMessage("§cThis command is only for players!");
	        return true;
	      }
		 /* 21 */     if (cmd.getName().equalsIgnoreCase("kitsc")) {
				
			    {
	      if (args.length == 0) {
	        sender.sendMessage("§7» §cUse: §7/kitsc <message>");
	      }
	      if (args.length > 0)
	      {
	        StringBuilder string = new StringBuilder();
	        for (int i = 0; i < args.length; i++) {
	          string.append(args[i] + " ");
	        }
	        String mensagem = string.toString();
	       
	        
	        for (Player arrayOfPlayer : Bukkit.getOnlinePlayers())
	        
	        {
	          Player staff = arrayOfPlayer;
	          if (!sender.hasPermission("kitpvp.staffchat")){
	        	  sender.sendMessage("§cYou dont have the permission kitpvp.staffchat");
	        	  return true;
	          }
	          if (staff.hasPermission("kitpvp.staffchat")){
	            staff.sendMessage("§5§LSC §b\u27a1 §6" + sender.getName() + ": §f" + mensagem);
	        }
	        }
	      }
	    }
	    return false;
	  }
		return false;
	}
}
