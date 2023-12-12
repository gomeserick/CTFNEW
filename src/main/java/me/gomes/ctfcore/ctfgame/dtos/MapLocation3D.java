package me.gomes.ctfcore.ctfgame.dtos;

import me.gomes.ctfcore.ctfgame.application.contracts.requests.Location3DRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.LocationRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.Location3DResponse;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.LocationResponse;

import java.util.UUID;

public record MapLocation3D(UUID Id, double x1, double y1, double z1, double x2, double y2, double z2)
{
  public Location3DRequest MapToRequest(){
	return new Location3DRequest(this.Id, this.x1, this.y1, this.z1, this.x2, this.y2, this.z2);
  }

  public static MapLocation3D MapFromResponse(Location3DResponse r){
	return new MapLocation3D(r.Id(), r.x1(), r.y1(), r.z1(), r.x2(), r.y2(), r.z2());
  }
}
