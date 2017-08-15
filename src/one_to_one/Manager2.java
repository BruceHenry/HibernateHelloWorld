package one_to_one;

public class Manager2 {
    private Integer ID;
    private String name;
    private Department2 dept;

    public Manager2() {
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

    public Department2 getDept() {
        return dept;
    }

    public void setDept(Department2 dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ID=" + ID +
                ", name='" + name + '\'' + '}';
    }
}
