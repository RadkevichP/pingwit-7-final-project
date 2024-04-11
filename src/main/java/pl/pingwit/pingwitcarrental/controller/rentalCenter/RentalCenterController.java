package pl.pingwit.pingwitcarrental.controller.rentalCenter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitcarrental.service.rentalCenter.RentalCenterService;

import java.util.List;

@Tag(name = "Rental Centers API")
@RestController
@RequestMapping("/rental-center")
public class RentalCenterController {

    private final RentalCenterService rentalCenterService;

    public RentalCenterController(RentalCenterService rentalCenterService) {
        this.rentalCenterService = rentalCenterService;
    }

    // показ всех центров
    @Operation(description = "Show the list of centers")
    @GetMapping
    public List<RentalCenterShortDto> listCenters() {
        return rentalCenterService.listCenters();
    }

    // показ центра по id
    @GetMapping("/{id}")
    public RentalCenterDto getCenter(@PathVariable(name = "id") Integer id) {
        return rentalCenterService.getCenter(id);
    }

    // создание рентал центра
    @PostMapping
    public Integer createCenter(@RequestBody CreateRentalCenterInputDto inputDto) {
        return rentalCenterService.createCenter(inputDto);
    }

}
