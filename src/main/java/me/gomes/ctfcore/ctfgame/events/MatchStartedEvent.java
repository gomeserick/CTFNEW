package me.gomes.ctfcore.ctfgame.events;

import lombok.Getter;
import lombok.Setter;
import me.gomes.ctfcore.ctfgame.dtos.CTFMap;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import me.gomes.ctfcore.ctfgame.dtos.CTFTeam;
import me.gomes.ctfcore.ctfgame.services.context.ContextService;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.List;

public class MatchStartedEvent extends Event
{
  private static final HandlerList HANDLERS = new HandlerList();

  @Getter
  private final List<CTFPlayer> players;
  @Getter
  private final CTFTeam blue;
  @Getter
  private final CTFTeam red;
  @Getter
  private final CTFMap map;
  public MatchStartedEvent(ContextService context){
	this.players = context.getPlayers();
	this.blue = context.getBlue();
	this.red = context.getRed();
	this.map = context.getMap();
  }

  public static HandlerList getHandlerList() {
	return HANDLERS;
  }

  @Override
  public HandlerList getHandlers() {
	return HANDLERS;
  }
}
