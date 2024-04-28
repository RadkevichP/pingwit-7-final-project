package pl.pingwit.pingwitcarrental.controller.rentalсenter.dto;

import pl.pingwit.pingwitcarrental.controller.car.dto.CarDto;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RentalCenterDto that = (RentalCenterDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(cars, that.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, address, cars);
    }

    @Override
    public String toString() {
        return "RentalCenterDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cars=" + cars +
                '}';
    }
}
