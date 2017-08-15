package many_to_many;

import java.util.HashSet;
import java.util.Set;

public class Actor2 {
    private Integer id;
    private String name;

    private Set<Movie2> movies = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie2> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movie2> movies) {
        this.movies = movies;
    }
}
