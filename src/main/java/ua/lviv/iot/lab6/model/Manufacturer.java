package ua.lviv.iot.lab6.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"id"})
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "email")
    private String email;

    @Column(name = "website_link")
    private String websiteLink;

    @OneToMany(mappedBy = "deviceManufacturer")
    private List<Device> devices;

    @OneToMany(mappedBy = "partManufacturer")
    private List<RepairedPart> parts;

}
