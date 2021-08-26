package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class CarController {
    private final List<Car> cars;

    public CarController() {
        cars = new ArrayList<>();
        cars.add(new Car("Audi", 1000, "black"));
        cars.add(new Car("Renault", 2000, "metalic"));
        cars.add(new Car("Mersedes", 3000, "black"));
        cars.add(new Car("Ferrari", 4000, "red"));
        cars.add(new Car("Ford", 5000, "gray"));
    }

    @GetMapping(value = "/cars")
    public String getCars(ModelMap model, @RequestParam(value = "count", required = false) String count) {
        if (Objects.isNull(count) || Integer.parseInt(count) > 4) {
            model.addAttribute("cars", cars);
        } else if (Integer.parseInt(count) > 0 && Integer.parseInt(count) < 5) {
            model.addAttribute("cars",
                    cars.stream().limit(Integer.parseInt(count)).collect(Collectors.toList()));
        }
        return "cars";
    }
}
