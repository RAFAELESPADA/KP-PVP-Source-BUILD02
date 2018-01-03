package me.RafaelAulerDeMeloAraujo.main;



import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



	

	public class Dev implements CommandExecutor{
		
		@Override
		public boolean onCommand(CommandSender sender, Command cmd, String label,
				String[] args) {
			Player p = (Player) sender;
			if(label.equalsIgnoreCase("dev")) {
				p.sendMessage("§4§l\u2716 §2§lCREDITS §f§lAND §e§lINFORMATION §4§l\u2716");
				p.sendMessage("§6\u27a1 §cPlugin Name: §eKP-PVP"); 
				p.sendMessage("§6\u27a1 §cPlugin Version: §eBUILD-05"); 
				p.sendMessage("§6\u27a1 §cAuthor: §ezEnderX5_ , Rafael Auler");
				p.sendMessage("§6\u27a1 §cAuthor Channel: http://bit.ly/2kC345B");
				p.sendMessage("§6\u27a1 §cSpigot Profile: http://bit.ly/2j5qvnM");
				p.sendMessage("§6\u27a1 §cPlugin Page: http://bit.ly/2BZCtLE");
				p.sendMessage("§cThanks for use this plugin i really appreaciate IT");
				p.sendMessage("§cIf you like it consider giving a §e§l\u2730\u2730\u2730\u2730\u2730 §cReview");
				p.sendMessage("§cPS: §eSubscribe to my channel and follow me on Spigot Thanks! §9§l\u263B");
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 12.0F, 12.0F);
			}
			return false;
		}
	}
