package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import java.util.UUID;

public record Location3DRequest(
	UUID Id,
	double x1,
	double y1,
	double z1,
	double x2,
	double y2,
	double z2)
{
}
