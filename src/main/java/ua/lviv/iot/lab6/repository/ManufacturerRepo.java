package ua.lviv.iot.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab6.model.Manufacturer;

@Repository
public interface ManufacturerRepo extends JpaRepository<Manufacturer, Integer> {
}
