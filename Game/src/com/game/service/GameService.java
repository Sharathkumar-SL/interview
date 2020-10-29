package com.game.service;

/**
 * Interface
 * 
 * @author user
 *
 */
public interface GameService {

	/**
	 * @param userName
	 * @param round
	 * @return score by given user
	 */
	default int playGame(String userName, int round) {
		return 0;
	}
}
