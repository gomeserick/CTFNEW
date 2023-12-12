package me.gomes.ctfcore.ctfgame.util;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import me.gomes.ctfcore.ctfgame.services.context.ContextService;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.audience.Audiences;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;

import java.util.stream.Collectors;

public class SpeakerService extends AbstractModule
{
  private final NamedTextColor CTFCOLOR = NamedTextColor.DARK_AQUA;
  private final NamedTextColor DEATHCOLOR = NamedTextColor.DARK_RED;
  private final NamedTextColor KILLCOLOR = NamedTextColor.DARK_GREEN;
  public final TextComponent CTF = Component.text()
      .append(Component.text("[CTF] ", CTFCOLOR))
      .build();
  public final TextComponent DEATH = Component.text()
      .append(Component.text("[MORREU]: ", DEATHCOLOR))
      .build();
  public final TextComponent KILL = Component.text()
      .append(Component.text("[MATOU]: ", KILLCOLOR))
      .build();

  private final ContextService _context;

  @Inject
  public SpeakerService(ContextService context)
  {
    this._context = context;
  }

  public void SendKillMessage(Audience audience, CTFPlayer killed){
    assert killed.Team() != null;
    audience.sendMessage(KILL
        .append(
            Component.text(
                killed.Player().getName(),
                killed.Team().getColorCode()))
        .append(Component.text(" ("+killed.LastClass()+")", NamedTextColor.GRAY))
    );
    Audience.audience(_context.getPlayers().stream().map(e -> e.Player()).collect(Collectors.toList()));
  }

  public void SendDeathMessage(Audience audience, CTFPlayer killer){
    assert killer.Team() != null;
    audience.sendMessage(KILL
        .append(
            Component.text(
                killer.Player().getName(),
                killer.Team().getColorCode()))
        .append(Component.text(" ("+killer.LastClass()+")", NamedTextColor.GRAY))
    );
    Audience.audience(_context.getPlayers().stream().map(e -> e.Player()).collect(Collectors.toList()));
  }

  public void SendCountDown(int seconds){
    var audicence = Audience.audience(_context.getPlayers().stream().map(e -> e.Player()).collect(Collectors.toList()));
    audicence.sendMessage(
        CTF.append(Component..text("A partida iniciará em ", NamedTextColor.GOLD))
            .append(Component.text(seconds, seconds > 10 ? NamedTextColor.WHITE : NamedTextColor.))
    );

  }
}
