package me.rolandliedtke.zadanie_jjd.service;

import me.rolandliedtke.zadanie_jjd.model.Region;
import me.rolandliedtke.zadanie_jjd.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private final RegionRepository regionRepository;

    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> findAll() {
        return regionRepository.findAll();
    }

    public Region addRegion(Region region) {
        return regionRepository.save(region);
    }

    public Region updateRegion(Long id, Region updatedRegion) {
        regionRepository.findById(id)
                .map(region -> {
                    region.setActive(updatedRegion.isActive());
                    region.setName(updatedRegion.getName());
                    region.setTechnician_id(updatedRegion.getTechnician_id());
                    return regionRepository.save(region);
                });
        return regionRepository.findById(id).orElseThrow();
    }

    public String deleteRegion(Long id) {
        regionRepository.deleteById(id);
        return "Success!";
    }
}
