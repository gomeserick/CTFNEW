package me.gomes.ctfcore.ctfgame.services.filestorage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import lombok.Getter;
import lombok.Setter;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.ClassEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.enums.TeamEnum;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.MapRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.requests.PlayerRequest;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.MapResponse;
import me.gomes.ctfcore.ctfgame.application.contracts.responses.PlayerResponse;
import me.gomes.ctfcore.ctfgame.dtos.CTFMap;
import me.gomes.ctfcore.ctfgame.dtos.CTFPlayer;
import org.bukkit.entity.Player;

import java.io.*;

public class FileService extends AbstractModule
{
  @Getter
  @Setter
  private String Url;

  @Inject
  public FileService()
  {
	try
	{
	  this.Url = new File(".").getCanonicalPath() + "\\plugins\\CTF\\";
	} catch (IOException e)
	{
	  System.err.println("Erro: Não foi possível encontrar o caminho do arquivo");
	  e.printStackTrace();
	}
  }

  private <T> T ReadFile(String path, Class<T> tClass) throws IOException
  {
	File file = new File(path);
	var reader = new FileReader(file);
	var gson = new Gson().fromJson(reader, tClass);
	reader.close();
	return gson;
  }

  public CTFPlayer ReadPlayer(Player player)
  {
	var url = this.Url + "Players\\" + player.getUniqueId() + ".json";
	try
	{
	  var p = this.ReadFile(url, PlayerResponse.class);
	  if (p == null)
	  {
		var ctfPlayer = new CTFPlayer(player.getUniqueId(), ClassEnum.Guerreiro, ClassEnum.Guerreiro, TeamEnum.Blue, player);
		this.SavePlayer(ctfPlayer);
		return ctfPlayer;
	  }
	  return CTFPlayer.MapFromResponse(p, TeamEnum.Blue, player);
	} catch (IOException e)
	{
	  try
	  {
		var file = new File(url);
		file.createNewFile();
		var ctfPlayer = new CTFPlayer(player.getUniqueId(), ClassEnum.Guerreiro, ClassEnum.Guerreiro, TeamEnum.Blue, player);
		this.SavePlayer(ctfPlayer);
		return ctfPlayer;
	  } catch (IOException ex)
	  {
		System.err.println("Erro ao criar o arquivo para o jogador " + player.getName());
		ex.printStackTrace();
	  }
	}
	return null;
  }

  public CTFMap ReadMap(String mapName)
  {
	var url = this.Url + "Maps\\" + mapName + ".json";
	try
	{
	  var m = this.ReadFile(url, MapResponse.class);
	  return CTFMap.MapFromResponse(m, null);
	} catch (IOException e)
	{
	  System.err.println("Erro: o mapa " + mapName + " não foi encontrado");
	}
	return null;
  }

  public void SavePlayer(CTFPlayer player)
  {
	var url = this.Url + "Players\\" + player.Id() + ".json";

	try
	{
	  var gson = new GsonBuilder().setPrettyPrinting().create();
	  var request = player.MapToRequest();
	  var writer = new FileWriter(url);

	  gson.toJson(request, writer);

	  writer.flush();
	  writer.close();
	} catch (IOException e)
	{
	  System.err.println("Erro: Não foi possivel salvar o jogador " + player.Player().name());
	}
  }

  public void SaveMap(CTFMap map)
  {
	var url = this.Url + "Maps\\" + map.Name() + ".json";
	try
	{
	  var writer = new FileWriter(url);
	  new Gson().toJson(map.mapToRequest(), new FileWriter(url));

	  writer.flush();
	  writer.close();
	} catch (IOException e)
	{
	  System.err.println("Erro: Não foi possivel salvar o mapa " + map.Name());
	}
  }
}
