package me.gomes.ctfcore.ctfgame.services.context;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import lombok.Getter;
import lombok.Setter;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.dtos.CTFMap;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import me.gomes.ctfcore.ctfgame.dtos.CTFTeam;
import me.gomes.ctfcore.ctfgame.services.filestorage.FileService;
import me.gomes.ctfcore.ctfgame.services.plugin.managers.TeamManagerService;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@Singleton
public class ContextService extends AbstractModule
{
  @Getter
  private List<CTFPlayer> Players = new ArrayList<>();;
  @Getter
  private CTFMap Map;
  @Inject
  private final TeamManagerService _teamService;
  @Inject
  private FileService _fileService;
  @Getter @Setter
  private boolean Started = false;
  @Getter @Setter
  private boolean Finished = false;

  @Inject
  public ContextService(FileService fileService, TeamManagerService teamService)
  {
    this._teamService = teamService;
    this._fileService = fileService;
  }

  public void AddPlayer(CTFPlayer player)
  {
    Players.add(player);
    _teamService.AddPlayer(player);
  }

  public CTFPlayer GetPlayer(Player player){
    return Players.stream().filter(e -> e.Id().equals(player.getUniqueId())).findFirst().get();
  }

  public CTFTeam getBlue(){
    return this._teamService.GetTeam(TeamEnum.Blue);
  }
  public CTFTeam getRed(){
    return this._teamService.GetTeam(TeamEnum.Red);
  }

  public void RemovePlayer(CTFPlayer p) {
    Players.remove(p);
    _teamService.RemovePlayer(p);
  }
}
