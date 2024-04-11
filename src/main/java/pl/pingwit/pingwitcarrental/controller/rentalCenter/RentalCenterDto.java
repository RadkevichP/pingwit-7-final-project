package pl.pingwit.pingwitcarrental.controller.rentalCenter;

import pl.pingwit.pingwitcarrental.controller.car.CarDto;

import java.util.List;

public class RentalCenterDto {

    private Integer id;
    private String name;
    private String address;

    private List<CarDto> cars;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }
}
