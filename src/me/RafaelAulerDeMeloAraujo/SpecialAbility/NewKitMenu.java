/*     */ package me.RafaelAulerDeMeloAraujo.SpecialAbility;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import me.RafaelAulerDeMeloAraujo.main.Main;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandExecutor;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.event.EventHandler;
/*     */ import org.bukkit.event.Listener;
/*     */ import org.bukkit.event.inventory.InventoryClickEvent;
/*     */ import org.bukkit.inventory.Inventory;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NewKitMenu
/*     */   implements Listener, CommandExecutor
/*     */ {
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public NewKitMenu(Main main)
/*     */   {
/*  31 */     this.main = main;
/*  32 */     plugin = main;
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
/*     */   @EventHandler
/*     */   public void kits(InventoryClickEvent e)
/*     */   {
/*  48 */     if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
/*     */     {
/*  50 */       Inventory inv = e.getInventory();
/*  51 */       Player p = (Player)e.getWhoClicked();
/*  52 */       if (inv.getTitle().equals("§bKit Menu"))
/*     */       {
/*  54 */         p.playSound(p.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitMenu")), 1.0F, 1.0F);
/*     */         
/*  56 */         e.setCancelled(true);
/*     */         
/*     */ 
/*     */ 
/*  60 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPvP")) {
/*  61 */           Bukkit.dispatchCommand(p, "kpvp");
/*  62 */           p.closeInventory();
/*     */         }
/*     */         
/*  65 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lArcher"))
/*     */         {
/*  67 */           Bukkit.dispatchCommand(p, "archer");
/*  68 */           p.closeInventory();
/*     */         }
/*  70 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lWarper"))
/*     */         {
/*  72 */           Bukkit.dispatchCommand(p, "warper");
/*  73 */           p.closeInventory();
/*     */         }
/*     */         
/*  76 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lKangaroo"))
/*     */         {
/*  78 */           Bukkit.dispatchCommand(p, "kangaroo");
/*  79 */           p.closeInventory();
/*     */         }
/*  81 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lFisherman"))
/*     */         {
/*  83 */           Bukkit.dispatchCommand(p, "fisherman");
/*  84 */           p.closeInventory();
/*     */         }
/*  86 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lGladiator"))
/*     */         {
/*  88 */           Bukkit.dispatchCommand(p, "gladiator");
/*  89 */           p.closeInventory();
/*     */         }
/*  91 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCritical"))
/*     */         {
/*  93 */           Bukkit.dispatchCommand(p, "critical");
/*  94 */           p.closeInventory();
/*     */         }
/*  96 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lMonk"))
/*     */         {
/*  98 */           Bukkit.dispatchCommand(p, "monk");
/*  99 */           p.closeInventory();
/*     */         }
/* 101 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSnail"))
/*     */         {
/* 103 */           Bukkit.dispatchCommand(p, "snail");
/* 104 */           p.closeInventory();
/*     */         }
/* 106 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lViper"))
/*     */         {
/* 108 */           Bukkit.dispatchCommand(p, "viper");
/* 109 */           p.closeInventory();
/*     */         }
/* 111 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lThor"))
/*     */         {
/* 113 */           Bukkit.dispatchCommand(p, "kthor");
/* 114 */           p.closeInventory();
/*     */         }
/* 116 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNinja"))
/*     */         {
/* 118 */           Bukkit.dispatchCommand(p, "ninja");
/* 119 */           p.closeInventory();
/*     */         }
/* 121 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lStomper"))
/*     */         {
/* 123 */           Bukkit.dispatchCommand(p, "stomper");
/* 124 */           p.closeInventory();
/*     */         }
/* 126 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTimeLord"))
/*     */         {
/* 128 */           Bukkit.dispatchCommand(p, "timelord");
/* 129 */           p.closeInventory();
/*     */         }
/* 131 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDoubleJump"))
/*     */         {
/* 133 */           Bukkit.dispatchCommand(p, "doublejump");
/* 134 */           p.closeInventory();
/*     */         }
/* 136 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lJumper"))
/*     */         {
/* 138 */           Bukkit.dispatchCommand(p, "jumper");
/* 139 */           p.closeInventory();
/*     */         }
/* 141 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lCactus"))
/*     */         {
/* 143 */           Bukkit.dispatchCommand(p, "cactus");
/* 144 */           p.closeInventory();
/*     */         }
/* 146 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lNaruto"))
/*     */         {
/* 148 */           Bukkit.dispatchCommand(p, "naruto");
/* 149 */           p.closeInventory();
/*     */         }
/* 151 */         if ((inv.getName().equals("§bKit Menu")) && (e.getCurrentItem().getType() == Material.BARRIER)) {
/* 152 */           p.closeInventory();
/* 153 */           p.sendMessage("§2§lœ” §aYou close the Kit Menu Successfully!");
/*     */         }
/*     */         
/* 156 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBomber"))
/*     */         {
/* 158 */           Bukkit.dispatchCommand(p, "bomber");
/* 159 */           p.closeInventory();
/*     */         }
/* 161 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lBasic"))
/*     */         {
/* 163 */           Bukkit.dispatchCommand(p, "basic");
/* 164 */           p.closeInventory();
/*     */         }
/* 166 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSpiderman"))
/*     */         {
/* 168 */           Bukkit.dispatchCommand(p, "spiderman");
/* 169 */           p.closeInventory();
/*     */         }
/* 171 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lAirman"))
/*     */         {
/* 173 */           Bukkit.dispatchCommand(p, "airman");
/* 174 */           p.closeInventory();
/*     */         }
/* 176 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lSwitcher"))
/*     */         {
/* 178 */           Bukkit.dispatchCommand(p, "switcher");
/* 179 */           p.closeInventory();
/*     */         }
/* 181 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lWasp"))
/*     */         {
/* 183 */           Bukkit.dispatchCommand(p, "wasp");
/* 184 */           p.closeInventory();
/*     */         }
/* 186 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lPyro"))
/*     */         {
/* 188 */           Bukkit.dispatchCommand(p, "pyro");
/* 189 */           p.closeInventory();
/*     */         }
/* 191 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lTank"))
/*     */         {
/* 193 */           Bukkit.dispatchCommand(p, "tank");
/* 194 */           p.closeInventory();
/*     */         }
/* 196 */         if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7Kit §e§lDeshfire"))
/*     */         {
/* 198 */           Bukkit.dispatchCommand(p, "deshfire");
/* 199 */           p.closeInventory();
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args)
/*     */   {
/* 209 */     if (!(sender instanceof Player)) {
/* 210 */       return true;
/*     */     }
/* 212 */     Player p = (Player)sender;
/* 213 */     if (cmd.getName().equalsIgnoreCase("kpkitmenu"))
/*     */     {
/* 215 */       Inventory kits = Bukkit.createInventory(p, 54, "§bKit Menu");
/*     */       
/* 217 */       ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
/* 218 */       ItemMeta vidro2 = vidro.getItemMeta();
/* 219 */       vidro2.setDisplayName("§cSlot blocked. Buy more kits on shop to unlock!");
/* 220 */       vidro.setItemMeta(vidro2);
/*     */       
/* 222 */       ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)7);
/* 223 */       ItemMeta vidro12 = vidro1.getItemMeta();
/* 224 */       vidro12.setDisplayName("§a§k========");
/* 225 */       vidro1.setItemMeta(vidro12);
/*     */       
/* 227 */       ItemStack barrier = new ItemStack(Material.BARRIER);
/* 228 */       ItemMeta barrier2 = barrier.getItemMeta();
/* 229 */       barrier2.setDisplayName("§4§lœ– §a§lClose the Kit Menu");
/* 230 */       barrier.setItemMeta(barrier2);
/*     */       
/*     */ 
/* 233 */       kits.setItem(27, vidro1);
/* 234 */       kits.setItem(28, vidro1);
/* 235 */       kits.setItem(29, vidro1);
/* 236 */       kits.setItem(30, vidro1);
/* 237 */       kits.setItem(31, vidro1);
/* 238 */       kits.setItem(32, vidro1);
/* 239 */       kits.setItem(33, vidro1);
/* 240 */       kits.setItem(34, vidro1);
/* 241 */       kits.setItem(35, vidro1);
/* 242 */       kits.setItem(36, vidro1);
/* 243 */       kits.setItem(37, vidro1);
/* 244 */       kits.setItem(38, vidro1);
/* 245 */       kits.setItem(39, vidro1);
/* 246 */       kits.setItem(40, vidro1);
/* 247 */       kits.setItem(41, vidro1);
/* 248 */       kits.setItem(42, vidro1);
/* 249 */       kits.setItem(43, vidro1);
/* 250 */       kits.setItem(44, vidro1);
/* 251 */       kits.setItem(45, vidro1);
/* 252 */       kits.setItem(46, vidro1);
/* 253 */       kits.setItem(47, vidro1);
/* 254 */       kits.setItem(48, vidro1);
/* 255 */       kits.setItem(49, vidro1);
/* 256 */       kits.setItem(50, vidro1);
/* 257 */       kits.setItem(51, vidro1);
/* 258 */       kits.setItem(52, vidro1);
/* 259 */       kits.setItem(53, barrier);

/* 272 */        {
/* 273 */         ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
/* 274 */         ItemMeta metapyro = pyro.getItemMeta();
/* 275 */         metapyro.setDisplayName("§7Kit §e§lBasic");
/* 276 */         ArrayList indiob = new ArrayList();
/* 277 */         indiob.add("§7A Basic and Standard kit!");
/* 278 */         metapyro.setLore(indiob);
/* 279 */         pyro.setItemMeta(metapyro);
/* 280 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 272 */       if (p.hasPermission("kitpvp.kit.pvp")) {
/* 273 */         ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
/* 274 */         ItemMeta metapyro = pyro.getItemMeta();
/* 275 */         metapyro.setDisplayName("§7Kit §e§lPvP");
/* 276 */         ArrayList indiob = new ArrayList();
/* 277 */         indiob.add("§7A Stronger version of basic kit !");
/* 278 */         metapyro.setLore(indiob);
/* 279 */         pyro.setItemMeta(metapyro);
/* 280 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 282 */       if (p.hasPermission("kitpvp.kit.kangaroo")) {
/* 283 */         ItemStack pyro = new ItemStack(Material.FIREWORK);
/* 284 */         ItemMeta metapyro = pyro.getItemMeta();
/* 285 */         metapyro.setDisplayName("§7Kit §e§lKangaroo");
/* 286 */         ArrayList indiob = new ArrayList();
/* 287 */         indiob.add("§7Do double jumps");
/* 288 */         indiob.add("§7using your firework !");
/* 289 */         metapyro.setLore(indiob);
/* 290 */         pyro.setItemMeta(metapyro);
/* 291 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 293 */       if (p.hasPermission("kitpvp.kit.archer")) {
/* 294 */         ItemStack pyro = new ItemStack(Material.BOW);
/* 295 */         ItemMeta metapyro = pyro.getItemMeta();
/* 296 */         metapyro.setDisplayName("§7Kit §e§lArcher");
/* 297 */         ArrayList indiob = new ArrayList();
/* 298 */         indiob.add("§7Starts with sword,bow and arrows !");
/* 299 */         metapyro.setLore(indiob);
/* 300 */         pyro.setItemMeta(metapyro);
/* 301 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 303 */       if (p.hasPermission("kitpvp.kit.tank")) {
/* 304 */         ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
/*     */         
/* 306 */         ItemMeta metapyro = pyro.getItemMeta();
/* 307 */         metapyro.setDisplayName("§7Kit §e§lTank");
/* 308 */         ArrayList indiob = new ArrayList();
/* 309 */         indiob.add("§7Your armor is strong !");
/* 310 */         indiob.add("§7but you are slow!");
/* 311 */         metapyro.setLore(indiob);
/* 312 */         pyro.setItemMeta(metapyro);
/* 313 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 315 */       if (p.hasPermission("kitpvp.kit.snail")) {
/* 316 */         ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
/* 317 */         ItemMeta metapyro = pyro.getItemMeta();
/* 318 */         metapyro.setDisplayName("§7Kit §e§lSnail");
/* 319 */         ArrayList indiob = new ArrayList();
/* 320 */         indiob.add("§7Have a 33% chance do give slow a each hit !");
/* 321 */         metapyro.setLore(indiob);
/* 322 */         pyro.setItemMeta(metapyro);
/* 323 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 325 */       if (p.hasPermission("kitpvp.kit.viper")) {
/* 326 */         ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
/* 327 */         ItemMeta metapyro = pyro.getItemMeta();
/* 328 */         metapyro.setDisplayName("§7Kit §e§lViper");
/* 329 */         ArrayList indiob = new ArrayList();
/* 330 */         indiob.add("§7Have a 33% chance do give slow a each hit !!");
/* 331 */         metapyro.setLore(indiob);
/* 332 */         pyro.setItemMeta(metapyro);
/* 333 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 335 */       if (p.hasPermission("kitpvp.kit.stomper")) {
/* 336 */         ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
/* 337 */         ItemMeta metapyro = pyro.getItemMeta();
/* 338 */         metapyro.setDisplayName("§7Kit §e§lStomper");
/* 339 */         ArrayList indiob = new ArrayList();
/* 340 */         indiob.add("§7Get a boost");
/* 341 */         indiob.add("§7and smash your enemies");
/* 342 */         metapyro.setLore(indiob);
/* 343 */         pyro.setItemMeta(metapyro);
/* 344 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 346 */       if (p.hasPermission("kitpvp.kit.deshfire")) {
/* 347 */         ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
/* 348 */         ItemMeta metapyro = pyro.getItemMeta();
/* 349 */         metapyro.setDisplayName("§7Kit §e§lDeshfire");
/* 350 */         ArrayList indiob = new ArrayList();
/* 351 */         indiob.add("§7Get a boost");
/* 352 */         indiob.add("§7and put your enemies on fire!");
/* 353 */         metapyro.setLore(indiob);
/* 354 */         pyro.setItemMeta(metapyro);
/* 355 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 357 */       if (p.hasPermission("kitpvp.kit.monk")) {
/* 358 */         ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
/* 359 */         ItemMeta metapyro = pyro.getItemMeta();
/* 360 */         metapyro.setDisplayName("§7Kit §e§lMonk");
/* 361 */         ArrayList indiob = new ArrayList();
/* 362 */         indiob.add("§7Right click on your enemy");
/* 363 */         indiob.add("§7And mix they inventory");
/* 364 */         metapyro.setLore(indiob);
/* 365 */         pyro.setItemMeta(metapyro);
/* 366 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 368 */       if (p.hasPermission("kitpvp.kit.critical")) {
/* 369 */         ItemStack pyro = new ItemStack(Material.GOLDEN_APPLE);
/* 370 */         ItemMeta metapyro = pyro.getItemMeta();
/* 371 */         metapyro.setDisplayName("§7Kit §e§lCritical");
/* 372 */         ArrayList indiob = new ArrayList();
/* 373 */         indiob.add("§7Have a 10% of chance to do more damage on each hit!");
/* 374 */         metapyro.setLore(indiob);
/* 375 */         pyro.setItemMeta(metapyro);
/* 376 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 378 */       if (p.hasPermission("kitpvp.kit.gladiator")) {
/* 379 */         ItemStack pyro = new ItemStack(Material.IRON_FENCE);
/* 380 */         ItemMeta metapyro = pyro.getItemMeta();
/* 381 */         metapyro.setDisplayName("§7Kit §e§lGladiator");
/* 382 */         ArrayList indiob = new ArrayList();
/* 383 */         indiob.add("§7Challenge someome into you glass arena!");
/* 384 */         metapyro.setLore(indiob);
/* 385 */         pyro.setItemMeta(metapyro);
/* 386 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 388 */       if (p.hasPermission("kitpvp.kit.thor")) {
/* 389 */         ItemStack pyro = new ItemStack(Material.GOLD_AXE);
/* 390 */         ItemMeta metapyro = pyro.getItemMeta();
/* 391 */         metapyro.setDisplayName("§7Kit §e§lThor");
/* 392 */         ArrayList indiob = new ArrayList();
/* 393 */         indiob.add("§7Thunderbolts with your axe");
/* 394 */         indiob.add("§7and be immune to them");
/* 395 */         metapyro.setLore(indiob);
/* 396 */         pyro.setItemMeta(metapyro);
/* 397 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 399 */       if (p.hasPermission("kitpvp.kit.doublejump")) {
/* 400 */         ItemStack pyro = new ItemStack(Material.CHAINMAIL_BOOTS);
/* 401 */         ItemMeta metapyro = pyro.getItemMeta();
/* 402 */         metapyro.setDisplayName("§7Kit §e§lDoubleJump");
/* 403 */         ArrayList indiob = new ArrayList();
/* 404 */         indiob.add("§7Press space two times");
/* 405 */         indiob.add("§7and do a doublejump");
/* 406 */         metapyro.setLore(indiob);
/* 407 */         pyro.setItemMeta(metapyro);
/* 408 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 410 */       if (p.hasPermission("kitpvp.kit.bomber")) {
/* 411 */         ItemStack pyro = new ItemStack(Material.TNT);
/* 412 */         ItemMeta metapyro = pyro.getItemMeta();
/* 413 */         metapyro.setDisplayName("§7Kit §e§lBomber");
/* 414 */         ArrayList indiob = new ArrayList();
/* 415 */         indiob.add("§7Throws tnt and");
/* 416 */         indiob.add("§7become a terrorist");
/* 417 */         metapyro.setLore(indiob);
/* 418 */         pyro.setItemMeta(metapyro);
/* 419 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 421 */       if (p.hasPermission("kitpvp.kit.wasp")) {
/* 422 */         ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
/* 423 */         ItemMeta metapyro = pyro.getItemMeta();
/* 424 */         metapyro.setDisplayName("§7Kit §e§lWasp");
/* 425 */         ArrayList indiob = new ArrayList();
/* 426 */         indiob.add("§7Starts with a");
/* 427 */         indiob.add("§7Sharp VII BlazeHod");
/* 428 */         metapyro.setLore(indiob);
/* 429 */         pyro.setItemMeta(metapyro);
/* 430 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 432 */       if (p.hasPermission("kitpvp.kit.airman")) {
/* 433 */         ItemStack pyro = new ItemStack(Material.FEATHER);
/* 434 */         ItemMeta metapyro = pyro.getItemMeta();
/* 435 */         metapyro.setDisplayName("§7Kit §e§lAirman");
/* 436 */         ArrayList indiob = new ArrayList();
/* 437 */         indiob.add("§7With this kit");
/* 438 */         indiob.add("§7your can fly with your feather");
/* 439 */         metapyro.setLore(indiob);
/* 440 */         pyro.setItemMeta(metapyro);
/* 441 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 443 */       if (p.hasPermission("kitpvp.kit.switcher"))
/*     */       {
/* 445 */         ItemStack pyro = new ItemStack(Material.SNOW_BALL, 16);
/* 446 */         ItemMeta metapyro = pyro.getItemMeta();
/* 447 */         metapyro.setDisplayName("§7Kit §e§lSwitcher");
/* 448 */         ArrayList indiob = new ArrayList();
/* 449 */         indiob.add("§7Swap your location with your enemy");
/* 450 */         indiob.add("§7With your snowballs!");
/* 451 */         metapyro.setLore(indiob);
/* 452 */         pyro.setItemMeta(metapyro);
/* 453 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 455 */       if (p.hasPermission("kitpvp.kit.ninja")) {
/* 456 */         ItemStack pyro = new ItemStack(Material.COAL);
/* 457 */         ItemMeta metapyro = pyro.getItemMeta();
/* 458 */         metapyro.setDisplayName("§7Kit §e§lNinja");
/* 459 */         ArrayList indiob = new ArrayList();
/* 460 */         metapyro.setLore(indiob);
/* 461 */         indiob.add("§7If you hurt a player and");
/* 462 */         indiob.add("§7and sneak you get");
/* 463 */         indiob.add("§7Teleported to him");
/* 464 */         metapyro.setLore(indiob);
/* 465 */         pyro.setItemMeta(metapyro);
/* 466 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 468 */       if (p.hasPermission("kitpvp.kit.cactus")) {
/* 469 */         ItemStack pyro = new ItemStack(Material.CACTUS);
/* 470 */         ItemMeta metapyro = pyro.getItemMeta();
/* 471 */         metapyro.setDisplayName("§7Kit §e§lCactus");
/* 472 */         ArrayList indiob = new ArrayList();
/* 473 */         indiob.add("§7Get a thorns armor");
/*     */         
/* 475 */         metapyro.setLore(indiob);
/* 476 */         pyro.setItemMeta(metapyro);
/* 477 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 479 */       if (p.hasPermission("kitpvp.kit.pyro")) {
/* 480 */         ItemStack pyro = new ItemStack(Material.FLINT_AND_STEEL);
/* 481 */         ItemMeta metapyro = pyro.getItemMeta();
/* 482 */         metapyro.setDisplayName("§7Kit §e§lPyro");
/* 483 */         ArrayList indiob = new ArrayList();
/* 484 */         indiob.add("§7Starts with a fire bow and fire sword");
/*     */         
/* 486 */         metapyro.setLore(indiob);
/* 487 */         pyro.setItemMeta(metapyro);
/* 488 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 490 */       if (p.hasPermission("kitpvp.kit.jumper")) {
/* 491 */         ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
/* 492 */         ItemMeta metapyro = pyro.getItemMeta();
/* 493 */         metapyro.setDisplayName("§7Kit §e§lJumper");
/* 494 */         ArrayList indiob = new ArrayList();
/* 495 */         indiob.add("§7Jumps all you can");
/*     */         
/* 497 */         metapyro.setLore(indiob);
/* 498 */         pyro.setItemMeta(metapyro);
/* 499 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/*     */       
/* 502 */       if (p.hasPermission("kitpvp.kit.timelord"))
/*     */       {
/* 504 */         ItemStack pyro = new ItemStack(Material.WATCH);
/* 505 */         ItemMeta metapyro = pyro.getItemMeta();
/* 506 */         metapyro.setDisplayName("§7Kit §e§lTimeLord");
/* 507 */         ArrayList indiob = new ArrayList();
/* 508 */         indiob.add("§7Stop the time");
/* 509 */         indiob.add("§7And freeze your enemies");
/* 510 */         indiob.add("§7With your magic clock");
/* 511 */         metapyro.setLore(indiob);
/* 512 */         pyro.setItemMeta(metapyro);
/* 513 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 515 */       if (p.hasPermission("kitpvp.kit.fisherman"))
/*     */       {
/* 517 */         ItemStack pyro = new ItemStack(Material.FISHING_ROD);
/* 518 */         ItemMeta metapyro = pyro.getItemMeta();
/* 519 */         metapyro.setDisplayName("§7Kit §e§lFisherman");
/* 520 */         ArrayList indiob = new ArrayList();
/* 521 */         indiob.add("§7You can teleport players to you!");
/* 522 */         indiob.add("§7Using your fishing rod!");
/* 523 */         metapyro.setLore(indiob);
/* 524 */         pyro.setItemMeta(metapyro);
/* 525 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 527 */       if (p.hasPermission("kitpvp.kit.spiderman"))
/*     */       {
/* 529 */         ItemStack pyro = new ItemStack(Material.WEB);
/* 530 */         ItemMeta metapyro = pyro.getItemMeta();
/* 531 */         metapyro.setDisplayName("§7Kit §e§lSpiderman");
/* 532 */         ArrayList indiob = new ArrayList();
/* 533 */         indiob.add("§7With this kit");
/* 534 */         indiob.add("§7You can climb walls and jumps!");
/* 535 */         indiob.add("§7Clicking in your sword!");
/* 536 */         metapyro.setLore(indiob);
/* 537 */         pyro.setItemMeta(metapyro);
/* 538 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 540 */       if (p.hasPermission("kitpvp.kit.warper"))
/*     */       {
/* 542 */         ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
/* 543 */         ItemMeta metapyro = pyro.getItemMeta();
/* 544 */         metapyro.setDisplayName("§7Kit §e§lWarper");
/* 545 */         ArrayList indiob = new ArrayList();
/* 546 */         indiob.add("§7Starts with");
/* 547 */         indiob.add("§7Sword , Armor and 8 ender pearls!");
/*     */         
/* 549 */         metapyro.setLore(indiob);
/* 550 */         pyro.setItemMeta(metapyro);
/* 551 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/* 553 */       if (p.hasPermission("kitpvp.kit.naruto"))
/*     */       {
/* 555 */         ItemStack pyro = new ItemStack(Material.NETHER_STAR);
/* 556 */         ItemMeta metapyro = pyro.getItemMeta();
/* 557 */         metapyro.setDisplayName("§7Kit §e§lNaruto");
/* 558 */         ArrayList indiob = new ArrayList();
/* 559 */         indiob.add("§7Click on the nether star and gains!");
/* 560 */         indiob.add("§7Strenght and Regeneration effects");
/* 561 */         metapyro.setLore(indiob);
/* 562 */         pyro.setItemMeta(metapyro);
/* 563 */         kits.addItem(new ItemStack[] { pyro });
/*     */       }
/*     */       ItemStack[] arrayOfItemStack;
/* 566 */       int descpyro1 = (arrayOfItemStack = kits.getContents()).length;
/* 567 */       for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
/*     */       {
/* 569 */         ItemStack item = arrayOfItemStack[metapyro1];
/* 570 */         if (item == null) {
/* 571 */           kits.setItem(kits.firstEmpty(), vidro);
/*     */         }
/*     */       }
/*     */       
/* 575 */       p.openInventory(kits);
/*     */     }
/* 577 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\Desktop\video\Minhas Coisas do Desktop\KP-PVPvB12 (1).jar!\me\RafaelAulerDeMeloAraujo\SpecialAbility\NewKitMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */
