package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

import me.RafaelAulerDeMeloAraujo.SpecialAbility.Habilidade;

public class NoExplosion
  implements Listener
{
  @EventHandler
  public void NoExplodeMyMapPlease(EntityExplodeEvent e)
  {
    e.setCancelled(true);
  }

@EventHandler
public void OnBlockBB(EntityDamageEvent e) {
	  if (!(e.getEntity() instanceof Player)) {
          return;
      }
	
	if (e.getCause() == EntityDamageEvent.DamageCause.BLOCK_EXPLOSION || e.getCause() == EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
		e.setCancelled(false);
	}
}
}

