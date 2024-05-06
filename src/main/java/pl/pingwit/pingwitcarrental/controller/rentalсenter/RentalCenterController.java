package pl.pingwit.pingwitcarrental.controller.rentalсenter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;
import pl.pingwit.pingwitcarrental.service.export.RentalCenterExportService;
import pl.pingwit.pingwitcarrental.service.rentalCenter.RentalCenterService;

import java.io.IOException;
import java.util.List;

@Tag(name = "Rental Centers API")
@RestController
@RequestMapping("/rental-center")
public class RentalCenterController {

    private final RentalCenterService rentalCenterService;
    private final RentalCenterExportService rentalCenterExportService;

    public RentalCenterController(RentalCenterService rentalCenterService,
                                  RentalCenterExportService rentalCenterExportService) {
        this.rentalCenterService = rentalCenterService;
        this.rentalCenterExportService = rentalCenterExportService;
    }

    @Operation(description = "Show the list of centers")
    @GetMapping
    public List<RentalCenterShortDto> listCenters() {
        return rentalCenterService.listCenters();
    }

    @Operation(description = "Get rental center by ID")
    @GetMapping("/{id}")
    public RentalCenterDto getCenter(@PathVariable(name = "id") Integer id) {
        return rentalCenterService.getCenter(id);
    }

    @Operation(description = "Create rental center")
    @PostMapping
    public Integer createCenter(@RequestBody CreateRentalCenterInputDto inputDto) {
        return rentalCenterService.createCenter(inputDto);
    }

    @Operation(description = "Export the list of rental centers to Excel file")
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportRentalCentersToExcel() {
        try {
            byte[] fileBytes = rentalCenterExportService.exportRentalCenters();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
            headers.setContentDispositionFormData("attachment", "rental-centers.xlsx");

            return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
