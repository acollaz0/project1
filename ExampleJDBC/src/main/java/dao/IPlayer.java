package dao;

import java.util.List;

import model.Player;

public interface IPlayer {
	
	public Player getPlayer(int p_id);
	public boolean addPlayer(Player p);
	public boolean deletePlayer(int p_id);
	public List<Player> allPlayers();

}
