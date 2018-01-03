package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.event.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.event.block.*;
import org.bukkit.block.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.meta.*;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Join;

import org.bukkit.inventory.*;

public class SoupSign implements Listener
{
    @EventHandler
    public void onSignChange(final SignChangeEvent e) {
        if (e.getLine(0).equalsIgnoreCase("[kp]") && e.getLine(1).equalsIgnoreCase("soup") && e.getPlayer().hasPermission("kitpvp.createsigns")) {
            e.setLine(0, "§4=-=-=-=");
            e.setLine(1, "§2Free");
            e.setLine(2, "§bSoup!");
            e.setLine(3, "§4=-=-=-=");
        }
    }
    
    @EventHandler
    public void inv(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack sopas = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopasm = sopas.getItemMeta();
        sopasm.setDisplayName("§6Soup");
        sopas.setItemMeta(sopasm);
        final Inventory inve = Bukkit.getServer().createInventory((InventoryHolder)p, 36, "§bFree Soups!");
        inve.setItem(0, sopas);
        inve.setItem(1, sopas);
        inve.setItem(2, sopas);
        inve.setItem(3, sopas);
        inve.setItem(4, sopas);
        inve.setItem(5, sopas);
        inve.setItem(6, sopas);
        inve.setItem(7, sopas);
        inve.setItem(8, sopas);
        inve.setItem(9, sopas);
        inve.setItem(10, sopas);
        inve.setItem(11, sopas);
        inve.setItem(12, sopas);
        inve.setItem(13, sopas);
        inve.setItem(14, sopas);
        inve.setItem(15, sopas);
        inve.setItem(16, sopas);
        inve.setItem(17, sopas);
        inve.setItem(18, sopas);
        inve.setItem(19, sopas);
        inve.setItem(20, sopas);
        inve.setItem(21, sopas);
        inve.setItem(22, sopas);
        inve.setItem(23, sopas);
        inve.setItem(24, sopas);
        inve.setItem(25, sopas);
        inve.setItem(26, sopas);
        inve.setItem(27, sopas);
        inve.setItem(28, sopas);
        inve.setItem(29, sopas);
        inve.setItem(30, sopas);
        inve.setItem(31, sopas);
        inve.setItem(32, sopas);
        inve.setItem(33, sopas);
        inve.setItem(34, sopas);
        inve.setItem(35, sopas);
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null && (e.getClickedBlock().getType() == Material.WALL_SIGN || e.getClickedBlock().getType() == Material.SIGN_POST)) {
            final Sign s = (Sign)e.getClickedBlock().getState();
            final String[] lines = s.getLines();
            if (lines.length > 0 && lines[0].equals("§4=-=-=-=") && lines.length > 1 && lines[1].equals("§2Free") && lines.length > 2 && lines[2].equals("§bSoup!") && lines.length > 3 && lines[3].equals("§4=-=-=-=") && Join.game.contains(p.getName())) {
                p.openInventory(inve);
            }
        }
    }
    
    
}

  

