package DAO;

import many_to_many.Movie;

public class Main {
    public static void main(String[] args) throws Exception{
//        MovieDAO dao = new MovieDAO();
        Movie movie = new Movie();
        movie.setName("008");
        MovieDAO.save(movie);
    }
}
