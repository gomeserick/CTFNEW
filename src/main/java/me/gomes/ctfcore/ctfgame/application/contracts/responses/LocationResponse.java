package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import java.util.UUID;

public record LocationResponse(UUID Id, double x, double y, double z)
{
}
