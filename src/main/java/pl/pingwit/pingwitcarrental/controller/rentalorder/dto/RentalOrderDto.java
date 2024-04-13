package pl.pingwit.pingwitcarrental.controller.rentalorder.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class RentalOrderDto {

    private Integer id;
    private String client;
    private String car;
    private LocalDateTime dateFrom;
    private LocalDateTime dateTo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
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
        RentalOrderDto that = (RentalOrderDto) o;
        return Objects.equals(id, that.id) && Objects.equals(client, that.client) && Objects.equals(car, that.car) && Objects.equals(dateFrom, that.dateFrom) && Objects.equals(dateTo, that.dateTo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, client, car, dateFrom, dateTo);
    }
}
