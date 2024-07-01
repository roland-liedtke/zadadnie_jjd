package me.rolandliedtke.zadanie_jjd.repository;

import me.rolandliedtke.zadanie_jjd.model.Technician;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechnicianRepository extends JpaRepository<Technician, Long> {
}
