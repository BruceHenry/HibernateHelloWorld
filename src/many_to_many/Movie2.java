package many_to_many;

import java.util.HashSet;
import java.util.Set;

public class Movie2 {
    private Integer id;
    private String name;

    private Set<Actor2> actors= new HashSet<>();

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

    public Set<Actor2> getActors() {
        return actors;
    }

    public void setActors(Set<Actor2> actors) {
        this.actors = actors;
    }
}
