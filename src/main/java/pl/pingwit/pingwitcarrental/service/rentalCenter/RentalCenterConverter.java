package pl.pingwit.pingwitcarrental.service.rentalCenter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;
import pl.pingwit.pingwitcarrental.service.car.CarConverter;

@Component
public class RentalCenterConverter {

    private final CarConverter carConverter;

    public RentalCenterConverter(CarConverter carConverter) {
        this.carConverter = carConverter;
    }

    public RentalCenter convertToEntity(CreateRentalCenterInputDto inputDto) {
        return new RentalCenter(inputDto.getName(), inputDto.getAddress());
    }

    public RentalCenterShortDto convertToShortDto(RentalCenter rentalCenter) {
        return new RentalCenterShortDto(rentalCenter.getId(), rentalCenter.getName(), rentalCenter.getAddress());
    }

    public RentalCenterDto convertToDto(RentalCenter rentalCenter) {
        RentalCenterDto result = new RentalCenterDto();
        result.setId(rentalCenter.getId());
        result.setAddress(rentalCenter.getAddress());
        result.setName(rentalCenter.getName());

        result.setCars(rentalCenter.getCars().stream()
                .map(carConverter::toDto)
                .toList());
        return result;
    }
}
