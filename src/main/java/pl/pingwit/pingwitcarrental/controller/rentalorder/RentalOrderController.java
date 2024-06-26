package pl.pingwit.pingwitcarrental.controller.rentalorder;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.CreateRentalOrderInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalorder.dto.RentalOrderDto;
import pl.pingwit.pingwitcarrental.service.rentalorder.RentalOrderService;

@Tag(name = "Rental Order API")
@RestController
@RequestMapping("/rental-order")
public class RentalOrderController {

    private final RentalOrderService rentalOrderService;

    public RentalOrderController(RentalOrderService rentalOrderService) {
        this.rentalOrderService = rentalOrderService;
    }

    @Operation(description = "Get the list of rental orders")
    @GetMapping
    public List<RentalOrderDto> listOrders() {
        return rentalOrderService.listOrders();
    }

    @Operation(description = "Get rental order by id")
    @GetMapping("/{id}")
    public RentalOrderDto getOrder(@PathVariable Integer id) {
        return rentalOrderService.getOrder(id);
    }

    @Operation(description = "Create a rental order")
    @PostMapping
    public Integer createOrder(@RequestBody CreateRentalOrderInputDto rentalOrderDto) {
        return rentalOrderService.createOrder(rentalOrderDto);
    }
}
