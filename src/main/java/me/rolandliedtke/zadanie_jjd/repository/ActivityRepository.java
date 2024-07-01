package me.rolandliedtke.zadanie_jjd.repository;

import me.rolandliedtke.zadanie_jjd.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {

}