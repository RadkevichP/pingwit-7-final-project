package pl.pingwit.pingwitcarrental.service.rentalCenter;

import org.springframework.stereotype.Service;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.CreateRentalCenterInputDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterShortDto;
import pl.pingwit.pingwitcarrental.exceptionhandling.CarRentNotFoundException;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenterRepository;

import java.util.List;

@Service
public class RentalCenterServiceImpl implements RentalCenterService {

    private final RentalCenterRepository repository;
    private final RentalCenterConverter converter;

    public RentalCenterServiceImpl(RentalCenterRepository repository, RentalCenterConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public List<RentalCenterShortDto> listCenters() {
        return repository.findAll().stream()
                .map(converter::convertToShortDto)
                .toList();
    }

    @Override
    public RentalCenterDto getCenter(Integer id) {
        RentalCenter rentalCenter = repository.findById(id).orElseThrow(() -> new CarRentNotFoundException("Rental Center not found: " + id));
        return converter.convertToDto(rentalCenter);
    }

    @Override
    public Integer createCenter(CreateRentalCenterInputDto inputDto) {
        RentalCenter savedCenter = repository.save(converter.convertToEntity(inputDto));
        return savedCenter.getId();
    }
}
