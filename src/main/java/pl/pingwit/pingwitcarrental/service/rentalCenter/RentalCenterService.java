package pl.pingwit.pingwitcarrental.service.rentalCenter;

import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;

import java.util.List;

public interface RentalCenterService {


    List<RentalCenterShortDto> listCenters();

    RentalCenterDto getCenter(Integer id);

    Integer createCenter(CreateRentalCenterInputDto inputDto);
}
