package me.RafaelAulerDeMeloAraujo.SpecialAbility;
import java.util.*;
import org.bukkit.entity.*;

import me.RafaelAulerDeMeloAraujo.main.Main;

import org.bukkit.*;

public class Cooldown
{
    public static HashMap<Player, Long> run;
   
    static {
        Cooldown.run = new HashMap<Player, Long>();
    }
    
    	/*     */   
    	/*     */   
    public static void add(final Player p, final int seconds) {
        final long cooldownLength = System.currentTimeMillis() + seconds * 1000;
        Cooldown.run.remove(p);
        Cooldown.run.put(p, cooldownLength);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Cooldown.run.remove(p);
            }
        }, (long)(seconds * 20));
    }
    
    public static long cooldown(final Player p) {
        final long cooldownLength = Cooldown.run.get(p);
        final long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
        return left;
    }
    
    public static boolean add(final Player p) {
        return Cooldown.run.containsKey(p);
    }
    
    public static void remove(final Player p) {
        Cooldown.run.remove(p);
    }
}
