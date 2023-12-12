package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.requests.LocationRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.LocationResponse;

import javax.annotation.Nullable;
import java.util.UUID;

public record MapLocation(UUID Id, double x, double y, double z)
{
  public LocationRequest MapToRequest(){
	return new LocationRequest(this.Id, this.x, this.y, this.z);
  }
  public static MapLocation MapFromResponse(LocationResponse r){
	return new MapLocation(r.Id(), r.x(), r.y(), r.z());
  }
}