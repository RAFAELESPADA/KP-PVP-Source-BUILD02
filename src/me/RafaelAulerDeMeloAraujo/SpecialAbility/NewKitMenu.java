package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;



import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;




import org.bukkit.enchantments.Enchantment;

public class NewKitMenu 
implements Listener, CommandExecutor
{
	
	@EventHandler
	public void kits(InventoryClickEvent e)
	{
	  if ((e.getCurrentItem() != null) && (e.getCurrentItem().getItemMeta() != null))
	  {
	    Inventory inv = e.getInventory();
	    Player p = (Player)e.getWhoClicked();
	    if (inv.getTitle().equals("§bKit Menu"))
	    {
	      p.playSound(p.getLocation(), Sound.BLOCK_WOODEN_DOOR_CLOSE, 5.0F, 5.0F);
	      e.setCancelled(true);
	      
	      
	      
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lPvP")){
	    	  Bukkit.dispatchCommand(p, "kpvp");
	    	  p.closeInventory();
	      }
	    
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lArcher"))
	        {
	          Bukkit.dispatchCommand(p, "archer");
	          p.closeInventory();
	        }
	      if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lWarper"))
	        {
	          Bukkit.dispatchCommand(p, "warper");
	          p.closeInventory();
	        }
	        
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lKangaroo"))
	        {
	          Bukkit.dispatchCommand(p, "kangaroo");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lFisherman"))
	        {
	          Bukkit.dispatchCommand(p, "fisherman");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lGladiator"))
	        {
	          Bukkit.dispatchCommand(p, "gladiator");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lCritical"))
	        {
	          Bukkit.dispatchCommand(p, "critical");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lMonk"))
	        {
	          Bukkit.dispatchCommand(p, "monk");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lSnail"))
	        {
	          Bukkit.dispatchCommand(p, "snail");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lViper"))
	        {
	          Bukkit.dispatchCommand(p, "viper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lThor"))
	        {
	          Bukkit.dispatchCommand(p, "kthor");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lNinja"))
	        {
	          Bukkit.dispatchCommand(p, "ninja");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lStomper"))
	        {
	          Bukkit.dispatchCommand(p, "stomper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lTimeLord"))
	        {
	          Bukkit.dispatchCommand(p, "timelord");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lDoubleJump"))
	        {
	          Bukkit.dispatchCommand(p, "doublejump");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lJumper"))
	        {
	          Bukkit.dispatchCommand(p, "jumper");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lCactus"))
	        {
	          Bukkit.dispatchCommand(p, "cactus");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lNaruto"))
	        {
	          Bukkit.dispatchCommand(p, "naruto");
	          p.closeInventory();
	        }
	        if ((inv.getName().equals("§bKit Menu")) && (e.getCurrentItem().getType() == Material.BARRIER)) {
	  	      p.closeInventory();
	  	      p.sendMessage("§2§l\u2714 §aYou close the Kit Menu Successfully!");

	  	      }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lBomber"))
	        {
	          Bukkit.dispatchCommand(p, "bomber");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lBasic"))
	        {
	          Bukkit.dispatchCommand(p, "basic");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lSpiderman"))
	        {
	          Bukkit.dispatchCommand(p, "spiderman");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lAirman"))
	        {
	          Bukkit.dispatchCommand(p, "airman");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lSwitcher"))
	        {
	          Bukkit.dispatchCommand(p, "switcher");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lWasp"))
	        {
	          Bukkit.dispatchCommand(p, "wasp");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lPyro"))
	        {
	          Bukkit.dispatchCommand(p, "pyro");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lTank"))
	        {
	          Bukkit.dispatchCommand(p, "tank");
	          p.closeInventory();
	        }
	        if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6\u27a1 §7Kit §e§lDeshfire"))
	        {
	          Bukkit.dispatchCommand(p, "deshfire");
	          p.closeInventory();
	        }
	        
	       
	     }
	  }
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean onCommand(CommandSender sender, Command cmd, String CommandLabel, String[] args) {
		if(!(sender instanceof Player)){
			return true;
		}
		Player p = (Player)sender;
		if(cmd.getName().equalsIgnoreCase("kpkitmenu")){
			
			Inventory kits = Bukkit.createInventory(p, 54, "§bKit Menu");
			
			ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)14);
			ItemMeta vidro2 = vidro.getItemMeta();
			vidro2.setDisplayName("§cSlot blocked. Buy more kits on shop to unlock!");
			vidro.setItemMeta(vidro2);
			
			ItemStack vidro1 = new ItemStack(Material.STAINED_GLASS_PANE,1,(short)7);
			ItemMeta vidro12 = vidro1.getItemMeta();
			vidro12.setDisplayName("§a§k========");
			vidro1.setItemMeta(vidro12);
			
			ItemStack barrier = new ItemStack(Material.BARRIER);
			ItemMeta barrier2 = barrier.getItemMeta();
			barrier2.setDisplayName("§4§l\u2716 §a§lClose the Kit Menu");
			barrier.setItemMeta(barrier2);
			
			 
			 kits.setItem(27, vidro1);
			 kits.setItem(28, vidro1);
			 kits.setItem(29, vidro1);
			 kits.setItem(30, vidro1);
			 kits.setItem(31, vidro1);
			 kits.setItem(32, vidro1);
			 kits.setItem(33, vidro1);
			 kits.setItem(34, vidro1);
			 kits.setItem(35, vidro1);
			 kits.setItem(36, vidro1);
			 kits.setItem(37, vidro1);
			 kits.setItem(38, vidro1);
			 kits.setItem(39, vidro1);
			 kits.setItem(40, vidro1);
			 kits.setItem(41, vidro1);
			 kits.setItem(42, vidro1);
			 kits.setItem(43, vidro1);
			 kits.setItem(44, vidro1);
			 kits.setItem(45, vidro1);
			 kits.setItem(46, vidro1);
			 kits.setItem(47, vidro1);
			 kits.setItem(48, vidro1);
			 kits.setItem(49, vidro1);
			 kits.setItem(50, vidro1);
			 kits.setItem(51, vidro1);
			 kits.setItem(52, vidro1);
			 kits.setItem(53, barrier);
			
			
		     {
				ItemStack pyro = new ItemStack(Material.STONE_SWORD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lBasic");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7A Basic and Stantard kit!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.pvp")){
				ItemStack pyro = new ItemStack(Material.DIAMOND_SWORD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lPvP");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7A Stronger version of basic kit !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.kangaroo")){
				ItemStack pyro = new ItemStack(Material.FIREWORK);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lKangaroo");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Do double jumps");
			      indiob.add("§7using your firework !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.archer")){
				ItemStack pyro = new ItemStack(Material.BOW);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lArcher");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Starts with sword,bow and arrows !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.tank")){
				ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
				
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lTank");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Your armor is strong !");
			      indiob.add("§7but you are slow!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.snail")){
				ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lSnail");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Have a 33% chance do give slow a each hit !");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.viper")){
				ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lViper");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Have a 33% chance do give slow a each hit !!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.stomper")){
				ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lStomper");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Get a boost");
			      indiob.add("§7and smash your enemies");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.deshfire")){
				ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lDeshfire");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Get a boost");
			      indiob.add("§7and put your enemies on fire!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.monk")){
				ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lMonk");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Right click on your enemy");
			      indiob.add("§7And mix they inventory");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.critical")){
				ItemStack pyro = new ItemStack(Material.GOLDEN_APPLE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lCritical");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Have a 10% of chance to do more damage on each hit!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.gladiator")){
				ItemStack pyro = new ItemStack(Material.IRON_FENCE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lGladiator");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Challenge someome into you glass arena!");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.thor")){
				ItemStack pyro = new ItemStack(Material.GOLD_AXE);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lThor");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Thunderbolts with your axe");
			      indiob.add("§7and be immune to them");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.doublejump")){
				ItemStack pyro = new ItemStack(Material.CHAINMAIL_BOOTS);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lDoubleJump");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Press space two times");
			      indiob.add("§7and do a doublejump");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.bomber")){
				ItemStack pyro = new ItemStack(Material.TNT);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lBomber");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Throws tnt and");
			      indiob.add("§7become a terrorist");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.wasp")){
				ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lWasp");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Starts with a");
			      indiob.add("§7Sharp VII BlazeHod");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.airman")){
				ItemStack pyro = new ItemStack(Material.FEATHER);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lAirman");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7With this kit");
			      indiob.add("§7your can fly with your feather");
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			 if (p.hasPermission("kitpvp.kit.switcher"))
		      {
		        ItemStack pyro = new ItemStack(Material.SNOW_BALL, 16);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lSwitcher");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Swap your location with your enemy");
		        indiob.add("§7With your snowballs!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
			if(p.hasPermission("kitpvp.kit.ninja")){
				ItemStack pyro = new ItemStack(Material.COAL);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lNinja");
			      ArrayList indiob = new ArrayList();
			      metapyro.setLore(indiob);
			      indiob.add("§7If you hurt a player and");
			      indiob.add("§7and sneak you get");
			      indiob.add("§7Teleported to him");
			      metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.cactus")){
				ItemStack pyro = new ItemStack(Material.CACTUS);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lCactus");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Get a thorns armor");
			      
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.pyro")){
				ItemStack pyro = new ItemStack(Material.FLINT_AND_STEEL);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lPyro");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Starts with a fire bow and fire sword");
			      
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
			if(p.hasPermission("kitpvp.kit.jumper")){
				ItemStack pyro = new ItemStack(Material.LEATHER_BOOTS);
			      ItemMeta metapyro = pyro.getItemMeta();
			      metapyro.setDisplayName("§6\u27a1 §7Kit §e§lJumper");
			      ArrayList indiob = new ArrayList();
			      indiob.add("§7Jumps all you can");
			      
				    metapyro.setLore(indiob);
			      pyro.setItemMeta(metapyro);
			      kits.addItem(new ItemStack[] { pyro });
			}
		
		      if (p.hasPermission("kitpvp.kit.timelord"))
		      {
		        ItemStack pyro = new ItemStack(Material.WATCH);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lTimeLord");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Stop the time");
		        indiob.add("§7And freeze your enemies");
		        indiob.add("§7With your magic clock");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.fisherman"))
		      {
		        ItemStack pyro = new ItemStack(Material.FISHING_ROD);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lFisherman");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7You can teleport players to you!");
		        indiob.add("§7Using your fishing rod!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.spiderman"))
		      {
		        ItemStack pyro = new ItemStack(Material.WEB);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lSpiderman");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7With this kit");
		        indiob.add("§7You can climb walls and jumps!");
		        indiob.add("§7Clicking in your sword!");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.warper"))
		      {
		        ItemStack pyro = new ItemStack(Material.ENDER_PEARL);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lWarper");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Starts with");
		        indiob.add("§7Sword , Armor and 8 ender pearls!");
		        
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
		      if (p.hasPermission("kitpvp.kit.naruto"))
		      {
		        ItemStack pyro = new ItemStack(Material.NETHER_STAR);
		        ItemMeta metapyro = pyro.getItemMeta();
		        metapyro.setDisplayName("§6\u27a1 §7Kit §e§lNaruto");
		        ArrayList indiob = new ArrayList();
		        indiob.add("§7Click on the nether star and gains!");
		        indiob.add("§7Strenght and Regeneration effects");
		        metapyro.setLore(indiob);
		        pyro.setItemMeta(metapyro);
		        kits.addItem(new ItemStack[] { pyro });
		      }
			ItemStack[] arrayOfItemStack;
		    int descpyro1 = (arrayOfItemStack = kits.getContents()).length;
		    for (int metapyro1 = 0; metapyro1 < descpyro1; metapyro1++)
		    {
		      ItemStack item = arrayOfItemStack[metapyro1];
		      if (item == null) {
		        kits.setItem(kits.firstEmpty(), vidro);
		      }
		    }
			
			p.openInventory(kits);
		}
		return true;
	}
}
