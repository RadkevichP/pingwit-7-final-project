package pl.pingwit.pingwitcarrental.service.car;

import java.util.List;

import pl.pingwit.pingwitcarrental.controller.car.dto.CarDto;
import pl.pingwit.pingwitcarrental.controller.car.dto.CreateCarInputDto;

public interface CarService {

    List<CarDto> listCars();

    CarDto getCar(Integer id);

    Integer createCar(CreateCarInputDto carDto);
}
