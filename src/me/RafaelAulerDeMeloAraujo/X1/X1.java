package me.RafaelAulerDeMeloAraujo.X1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import me.RafaelAulerDeMeloAraujo.ScoreboardManager.ScoreBoarding;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;
import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;
import me.RafaelAulerDeMeloAraujo.main.ItemAPI;
import me.RafaelAulerDeMeloAraujo.main.Main;

public class X1 implements Listener {
	/*     */   private static Main main;
	
	
	
	/*     */   static Main plugin;
	/*     */   
	/*     */   public X1() {
	/*  27 */     this.main = main;
	/*  28 */     plugin = main;
	/*     */   }
	
	/*     */   
	public static Map<String, String> convites = new HashMap<String, String>();
	public static Map<String, String> lutadores = new HashMap<String, String>();
	public static ArrayList<Player> hide = new ArrayList<>();
	public static ArrayList<Player> inx1 = new ArrayList<>();
	
	public static void sair1v1(Player p) {
		p.getInventory().clear();
		inx1.remove(p);
		Join.game.add(p.getName());
		 World w = Bukkit.getServer().getWorld(Main.plugin.getConfig().getString("Spawn.World"));
         double x =  Main.plugin.getConfig().getDouble("Spawn.X");
           double y = Main.plugin.getConfig().getDouble("Spawn.Y");
           double z = Main.plugin.getConfig().getDouble("Spawn.Z");
           Location lobby = new Location(w, x, y, z);
           lobby.setPitch((float)Main.plugin.getConfig().getDouble("Spawn.Pitch"));
           lobby.setYaw((float)Main.plugin.getConfig().getDouble("Spawn.Yaw"));
           p.getInventory().clear();
           p.teleport(lobby);
           /*  52 */       p.getInventory().setLeggings(new ItemStack(Material.AIR));
           /*  53 */       p.getInventory().setBoots(new ItemStack(Material.AIR));
           ItemStack shop = new ItemStack(Material.BOOK);
           ItemMeta shop2 = shop.getItemMeta();
           shop2.setDisplayName("§aKit menu §7(Right click)");
           shop.setItemMeta(shop2);
           ItemStack kits = new ItemStack(Material.EMERALD);
           ItemMeta kits2 = kits.getItemMeta();
           kits2.setDisplayName("§b§lShop Menu");
           kits.setItemMeta(kits2);
           p.getInventory().addItem(shop);
           p.getInventory().addItem(kits);
           Habilidade.removeAbility(p);
           p.setHealth(20);
	       
	        
                           p.updateInventory();
                           p.sendMessage("§cYou leave the 1v1");
                           p.sendMessage("§eIf you want");
                           p.sendMessage("§eTo join again write /kitpvp 1v1");
                           
		
	}

	public static void entrar1v1(Player p) {
		
		inx1.add(p);
		p.teleport(new Location(p.getWorld(), Main.cfg_x1.getDouble("x1.coords.spawn.x"),
				Main.cfg_x1.getDouble("x1.coords.spawn.y"), Main.cfg_x1.getDouble("x1.coords.spawn.z")));
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		
		  ItemStack v1 = new ItemStack(Material.BLAZE_ROD);
		  ItemMeta v12 = v1.getItemMeta();
		  v12.setDisplayName("§6Right click on someone to challenge him!");
		  v1.setItemMeta(v12);
		  ItemStack rd1 = new ItemStack(Material.REDSTONE);
		  ItemMeta rd12 = rd1.getItemMeta();
		  rd12.setDisplayName("§cLeave");
		  rd1.setItemMeta(rd12);
		 
		  p.getInventory().setItem(0, v1);
		  p.getInventory().setItem(8, rd1);
				
Join.game.add(p.getName());
		p.setHealth(20D);
		p.setExp(0);
		p.setLevel(0);
		Habilidade.setAbility(p, Main.cfg_x1.getString("x1.ability"));
		ScoreBoarding.setScoreBoard(p);
		
	}

	public static void set1v1(Player p) {
		p.getInventory().clear();
		p.getInventory().setArmorContents(null);
		 ItemStack dima = new ItemStack(Material.DIAMOND_SWORD);
	        ItemMeta souperaa = dima.getItemMeta();
	        souperaa.setDisplayName("§cSword");
	        dima.setItemMeta(souperaa);
	        p.getInventory().addItem(new ItemStack[] { dima });
		/*  87 */       p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
		/*  88 */       p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
		/*  89 */       p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
		/*  90 */       p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
		ScoreBoarding.setScoreBoard(p);
		ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
	     ItemMeta sopas = sopa.getItemMeta();
	     sopas.setDisplayName("§6Soup");
	     sopa.setItemMeta(sopas);
		for (int i = 0; i <= 7; i++) {
		    p.getInventory().addItem(new ItemStack[] { sopa });
		    p.updateInventory(); 
		  }
		}
		
		
	


	public static void aceitar(Player p1, Player p2) {
		p1.teleport(new Location(p1.getWorld(), Main.cfg_x1.getDouble("x1.coords.loc_1.x"),
				Main.cfg_x1.getDouble("x1.coords.loc_1.y"), Main.cfg_x1.getDouble("x1.coords.loc_1.z"),
				Float.valueOf((float) Main.cfg_x1.getDouble("x1.coords.loc_1.yaw")), Float.valueOf((float) Main.cfg_x1.getDouble("x1.coords.loc_1.pitch"))));
		p2.teleport(new Location(p1.getWorld(), Main.cfg_x1.getDouble("x1.coords.loc_2.x"),
				Main.cfg_x1.getDouble("x1.coords.loc_2.y"), Main.cfg_x1.getDouble("x1.coords.loc_2.z"),
				Float.valueOf((float) Main.cfg_x1.getDouble("x1.coords.loc_2.yaw")), Float.valueOf((float) Main.cfg_x1.getDouble("x1.coords.loc_2.pitch"))));
		
		set1v1(p1);
		set1v1(p2);
		lutadores.put(p1.getName(), p2.getName());
		lutadores.put(p2.getName(), p1.getName());
		convites.remove(p1.getName());
		for (Player pp : Bukkit.getOnlinePlayers()) {
			p1.hidePlayer(pp);
		}
		hide.add(p1);
		for (Player pp : Bukkit.getOnlinePlayers()) {
			p2.hidePlayer(pp);
		}
		hide.add(p2);
		p1.showPlayer(p2);
		p2.showPlayer(p1);
		p1.updateInventory();
		p2.updateInventory();
		p1.sendMessage((Main.cfg_x1.getString("x1.msg.invite_accept")).replace("$player$", p2.getName()).replace("&", "§"));
		p2.sendMessage((Main.cfg_x1.getString("x1.msg.guest_accept")).replace("$player$", p1.getName()).replace("&", "§"));
	}

	@EventHandler
	public void interact(PlayerInteractEvent e) {
		if (Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) {
			if (e.getAction().name().contains("RIGHT_CLICK")) {
				if (e.getPlayer().getItemInHand().getType().equals(Material.REDSTONE)) {
					sair1v1(e.getPlayer());
				}
			}
		}
	}

	@EventHandler
	public void entrar(PlayerJoinEvent e) {
		for (Player p : hide) {
			p.hidePlayer(e.getPlayer());
		}
	}

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent e) {
		if (Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) {
			e.getPlayer().sendMessage(Main.cfg_x1.getString("x1.msg.no_cmd").replace("&", "§"));
			e.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void kick(PlayerQuitEvent e) {
		if (lutadores.containsKey(e.getPlayer().getName())) {
			Player matou = Bukkit.getServer().getPlayerExact(lutadores.get(e.getPlayer().getName()));
			Player perdedor = e.getPlayer();
			matou.sendMessage((Main.cfg_x1.getString("x1.msg.disconect")));
			hide.remove(perdedor);
			hide.remove(matou);
			for (Player pp : Bukkit.getOnlinePlayers()) {
				matou.showPlayer(pp);
				perdedor.showPlayer(pp);
			}
			entrar1v1(matou);
		}
	}

	@EventHandler
	public void kick(PlayerKickEvent e) {
		if (lutadores.containsKey(e.getPlayer().getName())) {
			Player matou = Bukkit.getServer().getPlayerExact(lutadores.get(e.getPlayer().getName()));
			Player perdedor = e.getPlayer();
			matou.sendMessage((Main.cfg_x1.getString("x1.msg.disconect")));
			hide.remove(perdedor);
			hide.remove(matou);
			for (Player pp : Bukkit.getOnlinePlayers()) {
				matou.showPlayer(pp);
				perdedor.showPlayer(pp);
			}
			entrar1v1(matou);
		}
	}

	@EventHandler
	public void morrer(PlayerDeathEvent e) {
		Player p = e.getEntity().getPlayer();
		Player k = p.getKiller();
		if (!Habilidade.getAbility(p).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability")))
			return;
		if ((e.getEntity() instanceof Player)) {
			p.spigot().respawn();
			p.setFireTicks(0);
			for (PotionEffect effect : p.getActivePotionEffects())
				p.removePotionEffect(effect.getType());
		}
		if ((p instanceof Player) && (k instanceof Player)) {
			p.spigot().respawn();
			p.setFireTicks(0);
			for (PotionEffect effect : p.getActivePotionEffects())
				p.removePotionEffect(effect.getType());
		}
		if (lutadores.containsKey(e.getEntity().getPlayer().getName())) {
			new BukkitRunnable() {

				@Override
				public void run() {
					Player matou = Bukkit.getServer()
							.getPlayerExact(lutadores.get(e.getEntity().getPlayer().getName()));
					Player morreu = e.getEntity().getPlayer();
					morreu.spigot().respawn();
					lutadores.remove(morreu.getName());
					lutadores.remove(matou.getName());
					hide.remove(matou);
					hide.remove(morreu);
					entrar1v1(matou);
					entrar1v1(morreu);
					morreu.updateInventory();
					matou.updateInventory();
					for (Player online : Bukkit.getOnlinePlayers()) {
						morreu.showPlayer(online);
						matou.showPlayer(online);
					}

				}
			}.runTaskLater(Main.plugin, 5);
		}
	}

	@SuppressWarnings("deprecation")
	@EventHandler
	public void InteractItem(PlayerInteractEntityEvent e) {
		if (Habilidade.getAbility(e.getPlayer()).equalsIgnoreCase(Main.cfg_x1.getString("x1.ability"))) {
			if (((e.getRightClicked() instanceof Player))
					&& (e.getPlayer().getItemInHand().getType() == Material.BLAZE_ROD)) {
				Player p = e.getPlayer();
				Player target = (Player) e.getRightClicked();
				if (convites.containsKey(target.getName())) {
					if (((String) convites.get(target.getName())).equalsIgnoreCase(p.getName())) {
						aceitar(target, p);
					} else if (!convites.containsKey(p.getName())) {
						p.sendMessage((Main.cfg_x1.getString("§6" + "x1.msg.invite").replace("$player$", target.getName())));
						target.sendMessage(
								(Main.cfg_x1.getString("§6" + "x1.msg.guest").replace("$player$", p.getName())));
						convites.put(p.getName(), target.getName());
						Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable() {

							@Override
							public void run() {
								if (convites.containsKey(p.getName())) {
									convites.remove(p.getName());
								}
							}
						}, 200L);
					} else {
						p.sendMessage((Main.cfg_x1.getString("x1.msg.invite_cooldown")).replace("&", "§"));
					}
				} else if (!convites.containsKey(p.getName())) {
					p.sendMessage((Main.cfg_x1.getString("x1.msg.invite").replace("$player$", target.getName().replace("&", "§"))));
					target.sendMessage(
							(Main.cfg_x1.getString("x1.msg.guest").replace("$player$", p.getName().replace("&", "§"))));
					convites.put(p.getName(), target.getName());
					Bukkit.getServer().getScheduler().runTaskLater(Main.plugin, new BukkitRunnable() {

						@Override
						public void run() {
							if (convites.containsKey(p.getName())) {
								convites.remove(p.getName());
							}
						}
					}, 200L);
				} else {
					p.sendMessage((Main.cfg_x1.getString("x1.msg.invite_cooldown")).replace("&", "§"));
				}

			}
		}
	}


/*     */   private static ItemStack make(Material material, int amount, int shrt, String displayName, java.util.List<String> lore) {
/* 804 */     ItemStack item = new ItemStack(material, amount, (short)shrt);
/* 805 */     ItemMeta meta = item.getItemMeta();
/* 806 */     meta.setDisplayName(displayName);
/* 807 */     meta.setLore(lore);
/* 808 */     item.setItemMeta(meta);
/* 809 */     return item;
/*     */   }
/*     */ }
