package me.RafaelAulerDeMeloAraujo.main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class AntiBugCommand implements CommandExecutor
{
	

public boolean onCommand(CommandSender sender, Command cmd, String label,
		String[] args) {
	Player p = (Player) sender;
	if(label.equalsIgnoreCase("rektf58942kka")) {
	 World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
	  double x =  Main.plugin.getConfig().getDouble("Spawn.X");
	    double y = Main.plugin.getConfig().getDouble("Spawn.Y");
	    double z = Main.plugin.getConfig().getDouble("Spawn.Z");
	    Location lobby = new Location(w, x, y, z);
	    lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
	    lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	    
	    p.teleport(lobby);
}
	return false;
}
}