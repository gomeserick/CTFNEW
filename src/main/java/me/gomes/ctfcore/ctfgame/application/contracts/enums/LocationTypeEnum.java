package me.gomes.ctfcore.ctfgame.application.contracts.enums;

import lombok.Getter;

public enum LocationTypeEnum
{
  spawn(0),
  worldSpawn(1),
  flag(2);
  final int Id;
  LocationTypeEnum(int id){
	this.Id = id;
  }
}
