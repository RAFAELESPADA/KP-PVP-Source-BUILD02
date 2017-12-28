package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KITPVP implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		Player p = (Player) sender;
		if(label.equalsIgnoreCase("kp")) {
			p.sendMessage("§b§l\u2716 §e§lKP-PVP Command Help Menu §b§l\u2716");
			p.sendMessage("§a<> = Opcional §b/ §a[] = Required");
			p.sendMessage("§e/kitpvp §7(View the main command list)");
			p.sendMessage("§e/kpkits §7(Open the kit menu)");
			p.sendMessage("§e/kpshop §7(Open the Shop menu)"); 
			p.sendMessage("§e/kitreload §7(Reload the configuration)"); 
			p.sendMessage("§e/stats <Player> §7(View your or other player stats)");
			p.sendMessage("§e/kitclear §7(Clear your kit)");
			p.sendMessage("§e/togglescore §7((Toggle the scoreboard ON or OFF)");
			p.sendMessage("§e/kitcredits §7(Display some information about the plugin)");
			p.sendMessage("§e/ksc [Message] §7(A Custom StaffChat)");
			p.sendMessage("§e/coins add/remove/set/pay §7(Manage the players coins)");
			p.sendMessage("§e/adminmode §7(Stay invisible and receive items to catch hackers!)");
			
			p.sendMessage("§e/kpsetspawn §7(Set the kitpvp spawn!)");
			p.sendMessage("§e/set1v1 §7(Set the 1VS1 spawn!)");
			
			p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 12.0F, 12.0F);
		}
		return false;
	}
}
	
			
