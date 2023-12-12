package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.requests.MapRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.MapResponse;
import org.bukkit.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public record CTFMap(
	UUID Id,
	String Name,
	Spawn StartSpawn,
	Spawn BlueSpawn,
	Spawn RedSpawn,
	MapLocation BlueFlag,
	MapLocation RedFlag,
	List<Sponge> Sponges,
	@Nullable World World)
{
  public MapRequest mapToRequest(){
	return new MapRequest(
		this.Id,
		this.Name,
		this.StartSpawn.MapToRequest(),
		this.BlueSpawn.MapToRequest(),
		this.RedSpawn.MapToRequest(),
		this.BlueFlag.MapToRequest(),
		this.RedFlag.MapToRequest(),
		this.Sponges.stream().map(e -> e.MapToRequest()).collect(Collectors.toList()));
  }

  public static CTFMap MapFromResponse(MapResponse r, @Nullable World world) {
	return new CTFMap(
		r.Id(),
		r.Name(),
		Spawn.MapFromResponse(r.StartSpawn()),
		Spawn.MapFromResponse(r.BlueSpawn()),
		Spawn.MapFromResponse(r.RedSpawn()),
		MapLocation.MapFromResponse(r.BlueFlag()),
		MapLocation.MapFromResponse(r.RedFlag()),
		r.Sponges().stream().map(e -> Sponge.MapFromResponse(e)).collect(Collectors.toList()),
		world);
  }
}
