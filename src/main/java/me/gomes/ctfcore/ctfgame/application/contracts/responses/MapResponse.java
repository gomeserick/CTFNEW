package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import java.util.List;
import java.util.UUID;

public record MapResponse(UUID Id,
						  String Name,
						  SpawnResponse StartSpawn,
						  SpawnResponse BlueSpawn,
						  SpawnResponse RedSpawn,
						  LocationResponse BlueFlag,
						  LocationResponse RedFlag,
						  List<SpongeResponse> Sponges)
{
}
