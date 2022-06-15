package javaDev;

import javaDev.model.Employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class SortByName {
    public static void main(String[] args) {
        Employee e1 = new Employee("df", "city1", "desg1");
        Employee e2 = new Employee("zf", "city1", "desg1");
        Employee e4 = new Employee("ff", "city1", "desg1");
        Employee e5 = new Employee("cf", "city1", "desg1");

        List<Employee> list = new ArrayList<>();;
        list.add(e1);
        list.add(e2);
        list.add(e4);
        list.add(e5);

        List<Employee> lf = new CopyOnWriteArrayList<>(list);
       // sort by name
        //list.sort(Comparator.comparing(Employee::getName));
        // reverse sort by name
        lf.sort((v1, v2) -> v2.getName().compareTo(v1.getName()));

        System.out.println(list);
    }
}
