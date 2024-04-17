package pl.pingwit.pingwitcarrental.service.rentalCenter;

import org.junit.jupiter.api.Test;
import pl.pingwit.pingwitcarrental.controller.rentalсenter.dto.RentalCenterDto;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;
import pl.pingwit.pingwitcarrental.service.car.CarConverter;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class RentalCenterConverterTest {

    private final CarConverter carConverter = mock(CarConverter.class);

    private final RentalCenterConverter target = new RentalCenterConverter(carConverter);

    @Test
    void shouldConvertToDto() {
        // given
        RentalCenter rentalCenter = new RentalCenter();
        rentalCenter.setId(1);
        rentalCenter.setAddress("Test Address");
        rentalCenter.setName("Test Name");
        rentalCenter.setCars(List.of());

        RentalCenterDto expected = new RentalCenterDto();
        expected.setId(1);
        expected.setAddress("Test Address");
        expected.setName("Test Name");
        expected.setCars(List.of());

        // when
        RentalCenterDto actual = target.convertToDto(rentalCenter);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}