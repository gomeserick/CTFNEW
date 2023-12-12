package me.gomes.ctfcore.ctfgame.services.plugin.managers;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import me.gomes.ctfcore.ctfgame.services.context.ContextService;

import java.util.Timer;
import java.util.concurrent.*;

@Singleton
public class MatchManagerService extends AbstractModule
{
  private final ContextService context;
  private ScheduledThreadPoolExecutor schedule = new ScheduledThreadPoolExecutor(1);
  private ScheduledFuture<?> t;
  @Inject
  public MatchManagerService(ContextService context){
	this.context = context;
  }

  public void startMatch(){
	var players = this.context.getPlayers();
	if(players.size() <= 4)
	  return;

	this.context.setStarted(true);
  }

  public void scheduleMatch(int time){
	if(this.schedule.getCompletedTaskCount() != 0)
	  return;
	var executions = 60;
	t = this.schedule.scheduleAtFixedRate(new Runnable()
	{
	  @Override
	  public void run()
	  {

		if(executions == 0)
		schedule.shutdown();
	  }
	}, 0, 1*1000, TimeUnit.MILLISECONDS);

	this.schedule.
  }
}
