package me.gomes.ctfcore.ctfgame.services.plugin.managers;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import me.gomes.ctfcore.ctfgame.dtos.CTFTeam;

import java.util.ArrayList;
@Singleton
public class TeamManagerService extends AbstractModule
{
  private final CTFTeam Blue;
  private final CTFTeam Red;

  public TeamManagerService()
  {
	this.Blue = new CTFTeam(TeamEnum.Blue, new ArrayList<CTFPlayer>(), 0, false);
	this.Red = new CTFTeam(TeamEnum.Red, new ArrayList<CTFPlayer>(), 0, false);
  }

  public CTFTeam AddPlayer(CTFPlayer player)
  {
	var team = GetNextTeam();
	team.Players().add(player);
	return team;
  }

  public CTFTeam RemovePlayer(CTFPlayer player)
  {
	var team = GetTeam(player.Team());
	team.Players().remove(player);
	return team;
  }

  public CTFTeam GetTeam(TeamEnum team)
  {
	return team == TeamEnum.Blue ? Blue : Red;
  }

  public CTFTeam GetNextTeam()
  {
	if (Blue.Players().size() > Red.Players().size()) return Red;
	else if (Blue.Players().size() < Red.Players().size()) return Blue;

	return Math.random() > 0.5 ? Blue : Red;
  }
}
