package me.gomes.ctfcore.ctfgame.application.contracts.enums;

import lombok.Getter;
import net.kyori.adventure.text.format.NamedTextColor;

public enum TeamEnum
{
  Blue(0, "Azul", NamedTextColor.BLUE),
  Red(1, "Vermelho", NamedTextColor.RED);
  @Getter
  final int Id;
  @Getter
  final String Name;
  @Getter
  final NamedTextColor ColorCode;

  private TeamEnum(int id, String name, NamedTextColor colorCode){
	this.Id = id;
	this.Name = name;
	this.ColorCode = colorCode;
  }
}
