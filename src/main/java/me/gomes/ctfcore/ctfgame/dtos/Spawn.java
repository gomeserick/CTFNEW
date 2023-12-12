package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.PlayerRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.SpawnRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.PlayerResponse;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.SpawnResponse;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.UUID;

public record Spawn(UUID Id, TeamEnum Team, double Range, String SpawnBlock, MapLocation SpawnLocation, MapLocation3D SpawnRange)
{
  public SpawnRequest MapToRequest(){
	return new SpawnRequest(Id, Team, Range, SpawnBlock, SpawnLocation.MapToRequest(), SpawnRange.MapToRequest());
  }

  public static Spawn MapFromResponse(SpawnResponse spawn) {
	return new Spawn(spawn.Id(), spawn.Team(), spawn.Range(), spawn.SpawnBlock(), MapLocation.MapFromResponse(spawn.SpawnLocation()), MapLocation3D.MapFromResponse(spawn.SpawnRange()));
  }
}
