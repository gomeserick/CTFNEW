package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.PlayerResponse;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import me.gomes.ctfcore.ctfgame.dtos.MapLocation;
import me.gomes.ctfcore.ctfgame.dtos.MapLocation3D;
import org.bukkit.entity.Player;

import javax.annotation.Nullable;
import java.util.UUID;

public record SpawnRequest(UUID Id, TeamEnum Team, double Range, String SpawnBlock, LocationRequest SpawnLocation, Location3DRequest SpawnRange)
{
}
