package appserver.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import appserver.model.Movie;
import appserver.model.TitleSearch;

/**
 * @author Edivaldo Nogueira Class responsible for the search filter.
 */
public class Filter {

	public String getPage(URL url, File file, String title) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

		BufferedWriter out = new BufferedWriter(new FileWriter(file));

		String inputLine;
		String response = null;
		String name;
		String year;
		String[] array;

		List<Movie> movies = new ArrayList<Movie>();

		// Performs the return reading of the page searched.
		while ((inputLine = in.readLine()) != null) {

			if (inputLine.contains("result_text")) {
				if (!inputLine.contains("name") && !inputLine.contains("search") && !inputLine.contains("company")) {
					response = inputLine;
					out.write(inputLine);
				}

				out.newLine();
			}
		}
		array = response.split("</td>");

		for (int i = 0; i < array.length; i++) {
			Movie movie = new Movie();
			if (!array[i].contains("img") && !array[i].contains("table")) {
				name = array[i].substring(55, array[i].indexOf(")") + 1);
				name = name.replaceAll("</a>", "");

				year = name.substring(name.indexOf("(")+1, name.indexOf(")") );
				
				name = name.substring(0,name.indexOf("("));
				
				movie.setName(name);

				movie.setYear(year);

				movies.add(movie);
			}
		}

		in.close();
		out.flush();
		out.close();

		try {

			TitleSearch titleSearch = new TitleSearch(title, movies);

			response = Transformer.layoutResponseXML(titleSearch);

		} catch (NoSuchFieldException ex) {
			Logger.getLogger(Filter.class.getName()).log(Level.SEVERE, null, ex);
		}

		return response;
	}
}
