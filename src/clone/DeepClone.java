package clone;

public class DeepClone {
    public static void main(String[] args) throws Exception {
        Employee employee = new Employee("prashant", new Address("Punjab"));
        Employee employee2 = (Employee) employee.clone();
        employee2.setAddress(new Address("Mumbai"));
        System.out.println("Employee before clone::"+ employee);
        System.out.println("Employee after clone::"+employee2);
    }
}
