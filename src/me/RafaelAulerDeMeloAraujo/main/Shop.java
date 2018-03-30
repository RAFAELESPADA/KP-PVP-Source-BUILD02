/*     */ package me.RafaelAulerDeMeloAraujo.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import me.RafaelAulerDeMeloAraujo.Coins.Coins;
/*     */ import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Server;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Shop
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*  38 */   public static Inventory shop = Bukkit.getServer().createInventory(null, 54, "Buy More Kits! :D");
/*     */   
/*     */ 
/*     */   static
/*     */   {
/*  43 */     createButton(Material.DIAMOND_SWORD, shop, 0, "§6\u2714 §cPvP", "§ePrice: 4500");
/*  44 */     createButton(Material.BOW, shop, 1, "§6\u2714 §cArcher", "§ePrice: 3000");
/*  45 */     createButton(Material.FLINT_AND_STEEL, shop, 2, "§6\u2714 §cPyro", "§ePrice: 6000");
/*  46 */     createButton(Material.DIAMOND_CHESTPLATE, shop, 3, "§6\u2714 §cTank", "§ePrice: 7000");
/*  47 */     createButton(Material.SNOW_BALL, shop, 4, "§6\u2714 §cSwitcher", "§ePrice: 6500");
/*  48 */     createButton(Material.MAGMA_CREAM, shop, 5, "§6\u2714 §cJumper", "§ePrice: 8000");
/*  49 */     createButton(Material.CACTUS, shop, 6, "§6\u2714 §cCactus", "§ePrice: 4000");
/*  50 */     createButton(Material.TNT, shop, 7, "§6\u2714 §cBomber", "§ePrice: 9000");
/*  51 */     createButton(Material.ENDER_PEARL, shop, 8, "§6\u2714 §cWarper", "§ePrice: 4000");
/*     */     
/*     */ 
/*  54 */     createButton(Material.FISHING_ROD, shop, 9, "§6\u2714 §cFisherman", "§ePrice: 5000");
/*     */     
/*  56 */     createButton(Material.IRON_BOOTS, shop, 10, "§6\u2714 §cStomper", "§ePrice: 17500");
/*  57 */     createButton(Material.REDSTONE_BLOCK, shop, 11, "§6\u2714 §cDeshfire", "§ePrice: 8500");
/*  58 */     createButton(Material.SPIDER_EYE, shop, 12, "§6\u2714 §cViper", "§ePrice: 7000");
/*  59 */     createButton(Material.STRING, shop, 13, "§6\u2714 §cSpiderman", "§ePrice: 6000");
/*  60 */     createButton(Material.IRON_FENCE, shop, 14, "§6\u2714 §cGladiator", "§ePrice: 16000");
/*  61 */     createButton(Material.FIREWORK, shop, 15, "§6\u2714 §cKangaroo", "§ePrice: 5000");
/*  62 */     createButton(Material.COAL, shop, 16, "§6\u2714 §cNinja", "§ePrice: 6500");
/*  63 */     createButton(Material.WATCH, shop, 17, "§6\u2714 §cTimelord", "§ePrice: 7000");
/*  64 */     createButton(Material.GOLDEN_APPLE, shop, 18, "§6\u2714 §cCritical", "§ePrice: 8000");
/*  65 */     createButton(Material.BLAZE_ROD, shop, 19, "§6\u2714 §cMonk", "§ePrice: 5000");
/*  66 */     createButton(Material.CHAINMAIL_BOOTS, shop, 20, "§6\u2714 §cDoubleJump", "§ePrice: 9500");
/*  67 */     createButton(Material.GOLD_AXE, shop, 21, "§6\u2714 §cThor", "§ePrice: 7000");
/*  68 */     createButton(Material.FERMENTED_SPIDER_EYE, shop, 22, "§6\u2714 §cSnail", "§ePrice: 6000");
/*  69 */     createButton(Material.BLAZE_ROD, shop, 23, "§6\u2714 §cWasp", "§ePrice: 6000");
/*  70 */     createButton(Material.NETHER_STAR, shop, 24, "§6\u2714 §cNaruto", "§ePrice: 12500");
createButton(Material.FEATHER, shop, 25, "§6\u2714 §cAirman", "§ePrice: 9000");
/*  71 */     createButton(Material.BARRIER, shop, 53, "§4§l\u274C §cClose", "§bClose the menu!");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Shop(Main main)
/*     */   {
/* 782 */     ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
/* 783 */     ItemMeta vidro2 = vidro.getItemMeta();
/* 784 */     vidro2.setDisplayName("§bIf you buy a kit you need to relog to receive them");
/* 785 */     vidro.setItemMeta(vidro2);
/*     */     ItemStack[] arrayOfItemStack;
/* 787 */     int descpyro1 = (arrayOfItemStack = shop.getContents()).length;
/* 788 */     for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
/*     */     {
/* 790 */       ItemStack item = arrayOfItemStack[metapyro1];
/* 791 */       if (item == null) {
/* 792 */         shop.setItem(shop.firstEmpty(), vidro);
/*     */       }
/*     */     }
/*  77 */     this.main = main;
/*     */   }
/*     */   
/*     */   private static void createButton(Material mat, Inventory inv, int Slot, String name, String lore)
/*     */   {
/*  82 */     ItemStack item = new ItemStack(mat);
/*  83 */     ItemMeta meta = item.getItemMeta();
/*  84 */     meta.setDisplayName(name);
/*  85 */     meta.setLore(Arrays.asList(new String[] { lore }));
/*  86 */     item.setItemMeta(meta);
/*  87 */     inv.setItem(Slot, item);
/*     */   }
/*     */   
/*     */   @EventHandler
/*  91 */   public void quickcommand(PlayerCommandPreprocessEvent e) { if (e.getMessage().equalsIgnoreCase("/kpshop")) {
/*  92 */       e.setCancelled(true);
/*  93 */       openMenu(e.getPlayer());
/*  94 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/*  96 */         e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
/*  97 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void quickcommand1(PlayerCommandPreprocessEvent e)
/*     */   {
/* 105 */     if (e.getMessage().equalsIgnoreCase("/kploja")) {
/* 106 */       e.setCancelled(true);
/* 107 */       openMenu(e.getPlayer());
/* 108 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 110 */         e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
/* 111 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   @EventHandler
/*     */   public void quickcommand2(PlayerCommandPreprocessEvent e)
/*     */   {
/* 120 */     if (e.getMessage().equalsIgnoreCase("/shopmenu")) {
/* 121 */       e.setCancelled(true);
/* 122 */       openMenu(e.getPlayer());
/* 123 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 125 */         e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
/* 126 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   @EventHandler
/* 132 */   public void quickcommand3(PlayerCommandPreprocessEvent e) { if (e.getMessage().equalsIgnoreCase("/kitpvp shop")) {
/* 133 */       e.setCancelled(true);
/* 134 */       openMenu(e.getPlayer());
/* 135 */       if (!Join.game.contains(e.getPlayer().getName()))
/*     */       {
/* 137 */         e.getPlayer().sendMessage("§cYou must be in game to open shop menu!");
/* 138 */         e.getPlayer().closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void openMenu(Player p) {
/* 144 */     p.openInventory(shop);
/* 145 */     p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu")), 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void kit(InventoryClickEvent e)
/*     */   {
/* 151 */     Inventory inv = e.getInventory();
/*     */     
/* 153 */     if (inv.getTitle().equals(shop.getName()))
/*     */     {
/*     */ 
/* 156 */       e.setCancelled(true);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   @EventHandler
/*     */   public void warps(InventoryClickEvent e)
/*     */   {
/* 165 */     Inventory inv = e.getInventory();
/* 166 */     Player p = (Player)e.getWhoClicked();
/* 167 */     if (inv.getTitle().equals("Buy More Kits! :D"))
/*     */     {
/*     */ 
/* 170 */       p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.ShopMenu-Click")), 1.0F, 1.0F);
/* 171 */       e.setCancelled(true);
/*     */     }
/*     */     
/*     */ 
/* 175 */     ItemStack clicked = e.getCurrentItem();
/*     */     
/*     */ 
/* 178 */     if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem() == null))
/* 179 */       return;
/* 180 */     if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getType() == Material.AIR))
/* 181 */       return;
/* 182 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER)) {
/* 183 */       p.closeInventory();
/* 184 */       p.sendMessage("§2§lœ” §aYou close the Shop Menu Successfully!");
/*     */     }
/*     */     
/*     */ 
/* 188 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BOW)) {
/* 189 */       if (Coins.getCoins(p.getName()).doubleValue() >= 3000.0D)
/*     */       {
/* 191 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.archer");
/* 192 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.archer local");
/* 193 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.archer global");
/* 194 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.archer");
/* 195 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.archer true");
/* 196 */         p.sendMessage("§6\u2714 §cYou buy the Archer kit §e-3000 coins");
/* 197 */         Coins.removeCoins(p.getName(), 3000.0D);
/* 198 */         e.setCancelled(true);
/* 199 */         p.closeInventory();
/*     */ 
/*     */       }
/* 202 */       else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
/*     */       {
/* 204 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 205 */         e.setCancelled(true);
/* 206 */         p.closeInventory();
/*     */       }
/*     */     }
/* 188 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FEATHER)) {
/* 189 */       if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
/*     */       {
/* 191 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.airman");
/* 192 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.airman local");
/* 193 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.airman global");
/* 194 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.airman");
/* 195 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.airman true");
/* 196 */         p.sendMessage("§6\u2714 §cYou buy the Airman kit §e-9000 coins");
/* 197 */         Coins.removeCoins(p.getName(), 9000.0D);
/* 198 */         e.setCancelled(true);
/* 199 */         p.closeInventory();
/*     */ 
/*     */       }
/* 202 */       else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
/*     */       {
/* 204 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 205 */         e.setCancelled(true);
/* 206 */         p.closeInventory();
/*     */       }
/*     */     }
/* 209 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.NETHER_STAR)) {
/* 210 */       if (Coins.getCoins(p.getName()).doubleValue() >= 12500.0D)
/*     */       {
/* 212 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.naruto");
/* 213 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.naruto local");
/* 214 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.naruto global");
/* 215 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.naruto");
/* 216 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.naruto true");
/* 217 */         p.sendMessage("§6\u2714 §cYou buy the Naruto kit §e-12500 coins");
/* 218 */         Coins.removeCoins(p.getName(), 12500.0D);
/* 219 */         e.setCancelled(true);
/* 220 */         p.closeInventory();
/*     */ 
/*     */       }
/* 223 */       else if (Coins.getCoins(p.getName()).doubleValue() < 12500.0D)
/*     */       {
/* 225 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 226 */         e.setCancelled(true);
/* 227 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 232 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_SWORD)) {
/* 233 */       if (Coins.getCoins(p.getName()).doubleValue() >= 4500.0D)
/*     */       {
/* 235 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pvp");
/* 236 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pvp local");
/* 237 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pvp global");
/* 238 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pvp");
/* 239 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pvp true");
/* 240 */         p.sendMessage("§6\u2714 §cYou buy the PvP kit §e-3500 coins");
/* 241 */         Coins.removeCoins(p.getName(), 4500.0D);
/* 242 */         e.setCancelled(true);
/* 243 */         p.closeInventory();
/*     */ 
/*     */       }
/* 246 */       else if (Coins.getCoins(p.getName()).doubleValue() < 4500.0D)
/*     */       {
/* 248 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 249 */         e.setCancelled(true);
/* 250 */         p.closeInventory();
/*     */       }
/*     */     }
/* 253 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.COAL)) {
/* 254 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6500.0D)
/*     */       {
/* 256 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.ninja");
/* 257 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.ninja local");
/* 258 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.ninja global");
/* 259 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.ninja");
/* 260 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.ninja true");
/*     */         
/* 262 */         p.sendMessage("§6\u2714 §cYou buy the Ninja kit §e-6500 coins");
/* 263 */         Coins.removeCoins(p.getName(), 6500.0D);
/* 264 */         e.setCancelled(true);
/* 265 */         p.closeInventory();
/*     */ 
/*     */       }
/* 268 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6500.0D)
/*     */       {
/* 270 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 271 */         e.setCancelled(true);
/* 272 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/* 276 */     if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u2714 §cMonk"))) {
/* 277 */       if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
/*     */       {
/* 279 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.monk");
/* 280 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.monk local");
/* 281 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.monk global");
/* 282 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.monk");
/* 283 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.monk true");
/*     */         
/* 285 */         p.sendMessage("§6\u2714 §cYou buy the Monk kit §e-5000 coins");
/* 286 */         Coins.removeCoins(p.getName(), 5000.0D);
/* 287 */         e.setCancelled(true);
/* 288 */         p.closeInventory();
/*     */ 
/*     */       }
/* 291 */       else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
/*     */       {
/* 293 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 294 */         e.setCancelled(true);
/* 295 */         p.closeInventory();
/*     */       }
/*     */     }
/* 298 */     if ((inv.getName().equals(shop.getName())) && (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u2714 §cWasp"))) {
/* 299 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 301 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.wasp");
/* 302 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.wasp local");
/* 303 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.wasp global");
/* 304 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.wasp");
/* 305 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.wasp true");
/*     */         
/* 307 */         p.sendMessage("§6\u2714 §cYou buy the Wasp kit §e-6000 coins");
/* 308 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 309 */         e.setCancelled(true);
/* 310 */         p.closeInventory();
/*     */ 
/*     */       }
/* 313 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 315 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 316 */         e.setCancelled(true);
/* 317 */         p.closeInventory();
/*     */       }
/*     */     }
/* 320 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_FENCE)) {
/* 321 */       if (Coins.getCoins(p.getName()).doubleValue() >= 16000.0D)
/*     */       {
/* 323 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.gladiator");
/* 324 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.gladiator local");
/* 325 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.gladiator global");
/* 326 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.gladiator");
/* 327 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.gladiator true");
/*     */         
/* 329 */         p.sendMessage("§6\u2714 §cYou buy the Gladiator kit §e-16000 coins");
/* 330 */         Coins.removeCoins(p.getName(), 16000.0D);
/* 331 */         e.setCancelled(true);
/* 332 */         p.closeInventory();
/*     */ 
/*     */       }
/* 335 */       else if (Coins.getCoins(p.getName()).doubleValue() < 16000.0D)
/*     */       {
/* 337 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 338 */         e.setCancelled(true);
/* 339 */         p.closeInventory();
/*     */       }
/*     */     }
/* 342 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FIREWORK)) {
/* 343 */       if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
/*     */       {
/* 345 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.kangaroo");
/* 346 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.kangaroo local");
/* 347 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.kangaroo global");
/* 348 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.kangaroo");
/* 349 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.kangaroo true");
/*     */         
/* 351 */         p.sendMessage("§6\u2714 §cYou buy the Kangaroo kit §e-5000 coins");
/* 352 */         Coins.removeCoins(p.getName(), 5000.0D);
/* 353 */         e.setCancelled(true);
/* 354 */         p.closeInventory();
/*     */ 
/*     */       }
/* 357 */       else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
/*     */       {
/* 359 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 360 */         e.setCancelled(true);
/* 361 */         p.closeInventory();
/*     */       }
/*     */     }
/* 364 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.STRING)) {
/* 365 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 367 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.spiderman");
/* 368 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.spiderman local");
/* 369 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.spiderman global");
/* 370 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.spiderman");
/* 371 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.spiderman true");
/*     */         
/* 373 */         p.sendMessage("§6\u2714 §cYou buy the PvP kit §e-6000 coins");
/* 374 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 375 */         e.setCancelled(true);
/* 376 */         p.closeInventory();
/*     */ 
/*     */       }
/* 379 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 381 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 382 */         e.setCancelled(true);
/* 383 */         p.closeInventory();
/*     */       }
/*     */     }
/* 386 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SPIDER_EYE)) {
/* 387 */       if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
/*     */       {
/* 389 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.viper");
/* 390 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.viper local");
/* 391 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.viper global");
/* 392 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.viper");
/* 393 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.viper true");
/*     */         
/* 395 */         p.sendMessage("§6\u2714 §cYou buy the Viper kit §e-7000 coins");
/* 396 */         Coins.removeCoins(p.getName(), 7000.0D);
/* 397 */         e.setCancelled(true);
/* 398 */         p.closeInventory();
/*     */ 
/*     */       }
/* 401 */       else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
/*     */       {
/* 403 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 404 */         e.setCancelled(true);
/* 405 */         p.closeInventory();
/*     */       }
/*     */     }
/* 408 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLD_AXE)) {
/* 409 */       if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
/*     */       {
/* 411 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.thor");
/* 412 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.thor local");
/* 413 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.thor global");
/* 414 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.thor");
/* 415 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.thor true");
/*     */         
/* 417 */         p.sendMessage("§6\u2714 §cYou buy the Thor kit §e-7000 coins");
/* 418 */         Coins.removeCoins(p.getName(), 7000.0D);
/* 419 */         e.setCancelled(true);
/* 420 */         p.closeInventory();
/*     */ 
/*     */       }
/* 423 */       else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
/*     */       {
/* 425 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 426 */         e.setCancelled(true);
/* 427 */         p.closeInventory();
/*     */       }
/*     */     }
/* 430 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.BARRIER)) {
/* 431 */       p.closeInventory();
/* 432 */       p.sendMessage("§2§lœ” §aYou close the Shop Menu Successfully!");
/*     */     }
/*     */     
/* 435 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.REDSTONE_BLOCK)) {
/* 436 */       if (Coins.getCoins(p.getName()).doubleValue() >= 8500.0D)
/*     */       {
/* 438 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.deshfire");
/* 439 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.deshfire local");
/* 440 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.deshfire global");
/* 441 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.deshfire");
/* 442 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.deshfire true");
/*     */         
/* 444 */         p.sendMessage("§6\u2714 §cYou buy the Deshfire kit §e-8500 coins");
/* 445 */         Coins.removeCoins(p.getName(), 8500.0D);
/* 446 */         e.setCancelled(true);
/* 447 */         p.closeInventory();
/*     */ 
/*     */       }
/* 450 */       else if (Coins.getCoins(p.getName()).doubleValue() < 8500.0D)
/*     */       {
/* 452 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 453 */         e.setCancelled(true);
/* 454 */         p.closeInventory();
/*     */       }
/*     */     }
/* 457 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == null)) {
/* 458 */       e.setCancelled(true);
/* 459 */       p.closeInventory();
/*     */       
/* 461 */       return;
/*     */     }
/*     */     
/*     */ 
/* 465 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FLINT_AND_STEEL)) {
/* 466 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 468 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.pyro");
/* 469 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pyro local");
/* 470 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.pyro global");
/* 471 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.pyro");
/* 472 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.pyro true");
/*     */         
/* 474 */         p.sendMessage("§6\u2714 §cYou buy the Pyro kit §e-6000 coins");
/* 475 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 476 */         e.setCancelled(true);
/* 477 */         p.closeInventory();
/*     */       }
/* 479 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 481 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 482 */         e.setCancelled(true);
/* 483 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/* 487 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FERMENTED_SPIDER_EYE)) {
/* 488 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 490 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.snail");
/* 491 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.snail local");
/* 492 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.snail global");
/* 493 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.snail");
/* 494 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.snail true");
/*     */         
/* 496 */         p.sendMessage("§6\u2714 §cYou buy the Snail kit §e-6000 coins");
/* 497 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 498 */         e.setCancelled(true);
/* 499 */         p.closeInventory();
/*     */       }
/* 501 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 503 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 504 */         e.setCancelled(true);
/* 505 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/* 509 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.DIAMOND_CHESTPLATE)) {
/* 510 */       if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
/*     */       {
/* 512 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.tank");
/* 513 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.tank local");
/* 514 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.tank global");
/* 515 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.tank");
/* 516 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.tank true");
/*     */         
/* 518 */         p.sendMessage("§6\u2714 §cYou buy the Tank kit §e-7000 coins");
/* 519 */         Coins.removeCoins(p.getName(), 7000.0D);
/* 520 */         e.setCancelled(true);
/* 521 */         p.closeInventory();
/*     */       }
/* 523 */       else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
/*     */       {
/* 525 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 526 */         e.setCancelled(true);
/* 527 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/* 531 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.WATCH)) {
/* 532 */       if (Coins.getCoins(p.getName()).doubleValue() >= 7000.0D)
/*     */       {
/* 534 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.timelord");
/* 535 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.timelord local");
/* 536 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.timelord global");
/* 537 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.timelord");
/* 538 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.timelord true");
/*     */         
/* 540 */         p.sendMessage("§6\u2714 §cYou buy the Timelord kit §e-7000 coins");
/* 541 */         Coins.removeCoins(p.getName(), 7000.0D);
/* 542 */         e.setCancelled(true);
/* 543 */         p.closeInventory();
/*     */       }
/* 545 */       else if (Coins.getCoins(p.getName()).doubleValue() < 7000.0D)
/*     */       {
/* 547 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 548 */         e.setCancelled(true);
/* 549 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */     
/* 553 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.SNOW_BALL)) {
/* 554 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 556 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.switcher");
/* 557 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.switcher local");
/* 558 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.switcher global");
/* 559 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.switcher");
/* 560 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.switcher true");
/*     */         
/* 562 */         p.sendMessage("§6\u2714 §cYou buy the Switcher kit §e-6000 coins");
/* 563 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 564 */         e.setCancelled(true);
/* 565 */         p.closeInventory();
/*     */       }
/* 567 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 569 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 570 */         e.setCancelled(true);
/* 571 */         p.closeInventory();
/*     */       }
/*     */     }
/* 574 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.MAGMA_CREAM)) {
/* 575 */       if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
/*     */       {
/* 577 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.jumper");
/* 578 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.jumper local");
/* 579 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.jumper global");
/* 580 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.jumper");
/* 581 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.jumper true");
/*     */         
/* 583 */         p.sendMessage("§6\u2714 §cYou buy the JUMPER kit §e-8000 coins");
/* 584 */         Coins.removeCoins(p.getName(), 8000.0D);
/* 585 */         e.setCancelled(true);
/* 586 */         p.closeInventory();
/*     */       }
/* 588 */       else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
/*     */       {
/* 590 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 591 */         e.setCancelled(true);
/* 592 */         p.closeInventory();
/*     */       }
/*     */     }
/* 595 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CACTUS)) {
/* 596 */       if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
/*     */       {
/* 598 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.cactus");
/* 599 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.cactus local");
/* 600 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.cactus global");
/* 601 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.cactus");
/* 602 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.cactus true");
/*     */         
/* 604 */         p.sendMessage("§6\u2714 §cYou buy the Cactus kit §e-4000 coins");
/* 605 */         Coins.removeCoins(p.getName(), 4000.0D);
/* 606 */         e.setCancelled(true);
/* 607 */         p.closeInventory();
/*     */       }
/* 609 */       else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
/*     */       {
/* 611 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 612 */         e.setCancelled(true);
/* 613 */         p.closeInventory();
/*     */       }
/*     */     }
/* 616 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.TNT)) {
/* 617 */       if (Coins.getCoins(p.getName()).doubleValue() >= 9000.0D)
/*     */       {
/* 619 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.bomber");
/* 620 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.bomber local");
/* 621 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.bomber global");
/* 622 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.bomber");
/* 623 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.bomber true");
/*     */         
/* 625 */         p.sendMessage("§6\u2714 §cYou buy the Bomber kit §e-9000 coins");
/* 626 */         Coins.removeCoins(p.getName(), 9000.0D);
/* 627 */         e.setCancelled(true);
/* 628 */         p.closeInventory();
/*     */       }
/* 630 */       else if (Coins.getCoins(p.getName()).doubleValue() < 9000.0D)
/*     */       {
/* 632 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 633 */         e.setCancelled(true);
/* 634 */         p.closeInventory();
/*     */       }
/*     */     }
/* 637 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ENDER_PEARL)) {
/* 638 */       if (Coins.getCoins(p.getName()).doubleValue() >= 4000.0D)
/*     */       {
/* 640 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.warper");
/* 641 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.warper local");
/* 642 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.warper global");
/* 643 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.warper");
/* 644 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.warper true");
/*     */         
/* 646 */         p.sendMessage("§6\u2714 §cYou buy the Warper kit §e-4000 coins");
/* 647 */         Coins.removeCoins(p.getName(), 4000.0D);
/* 648 */         e.setCancelled(true);
/* 649 */         p.closeInventory();
/*     */       }
/* 651 */       else if (Coins.getCoins(p.getName()).doubleValue() < 4000.0D)
/*     */       {
/* 653 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 654 */         e.setCancelled(true);
/* 655 */         p.closeInventory();
/*     */       }
/*     */     }
/* 658 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.GOLDEN_APPLE)) {
/* 659 */       if (Coins.getCoins(p.getName()).doubleValue() >= 8000.0D)
/*     */       {
/* 661 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.critical");
/* 662 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.critical local");
/* 663 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.critical global");
/* 664 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.critical");
/* 665 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.critical true");
/*     */         
/* 667 */         p.sendMessage("§6\u2714 §cYou buy the Critical kit §e-8000 coins");
/* 668 */         Coins.removeCoins(p.getName(), 8000.0D);
/* 669 */         e.setCancelled(true);
/* 670 */         p.closeInventory();
/*     */       }
/* 672 */       else if (Coins.getCoins(p.getName()).doubleValue() < 8000.0D)
/*     */       {
/* 674 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 675 */         e.setCancelled(true);
/* 676 */         p.closeInventory();
/*     */       }
/*     */     }
/* 679 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.FISHING_ROD)) {
/* 680 */       if (Coins.getCoins(p.getName()).doubleValue() >= 5000.0D)
/*     */       {
/* 682 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.fisherman");
/* 683 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.fisherman local");
/* 684 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.fisherman global");
/* 685 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.fisherman");
/* 686 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.fisherman true");
/*     */         
/* 688 */         p.sendMessage("§6\u2714 §cYou buy the Fisherman kit §e-5000 coins");
/* 689 */         Coins.removeCoins(p.getName(), 5000.0D);
/* 690 */         e.setCancelled(true);
/* 691 */         p.closeInventory();
/*     */       }
/* 693 */       else if (Coins.getCoins(p.getName()).doubleValue() < 5000.0D)
/*     */       {
/* 695 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 696 */         e.setCancelled(true);
/* 697 */         p.closeInventory();
/*     */       }
/*     */     }
/* 700 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.ICE)) {
/* 701 */       if (Coins.getCoins(p.getName()).doubleValue() >= 6000.0D)
/*     */       {
/* 703 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.freezer");
/* 704 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.freezer local");
/* 705 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.freezer global");
/* 706 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.freezer");
/* 707 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.freezer true");
/*     */         
/* 709 */         p.sendMessage("§6\u2714 §cYou buy the Freezer kit §e-5000 coins");
/* 710 */         Coins.removeCoins(p.getName(), 6000.0D);
/* 711 */         e.setCancelled(true);
/* 712 */         p.closeInventory();
/*     */       }
/* 714 */       else if (Coins.getCoins(p.getName()).doubleValue() < 6000.0D)
/*     */       {
/* 716 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 717 */         e.setCancelled(true);
/* 718 */         p.closeInventory();
/*     */       }
/*     */     }
/* 721 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.CHAINMAIL_BOOTS)) {
/* 722 */       if (Coins.getCoins(p.getName()).doubleValue() >= 9500.0D)
/*     */       {
/* 724 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.doublejump");
/* 725 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.doublejump local");
/* 726 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.doublejump global");
/* 727 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.doublejump");
/* 728 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.doublejump true");
/*     */         
/* 730 */         p.sendMessage("§6\u2714 §cYou buy the DoubleJump kit §e-9500 coins");
/* 731 */         Coins.removeCoins(p.getName(), 9500.0D);
/* 732 */         e.setCancelled(true);
/* 733 */         p.closeInventory();
/*     */       }
/* 735 */       else if (Coins.getCoins(p.getName()).doubleValue() < 9500.0D)
/*     */       {
/* 737 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 738 */         e.setCancelled(true);
/* 739 */         p.closeInventory();
/*     */       }
/*     */     }
/* 742 */     if ((inv.getName().equals(shop.getName())) && (clicked.getType() == Material.IRON_BOOTS)) {
/* 743 */       if (Coins.getCoins(p.getName()).doubleValue() >= 17500.0D)
/*     */       {
/* 745 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "permissions player " + p.getName() + " set kitpvp.kit.stomper");
/* 746 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.stomper local");
/* 747 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "upc " + p.getName() + " addpermission  kitpvp.kit.stomper global");
/* 748 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + p.getName() + " add kitpvp.kit.stomper");
/* 749 */         Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + p.getName() + " permission set kitpvp.kit.stomper true");
/*     */         
/* 751 */         p.sendMessage("§6\u2714 §cYou buy the Stomper kit §e-17500 coins");
/* 752 */         Coins.removeCoins(p.getName(), 17500.0D);
/* 753 */         e.setCancelled(true);
/* 754 */         p.closeInventory();
/*     */       }
/* 756 */       else if (Coins.getCoins(p.getName()).doubleValue() < 17500.0D)
/*     */       {
/* 758 */         p.sendMessage("§4§l\u274C You dont have Money to buy this kit!");
/* 759 */         e.setCancelled(true);
/* 760 */         p.closeInventory();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3)
/*     */   {
/* 779 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\main\Shop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
