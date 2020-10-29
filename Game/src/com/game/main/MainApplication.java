package com.game.main;

import java.util.Map;
import java.util.Scanner;

import com.game.dao.DaoService;
import com.game.factory.FactoryService;
import com.game.service.GameService;
import com.game.util.Constants;
import com.game.vo.Game;
import com.game.vo.Player;
import com.game.vo.Scores;

public class MainApplication {

	DaoService daoService = null;
	GameService service = null;
	int gameId = 0;

	/**
	 * Constructor
	 */
	public MainApplication() {
		service = FactoryService.getGameService();
		daoService = FactoryService.getDaoService();
	}

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		MainApplication app = new MainApplication();
		// get an input from users

		int option = 0;
		while (option != 3) {
			System.out.println(
					"Welcome, Please enter \n 1. to play game \n 2. to list game scores played by user \n 3. Exit");
			option = sc.nextInt();
			switch (option) {
			case Constants.OPTION_PLAY_GAME:
				Game game = app.getInputFromToPlayGame(sc);
				app.playGame(game);
				app.announceWinner(game);
				app.daoService.saveGame(game);
				app.gameId++;
				break;
			case Constants.OPTION_LIST_GAMES:
				String name = null;
				System.out.println("please enter the name of user : ");
				name = sc.next();
				app.displayUserDetails(name);
				break;
			default:
			}
		}
		System.out.println("Thanks for playing game");
	}

	/**
	 * @param sc
	 * @return
	 */
	private Game getInputFromToPlayGame(Scanner sc) {
		Game game = new Game();
		game.setGameId(gameId);

		System.out.println("Welcome to bowling game");
		System.out.println("Please enter number of rounds : ");
		game.setRounds(sc.nextInt());
		System.out.println("Please enter number of player : ");
		game.setPlayers(sc.nextInt());
		String name = null;
		Player user = null;
		for (int player = 0; player < game.getPlayers(); player++) {
			System.out.println("Please enter player " + (player + 1) + " name :");
			name = sc.next();
			user = daoService.getUser(name);
			if (user == null) {
				user = new Player(name);
			}
			user.addGame(gameId);
			game.addScore(name, new Scores());
			daoService.saveUser(user);
		}
		return game;
	}

	/**
	 * @param game
	 */
	private void playGame(Game game) {
		int currRoundScore = 0;
		String name;
		Scores scores = null;

		for (int round = 0; round < game.getRounds(); round++) {

			System.out.println("Round numbers " + (round + 1) + " scores");
			for (Map.Entry<String, Scores> entry : game.getScoreMap().entrySet()) {

				name = entry.getKey();
				scores = entry.getValue();
				currRoundScore = service.playGame(name, round);

				scores.setRoundScore(round, currRoundScore);
				scores.setTotoalScore(currRoundScore + scores.getTotoalScore());

			}
		}
	}

	/**
	 * if both user have same score then currently considering first user as winner
	 */
	private void announceWinner(Game game) {
		int highestScore = 0;
		String winnerName = null;
		Scores scores = null;

		System.out.println("total scores of users");
		for (Map.Entry<String, Scores> entry : game.getScoreMap().entrySet()) {
			scores = entry.getValue();
			if (highestScore < scores.getTotoalScore()) {
				highestScore = scores.getTotoalScore();
				winnerName = entry.getKey();
			}
			System.out.println("total score of user : " + entry.getKey() + " is : " + scores.getTotoalScore());
		}
		System.out.println("Winner is user : " + winnerName);
	}

	/**
	 * @param name
	 */
	private void displayUserDetails(String name) {
		Player user = daoService.getUser(name);
		if (user == null) {
			System.out.println("User doesn't exists");
			return;
		}
		Game game = null;
		Scores scores = null;
		for (int gameId : user.getGameIdList()) {
			System.out.println("Score of game : " + gameId);
			game = daoService.getGame(gameId);
			scores = game.getScoure(user.getName());
			for (int round = 0; round < game.getRounds(); round++) {
				System.out.println("for round " + (round + 1) + " score is :" + scores.getRoundScore(round));
			}
			System.out.println("Total score is : " + scores.getTotoalScore());
		}
	}
}
