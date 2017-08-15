package one_to_one;

public class Manager {
    private Integer ID;
    private String name;
    private Department dept;

    public Manager() {
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

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ID=" + ID +
                ", name='" + name + '\'' + '}';
    }
}
