package pl.pingwit.pingwitcarrental.exceptionhandling;

public class CarRentNotFoundException extends RuntimeException {
    public CarRentNotFoundException(String message) {
        super(message);
    }
}
