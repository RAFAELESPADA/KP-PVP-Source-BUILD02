package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;




import org.bukkit.Material;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;


import me.RafaelAulerDeMeloAraujo.main.Main;
public class DesifireCMD implements CommandExecutor {
	 private Main main;
	 /*     */   static Main plugin;
	 /*     */   
	 /*     */   public DesifireCMD(Main main) {
	 /*  27 */     this.main = main;
	 /*  28 */     plugin = main;
	 /*     */   }		
public boolean onCommand(CommandSender sender, Command command, String cmd, String[] args)
{

  

	 Player p = (Player)sender;
  if (command.getName().equalsIgnoreCase("deshfire"))
  {
  if (!p.hasPermission("kitpvp.deshfire")) {
	  p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", cmd));
    return true;
  }
  
  

  p.getInventory().clear();
  Habilidade.setAbility(p, "Deshfire");
  
  ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
  ItemMeta souperaa = dima.getItemMeta();
  souperaa.setDisplayName("§cSword");
  dima.setItemMeta(souperaa);
  ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
  ItemMeta sopas = sopa.getItemMeta();
  sopas.setDisplayName("§6Soup");
  sopa.setItemMeta(sopas);
  ItemStack especial = new ItemStack(Material.REDSTONE_BLOCK);
  ItemMeta especial2 = especial.getItemMeta();
  especial2.setDisplayName("§cDeshfire!");
  especial.setItemMeta(especial2);
  
  ItemStack capacete0 = new ItemStack(Material.IRON_HELMET);
  
  ItemStack peitoral0 = new ItemStack(Material.IRON_CHESTPLATE);
  
  ItemStack calca0 = new ItemStack(Material.IRON_LEGGINGS);
  
  ItemStack Bota0 = new ItemStack(Material.IRON_BOOTS);
  p.getInventory().addItem(new ItemStack[] { dima });
  p.getInventory().addItem(new ItemStack[] { especial });
  p.getInventory().setHelmet(capacete0);
  p.getInventory().setChestplate(peitoral0);
  p.getInventory().setLeggings(calca0);
  p.getInventory().setBoots(Bota0);

p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Deshfire").replace("&", "§"));
Habilidade.setAbility(p, "Deshfire");

  
  
  for (int i = 0; i <= 34; i++) {
    p.getInventory().addItem(new ItemStack[] { sopa });
    
  }
}
  if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
	  /*  94 */         p.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Deshfire").replace("&", "§"));
	  /*     */       }
	  /*  96 */       return false; }{

}


{
}
}
	 
	  
	  
