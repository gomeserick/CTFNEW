package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import java.util.UUID;

public record SpongeResponse(UUID Id, double vx, double vy, double vz, LocationResponse Location)
{

}
