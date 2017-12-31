package me.RafaelAulerDeMeloAraujo.SpecialAbility;


import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

import me.RafaelAulerDeMeloAraujo.main.Main;

  public class Sponge implements Listener
  {
      public static ArrayList<String> naotomardanoqueda;
      
      static {
    	  Sponge.naotomardanoqueda = new ArrayList<String>();
      }
      
      
      @EventHandler(priority = EventPriority.MONITOR)
      public void aoBlocoJump(final PlayerMoveEvent e) {
          final Player p = e.getPlayer();
          if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.SPONGE && Join.game.contains(p.getName())) {
        	  Sponge.naotomardanoqueda.add(p.getName());
              final Location loc = e.getTo().getBlock().getLocation();
              final Vector v = p.getVelocity().setY(4).multiply(2);
              p.setVelocity(v);
              p.playSound(loc, Sound.ENTITY_ENDERMEN_TELEPORT, 6.0f, 1.0f);
              p.playEffect(loc, Effect.MOBSPAWNER_FLAMES, (Object)null);
              Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                  @Override
                  public void run() {
                	  Sponge.naotomardanoqueda.remove(p.getName());
                  }
              }, 100L);
          }
      }
      
      @EventHandler
      public void aoCair(final EntityDamageEvent e) {
          if (e.getEntity() instanceof Player) {
              final Player p = (Player)e.getEntity();
              if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && Join.game.contains(p.getName()) &&  Sponge.naotomardanoqueda.contains(p.getName())) {
                  e.setCancelled(true);
              }
          }
      }
      
      @EventHandler
      public void aoMorrer(final PlayerDeathEvent e) {
          final Player p = e.getEntity();
          if (Sponge.naotomardanoqueda.contains(p.getName())) {
        	  Sponge.naotomardanoqueda.remove(p.getName());
          }
      }
      
      @EventHandler
      public void aoSair(final PlayerQuitEvent e) {
          final Player p = e.getPlayer();
          if (Sponge.naotomardanoqueda.contains(p.getName())) {
        	  Sponge.naotomardanoqueda.remove(p.getName());
          }
      }
      
      @EventHandler(priority = EventPriority.MONITOR)
      public void aoBlocoJumpPraFrente(final PlayerMoveEvent e) {
          final Player p = e.getPlayer();
          if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COAL) {
              final Location loc = e.getTo().getBlock().getLocation();
              final Vector v = p.getLocation().getDirection().multiply(4).setY(1);
              p.setVelocity(v);
              p.playSound(loc, Sound.ENTITY_HORSE_JUMP, 6.0f, 1.0f);
              p.playEffect(loc, Effect.MAGIC_CRIT, (Object)null);
          }
      }
  }

