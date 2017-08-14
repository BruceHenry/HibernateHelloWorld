package many_to_one;

public class MyOrder {
    private Integer order_ID;
    private String name;

    private Customer customer;

    public MyOrder() {
    }

    public MyOrder(String name) {
        this.name = name;
    }

    public Integer getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(Integer ID) {
        this.order_ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "MyOrder{" +
                "order_ID=" + order_ID +
                ", name='" + name + '\'' +
                ", customer="+customer+
                '}';
    }
}
