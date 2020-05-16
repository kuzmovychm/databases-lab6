package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "price", "currency", "inRepair", "deviceManufacturer"})
@Table(name = "device")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private Integer price;

    @Column(name = "currency")
    private String currency;

    @Column(name = "in_repair")
    private Boolean inRepair;

    @Column(name = "model")
    private String model;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer deviceManufacturer;

}
