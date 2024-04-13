package pl.pingwit.pingwitcarrental.service.rentalCenter;

import org.springframework.stereotype.Component;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;

@Component
public class RentalCenterConverter {

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

        // todo: add cars
        return result;
    }
}
