package pl.pingwit.pingwitcarrental.repository.car;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import pl.pingwit.pingwitcarrental.repository.rentalcenter.RentalCenter;

@Entity
@Table(name = "car", schema = "car_rent")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "car_id_gen")
    @SequenceGenerator(name = "car_id_gen", sequenceName = "car_id_seq", schema = "car_rent", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_center_id")
    private RentalCenter rentalCenter;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "gearbox_type")
    private GearboxType gearboxType;

    @Column(name = "license_plate")
    private String licensePlate;

    public Car() {
    }

    public Car(
            RentalCenter rentalCenter,
            String brand, String model,
            GearboxType gearboxType,
            String licensePlate
    ) {
        this.rentalCenter = rentalCenter;
        this.brand = brand;
        this.model = model;
        this.gearboxType = gearboxType;
        this.licensePlate = licensePlate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RentalCenter getRentalCenter() {
        return rentalCenter;
    }

    public void setRentalCenter(RentalCenter rentalCenter) {
        this.rentalCenter = rentalCenter;
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

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
