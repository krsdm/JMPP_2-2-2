package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
public class CarController {
    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping(value = "/cars")
    public String getCars(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
/*
        if (Objects.isNull(count) || count > 4) {
            model.addAttribute("cars", cars);
        } else if (count > 0 && count < 5) {
            model.addAttribute("cars",
                    cars.stream().limit(count).collect(Collectors.toList()));
        }
*/
        model.addAttribute("cars", carService.getCars(count));
        return "cars";
    }
}
