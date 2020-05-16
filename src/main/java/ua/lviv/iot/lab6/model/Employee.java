package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "salary", "currency", "workingDayStart", "workingDayEnd", "workingPlace"})
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "currency")
    private String currency;

    @Column(name = "working_day_start")
    private Integer workingDayStart;

    @Column(name = "working_day_end")
    private Integer workingDayEnd;

    @ManyToOne
    @JoinColumn(name = "repair_service_id")
    private RepairService workingPlace;

}
