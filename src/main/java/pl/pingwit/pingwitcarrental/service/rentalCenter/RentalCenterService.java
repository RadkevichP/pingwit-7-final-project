package pl.pingwit.pingwitcarrental.service.rentalCenter;

import pl.pingwit.pingwitcarrental.controller.rentalCenter.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalCenter.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalCenter.RentalCenterShortDto;

import java.util.List;

public interface RentalCenterService {


    List<RentalCenterShortDto> listCenters();

    RentalCenterDto getCenter(Integer id);

    Integer createCenter(CreateRentalCenterInputDto inputDto);
}
