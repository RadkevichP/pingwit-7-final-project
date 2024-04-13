package pl.pingwit.pingwitcarrental.controller.car.dto;

import java.util.Objects;

public class CarDto {

    private Integer id;
    private String brand;
    private String model;
    private String licensePlate;
    private Integer rentalCenterId;
    private GearboxTypeDto gearboxTypeDto;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getRentalCenterId() {
        return rentalCenterId;
    }

    public void setRentalCenterId(Integer rentalCenterId) {
        this.rentalCenterId = rentalCenterId;
    }

    public GearboxTypeDto getGearboxTypeDto() {
        return gearboxTypeDto;
    }

    public void setGearboxTypeDto(GearboxTypeDto gearboxTypeDto) {
        this.gearboxTypeDto = gearboxTypeDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDto carDto = (CarDto) o;
        return Objects.equals(id, carDto.id) && Objects.equals(brand, carDto.brand) && Objects.equals(model, carDto.model) && Objects.equals(licensePlate, carDto.licensePlate) && Objects.equals(rentalCenterId, carDto.rentalCenterId) && gearboxTypeDto == carDto.gearboxTypeDto;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model, licensePlate, rentalCenterId, gearboxTypeDto);
    }
}
