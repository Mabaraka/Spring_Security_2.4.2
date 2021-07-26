package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarService {
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car(1, 200, 1000));
        cars.add(new Car(2, 250, 700));
        cars.add(new Car(3, 180, 1900));
        cars.add(new Car(4, 210, 1200));
        cars.add(new Car(5, 120, 3200));
    }

    public List<Car> getCars(int amount) {
        return cars.stream().limit(amount).collect(Collectors.toList());
    }
}
