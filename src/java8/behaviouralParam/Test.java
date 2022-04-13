package java8.behaviouralParam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Test implements FilterCar{

    @Override
    public List<Car> filter(List<Car> cars, Predicate<Car> carFilter) {
        List<Car> resp = new ArrayList<>();
        cars.forEach(c -> {
            if(carFilter.test(c)) {
                resp.add(c);
            }
        });
        return resp;
    }

    public static void main(String[] args) {
        Car car1 = new Car("black", "suv");
        Car car2 = new Car("black", "sedan");
        Car car3 = new Car("red", "suv");
        Car car4 = new Car("red", "sedan");
        Car car5 = new Car("blue", "suv");

        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(car5);

        // filter red car and type SUV
        Predicate<Car> p = (o) -> o.getColor().equals("red") && o.getType().equals("sedan");

        Comparator<Integer> comp = Integer::compareTo;

        Test t = new Test();
        List<Car> filter = t.filter(cars, p);
        filter.forEach(e -> System.out.println(e +" "));

    }
}
