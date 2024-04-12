package pl.pingwit.pingwitcarrental.service.car;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitcarrental.controller.car.dto.CarDto;
import pl.pingwit.pingwitcarrental.controller.car.dto.CreateCarInputDto;
import pl.pingwit.pingwitcarrental.repository.car.CarRepository;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarConverter carConverter;

    public CarServiceImpl(CarRepository carRepository, CarConverter carConverter) {
        this.carRepository = carRepository;
        this.carConverter = carConverter;
    }

    @Override
    public List<CarDto> listCars() {
        return carRepository.findAll().stream()
                .map(carConverter::toDto)
                .toList();
    }

    @Override
    public CarDto getCar(Integer id) {
        return carRepository.findById(id).map(carConverter::toDto).orElseThrow();
    }

    @Override
    public Integer createCar(CreateCarInputDto carDto) {
        return carRepository.save(carConverter.toEntity(carDto)).getId();
    }
}
