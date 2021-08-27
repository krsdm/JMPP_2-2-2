package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {
    private final List<Car> cars;

    public CarDaoImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", 1000, "black"));
        cars.add(new Car("Renault", 2000, "metalic"));
        cars.add(new Car("Mersedes", 3000, "black"));
        cars.add(new Car("Ferrari", 4000, "red"));
        cars.add(new Car("Ford", 5000, "gray"));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }
}
