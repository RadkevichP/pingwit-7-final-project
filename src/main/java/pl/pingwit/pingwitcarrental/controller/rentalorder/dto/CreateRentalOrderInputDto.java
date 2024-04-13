package pl.pingwit.pingwitcarrental.controller.rentalorder.dto;


import java.time.LocalDateTime;
import java.util.Objects;

public class CreateRentalOrderInputDto {

    private Integer clientId;
    private Integer carId;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateRentalOrderInputDto that = (CreateRentalOrderInputDto) o;
        return Objects.equals(clientId, that.clientId) && Objects.equals(carId, that.carId) && Objects.equals(dateFrom, that.dateFrom) && Objects.equals(dateTo, that.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, carId, dateFrom, dateTo);
    }
}
