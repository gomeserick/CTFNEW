package me.gomes.ctfcore.ctfgame;

import com.google.inject.Inject;
import me.gomes.ctfcore.ctfgame.services.plugin.CTFPlugin;
import me.gomes.ctfcore.ctfgame.services.plugin.ListenerRegisterService;
import org.bukkit.plugin.java.JavaPlugin;

public final class CTFGame extends JavaPlugin
{
  @Inject
  private ListenerRegisterService listenerRegister;
  @Override
  public void onEnable()
  {
	// Fetch dependencies. We only have to do it this way for our main class.
	var module = new CTFPlugin(this);
	var injector = module.createInjector();
	injector.injectMembers(this);

	this.listenerRegister.registerListeners();
  }

  @Override
  public void onDisable()
  {

  }
}
