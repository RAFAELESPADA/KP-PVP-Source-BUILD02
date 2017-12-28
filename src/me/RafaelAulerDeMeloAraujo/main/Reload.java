/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import org.bukkit.Server;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.plugin.Plugin;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class Reload implements CommandExecutor
/*    */ {
/*    */   private Main main;
/*    */   /*     */   static Main plugin;
/*     */   
/*     */   public Reload(Main main) {
/*  27 */     this.main = main;
/*  28 */     plugin = main;

/*     */   }
/*    */   
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 20 */     Player p = (Player)sender;
/* 21 */     if (command.getName().equalsIgnoreCase("kitreload")) {
	
/* 22 */       if (!sender.hasPermission("kitpvp.reload")) {
/* 23 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", label));
/* 24 */         return true;
/*    */       }
/* 26 */       p.sendTitle("§6\u27a1 §aThe config is now", "§areloaded!");
/* 27 */       Plugin plugin = p.getServer().getPluginManager().getPlugin("KP-PVP");
/* 28 */       plugin.reloadConfig();
/* 29 */       p.getServer().getPluginManager().disablePlugin(plugin);
/* 30 */       p.getServer().getPluginManager().enablePlugin(plugin);
/* 31 */       p.playSound(p.getLocation(), org.bukkit.Sound.BLOCK_NOTE_PLING, 1.0F, 1.0F);
/* 32 */       return true;
/*    */     }
/* 34 */     return false;


}
 {
}
}
