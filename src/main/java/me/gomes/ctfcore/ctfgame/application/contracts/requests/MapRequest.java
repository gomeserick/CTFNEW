package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import me.gomes.ctfcore.ctfgame.application.contracts.requests.LocationRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.SpawnRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.SpongeRequest;

import java.util.List;
import java.util.UUID;

public record MapRequest(UUID Id,
						 String Name,
						 SpawnRequest StartSpawn,
						 SpawnRequest BlueSpawn,
						 SpawnRequest RedSpawn,
						 LocationRequest BlueFlag,
						 LocationRequest RedFlag,
						 List<SpongeRequest> Sponges)
{
}
