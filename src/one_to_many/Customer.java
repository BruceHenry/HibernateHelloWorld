package one_to_many;

import java.util.HashSet;
import java.util.Set;

public class Customer {
    private Integer customerID;
    private String name;

    private Set<MyOrder> orders = new HashSet<>();


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

    public Set<MyOrder> getOrders() {
        return orders;
    }

    public void setOrders(Set<MyOrder> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", name='" + name + '\'' +
                '}';
    }
}
