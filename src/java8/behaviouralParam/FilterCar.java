package java8.behaviouralParam;

import java.util.List;
import java.util.function.Predicate;

public interface FilterCar {

    List<Car> filter(List<Car> car, Predicate<Car> carFilter);
}
