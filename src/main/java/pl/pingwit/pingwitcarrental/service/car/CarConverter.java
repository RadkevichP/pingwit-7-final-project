package pl.pingwit.pingwitcarrental.service.car;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitcarrental.controller.car.dto.CarDto;
import pl.pingwit.pingwitcarrental.controller.car.dto.CreateCarInputDto;
import pl.pingwit.pingwitcarrental.repository.car.Car;
import pl.pingwit.pingwitcarrental.repository.car.GearboxType;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;


@Component
public class CarConverter {

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setId(car.getId());
        carDto.setBrand(car.getBrand());
        carDto.setModel(car.getModel());
        carDto.setLicensePlate(car.getLicensePlate());
        carDto.setRentalCenterId(car.getRentalCenter().getId());
        return carDto;
    }

    public Car toEntity(CreateCarInputDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setLicensePlate(carDto.getLicensePlate());
        car.setRentalCenter(new RentalCenter(carDto.getRentalCenterId()));
        car.setGearboxType(GearboxType.valueOf(carDto.getGearboxType().name()));
        return car;
    }

}
