package com.mitrais.javabootcamp;

/**
 * To solve this challenge, you are required to write an HTTP GET method to retrieve information from a movie database.
	Function Description
	Given a string substr, getMovieTitles must perform the following tasks:
	1. Query https://jsonmock.hackerrank.com/api/movies/search/?Title=substr (replace substr).
	2. Initialize the titles array to store total string elements. Store the Title of each movie meeting the search criterion in the titles array.
	3. Sort titles in ascending order and return it as your answer.
  The query response from the website is a JSON response with the following five fields: page : The current page.
  per_page : The maximum number of results per page.
  total : The total number of movies in the search result.
  total_pages : The total number of pages which must be queried to get all the results.
  data : An array of JSON objects containing movie information where the Title field denotes the title of
  the movie.
	In order to get all results, you may have to make multiple page requests. To request a page by number, your query should read https://jsonmock.hackerrank.com/api/movies/search/? Title=substr&page=pageNumber , replacing substr and pageNumber.

*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;

class MovieData {
	private String Poster;
	private String Title;
	private String Type;
	private String Year;
	private String imdbId;

	public MovieData(String poster, String title, String type, String year, String imdbId) {
		super();
		Poster = poster;
		Title = title;
		Type = type;
		Year = year;
		this.imdbId = imdbId;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		Poster = poster;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public MovieData() {

	}

}

class MoviePagination {
	private int page;
	private int per_page;
	private int total;
	private int total_page;
	private List<MovieData> data;

	public MoviePagination(int page, int per_page, int total, int total_page, List<MovieData> data) {
		super();
		this.page = page;
		this.per_page = per_page;
		this.total = total;
		this.total_page = total_page;
		this.data = data;
	}

	public MoviePagination() {
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPer_page() {
		return per_page;
	}

	public void setPer_page(int per_page) {
		this.per_page = per_page;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getTotal_page() {
		return total_page;
	}

	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}

	public List<MovieData> getData() {
		return data;
	}

	public void setData(List<MovieData> data) {
		this.data = data;
	}

}

public class MovieTitle {

	public static void getMovieTitles(String substr, int page) {
		String url = "https://jsonmock.hackerrank.com/api/movies/search/?Title=" + substr + "&Page=" + page;
		URL obj;
		ArrayList<String> list_title = new ArrayList<String>();
		String saveOutput = "";
		int num = 0;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Accept", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(obj.openStream()));

			String output;

			while ((output = br.readLine()) != null) {
				saveOutput += output;
			}

			Gson gson = new Gson();
			MoviePagination mov = gson.fromJson(saveOutput, MoviePagination.class);
			for (int p = 1; p <= page; p++) {
				List<MovieData> data = mov.getData();
				
				for (int d = 0; d < data.size(); d++) {
					list_title.add(data.get(d).getTitle());
				}
			}

			Collections.sort(list_title);
			for (String title : list_title) {
				num++;
				System.out.print(num + " ");
				System.out.println(title);
			}

			con.disconnect();
		} catch (IOException e) {
			System.out.println("IO Error");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		getMovieTitles("spiderman", 1);

	}

}