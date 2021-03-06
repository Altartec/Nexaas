package appserver.model;

import java.io.Serializable;
import java.util.List;

public class TitleSearch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String title;

	List<Movie> movies;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public TitleSearch(String title, List<Movie> movies) {
		this.title = title;
		this.movies = movies;
	}

}
