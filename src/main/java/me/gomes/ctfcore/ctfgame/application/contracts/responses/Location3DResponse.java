package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import java.util.UUID;

public record Location3DResponse(
	UUID Id,
	double x1,
	double y1,
	double z1,
	double x2,
	double y2,
	double z2)
{
}
