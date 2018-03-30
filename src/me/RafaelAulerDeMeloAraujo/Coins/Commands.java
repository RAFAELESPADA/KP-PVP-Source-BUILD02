/*     */ package me.RafaelAulerDeMeloAraujo.Coins;
/*     */ 
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.ChatColor;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Commands
/*     */   implements CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Commands(Main main)
/*     */   {
/*  24 */     this.main = main;
/*  25 */     plugin = main;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
/*     */   {
/*  33 */     Player p = (Player)sender;
/*  34 */     Coins.loadCoins();
/*  35 */     if (label.equalsIgnoreCase("coins")) {
/*  36 */       if ((sender instanceof Player))
/*     */       {
/*  38 */         if (args.length == 0)
/*     */         {
/*  40 */           p.sendMessage("§eYou have: §6" + Coins.getCoins(p.getName()) + " §eCoins");
/*  41 */           p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*     */           
/*  43 */           return true;
/*     */         }
/*  45 */         if (args[0].equalsIgnoreCase("set"))
/*     */         {
/*  47 */           if (!p.hasPermission("kitpvp.coins.set"))
/*     */           {
/*  49 */             p.sendMessage("§cYou dont have the permissions kitpvp.coins.set");
/*  50 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/*  51 */             return true;
/*     */           }
/*  53 */           if (args.length == 2)
/*     */           {
/*  55 */             Player t = Bukkit.getPlayer(args[1]);
/*  56 */             if (t == null)
/*     */             {
/*  58 */               p.sendMessage("§cThis player is offline");
/*  59 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/*  60 */               return true;
/*     */             }
/*     */           }
/*  63 */           if (args.length == 3)
/*     */           {
/*  65 */             Player t = Bukkit.getPlayer(args[1]);
/*  66 */             double amount = 0.0D;
/*     */             try
/*     */             {
/*  69 */               amount = Double.parseDouble(args[2]);
/*     */             }
/*     */             catch (Exception localException) {}
/*  72 */             Coins.setCoins(t.getName(), amount);
/*  73 */             t.sendMessage(ChatColor.GOLD + "New balance! do /coins to view it");
/*  74 */             t.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*  75 */             p.sendMessage(ChatColor.GOLD + "Updated " + t.getName() + "'s balance");
/*  76 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*  77 */             return true;
/*     */           }
/*  79 */           if (args.length != 3)
/*     */           {
/*  81 */             p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins set <Player> <Amount>");
/*  82 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*     */           }
/*     */         }
/*  85 */         if (args[0].equalsIgnoreCase("add"))
/*     */         {
/*  87 */           if (!p.hasPermission("kitpvp.coins.add"))
/*     */           {
/*  89 */             p.sendMessage("§cYou dont have the permissions kitpvp.coins.add");
/*  90 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/*  91 */             return true;
/*     */           }
/*  93 */           if (args.length == 2)
/*     */           {
/*  95 */             Player t = Bukkit.getPlayer(args[1]);
/*  96 */             if (t == null)
/*     */             {
/*  98 */               p.sendMessage("§cThis player is offline");
/*  99 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/* 100 */               return true;
/*     */             }
/*     */           }
/* 103 */           if (args.length == 3)
/*     */           {
/* 105 */             Player t = Bukkit.getPlayer(args[1]);
/* 106 */             double amount = 0.0D;
/*     */             try
/*     */             {
/* 109 */               amount = Double.parseDouble(args[2]);
/*     */             }
/*     */             catch (Exception localException1) {}
/* 112 */             Coins.addCoins(t.getName(), amount);
/* 113 */             t.sendMessage("§e" + amount + " §aCoins have been give to You!");
/* 114 */             t.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 115 */             p.sendMessage("§eYou give " + amount + " Coins To the Player " + t.getName());
/* 116 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 117 */             return true;
/*     */           }
/* 119 */           if (args.length != 3)
/*     */           {
/* 121 */             p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins add <Player> <Amount>");
/* 122 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/*     */           }
/*     */         }
/*     */         
/* 126 */         if (args[0].equalsIgnoreCase("remove"))
/*     */         {
/* 128 */           if (!p.hasPermission("kitpvp.coins.remove"))
/*     */           {
/* 130 */             p.sendMessage(ChatColor.DARK_RED + "You don't have the permission kitpvp.coins.remove!");
/* 131 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 132 */             return true;
/*     */           }
/* 134 */           if (args.length == 2)
/*     */           {
/* 136 */             Player t = Bukkit.getPlayer(args[1]);
/* 137 */             if (t == null)
/*     */             {
/* 139 */               p.sendMessage("§cThis player is offline");
/* 140 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/* 141 */               return true;
/*     */             }
/*     */           }
/* 144 */           if (args.length == 3)
/*     */           {
/* 146 */             Player t = Bukkit.getPlayer(args[1]);
/* 147 */             if (Coins.getCoins(t.getName()).doubleValue() != 0.0D)
/*     */             {
/* 149 */               double amount = 0.0D;
/*     */               try
/*     */               {
/* 152 */                 amount = Double.parseDouble(args[2]);
/*     */               }
/*     */               catch (Exception localException2) {}
/* 155 */               Coins.removeCoins(t.getName(), amount);
/* 156 */               t.sendMessage("§c" + amount + " §eCoins has been removed from your account");
/* 157 */               t.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 158 */               p.sendMessage("§eYou removed " + amount + " From this player");
/* 159 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 160 */               return true;
/*     */             }
/* 162 */             p.sendMessage(ChatColor.RED + "User does not have enought coins to have this amount removed!");
/* 163 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/* 164 */             if (args.length != 3)
/*     */             {
/* 166 */               p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins remove <Player> <Amount>");
/* 167 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/*     */             }
/*     */           }
/*     */         }
/* 171 */         if (args[0].equalsIgnoreCase("pay"))
/*     */         {
/* 173 */           if (args.length == 2)
/*     */           {
/* 175 */             Player t = Bukkit.getPlayer(args[1]);
/* 176 */             if (t == null)
/*     */             {
/* 178 */               p.sendMessage("§cThis player is offline");
/* 179 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/* 180 */               return true;
/*     */             }
/*     */           }
/* 183 */           if (args.length == 3)
/*     */           {
/* 185 */             Player t = Bukkit.getPlayer(args[1]);
/* 186 */             if (Coins.getCoins(p.getName()).doubleValue() != 0.0D)
/*     */             {
/* 188 */               double amount = 0.0D;
/*     */               try
/*     */               {
/* 191 */                 amount = Double.parseDouble(args[2]);
/*     */               }
/*     */               catch (Exception localException3) {}
/* 194 */               Coins.removeCoins(p.getName(), amount);
/* 195 */               Coins.addCoins(t.getName(), amount);
/* 196 */               p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 197 */               p.sendMessage(ChatColor.GOLD + "You pay " + amount + "Coins to the player" + t.getName());
/* 198 */               t.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/* 199 */               t.sendMessage(ChatColor.GOLD + " The player " + t.getName() + " Pay you some coins");
/* 200 */               t.sendMessage(ChatColor.GOLD + " " + amount + " Coins has been added to your account!");
/* 201 */               return true;
/*     */             }
/* 203 */             p.sendMessage(ChatColor.DARK_RED + " You dont have this coins amount to pay!");
/* 204 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.SucefullMessage")), 1.0F, 1.0F);
/*     */           }
/* 206 */           if (args.length != 3) {
/* 207 */             p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage! Use /coins pay <Player> <Amount>");
/* 208 */             p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/*     */           }
/*     */         }
/* 211 */         if ((!args[0].equalsIgnoreCase("set")) && (!args[0].equalsIgnoreCase("add")) && (!args[0].equalsIgnoreCase("remove")) && (!args[0].equalsIgnoreCase("pay")))
/*     */         {
/* 213 */           p.sendMessage(ChatColor.DARK_RED + "Invalid Command! Use /coins add/remove/set/pay.");
/* 214 */           p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ErrorMessage")), 1.0F, 1.0F);
/*     */         }
/*     */       }
/*     */       else
/*     */       {
/* 219 */         p.sendMessage(ChatColor.GREEN + "You are a console?!");
/*     */       }
/*     */     }
/* 222 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\Coins\Commands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
