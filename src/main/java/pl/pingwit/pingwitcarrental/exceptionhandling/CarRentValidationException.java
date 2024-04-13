package pl.pingwit.pingwitcarrental.exceptionhandling;

public class CarRentValidationException extends RuntimeException {

    public CarRentValidationException(String message) {
        super(message);
    }
}
