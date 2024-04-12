package pl.pingwit.pingwitcarrental.controller.rentalorder;

import java.time.LocalDateTime;

public class RentalOrderDto {

    private LocalDateTime createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
