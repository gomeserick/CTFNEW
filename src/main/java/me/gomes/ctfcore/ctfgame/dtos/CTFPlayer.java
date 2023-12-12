package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.ClassEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.PlayerRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.PlayerResponse;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.UUID;

public record CTFPlayer(UUID Id, ClassEnum LastClass, ClassEnum DefaultClass, @Nullable TeamEnum Team, @Nullable Player Player)
{
  public PlayerRequest MapToRequest(){
	return new PlayerRequest(this.Id, this.LastClass, this.DefaultClass);
  }

  public static CTFPlayer MapFromResponse(PlayerResponse r, TeamEnum team, @Nullable Player player) {
	return new CTFPlayer(r.Id(), r.lastClass(), r.defaultClass(), team, player);
  }
}
