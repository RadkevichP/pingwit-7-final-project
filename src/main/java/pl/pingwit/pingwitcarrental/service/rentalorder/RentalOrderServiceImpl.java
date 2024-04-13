package pl.pingwit.pingwitcarrental.service.rentalorder;

import java.util.List;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.CreateRentalOrderInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.RentalOrderDto;
import pl.pingwit.pingwitcarrental.exceptionhandling.CarRentNotFoundException;
import pl.pingwit.pingwitcarrental.repository.rentalorder.RentalOrderRepository;

@Service
public class RentalOrderServiceImpl implements RentalOrderService {

    private final RentalOrderRepository rentalOrderRepository;
    private final RentalOrderConverter rentalOrderConverter;

    public RentalOrderServiceImpl(RentalOrderRepository rentalOrderRepository, RentalOrderConverter rentalOrderConverter) {
        this.rentalOrderRepository = rentalOrderRepository;
        this.rentalOrderConverter = rentalOrderConverter;
    }

    @Override
    public List<RentalOrderDto> listOrders() {
        return rentalOrderRepository.findAll().stream()
                .map(rentalOrderConverter::toDto)
                .toList();
    }

    @Override
    public RentalOrderDto getOrder(Integer id) {
        return rentalOrderRepository.findById(id).map(rentalOrderConverter::toDto)
                .orElseThrow(() -> new CarRentNotFoundException("Rental Order not found: " + id));
    }

    @Override
    public Integer createOrder(CreateRentalOrderInputDto inputDto) {
        return rentalOrderRepository.save(rentalOrderConverter.toEntity(inputDto)).getId();
    }
}
