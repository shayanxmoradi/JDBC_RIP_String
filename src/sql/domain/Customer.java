package sql.domain;

public class Customer extends BaseEntity{
    private String name;
    private String street;
    private String city;

    public Customer(Long id, String name, String street, String city) {
        super(id);
        this.name = name;
        this.street = street;
        this.city = city;
    }

    public Customer(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
