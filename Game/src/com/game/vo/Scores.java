package com.game.vo;

import com.game.util.Constants;

public class Scores {

	int totoalScore;

	int[] roundScore;

	public Scores() {
		this.totoalScore = 0;
		roundScore = new int[Constants.MAX];

	}

	public int getTotoalScore() {
		return totoalScore;
	}

	public void setTotoalScore(int totoalScore) {
		this.totoalScore = totoalScore;
	}

	public int getRoundScore(int round) {
		return roundScore[round];
	}

	public void setRoundScore(int round, int score) {
		roundScore[round] = score;
	}

}
