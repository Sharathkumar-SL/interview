package com.game.serviceImpl;

import java.util.Random;

import com.game.service.GameService;
import com.game.util.Constants;

public class GameServiceImpl implements GameService {

	public GameServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return Score
	 */
	public int playGame(String userName, int round) {

		int firstTry, secondTry, score;
		// first try
		firstTry = getRandomNumbers(Constants.MAX, Constants.MIN);
		if (firstTry == Constants.MAX) {
			score = Constants.FIRST_TRY_FULL_SCORE;
		} else {
			secondTry = getRandomNumbers(Constants.MAX - firstTry, Constants.MIN);
			score = firstTry + secondTry;
			if (score == Constants.MAX)
				score = Constants.SECOND_TRY_FULL_SCORE;
		}
		System.out.println("Score of user " + userName + " @ round : " + (round + 1) + "  is : " + score);
		return score;
	}

	/**
	 * @param max
	 * @param min
	 * @return
	 */
	private int getRandomNumbers(int max, int min) {
		Random random = new Random();
		return random.nextInt(max - min + 1) + min;
	}
}
