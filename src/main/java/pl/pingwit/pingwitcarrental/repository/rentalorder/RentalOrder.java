package pl.pingwit.pingwitcarrental.repository.rentalorder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import pl.pingwit.pingwitcarrental.repository.client.Client;

@Entity
@Table(name = "rental_order")
public class RentalOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rental_order_id_gen")
    @SequenceGenerator(name = "rental_order_id_gen", sequenceName = "rental_order_id_seq", schema = "car_rent", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn
    private Client client;



}
