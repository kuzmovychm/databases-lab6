package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "director"})
@Table(name = "repair_service")
public class RepairService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "opening_hour")
    private String openingHour;

    @Column(name = "closing_hour")
    private String closingHour;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "rating")
    private String rating;

    @OneToMany(mappedBy = "workingPlace")
    private List<Employee> employees;

    @OneToOne
    @JoinColumn(name = "director_id")
    private Employee director;

}
