package com.game.dao;

import com.game.vo.Game;
import com.game.vo.Player;

public interface DaoService {

	/**
	 * @param user
	 */
	default void saveUser(Player user) {
		return;
	}

	/**
	 * @param name
	 * @return
	 */
	default Player getUser(String name) {
		return null;
	}

	/**
	 * @param id
	 * @return
	 */
	default Game getGame(int id) {
		return null;
	}

	/**
	 * @param game
	 */
	default void saveGame(Game game) {
		return;
	}
}
