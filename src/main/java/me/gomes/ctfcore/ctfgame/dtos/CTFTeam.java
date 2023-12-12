package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public record CTFTeam(TeamEnum Team, List<CTFPlayer> Players, int Points, boolean isFlagStolen)
{
  public Optional<CTFPlayer> GetPlayer(UUID id)
  {
	return this.Players.stream().filter(e -> e.Id().equals(id)).findFirst();
  }
}
