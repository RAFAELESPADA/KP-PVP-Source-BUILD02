/*    */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import me.RafaelAulerDeMeloAraujo.TitleAPI.TitleAPI;
/*    */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.Sound;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.configuration.file.FileConfiguration;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.PlayerInventory;
/*    */ import org.bukkit.inventory.meta.ItemMeta;
/*    */ 
/*    */ public class DesifireCMD implements CommandExecutor
/*    */ {
/*    */   private Main main;
/*    */   static Main plugin;
/*    */   
/*    */   public DesifireCMD(Main main)
/*    */   {
/* 24 */     this.main = main;
/* 25 */     plugin = main;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
/*    */   {
/* 32 */     Player p = (Player)sender;
/* 33 */     if (command.getName().equalsIgnoreCase("deshfire"))
/*    */     {
/* 35 */       if (!Join.game.contains(p.getName()))
/*    */       {
/* 37 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
/* 38 */         return true;
/*    */       }
/* 40 */       if (Habilidade.ContainsAbility(p)) {
/* 41 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 42 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 43 */         return true;
/*    */       }
/* 45 */       if (!p.hasPermission("kitpvp.kit.deshfire")) {
/* 46 */         p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
/* 47 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.NoPermissionMessage")), 1.0F, 1.0F);
/* 48 */         return true;
/*    */       }
/*    */       
/*    */ 
/*    */ 
/* 53 */       p.getInventory().clear();
/* 54 */       Habilidade.setAbility(p, "Deshfire");
/*    */       
/* 56 */       ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
/* 57 */       ItemMeta souperaa = dima.getItemMeta();
/* 58 */       souperaa.setDisplayName("§cSword");
/* 59 */       dima.setItemMeta(souperaa);
/* 60 */       ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
/* 61 */       ItemMeta sopas = sopa.getItemMeta();
/* 62 */       sopas.setDisplayName("§6Soup");
/* 63 */       sopa.setItemMeta(sopas);
/* 64 */       ItemStack especial = new ItemStack(Material.REDSTONE_BLOCK);
/* 65 */       ItemMeta especial2 = especial.getItemMeta();
/* 66 */       especial2.setDisplayName("§cDeshfire!");
/* 67 */       especial.setItemMeta(especial2);
/*    */       
/* 69 */       ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
/*    */       
/* 71 */       ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
/*    */       
/* 73 */       ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
/*    */       
/* 75 */       ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
/* 76 */       p.getInventory().addItem(new ItemStack[] { dima });
/* 77 */       p.getInventory().addItem(new ItemStack[] { especial });
/* 78 */       p.getInventory().setHelmet(capacete0);
/* 79 */       p.getInventory().setChestplate(peitoral0);
/* 80 */       p.getInventory().setLeggings(calca0);
/* 81 */       p.getInventory().setBoots(Bota0);
/*    */       
/* 83 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Deshfire").replace("&", "§"));
/* 84 */       Habilidade.setAbility(p, "Deshfire");
/*    */       
/*    */ 
/*    */ 
/* 88 */       for (int i = 0; i <= 34; i++) {
/* 89 */         p.getInventory().addItem(new ItemStack[] { sopa });
/* 90 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 91 */         TitleAPI.sendTitle(p, Integer.valueOf(5), Integer.valueOf(20), Integer.valueOf(5), this.main.getConfig().getString("Title.KitTitle"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Deshfire"));
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 99 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\DesifireCMD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
