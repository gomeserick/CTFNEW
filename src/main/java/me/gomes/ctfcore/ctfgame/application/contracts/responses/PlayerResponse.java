package me.gomes.ctfcore.ctfgame.application.contracts.responses;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.ClassEnum;

import java.util.UUID;

public record PlayerResponse(UUID Id, ClassEnum lastClass, ClassEnum defaultClass)
{
}
