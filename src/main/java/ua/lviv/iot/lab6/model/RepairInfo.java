package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id", "repairService", "employee", "repairedPart"})
@Table(name = "repair_info")
public class RepairInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "repair_status")
    private String repairStatus;

    @Column(name = "repair_type")
    private String repairType;

    @Column(name = "starting_date")
    private String startingDate;

    @Column(name = "ending_date")
    private String endingDate;

    @OneToMany
    @JoinColumn(name = "repair_service_id")
    private List<RepairService> repairService;

    @OneToMany
    @JoinColumn(name = "employee_id")
    private List<Employee> employee;

    @OneToMany
    @JoinColumn(name = "repaired_part_id")
    private List<RepairedPart> repairedPart;

}
