package com.game.factory;

import com.game.dao.DaoService;
import com.game.daoImpl.DaoServiceImpl;
import com.game.service.GameService;
import com.game.serviceImpl.GameServiceImpl;

public class FactoryService {

	public FactoryService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return GameService
	 */
	public static GameService getGameService() {
		return new GameServiceImpl();
	}

	/**
	 * @return DaoService
	 */
	public static DaoService getDaoService() {
		return new DaoServiceImpl();
	}
}
