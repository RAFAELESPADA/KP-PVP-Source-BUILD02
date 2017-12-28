package me.RafaelAulerDeMeloAraujo.SpecialAbility;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.RafaelAulerDeMeloAraujo.main.Main;



public class API
{
  
    public static String NomeServer;

    public static String fimcooldown;
	
	  public static String monkCooldownMessage = "§c§bYou cannot use your ability for more: §5 %s seconds!";
	  public String monkedMessage = "§cYou use your ability !";
	  public static int cooldownmonk = 15;
	  @SuppressWarnings("deprecation")
	public static int monkItemId = Material.BLAZE_ROD.getId();
	  public static boolean sendThroughInventory = true;
	  public static transient HashMap<ItemStack, Long> monkStaff = new HashMap<ItemStack, Long>();
	
	public static ArrayList<String> admin = new ArrayList<String>();
	public static ArrayList<String> report = new ArrayList<String>();
	
	public static ArrayList<String> used = new ArrayList<String>();
	public static ArrayList<String> warp = new ArrayList<String>();
	
	public static ArrayList<String> Velotrol2 = new ArrayList<String>();
	public static ArrayList<String> freeze = new ArrayList<String>();
	public static ArrayList<String> freezing = new ArrayList<String>();
	
	public static HashMap<Player, String> kit = new HashMap<Player, String>();
    
    public static void MensagemCooldown(final Player p) {
        p.sendMessage(String.valueOf(API.NomeServer) + " §bYou cannot use your ability for more: §5" + Cooldown.cooldown(p) + " §bseconds");
    }
   
    	   static {
    	       
    	        API.NomeServer = Main.getInstance().getConfig().getString("Prefix").replace("&", "§");
    	        
    	    
    	    
    	    
    	   }

		public static String fimcooldown(Player p) {
			p.sendMessage(Main.getInstance().getConfig().getString("Prefix").replace("&", "§") + (" §aYou can use your ability again!"));
			return null;
		}
    	   
}