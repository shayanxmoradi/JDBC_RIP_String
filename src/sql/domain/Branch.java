package sql.domain;

public class Branch {
private String name;
private String city;
private double amount;

    public Branch(String name, String city, double amount) {
        this.name = name;
        this.city = city;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
