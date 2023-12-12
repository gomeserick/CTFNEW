package me.gomes.ctfcore.ctfgame.application.contracts.requests;

import me.gomes.ctfcore.ctfgame.application.contracts.enums.ClassEnum;

import java.util.UUID;

public record PlayerRequest(UUID Id, ClassEnum lastClass, ClassEnum defaultClass)
{
}
