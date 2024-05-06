package pl.pingwit.pingwitcarrental.repository.rentalcenter;

import org.apache.commons.collections4.functors.PrototypeFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCenterRepository extends JpaRepository<RentalCenter, Integer> {
}
