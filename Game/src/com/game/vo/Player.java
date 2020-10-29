package com.game.vo;

import java.util.ArrayList;
import java.util.List;

// to Store user related info for later 
public class Player {

	// currently require only score for each user
	String name;
	List<Integer> gameIdList;

	public Player(String name) {
		this.name = name;
		gameIdList = new ArrayList<Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addGame(int gameId) {
		gameIdList.add(gameId);
	}

	public List<Integer> getGameIdList() {
		return gameIdList;
	}

	public void setGameIdList(List<Integer> gameIdList) {
		this.gameIdList = gameIdList;
	}

}
