package me.RafaelAulerDeMeloAraujo.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class NoExplosion
  implements Listener
{
  @EventHandler
  public void NoExplodeMyMapPlease(EntityExplodeEvent e)
  {
    e.setCancelled(true);
  }
}

