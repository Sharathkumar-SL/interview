package com.game.vo;

import java.util.HashMap;

public class Game {

	int gameId;
	int players;
	int rounds;
	HashMap<String, Scores> scoreMap;

	public Game() {
		players = 0;
		rounds = 0;
		scoreMap = new HashMap<String, Scores>();
	}

	public Scores getScoure(String name) {
		return scoreMap.get(name);
	}

	public void addScore(String name, Scores score) {
		scoreMap.put(name, score);
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getPlayers() {
		return players;
	}

	public void setPlayers(int players) {
		this.players = players;
	}

	public int getRounds() {
		return rounds;
	}

	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	public HashMap<String, Scores> getScoreMap() {
		return scoreMap;
	}

	public void setScoreMap(HashMap<String, Scores> scoreMap) {
		this.scoreMap = scoreMap;
	}

}
