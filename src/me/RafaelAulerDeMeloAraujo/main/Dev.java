/*    */ package me.RafaelAulerDeMeloAraujo.main;
/*    */ 
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class Dev
/*    */   implements CommandExecutor
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public Dev(Main main)
/*    */   {
/* 19 */     this.main = main;
/* 20 */     plugin = main;
/*    */   }
/*    */   
/*    */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*    */   {
/* 25 */     Player p = (Player)sender;
/* 26 */     if (label.equalsIgnoreCase("dev")) {
	/* 27 */       p.sendMessage("§4§l\u274C §2§lCREDITS §f§lAND §e§lINFORMATION §4§l \u274C");
	/* 28 */       p.sendMessage("§6\u279C §cPlugin Name: §eKP-PVP");
	/* 29 */       p.sendMessage("§6\u279C §cPlugin Version: §e" + Main.getInstance().getDescription().getVersion());
	/* 30 */       p.sendMessage("§6\u279C §cAuthor: §ezEnderX5_ , Rafael Auler");
	/* 31 */       p.sendMessage("§6\u279C §cAuthor Channel: http://bit.ly/2kC345B");
	/* 32 */       p.sendMessage("§6\u279C §cSpigot Profile: http://bit.ly/2j5qvnM");
	/* 33 */       p.sendMessage("§6\u279C §cPlugin Page: http://bit.ly/2BZCtLE");
	/* 34 */       p.sendMessage("§cThanks for use this plugin i really appreaciate IT");
	/* 35 */       p.sendMessage("§cIf you like it consider giving a §e§l\u2605\u2605\u2605\u2605\u2605 §cReview");
	/* 36 */       p.sendMessage("§cPS: §eSubscribe to my channel and follow me on Spigot Thanks! §9§l=)");
/* 37 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*    */     }
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Dev.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
