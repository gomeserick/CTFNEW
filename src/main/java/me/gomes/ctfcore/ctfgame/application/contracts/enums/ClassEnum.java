package me.gomes.ctfcore.ctfgame.application.contracts.enums;

public enum ClassEnum
{
  Guerreiro(0),
  Arqueiro(1),
  Curador(2),
  Soldado(3),
  Mago(4),
  Quimico(5),
  Ninja(6),
  Ladrao(7),
  Assassino(8),
  Indendiario(9);
  final int Id;

  ClassEnum(int id)
  {
	this.Id = id;
  }
}
