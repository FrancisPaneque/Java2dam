package com.nttdata.spring.restcontrollers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.spring.repository.Game;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo de controlador REST
 * 
 * @author NTT Data Sevilla
 *
 */
@RestController
@RequestMapping("/home/games")
public class GamesRestController {

	/** Simula repositorio */
	private static Map<String, Game> gamesList;

	/**
	 * Constructor simula repositorio.
	 */
	public GamesRestController() {

		gamesList = new HashMap<String, Game>();

		final Game game1 = new Game("PS4CBTR-2020-A1", "Crash Bandicoot TR", "PS4", "Plataformas");
		gamesList.put("PS4CBTR-2020-A1", game1);

		final Game game2 = new Game("PS5ACW-2020-A2", "Assasins Creed Valhalla", "PS5", "Acción");
		gamesList.put("PS5ACW-2020-A2", game2);
	}

	/**
	 * Retorna todos los juegos.
	 * 
	 * @return List<Game>
	 */
	@GetMapping
	public Map<String, Game> showGames() {

		return gamesList;
	}

	/**
	 * Añade un nuevo juego.
	 * 
	 * @param newGame
	 */
	@PostMapping
	public void addGame(final @RequestBody Game newGame) {
		gamesList.put(newGame.getSerial(), newGame);
	}

	/**
	 * Elimina un juego.
	 * 
	 * @param serial
	 */
	@DeleteMapping(value = "/{serial}")
	public void deleteCustomer(final @PathVariable String serial) {
		gamesList.remove(serial);
	}

	/**
	 * Búsqueda por atributos (ID)
	 * 
	 * @param game
	 * @return Game
	 */
	@RequestMapping(path = "/game", method = RequestMethod.GET, consumes = "application/json")
	public Game searchBy(@RequestBody Game game) {
		return gamesList.get(game.getSerial());
	}

}
