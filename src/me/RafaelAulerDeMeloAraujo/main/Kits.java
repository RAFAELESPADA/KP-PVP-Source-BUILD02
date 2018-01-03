/*     */ package me.RafaelAulerDeMeloAraujo.main;
import java.util.Arrays;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;

import org.bukkit.Bukkit;
/*     */ import org.bukkit.Color;
import org.bukkit.Location;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Sound;
import org.bukkit.World;
/*     */ import org.bukkit.command.Command;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.configuration.file.FileConfiguration;
/*     */ import org.bukkit.enchantments.Enchantment;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.inventory.EntityEquipment;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ import org.bukkit.inventory.PlayerInventory;
/*     */ import org.bukkit.inventory.meta.ItemMeta;
/*     */ import org.bukkit.inventory.meta.LeatherArmorMeta;
/*     */ import org.bukkit.potion.PotionEffect;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Cooldown;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Deshfire;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Gladiator;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

/*     */ 
/*     */ public class Kits implements org.bukkit.command.CommandExecutor
/*     */ {
/*  22 */   java.util.List<Enchantment[]> enchantsList = new java.util.ArrayList();
/*     */   private Main main;
/*     */   static Main plugin;
/*     */   
/*     */   public Kits(Main main) {
/*  27 */     this.main = main;
/*  28 */     plugin = main;
/*     */   }
/*     */   

/*     */   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
/*     */   {
	 ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
     ItemMeta sopas = sopa.getItemMeta();
     sopas.setDisplayName("§6Soup");
     sopa.setItemMeta(sopas);
/*  34 */     if (!(sender instanceof Player)) {
/*  35 */       sender.sendMessage("[KitPvP] This command is only for players");
/*  36 */       return true;
/*     */     }
/*  38 */     Player s = (Player)sender;
/*  39 */     Player p = (Player)sender;
/*  40 */     if (cmd.getName().equalsIgnoreCase("kitclear")) {
    if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf("§cYou are not in kitpvp to do this!"));
    return true;
}
    {
/*  41 */       if (!sender.hasPermission("kitpvp.kitclear")) {
/*  42 */        p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/*  43 */         return true;
/*     */       }
/*  45 */       for (PotionEffect effect : s.getActivePotionEffects()) {
/*  46 */         s.removePotionEffect(effect.getType());
/*     */       }
/*  48 */       p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Clear").replace("&", "§"));
/*  49 */       p.getInventory().clear();
/*  50 */       s.getInventory().setHelmet(new ItemStack(Material.AIR));
/*  51 */       s.getInventory().setChestplate(new ItemStack(Material.AIR));
                Habilidade.removeAbility(p);
                Cooldown.remove(p);
                Deshfire.cooldownm.remove(p);
                Deshfire.armadura.remove(p);
                Gladiator.lutando.remove(p);
                Gladiator.gladgladiator.remove(p);
                World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
                double x =  Main.plugin.getConfig().getDouble("Spawn.X");
                  double y = Main.plugin.getConfig().getDouble("Spawn.Y");
                  double z = Main.plugin.getConfig().getDouble("Spawn.Z");
                  Location lobby = new Location(w, x, y, z);
                  lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
                  lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
	              p.getInventory().clear();
	              p.teleport(lobby);
                
/*  52 */       s.getInventory().setLeggings(new ItemStack(Material.AIR));
/*  53 */       s.getInventory().setBoots(new ItemStack(Material.AIR));
p.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.BOOK, 1, 0, "§aKit menu §7(Right click)", Arrays.asList(new String[] { this.main.getConfig().getString("JoinItem.Lore").replace("&", "§") }))) });
ItemStack kits = new ItemStack(Material.EMERALD);
ItemMeta kits2 = kits.getItemMeta();
kits2.setDisplayName("§b§lShop Menu");
kits.setItemMeta(kits2);
p.getInventory().addItem(kits);



                p.updateInventory();
/*     */       }
/*     */     }

    
  
/*  58 */     if (cmd.getName().equalsIgnoreCase("kpvp")) {
/*  59 */       if (!sender.hasPermission("kitpvp.kit.pvp")) {
/*  60 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/*  61 */         return true;
/*     */       }
/*  63 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/*  64 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/*  65 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/*  66 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to choose this kit!");
    return true;
}
/*  68 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "PvP").replace("&", "§"));
/*  69 */       s.getInventory().clear();
/*  70 */       s.setHealth(20.0D);
/*  71 */       s.setFoodLevel(20);
/*  72 */       for (PotionEffect effect : s.getActivePotionEffects()) {
/*  73 */         s.removePotionEffect(effect.getType());
/*     */       }
/*  75 */       ItemStack sword = new ItemStack(Material.DIAMOND_SWORD);
/*  76 */       sword.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/*  75 */       ItemStack colete = new ItemStack(Material.IRON_CHESTPLATE);
/*  76 */       colete.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
colete.addEnchantment(Enchantment.DURABILITY, 3);
/*  75 */       ItemStack colete1 = new ItemStack(Material.IRON_HELMET);
/*  76 */       colete1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1);
colete1.addEnchantment(Enchantment.DURABILITY, 3);
/*  77 */      
/*  75 */       ItemStack calcinhasuja = new ItemStack(Material.IRON_LEGGINGS);

calcinhasuja.addEnchantment(Enchantment.DURABILITY, 3);
/*  75 */       ItemStack bota = new ItemStack(Material.IRON_BOOTS);

bota.addEnchantment(Enchantment.DURABILITY, 3);
/*  77 */       s.getInventory().addItem(new ItemStack[] { sword });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }

/*  87 */       s.getInventory().setHelmet(new ItemStack(colete1));
/*  88 */       s.getInventory().setChestplate(new ItemStack(colete));
/*  89 */       s.getInventory().setLeggings(new ItemStack(calcinhasuja));
/*  90 */       s.getInventory().setBoots(new ItemStack(bota));
/*  91 */       
/*  92 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/*  93 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/*  94 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "PvP").replace("&", "§"));
/*     */       }
/*  96 */       return true; }
/*     */     Object meta;
/*  98 */     if (cmd.getName().equalsIgnoreCase("warper")) {
/*  99 */       if (!sender.hasPermission("kitpvp.kit.warper")) {
/* 100 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 101 */         return true;
/*     */       }
/* 103 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 104 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 105 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 106 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 108 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Warper").replace("&", "§"));
/* 109 */       s.getInventory().clear();
/* 110 */       s.setHealth(20.0D);
/* 111 */       s.setFoodLevel(20);
/* 112 */       for (PotionEffect effect : s.getActivePotionEffects()) {
/* 113 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 115 */       ItemStack sword = new ItemStack(Material.IRON_SWORD);
/* 116 */       s.getInventory().addItem(new ItemStack[] { sword });
/* 117 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL, 8) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 125 */       ItemStack tunic = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 126 */       tunic.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 127 */       meta = (LeatherArmorMeta)tunic.getItemMeta();
/* 128 */       ((LeatherArmorMeta)meta).setColor(Color.BLUE);
/* 129 */       tunic.setItemMeta((ItemMeta)meta);
/* 130 */       s.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
/* 131 */       s.getEquipment().setChestplate(tunic);
/* 132 */       s.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 133 */       s.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/* 134 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 135 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 136 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Warper").replace("&", "§"));
/*     */       }
/* 138 */       return true; }
/*     */     Object meta1;
/* 140 */     if (cmd.getName().equalsIgnoreCase("Switcher")) {
/* 141 */       if (!sender.hasPermission("kitpvp.kit.switcher")) {
/* 142 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 143 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 145 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 146 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 147 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 148 */         return true;
/*     */       }
/* 150 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Switcher").replace("&", "§"));
/* 151 */       s.getInventory().clear();
/* 152 */       s.setHealth(20.0D);
/* 153 */       s.setFoodLevel(20);
/* 154 */       for (meta1 = s.getActivePotionEffects().iterator(); ((Iterator)meta1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)meta1).next();
/* 155 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 157 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SWORD) });
/* 158 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SNOW_BALL, 16) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 166 */       ItemStack tunic = new ItemStack(Material.LEATHER_HELMET);
/* 167 */       tunic.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 168 */       meta1 = (LeatherArmorMeta)tunic.getItemMeta();
/* 169 */       ((LeatherArmorMeta)meta1).setColor(Color.WHITE);
/* 170 */       tunic.setItemMeta((ItemMeta)meta1);
/* 171 */       s.getEquipment().setHelmet(tunic);
/* 172 */       s.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
/* 173 */       s.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
/* 174 */       s.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
/* 175 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 176 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 177 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Switcher").replace("&", "§"));
/*     */       }
/* 179 */       return true; }
/*     */     Object bow;
/* 181 */     if (cmd.getName().equalsIgnoreCase("archer")) {
/* 182 */       if (!sender.hasPermission("kitpvp.kit.archer")) {
/* 183 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 184 */         return true;
/*     */       }
/* 186 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 187 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 188 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 189 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 191 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Archer").replace("&", "§"));
/* 192 */       s.getInventory().clear();
/* 193 */       s.setHealth(20.0D);
/* 194 */       s.setFoodLevel(20);
/* 195 */       for (meta1 = s.getActivePotionEffects().iterator(); ((Iterator)meta1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)meta1).next();
/* 196 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 198 */       ItemStack sword2 = new ItemStack(Material.STONE_SWORD);
                ItemStack flecha = new ItemStack(Material.ARROW);
/* 199 */       sword2.addEnchantment(Enchantment.KNOCKBACK, 2);
                sword2.addEnchantment(Enchantment.DAMAGE_ALL, 2); 
/* 200 */       bow = new ItemStack(Material.BOW);
/* 201 */       ((ItemStack)bow).addEnchantment(Enchantment.ARROW_DAMAGE, 2);
                ((ItemStack)bow).addEnchantment(Enchantment.ARROW_INFINITE, 1);
                ((ItemStack)bow).addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
/* 202 */       s.getInventory().addItem(new ItemStack[] { sword2 });
/* 203 */       s.getInventory().addItem(new ItemStack[] { (ItemStack) bow });
                s.getInventory().addItem(new ItemStack[] { (ItemStack) flecha });
for (int i = 0; i <= 33; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
   
    
  }
/* 211 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 64) });
/* 212 */       s.getInventory().setHelmet(new ItemStack(Material.CHAINMAIL_HELMET));
/* 213 */       ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
kPeitoral.setColor(Color.GREEN);
Peitoral.setItemMeta(kPeitoral);
/* 214 */       s.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
/* 215 */       s.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
s.getInventory().setChestplate(Peitoral);
/* 216 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 217 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 218 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Archer").replace("&", "§"));
/*     */       }
/* 220 */       return true; }
/*     */     Object bow1; 
/* 222 */     if (cmd.getName().equalsIgnoreCase("pyro")) {
/* 223 */       if (!sender.hasPermission("kitpvp.kit.pyro")) {
/* 224 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 225 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 227 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 228 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 229 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 230 */         return true;
/*     */       }
/* 232 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Pyro").replace("&", "§"));
/* 233 */       s.getInventory().clear();
/* 234 */       s.setHealth(20.0D);
/* 235 */       s.setFoodLevel(20);
/* 236 */       for (bow = s.getActivePotionEffects().iterator(); ((Iterator)bow).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)bow).next();
/* 237 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 239 */       ItemStack sword3 = new ItemStack(Material.STONE_SWORD);
/* 240 */       sword3.addEnchantment(Enchantment.KNOCKBACK, 2);
sword3.addEnchantment(Enchantment.DAMAGE_ALL, 1);
ItemStack flecha = new ItemStack(Material.ARROW , 64);
/* 241 */       sword3.addEnchantment(Enchantment.FIRE_ASPECT, 1);
/* 242 */       bow1 = new ItemStack(Material.BOW);
/* 243 */       ((ItemStack)bow1).addEnchantment(Enchantment.ARROW_DAMAGE, 3);
/* 244 */       ((ItemStack)bow1).addEnchantment(Enchantment.ARROW_FIRE, 1);
/* 245 */       s.getInventory().addItem(new ItemStack[] { sword3 });

/* 246 */       s.getInventory().addItem(new ItemStack[] { (ItemStack) bow1 });
s.getInventory().addItem(new ItemStack[] { flecha });
for (int i = 0; i <= 33; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 254 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 64) });
/* 255 */       ItemStack tunic = new ItemStack(Material.LEATHER_HELMET);
/* 256 */       tunic.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 257 */       LeatherArmorMeta meta11 = (LeatherArmorMeta)tunic.getItemMeta();
/* 258 */       meta11.setColor(Color.YELLOW);
/* 259 */       tunic.setItemMeta(meta11);
/* 260 */       s.getEquipment().setHelmet(tunic);
/* 261 */       s.getInventory().setChestplate(new ItemStack(Material.CHAINMAIL_CHESTPLATE));
/* 262 */       s.getInventory().setLeggings(new ItemStack(Material.CHAINMAIL_LEGGINGS));
/* 263 */       s.getInventory().setBoots(new ItemStack(Material.CHAINMAIL_BOOTS));
/* 264 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 265 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 266 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Pyro").replace("&", "§"));
/*     */       }
/* 268 */       return true;
/*     */     }
/* 270 */     if (cmd.getName().equalsIgnoreCase("Tank")) {
/* 271 */       if (!sender.hasPermission("kitpvp.kit.tank")) {
/* 272 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 273 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 275 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 276 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 277 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 278 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 280 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Tank").replace("&", "§"));
/* 281 */       s.getInventory().clear();
/* 282 */       s.setHealth(20.0D);
/* 283 */       s.setFoodLevel(20);
/* 284 */       for (bow1 = s.getActivePotionEffects().iterator(); ((Iterator)bow1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)bow1).next();
/* 285 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 287 */       ItemStack sword4 = new ItemStack(Material.WOOD_SWORD);
/* 288 */       sword4.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 289 */       sword4.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 290 */       s.getInventory().addItem(new ItemStack[] { sword4 });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 299 */       s.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
/* 300 */       s.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
/* 301 */       s.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
/* 302 */       s.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
/* 303 */       s.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.SLOW, 999999999, 2));
/* 304 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 305 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 306 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Tank").replace("&", "Â§"));
/*     */       }
/* 308 */       return true; }
/*     */     Object helmet;
/* 310 */     if (cmd.getName().equalsIgnoreCase("jumper")) {
/* 311 */       if (!sender.hasPermission("kitpvp.kit.jumper")) {
/* 312 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 313 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 315 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 316 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 317 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 318 */         return true;
/*     */       }
/* 320 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Jumper").replace("&", "§"));
/* 321 */       s.getInventory().clear();
/* 322 */       s.setHealth(20.0D);
/* 323 */       s.setFoodLevel(20);
/* 324 */       for (bow1 = s.getActivePotionEffects().iterator(); ((Iterator)bow1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)bow1).next();
/* 325 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 327 */       ItemStack sword5 = new ItemStack(Material.DIAMOND_SWORD);
/* 328 */       sword5.addEnchantment(Enchantment.DAMAGE_ALL, 1);
/* 329 */       s.getInventory().addItem(new ItemStack[] { sword5 });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 338 */       helmet = new ItemStack(Material.LEATHER_HELMET);
/* 339 */       ((ItemStack)helmet).addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 340 */       ((ItemStack)helmet).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 341 */       LeatherArmorMeta meta11 = (LeatherArmorMeta)((ItemStack)helmet).getItemMeta();
/* 342 */       meta11.setColor(Color.YELLOW);
/* 343 */       ((ItemStack)helmet).setItemMeta(meta11);
/* 344 */       s.getEquipment().setHelmet((ItemStack)helmet);
/* 345 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 346 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 347 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 348 */       LeatherArmorMeta meta111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 349 */       meta111.setColor(Color.BLACK);
/* 350 */       tunic1.setItemMeta(meta111);
/* 351 */       s.getEquipment().setChestplate(tunic1);
/* 352 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 353 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 354 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 355 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 356 */       meta1111.setColor(Color.BLACK);
/* 357 */       tunic11.setItemMeta(meta1111);
/* 358 */       s.getEquipment().setLeggings(tunic11);
/* 359 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 360 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 361 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 362 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 363 */       meta11111.setColor(Color.YELLOW);
/* 364 */       tunic111.setItemMeta(meta11111);
/* 365 */       s.getEquipment().setBoots(tunic111);
/* 366 */       s.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.SPEED, 999999999, 1));
/* 367 */       s.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.JUMP, 999999999, 3));
/* 368 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 369 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 370 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Jumper").replace("&", "§"));
/* 371 */         return true;
/*     */       }
/* 373 */       return true; }
/*     */     Object helmet1;
/* 375 */     if (cmd.getName().equalsIgnoreCase("Cactus")) {
/* 376 */       if (!sender.hasPermission("kitpvp.kit.cactus")) {
/* 377 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 378 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 380 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 381 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 382 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 383 */         return true;
/*     */       }
/* 385 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Cactus").replace("&", "§"));
/* 386 */       s.getInventory().clear();
/* 387 */       s.setHealth(20.0D);
/* 388 */       s.setFoodLevel(20);
/* 389 */       for (helmet1 = s.getActivePotionEffects().iterator(); ((Iterator)helmet1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)helmet1).next();
/* 390 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 392 */       ItemStack sword6 = new ItemStack(Material.DIAMOND_SWORD);
/* 393 */       s.getInventory().addItem(new ItemStack[] { sword6 });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 402 */       helmet1 = new ItemStack(Material.IRON_HELMET);
/* 403 */       ((ItemStack)helmet1).addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 404 */       ((ItemStack)helmet1).addEnchantment(Enchantment.THORNS, 3);
/* 405 */       s.getEquipment().setHelmet((ItemStack)helmet1);
/* 406 */       ItemStack tunic1 = new ItemStack(Material.IRON_CHESTPLATE);
/* 407 */       tunic1.addEnchantment(Enchantment.THORNS, 3);
/* 408 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 409 */       s.getEquipment().setChestplate(tunic1);
/* 410 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 411 */       tunic11.addEnchantment(Enchantment.THORNS, 3);
/* 412 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 413 */       s.getEquipment().setLeggings(tunic11);
/* 414 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 415 */       tunic111.addEnchantment(Enchantment.THORNS, 3);
/* 416 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 417 */       s.getEquipment().setBoots(tunic111);
/* 418 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 419 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 420 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Cactus").replace("&", "§"));
/* 421 */         return true;
/*     */       }
/* 423 */       return true; }
/*     */     Object meta11;
/* 425 */     if (cmd.getName().equalsIgnoreCase("bomber")) {
/* 426 */       if (!sender.hasPermission("kitpvp.kit.bomber")) {
/* 427 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 428 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 430 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 431 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 432 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 433 */         return true;
/*     */       }
/* 435 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Bomber").replace("&", "§"));
/* 436 */       s.getInventory().clear();
/* 437 */       s.setHealth(20.0D);
/* 438 */       s.setFoodLevel(20);
/* 439 */       for (helmet1 = s.getActivePotionEffects().iterator(); ((Iterator)helmet1).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)helmet1).next();
/* 440 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 442 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SWORD) });
/* 443 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.TNT, 10) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 451 */       ItemStack helmet11 = new ItemStack(Material.LEATHER_HELMET);
/* 452 */       helmet11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 453 */       helmet11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
/* 454 */       meta11 = (LeatherArmorMeta)helmet11.getItemMeta();
/* 455 */       ((LeatherArmorMeta)meta11).setColor(Color.RED);
/* 456 */       helmet11.setItemMeta((ItemMeta)meta11);
/* 457 */       s.getEquipment().setHelmet(helmet11);
/* 458 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 459 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 460 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
/* 461 */       LeatherArmorMeta meta111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 462 */       meta111.setColor(Color.WHITE);
/* 463 */       tunic1.setItemMeta(meta111);
/* 464 */       s.getEquipment().setChestplate(tunic1);
/* 465 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 466 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 467 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
/* 468 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 469 */       meta1111.setColor(Color.RED);
/* 470 */       tunic11.setItemMeta(meta1111);
/* 471 */       s.getEquipment().setLeggings(tunic11);
/* 472 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 473 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 474 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 1);
/* 475 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 476 */       meta11111.setColor(Color.WHITE);
/* 477 */       tunic111.setItemMeta(meta11111);
/* 478 */       s.getEquipment().setBoots(tunic111);
/* 479 */       s.addPotionEffect(new PotionEffect(org.bukkit.potion.PotionEffectType.SPEED, 999999999, 1));
/* 480 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 481 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 482 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Bomber").replace("&", "§"));
/* 483 */         return true;
/*     */       }
/* 485 */       return true; }
/*     */     Object helmet11;
/* 487 */     if (cmd.getName().equalsIgnoreCase("wasp")) {
/* 488 */       if (!sender.hasPermission("kitpvp.kit.wasp")) {
/* 489 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 490 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 492 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 493 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 494 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 495 */         return true;
/*     */       }
/* 497 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Wasp").replace("&", "§"));
/* 498 */       s.getInventory().clear();
/* 499 */       s.setHealth(20.0D);
/* 500 */       s.setFoodLevel(20);
/* 501 */       for (meta11 = s.getActivePotionEffects().iterator(); ((Iterator)meta11).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)meta11).next();
/* 502 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 504 */       ItemStack sword7 = new ItemStack(Material.BLAZE_ROD);
/* 505 */       sword7.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 7);
/* 506 */       s.getInventory().addItem(new ItemStack[] { sword7 });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 515 */       helmet11 = new ItemStack(Material.LEATHER_HELMET);
/* 516 */       ((ItemStack)helmet11).addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 517 */       ((ItemStack)helmet11).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 518 */       LeatherArmorMeta meta111 = (LeatherArmorMeta)((ItemStack)helmet11).getItemMeta();
/* 519 */       meta111.setColor(Color.BLACK);
/* 520 */       ((ItemStack)helmet11).setItemMeta(meta111);
/* 521 */       s.getEquipment().setHelmet((ItemStack)helmet11);
/* 522 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 523 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 524 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 525 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 526 */       meta1111.setColor(Color.YELLOW);
/* 527 */       tunic1.setItemMeta(meta1111);
/* 528 */       s.getEquipment().setChestplate(tunic1);
/* 529 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 530 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 531 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 532 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 533 */       meta11111.setColor(Color.BLACK);
/* 534 */       tunic11.setItemMeta(meta11111);
/* 535 */       s.getEquipment().setLeggings(tunic11);
/* 536 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 537 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 538 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 539 */       LeatherArmorMeta meta111111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 540 */       meta111111.setColor(Color.YELLOW);
/* 541 */       tunic111.setItemMeta(meta111111);
/* 542 */       s.getEquipment().setBoots(tunic111);
/* 543 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 544 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 545 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Wasp").replace("&", "§"));
/* 546 */         return true;
/*     */       }
/* 548 */       return true; }
/*     */     Object meta111;
/* 550 */     if (cmd.getName().equalsIgnoreCase("spiderman")) {
/* 551 */       if (!sender.hasPermission("kitpvp.kit.spiderman")) {
/* 552 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 553 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 555 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 556 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 557 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 558 */         return true;
/*     */       }
/* 560 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Spiderman").replace("&", "§"));
/* 561 */       s.getInventory().clear();
/* 562 */       s.setHealth(20.0D);
/* 563 */       s.setFoodLevel(20);
/* 564 */       for (helmet11 = s.getActivePotionEffects().iterator(); ((Iterator)helmet11).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)helmet11).next();
/* 565 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 567 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.DIAMOND_SWORD, 1, 0, this.main.getConfig().getString("SidermanKit.Name").replace("&", "§"), java.util.Arrays.asList(new String[] { this.main.getConfig().getString("SidermanKit.Lore").replace("&", "§") }))) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 576 */       ItemStack helmet111 = new ItemStack(Material.LEATHER_HELMET);
/* 577 */       helmet111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 578 */       helmet111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
helmet111.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
/* 579 */       meta111 = (LeatherArmorMeta)helmet111.getItemMeta();
/* 580 */       ((LeatherArmorMeta)meta111).setColor(Color.RED);
/* 581 */       helmet111.setItemMeta((ItemMeta)meta111);
/* 582 */       s.getEquipment().setHelmet(helmet111);
/* 583 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 584 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 585 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
tunic1.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
/* 586 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 587 */       meta1111.setColor(Color.RED);
/* 588 */       tunic1.setItemMeta(meta1111);
/* 589 */       s.getEquipment().setChestplate(tunic1);
/* 590 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 591 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 592 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 593 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic11.getItemMeta();
tunic11.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
/* 594 */       meta11111.setColor(Color.RED);
/* 595 */       tunic11.setItemMeta(meta11111);
/* 596 */       s.getEquipment().setLeggings(tunic11);
/* 597 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 598 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 599 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 600 */       LeatherArmorMeta meta111111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 601 */       meta111111.setColor(Color.RED);
/* 602 */       tunic111.setItemMeta(meta111111);
/* 603 */       s.getEquipment().setBoots(tunic111);
Habilidade.setAbility(s, "Spiderman");
tunic111.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
/* 604 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 605 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 606 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Spiderman").replace("&", "§"));
/* 607 */         return true;
/*     */       }
/* 609 */       return true; }
/*     */     Object helmet111;
/* 611 */     if (cmd.getName().equalsIgnoreCase("airman")) {
/* 612 */       if (!sender.hasPermission("kitpvp.kit.airman")) {
/* 613 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 614 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 616 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 617 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 618 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 619 */         return true;
/*     */       }
/* 621 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "AirMan").replace("&", "§"));
/* 622 */       s.getInventory().clear();
/* 623 */       s.setHealth(20.0D);
/* 624 */       s.setFoodLevel(20);
/* 625 */       for (meta111 = s.getActivePotionEffects().iterator(); ((Iterator)meta111).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)meta111).next();
/* 626 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 628 */       ItemStack sword8 = new ItemStack(Material.IRON_SWORD);
/* 629 */       sword8.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1);
Habilidade.setAbility(s, "Airman");
/* 630 */       s.getInventory().addItem(new ItemStack[] { sword8 });
/* 631 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(make(Material.FEATHER, 1, 0, this.main.getConfig().getString("AirmanKit.Name").replace("&", "§"), java.util.Arrays.asList(new String[] { this.main.getConfig().getString("AirmanKit.Lore").replace("&", "§") }))) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 639 */       helmet111 = new ItemStack(Material.LEATHER_HELMET);
/* 640 */       ((ItemStack)helmet111).addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 641 */       ((ItemStack)helmet111).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 642 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)((ItemStack)helmet111).getItemMeta();
/* 643 */       meta1111.setColor(Color.BLACK);
/* 644 */       ((ItemStack)helmet111).setItemMeta(meta1111);
/* 645 */       s.getEquipment().setHelmet((ItemStack)helmet111);
/* 646 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 647 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 648 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 649 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 650 */       meta11111.setColor(Color.BLACK);
/* 651 */       tunic1.setItemMeta(meta11111);
/* 652 */       s.getEquipment().setChestplate(tunic1);
/* 653 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 654 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 655 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 656 */       LeatherArmorMeta meta111111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 657 */       meta111111.setColor(Color.BLACK);
/* 658 */       tunic11.setItemMeta(meta111111);
/* 659 */       s.getEquipment().setLeggings(tunic11);
/* 660 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 661 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 662 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 663 */       LeatherArmorMeta meta1111111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 664 */       meta1111111.setColor(Color.BLACK);
/* 665 */       tunic111.setItemMeta(meta1111111);
/* 666 */       s.getEquipment().setBoots(tunic111);
/* 667 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 668 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 669 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "AriMan").replace("&", "§"));
/* 670 */         return true;
/*     */       }
/* 672 */       return true; }
/*     */     Object helmet1111;
/* 674 */     if (cmd.getName().equalsIgnoreCase("fisherman")) {
/* 675 */       if (!sender.hasPermission("kitpvp.kit.fisherman")) {
/* 676 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 677 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 679 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 680 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 681 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 682 */         return true;
/*     */       }
/* 684 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "FisherMan").replace("&", "§"));
/* 685 */       s.getInventory().clear();
                Habilidade.setAbility(p, "Fisherman");
/* 686 */       s.setHealth(20.0D);
/* 687 */       s.setFoodLevel(20);
/* 688 */       for (helmet1111 = s.getActivePotionEffects().iterator(); ((Iterator)helmet1111).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)helmet1111).next();
/* 689 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 691 */       ItemStack sword9 = new ItemStack(Material.STONE_SWORD);
/* 692 */       sword9.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
sword9.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
/* 693 */       s.getInventory().addItem(new ItemStack[] { sword9 });
/* 694 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FISHING_ROD) });
for (int i = 0; i <= 34; i++) {
    s.getInventory().addItem(new ItemStack[] { sopa });
    
  }
/* 702 */       helmet1111 = new ItemStack(Material.LEATHER_HELMET);
/* 703 */       ((ItemStack)helmet1111).addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 704 */       ((ItemStack)helmet1111).addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
((ItemStack)helmet1111).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);

/* 705 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)((ItemStack)helmet1111).getItemMeta();
/* 706 */       meta1111.setColor(Color.BLUE);
/* 707 */       ((ItemStack)helmet1111).setItemMeta(meta1111);
/* 708 */       s.getEquipment().setHelmet((ItemStack)helmet1111);
/* 709 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 710 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 711 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 712 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 713 */       meta11111.setColor(Color.BLUE);
/* 714 */       tunic1.setItemMeta(meta11111);
/* 715 */       s.getEquipment().setChestplate(tunic1);
/* 716 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 717 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 718 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
((ItemStack)tunic11).addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2);
/* 719 */       LeatherArmorMeta meta111111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 720 */       meta111111.setColor(Color.BLUE);
/* 721 */       tunic11.setItemMeta(meta111111);
/* 722 */       s.getEquipment().setLeggings(tunic11);
/* 723 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 724 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 725 */       tunic111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 726 */       LeatherArmorMeta meta1111111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 727 */       meta1111111.setColor(Color.BLUE);
/* 728 */       tunic111.setItemMeta(meta1111111);
/* 729 */       s.getEquipment().setBoots(tunic111);
/* 730 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 731 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 732 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "FisherMan").replace("&", "§"));
/* 733 */         return true;
/*     */       }
/* 735 */       return true;
/*     */     }
/* 737 */     if (cmd.getName().equalsIgnoreCase("freezer")) {
/* 738 */       if (!sender.hasPermission("kitpvp.kit.freezer")) {
/* 739 */         sender.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Permission").replace("&", "§").replaceAll("%permisson%", commandLabel));
/* 740 */         return true;
/*     */       }
if (!Join.game.contains(p.getName()))
{
    p.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + " §eYou are not in kitpvp to do choose this kit!");
    return true;
}
/* 742 */       if ((p.getInventory().contains(Material.MUSHROOM_SOUP)) || (p.getInventory().contains(Material.BOWL))) {
/* 743 */         s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.KitUse").replace("&", "§"));
/* 744 */         s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.KitUse")), 1.0F, 1.0F);
/* 745 */         return true;
/*     */       }
/* 747 */       s.sendMessage(String.valueOf(this.main.getConfig().getString("Prefix").replace("&", "§")) + this.main.getConfig().getString("Message.Kit").replaceAll("%kit%", "Freezer").replace("&", "§"));
/* 748 */       s.getInventory().clear();
/* 749 */       s.setHealth(20.0D);
/* 750 */       s.setFoodLevel(20);
/* 751 */       for (helmet1111 = s.getActivePotionEffects().iterator(); ((Iterator)helmet1111).hasNext();) { PotionEffect effect = (PotionEffect)((Iterator)helmet1111).next();
/* 752 */         s.removePotionEffect(effect.getType());
/*     */       }
/* 754 */       ItemStack sword10 = new ItemStack(Material.STONE_SWORD);
/* 755 */       sword10.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 3);
sword10.addUnsafeEnchantment(Enchantment.DURABILITY, 8);
		
/* 756 */       s.getInventory().addItem(new ItemStack[] { sword10 });
/* 757 */       s.getInventory().addItem(new ItemStack[] { new ItemStack(Material.FISHING_ROD) });

/* 765 */       ItemStack helmet11111 = new ItemStack(Material.LEATHER_HELMET);
/* 766 */       helmet11111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 767 */       helmet11111.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 768 */       LeatherArmorMeta meta1111 = (LeatherArmorMeta)helmet11111.getItemMeta();
/* 769 */       meta1111.setColor(Color.WHITE);
/* 770 */       helmet11111.setItemMeta(meta1111);
/* 771 */       s.getEquipment().setHelmet(helmet11111);
/* 772 */       ItemStack tunic1 = new ItemStack(Material.LEATHER_CHESTPLATE);
/* 773 */       tunic1.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 774 */       tunic1.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 775 */       LeatherArmorMeta meta11111 = (LeatherArmorMeta)tunic1.getItemMeta();
/* 776 */       meta11111.setColor(Color.BLUE);
/* 777 */       tunic1.setItemMeta(meta11111);
/* 778 */       s.getEquipment().setChestplate(tunic1);
/* 779 */       ItemStack tunic11 = new ItemStack(Material.LEATHER_LEGGINGS);
/* 780 */       tunic11.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 781 */       tunic11.addEnchantment(Enchantment.PROTECTION_PROJECTILE, 2);
/* 782 */       LeatherArmorMeta meta111111 = (LeatherArmorMeta)tunic11.getItemMeta();
/* 783 */       meta111111.setColor(Color.BLUE);
/* 784 */       tunic11.setItemMeta(meta111111);
/* 785 */       s.getEquipment().setLeggings(tunic11);
/* 786 */       ItemStack tunic111 = new ItemStack(Material.LEATHER_BOOTS);
/* 787 */       tunic111.addUnsafeEnchantment(Enchantment.DURABILITY, 150);
/* 788 */       tunic111.addUnsafeEnchantment(Enchantment.FROST_WALKER, 2);
/* 789 */       LeatherArmorMeta meta1111111 = (LeatherArmorMeta)tunic111.getItemMeta();
/* 790 */       meta1111111.setColor(Color.WHITE);
/* 791 */       tunic111.setItemMeta(meta1111111);
/* 792 */       s.getEquipment().setBoots(tunic111);
for (int i = 0; i <= 34;) {
    s.getInventory().addItem(new ItemStack[] { sopa });
/* 793 */       s.playSound(s.getLocation(), Sound.valueOf(this.main.getConfig().getString("Sound.Kit")), 1.0F, 1.0F);
/* 794 */       if (this.main.getConfig().getString("CustomKitTitleMessage").equalsIgnoreCase("true")) {
/* 795 */         s.sendTitle(this.main.getConfig().getString("Title.KitTitle").replace("&", "§"), this.main.getConfig().getString("Title.KitSubTitle").replaceAll("%kit%", "Freezer").replace("&", "§"));
/* 796 */         return true;
/*     */       }
/* 798 */       return true;
/*     */     }
}
return false;} 



/*     */   
/*     */   private ItemStack make(Material material, int amount, int shrt, String displayName, java.util.List<String> lore) {
/* 804 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 805 */     ItemMeta meta = item.getItemMeta();
/* 806 */     meta.setDisplayName(displayName);
/* 807 */     meta.setLore(lore);
/* 808 */     item.setItemMeta(meta);
/* 809 */     return item;
/*     */   }
/*     */ }


