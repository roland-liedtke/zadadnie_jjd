package me.rolandliedtke.zadanie_jjd.service;

import me.rolandliedtke.zadanie_jjd.model.Technician;
import me.rolandliedtke.zadanie_jjd.repository.TechnicianRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {
    private final TechnicianRepository technicianRepository;

    public TechnicianService(TechnicianRepository technicianRepository) {
        this.technicianRepository = technicianRepository;
    }

    public List<Technician> findAll() {
        return technicianRepository.findAll();
    }

    public Technician addTechnician(Technician technician) {
        return technicianRepository.save(technician);
    }

    public Technician updateTechnician(Long id, Technician updatedTechnician) {
        technicianRepository.findById(id)
                .map(technician -> {
                    technician.setActive(updatedTechnician.isActive());
                    technician.setLast_name(updatedTechnician.getLast_name());
                    return technicianRepository.save(technician);
                });
        return technicianRepository.findById(id).orElseThrow();
    }

    public String deleteTechnician(Long id) {
        technicianRepository.deleteById(id);
        return "Success!";
    }
}
