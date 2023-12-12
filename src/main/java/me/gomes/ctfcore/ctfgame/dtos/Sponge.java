package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.requests.SpongeRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.LocationResponse;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.SpongeResponse;

import java.util.UUID;

public record Sponge(UUID Id, double vx, double vy, double vz, MapLocation Location)
{
  public SpongeRequest MapToRequest(){
	return new SpongeRequest(this.Id, this.vx, this.vy, this.vz, Location.MapToRequest());
  }
  public static Sponge MapFromResponse(SpongeResponse r){
	return new Sponge(r.Id(), r.vx(), r.vy(), r.vz(), MapLocation.MapFromResponse(r.Location()));
  }
}
