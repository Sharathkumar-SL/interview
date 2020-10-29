package com.game.daoImpl;

import java.util.HashMap;
import java.util.Map;

import com.game.dao.DaoService;
import com.game.vo.Game;
import com.game.vo.Player;

public class DaoServiceImpl implements DaoService {

	Map<String, Player> userMap;
	Map<Integer, Game> gameMap;

	public DaoServiceImpl() {
		userMap = new HashMap<String, Player>();
		gameMap = new HashMap<Integer, Game>();
	}

	public void saveUser(Player user) {
		userMap.put(user.getName(), user);

	}

	public Player getUser(String name) {
		return userMap.get(name);
	}

	public Game getGame(int id) {
		return gameMap.get(id);
	}

	public void saveGame(Game game) {
		gameMap.put(game.getGameId(), game);
	}

}
