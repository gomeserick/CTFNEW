package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.Location3DRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.LocationRequest;

import java.util.UUID;

public record SpawnResponse(UUID Id, TeamEnum Team, double Range, String SpawnBlock, LocationResponse SpawnLocation, Location3DResponse SpawnRange)
{
}
