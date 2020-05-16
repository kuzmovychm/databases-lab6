package ua.lviv.iot.lab6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.lab6.model.RepairedPart;

@Repository
public interface RepairedPartRepo extends JpaRepository<RepairedPart, Integer> {
}
