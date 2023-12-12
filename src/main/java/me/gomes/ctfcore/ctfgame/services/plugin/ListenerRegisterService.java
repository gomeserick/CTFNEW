package me.gomes.ctfcore.ctfgame.services.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import me.gomes.ctfcore.ctfgame.CTFGame;
import me.gomes.ctfcore.ctfgame.application.listeners.PlayerConnectivityListener;
import me.gomes.ctfcore.ctfgame.classes.ArcherListener;
import org.bukkit.Bukkit;

public class ListenerRegisterService extends AbstractModule
{
  @Inject
  private final PlayerConnectivityListener playerJoin;
  @Inject
  private final ArcherListener archer;
  @Inject
  private final CTFGame plugin;
  @Inject
  public ListenerRegisterService(ArcherListener archer, CTFGame plugin, PlayerConnectivityListener playerJoin) {
	this.archer = archer;
	this.plugin = plugin;
	this.playerJoin = playerJoin;
  }

  public void registerListeners() {
	var manager = Bukkit.getPluginManager();

	manager.registerEvents(playerJoin, plugin);
	manager.registerEvents(archer, plugin);
  }
}
