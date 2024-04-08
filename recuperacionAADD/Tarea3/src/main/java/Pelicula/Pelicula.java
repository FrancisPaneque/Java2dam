package Pelicula;

public class Pelicula {
	
	private int film_id;
	private String title;
	private int year;
	private int lenght;
	private String description;
	
	public Pelicula(int film_id, String title, int year, int lenght, String description) {
		setFilm_id(film_id);
		setTitle(title);
		setYear(year);
		setLenght(lenght);
		setDescription(description);
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int length) {
		this.lenght = length;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Pelicula [film_id=" + film_id + ", title=" + title + ", year=" + year + ", length=" + lenght
				+ ", description=" + description + "]";
	}
	
	
}
