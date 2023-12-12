package me.gomes.ctfcore.ctfgame.services.plugin;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.multibindings.Multibinder;
import me.gomes.ctfcore.ctfgame.CTFGame;
import org.bukkit.command.Command;

public class CTFPlugin extends AbstractModule
{

  private final CTFGame plugin;

  @Inject
  public CTFPlugin(CTFGame plugin) {
	this.plugin = plugin;
  }

  public Injector createInjector() {
	return Guice.createInjector(this);
  }

  @Override
  protected void configure() {
	// Here we tell Guice to use our plugin instance everytime we need it
	this.bind(CTFGame.class).toInstance(this.plugin);

	Multibinder<Command> commandBuilder = Multibinder.newSetBinder(binder(), Command.class);


  }
}
