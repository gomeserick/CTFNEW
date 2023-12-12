package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import java.util.UUID;

public record SpongeRequest(UUID Id, double vx, double vy, double vz, LocationRequest Location)
{
}
