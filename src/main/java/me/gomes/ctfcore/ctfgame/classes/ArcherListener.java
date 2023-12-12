package me.gomes.ctfcore.ctfgame.classes;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.ClassEnum;
import me.gomes.ctfcore.ctfgame.services.context.ContextService;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class ArcherListener extends AbstractModule implements Listener
{
  @Inject
  private final ContextService _context;

  @Inject
  public ArcherListener(ContextService context)
  {
	_context = context;
  }

  @EventHandler
  public void HeadShot(EntityDamageByEntityEvent event)
  {
	var entityDamaged = event.getEntity();
	var entityDamager = event.getDamager();

	if (!(entityDamaged instanceof Player)) return;

	if (!(entityDamager instanceof Arrow)) return;

	var arrow = (Arrow) entityDamager;

	if(!(arrow.getShooter() instanceof Player))
	  return;
	var shooter = arrow.getShooter();
	var damager = _context.GetPlayer((Player) shooter);
	var damaged = _context.GetPlayer((Player) entityDamaged);

	if (damager.LastClass() != ClassEnum.Arqueiro) return;

	var damagerLocation = damager.Player().getLocation();
	var damagedLocation = damaged.Player().getLocation();

	if (damagerLocation.distance(damagedLocation) <= 25) return;

	event.setDamage(69420);

  }
}
