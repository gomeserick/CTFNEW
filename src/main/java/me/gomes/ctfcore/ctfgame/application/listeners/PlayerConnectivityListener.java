package me.gomes.ctfcore.ctfgame.application.listeners;

import com.google.inject.Inject;
import me.gomes.ctfcore.ctfgame.CTFGame;
import me.gomes.ctfcore.ctfgame.services.context.ContextService;
import me.gomes.ctfcore.ctfgame.services.filestorage.FileService;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerConnectivityListener implements Listener
{
  @Inject
  private final CTFGame _plugin;
  @Inject
  private final ContextService _context;
  @Inject
  private final FileService _fileService;

  @Inject
  public PlayerConnectivityListener(CTFGame plugin, ContextService context, FileService reader)
  {
	this._plugin = plugin;
    this._context = context;
    this._fileService = reader;
  }

  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent event)
  {
    var player = _fileService.ReadPlayer(event.getPlayer());
    _context.AddPlayer(player);
    player.Player().sendMessage("Você está no time" + player.Team().toString());
  }
  @EventHandler
  public void onPlayerLeft(PlayerQuitEvent event)
  {
   var player = _context.GetPlayer(event.getPlayer());
   _fileService.SavePlayer(player);
    _context.RemovePlayer(player);
  }
}
