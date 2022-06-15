package javaDev.model;

public class Employee {
    private String name;
    private String city;
    private String designation;

    public Employee(String name, String city, String designation) {
        this.name = name;
        this.city = city;
        this.designation = designation;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
