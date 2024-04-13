package pl.pingwit.pingwitcarrental.service.rentalorder;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.CreateRentalOrderInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.RentalOrderDto;
import pl.pingwit.pingwitcarrental.repository.car.Car;
import pl.pingwit.pingwitcarrental.repository.client.Client;
import pl.pingwit.pingwitcarrental.repository.rentalorder.RentalOrder;

@Component
public class RentalOrderConverter {

    public RentalOrderDto toDto(RentalOrder rentalOrder) {
        RentalOrderDto dto = new RentalOrderDto();
        dto.setId(rentalOrder.getId());
        dto.setCar(rentalOrder.getCar().getBrand() + " " + rentalOrder.getCar().getModel() + " " + rentalOrder.getCar().getLicensePlate());
        dto.setClient(rentalOrder.getClient().getName() + " " + rentalOrder.getClient().getSurname());
        dto.setDateFrom(rentalOrder.getDateFrom());
        dto.setDateTo(rentalOrder.getDateTo());
        return dto;
    }

    public RentalOrder toEntity(CreateRentalOrderInputDto inputDto) {
        RentalOrder rentalOrder = new RentalOrder();
        rentalOrder.setCar(new Car(inputDto.getCarId()));
        rentalOrder.setClient(new Client(inputDto.getClientId()));
        rentalOrder.setDateFrom(inputDto.getDateFrom());
        rentalOrder.setDateTo(inputDto.getDateTo());
        return rentalOrder;
    }
}
