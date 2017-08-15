package one_to_one;

public class Department2 {
    private Integer ID;
    private String name;

    private Manager2 manager;

    public Department2() {
    }


    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manager2 getManager() {
        return manager;
    }

    public void setManager(Manager2 manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}
