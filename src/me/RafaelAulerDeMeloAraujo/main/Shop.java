package me.RafaelAulerDeMeloAraujo.main;

import java.util.ArrayList;
import java.util.Arrays;
import me.RafaelAulerDeMeloAraujo.Coins.Coins;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Shop
  implements Listener, CommandExecutor
{
  private Main main;
  public static Inventory shop = Bukkit.getServer().createInventory(null, 54, "Buy More Kits! :D");
  
  static
  {
    createButton(Material.DIAMOND_SWORD, shop, 0, "§6-> §cPvP", "§ePrice: 4500");
    createButton(Material.BOW, shop, 1, "§6-> § cArcher", "§ePrice: 3000");
    createButton(Material.FLINT_AND_STEEL, shop, 2, "§6-> §cPyro", "§ePrice: 6000");
    createButton(Material.DIAMOND_CHESTPLATE, shop, 3, "§6-> §cTank", "§ ePrice: 7000");
    createButton(Material.SNOW_BALL, shop, 4, "§6-> §cSwitcher", "§ePrice: 6500");
    createButton(Material.MAGMA_CREAM, shop, 5, "§6-> §cJumper", "§ePrice: 8000");
    createButton(Material.CACTUS, shop, 6, "§6-> §cCactus", "§ePrice: 4000");
    createButton(Material.TNT, shop, 7, "§6-> §cBomber", "§ ePrice: 9000");
    createButton(Material.ENDER_PEARL, shop, 8, "§6-> §cWarper", "§ePrice: 4000");
    
    createButton(Material.FISHING_ROD, shop, 9, "§6-> §cFisherman", "§ePrice: 5000");
    
    createButton(Material.IRON_BOOTS, shop, 10, "§6-> §cStomper", "§ePrice: 17500");
    createButton(Material.REDSTONE_BLOCK, shop, 11, "§6-> §cDeshfire", "§ePrice: 8500");
    createButton(Material.SPIDER_EYE, shop, 12, "§6-> §cViper", "§ePrice: 7000");
    createButton(Material.STRING, shop, 13, "§6-> §cSpiderman", "§ePrice: 6000");
    createButton(Material.IRON_FENCE, shop, 14, "§6-> §cGladiator", "§ePrice: 16000");
    createButton(Material.FIREWORK, shop, 15, "§6-> §cKangaroo", "§ePrice: 5000");
    createButton(Material.COAL, shop, 16, "§6-> §cNinja", "§ePrice: 6500");
    createButton(Material.WATCH, shop, 17, "§6-> §cTimelord", "§ePrice: 7000");
    createButton(Material.GOLDEN_APPLE, shop, 18, "§6-> §cCritical", "§ePrice: 8000");
    createButton(Material.CHAINMAIL_BOOTS, shop, 20, "§6-> §cDoubleJump", "§ePrice: 9500");
    createButton(Material.GOLD_AXE, shop, 21, "§6-> §cThor", "§ePrice: 7000");
    createButton(Material.FERMENTED_SPIDER_EYE, shop, 22, "§6-> §cSnail", "§ePrice: 6000");
    createButton(Material.BLAZE_ROD, shop, 23, "§6-> §cWasp", "§ePrice: 6000");
    createButton(Material.NETHER_STAR, shop, 24, "§6-> §cNaruto", "§ePrice: 12500");
    createButton(Material.FEATHER, shop, 25, "§6-> §cAirman", "§ePrice: 9000");
    createButton(Material.GOLD_NUGGET, shop, 26, "§6-> §cVampire", "§ePrice: 10000");
    createButton(Material.BARRIER, shop, 53, "§4§l-> §cClose", "§bClose the menu!");
  }
  
  public Shop(Main main)
  {
	  ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
    ItemMeta vidro2 = vidro.getItemMeta();
    vidro2.setDisplayName("§bIf you buy a kit you need to relog to receive them");
    vidro.setItemMeta(vidro2);
    ItemStack[] arrayOfItemStack;
    int descpyro1 = (arrayOfItemStack = shop.getContents()).length;
    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
    {
      ItemStack item = arrayOfItemStack[metapyro1];
      if (item == null) {
        shop.setItem(shop.firstEmpty(), vidro);
      }
    }
    this.main = main;
  }
  
  private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore)
  {
    ItemStack item = new ItemStack(mat);
    ItemMeta meta = item.getItemMeta();
    meta.setDisplayName(name);
    meta.setLore(Arrays.asList(new String[] { lore }));
    item.setItemMeta(meta);
    inv.setItem(Slot, item);
  }
  
  @EventHandler
  public void quickcommand(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kpshop"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand1(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kploja"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand2(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/shopmenu"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  @EventHandler
  public void quickcommand3(PlayerCommandPreprocessEvent e)
  {
    if (e.getMessage().equalsIgnoreCase("/kitpvp shop"))
    {
      e.setCancelled(true);
      openMenu(e.getPlayer());
      if (!Join.game.contains(e.getPlayer().getName()))
      {
        e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
        e.getPlayer().closeInventory();
      }
    }
  }
  
  public void openMenu(Player p)
  {
    p.openInventory(shop);
    p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 1.0F, 1.0F);
  }
  
  @EventHandler
  public void kit(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    if (inv.getTitle().equals(shop.getName())) {
      e.setCancelled(true);
    }
  }
  
  @EventHandler
  public void warps(InventoryClickEvent e)
  {
    Inventory inv = e.getInventory();
    Player p = (Player)e.getWhoClicked();
    if (inv.getTitle().equals("Buy More Kits! :D"))
    {
      p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu-Click")), 1.0F, 1.0F);
      e.setCancelled(true);
    }
    ItemStack clicked = e.getCurrentItem();
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem() == null)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getType() == Material.AIR)) {
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER))
    {
      p.closeInventory();
      p.sendMessage("§2§lYou close the Shop Menu Successfully!");
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BOW)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 3000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.archer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.archer local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.archer global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.archer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.archer true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.archer");
        p.sendMessage("§6-> §cYou buy the Archer kit §e-3000 coins");
        Coins.removeCoins(p.getName(), 3000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FEATHER)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.airman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.airman local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.airman global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.airman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.airman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.airman");
        p.sendMessage("§6-> §cYou buy the Airman kit §e-9000 coins");
        Coins.removeCoins(p.getName(), 9000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.NETHER_STAR)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 12500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.naruto");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.naruto local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.naruto global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.naruto true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.naruto");
        p.sendMessage("§6-> §cYou buy the Naruto kit §e-12500 coins");
        Coins.removeCoins(p.getName(), 12500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 12500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_SWORD)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pvp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.pvp local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.pvp global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pvp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pvp true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.pvp");
        p.sendMessage("§6-> §cYou buy the PvP kit §e-3500 coins");
        Coins.removeCoins(p.getName(), 4500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_NUGGET)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 10000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.vampire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.vampire local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.vampire global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.vampire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.vampire true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.vampire");
        p.sendMessage("§6-> §cYou buy the Vampire kit §e-10000 coins");
        Coins.removeCoins(p.getName(), 10000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 10000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.COAL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ninja");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.ninja local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.ninja global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ninja true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.ninja");
        
        p.sendMessage("§6-> §cYou buy the Ninja kit §e-6500 coins");
        Coins.removeCoins(p.getName(), 6500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6-> § cMonk"))) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.monk");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.monk local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.monk global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.monk true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.monk");
        p.sendMessage("§6-> §cYou buy the Monk kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6-> § cWasp"))) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.wasp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.wasp local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.wasp global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.wasp");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.wasp true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.wasp");
        p.sendMessage("§6-> §cYou buy the Wasp kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_FENCE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 16000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.gladiator");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.gladiator local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.gladiator global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.gladiator true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.gladiator");
        p.sendMessage("§6-> §cYou buy the Gladiator kit §e-16000 coins");
        Coins.removeCoins(p.getName(), 16000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 16000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FIREWORK)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.kangaroo");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.kangaroo local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.kangaroo global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.kangaroo");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.kangaroo true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.kangaroo");
        p.sendMessage("§6-> §cYou buy the Kangaroo kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.STRING)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.spiderman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.spiderman local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.spiderman global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.spiderman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.spiderman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.spiderman");
        p.sendMessage("§6-> §cYou buy the PvP kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SPIDER_EYE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.viper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.viper local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.viper global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.viper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.viper");
        p.sendMessage("§6-> §cYou buy the Viper kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_AXE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.thor");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.thor local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.thor global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thor");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.thor true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.thor");
        p.sendMessage("§6-> §cYou buy the Thor kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER))
    {
      p.closeInventory();
      p.sendMessage(Main.messages.getString("ShopMenuClosed").replace("&", "§"));
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.REDSTONE_BLOCK)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.deshfire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.deshfire local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.deshfire global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.deshfire");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.deshfire true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.deshfire");
        
        p.sendMessage("§6-> §cYou buy the Deshfire kit §e-8500 coins");
        Coins.removeCoins(p.getName(), 8500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == null))
    {
      e.setCancelled(true);
      p.closeInventory();
      
      return;
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FLINT_AND_STEEL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pyro");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.pyro local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.pyro global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pyro");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pyro true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.pyro");
        p.sendMessage("§6-> §cYou buy the Pyro kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FERMENTED_SPIDER_EYE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.snail");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.snail local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.snail global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.snail true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.snail");
        p.sendMessage("§6-> §cYou buy the Snail kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.tank");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.tank local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.tank global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.tank");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.tank true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.tank");
        p.sendMessage("§6-> §cYou buy the Tank kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.WATCH)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.timelord");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.timelord local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.timelord global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.timelord true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.timelord");
        p.sendMessage("§6-> §cYou buy the Timelord kit §e-7000 coins");
        Coins.removeCoins(p.getName(), 7000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SNOW_BALL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.switcher");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.switcher local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.switcher global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.switcher");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.switcher true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.switcher");
        p.sendMessage("§6-> §cYou buy the Switcher kit §e-6000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.MAGMA_CREAM)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.jumper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.jumper local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.jumper global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jumper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.jumper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.jumper");
        p.sendMessage("§6-> §cYou buy the JUMPER kit §e-8000 coins");
        Coins.removeCoins(p.getName(), 8000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CACTUS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.cactus");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.cactus local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.cactus global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.cactus");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.cactus true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.cactus");
        p.sendMessage("§6-> §cYou buy the Cactus kit §e-4000 coins");
        Coins.removeCoins(p.getName(), 4000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.TNT)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.bomber");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.bomber local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.bomber global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.bomber");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.bomber true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.bomber");
        p.sendMessage("§6-> §cYou buy the Bomber kit §e-9000 coins");
        Coins.removeCoins(p.getName(), 9000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ENDER_PEARL)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.warper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.warper local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.warper global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.warper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.warper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.warper");
        p.sendMessage("§6-> §cYou buy the Warper kit §e-4000 coins");
        Coins.removeCoins(p.getName(), 4000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLDEN_APPLE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.critical");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.critical local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.critical global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.critical");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.critical true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.critical");
        p.sendMessage("§6-> §cYou buy the Critical kit §e-8000 coins");
        Coins.removeCoins(p.getName(), 8000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FISHING_ROD)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.fisherman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.fisherman local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.fisherman global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fisherman");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.fisherman true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.fisherman");
        p.sendMessage("§6-> §cYou buy the Fisherman kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 5000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ICE)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.freezer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.freezer local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.freezer global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.freezer");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.freezer true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.freezer");
        p.sendMessage("§6-> § cYou buy the Freezer kit §e-5000 coins");
        Coins.removeCoins(p.getName(), 6000.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 9500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.doublejump");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.doublejump local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.doublejump global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.doublejump true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.doublejump");
        p.sendMessage("§6-> § cYou buy the DoubleJump kit e-9500 coins");
        Coins.removeCoins(p.getName(), 9500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 9500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
    if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_BOOTS)) {
      if (Coins.getCoins(p.getName()).doubleValue() >= 17500.0D)
      {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.stomper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.stomper local");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addplayerpermission  kitpvp.kit.stomper global");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.stomper");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.stomper true");
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "manuaddp " + p.getName() + " kitpvp.kit.stomper");
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        Coins.removeCoins(p.getName(), 17500.0D);
        e.setCancelled(true);
        p.closeInventory();
      }
      else if (Coins.getCoins(p.getName()).doubleValue() < 17500.0D)
      {
        p.sendMessage(Main.messages.getString("NoFundsShop").replace("&", "§"));
        e.setCancelled(true);
        p.closeInventory();
      }
    }
  }
  
  public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
  {
    return false;
  }
}
