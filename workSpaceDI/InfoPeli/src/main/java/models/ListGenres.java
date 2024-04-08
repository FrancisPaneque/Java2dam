package models;

public class ListGenres {
	Genres[] genres;

	public ListGenres(Genres[] genres) {
		super();
		this.genres = genres;
	}

	public Genres[] getGenres() {
		return genres;
	}

	public void setGenres(Genres[] genres) {
		this.genres = genres;
	}
	
}
