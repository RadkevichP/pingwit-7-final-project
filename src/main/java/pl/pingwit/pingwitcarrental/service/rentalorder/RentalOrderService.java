package pl.pingwit.pingwitcarrental.service.rentalorder;


import java.util.List;

import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.CreateRentalOrderInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.RentalOrderDto;

public interface RentalOrderService {

    List<RentalOrderDto> listOrders();


    RentalOrderDto getOrder(Integer id);

    Integer createOrder(CreateRentalOrderInputDto rentalOrderDto);
}
