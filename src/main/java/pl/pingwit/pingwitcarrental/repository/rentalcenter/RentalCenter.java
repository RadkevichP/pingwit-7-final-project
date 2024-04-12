package pl.pingwit.pingwitcarrental.repository.rentalcenter;

import jakarta.persistence.*;
import pl.pingwit.pingwitcarrental.repository.car.Car;

import java.util.List;

@Entity
@Table(name = "rental_center", schema = "car_rent")
public class RentalCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_center_id_gen")
    @SequenceGenerator(name = "rental_center_id_gen", sequenceName = "rental_center_id_seq", schema = "car_rent", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(
            mappedBy = "rentalCenter"
    )
    private List<Car> cars;

    public RentalCenter() {
    }

    public RentalCenter(Integer id) {
        this.id = id;
    }

    public RentalCenter(String name, String address) {
        this.name = name;
        this.address = address;
    }

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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
