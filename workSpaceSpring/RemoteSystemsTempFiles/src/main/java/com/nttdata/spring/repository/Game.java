package com.nttdata.spring.repository;

/**
 * Formación - Spring - Ejemplos
 * 
 * Ejemplo para REST.
 * 
 * @author NTT Data Sevilla
 *
 */
public class Game {

	/** Identificador único */
	private String serial;

	/** Nombre */
	private String name;

	/** Plataforma */
	private String platform;

	/** Género */
	private String genre;

	/**
	 * Constructor
	 */
	public Game(final String serial, final String name, final String platform, final String genre) {
		this.serial = serial;
		this.name = name;
		this.platform = platform;
		this.genre = genre;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}

	/**
	 * @param serial
	 *            the serial to set
	 */
	public void setSerial(String serial) {
		this.serial = serial;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the platform
	 */
	public String getPlatform() {
		return platform;
	}

	/**
	 * @param platform
	 *            the platform to set
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
