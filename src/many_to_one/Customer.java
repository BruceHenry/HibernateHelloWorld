package many_to_one;


public class Customer {
    private Integer customerID;
    private String name;



    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer ID) {
        this.customerID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                '}';
    }
}
