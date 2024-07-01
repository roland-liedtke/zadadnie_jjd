package me.rolandliedtke.zadanie_jjd.repository;

import me.rolandliedtke.zadanie_jjd.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}