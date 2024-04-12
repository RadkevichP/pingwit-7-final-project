package pl.pingwit.pingwitcarrental.controller.car;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitcarrental.controller.car.dto.CarDto;
import pl.pingwit.pingwitcarrental.controller.car.dto.CreateCarInputDto;
import pl.pingwit.pingwitcarrental.service.car.CarService;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<CarDto> listCars() {
        return carService.listCars();
    }

    @GetMapping("/{id}")
    public CarDto getCar(@PathVariable Integer id) {
        return carService.getCar(id);
    }

    @PostMapping
    public Integer createCar(@RequestBody CreateCarInputDto createCarInputDto) {
        return carService.createCar(createCarInputDto);
    }
}
