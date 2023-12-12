package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import java.util.UUID;

public record LocationRequest(UUID Id, double x, double y, double z)
{
}
