package pl.pingwit.pingwitcarrental.controller.rentalorder;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.CreateRentalOrderInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.RentalOrderDto;
import pl.pingwit.pingwitcarrental.service.rentalorder.RentalOrderService;

@RestController
@RequestMapping("/rental-order")
public class RentalOrderController {

    private final RentalOrderService rentalOrderService;

    public RentalOrderController(RentalOrderService rentalOrderService) {
        this.rentalOrderService = rentalOrderService;
    }

    @GetMapping
    public List<RentalOrderDto> listOrders() {
        return rentalOrderService.listOrders();
    }

    @GetMapping("/{id}")
    public RentalOrderDto getOrder(@PathVariable Integer id) {
        return rentalOrderService.getOrder(id);
    }

    @PostMapping
    public Integer createOrder(@RequestBody CreateRentalOrderInputDto rentalOrderDto) {
        return rentalOrderService.createOrder(rentalOrderDto);
    }
}
