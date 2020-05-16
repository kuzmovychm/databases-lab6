package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "partManufacturer"})
@Table(name = "repaired_part")
public class RepairedPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "price")
    private Integer price;

    @Column(name = "repair_price")
    private Integer repairPrice;

    @Column(name = "currency")
    private String currency;

    @ManyToOne
    @JoinColumn(name = "part_manufacturer_id")
    private Manufacturer partManufacturer;

}
