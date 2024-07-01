package me.rolandliedtke.zadanie_jjd.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.rolandliedtke.zadanie_jjd.model.Activity;
import me.rolandliedtke.zadanie_jjd.model.Region;
import me.rolandliedtke.zadanie_jjd.model.Technician;
import me.rolandliedtke.zadanie_jjd.service.ActivityService;
import me.rolandliedtke.zadanie_jjd.service.EmailService;
import me.rolandliedtke.zadanie_jjd.service.RegionService;
import me.rolandliedtke.zadanie_jjd.service.TechnicianService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Tag(name = "API", description = "Activity API with documentation")
public class ApiController {
    private final TechnicianService technicianService;

    private final RegionService regionService;

    private final ActivityService activityService;

    private final EmailService emailService;

    public ApiController(TechnicianService technicianService, RegionService regionService, ActivityService activityService, EmailService emailService) {
        this.technicianService = technicianService;
        this.regionService = regionService;
        this.activityService = activityService;
        this.emailService = emailService;
    }


    // CREATE
    @PostMapping("/technicians")
    @Operation(summary = "Create a technician")
    public ResponseEntity<Technician> addTechnician(@RequestBody Technician technician) {
        return ResponseEntity.ok(technicianService.addTechnician(technician));
    }

    @PostMapping(value = "/regions")
    @Operation(summary = "Create a region")
    public ResponseEntity<Region> addRegion(@RequestBody Region region) {
        return ResponseEntity.ok(regionService.addRegion(region));
    }
    @PostMapping("/activities")
    @Operation(summary = "Create an activity")
    public ResponseEntity<Activity> addActivity(@RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.addActivity(activity));
    }


    // READ
    @GetMapping("/technicians")
    @Operation(summary = "Return list of all technicians")
    public ResponseEntity<List<Technician>> getTechnicians() {
        return ResponseEntity.ok(technicianService.findAll());
    }

    @GetMapping("/regions")
    @Operation(summary = "Return list of all regions")
    public ResponseEntity<List<Region>> getRegions() {
        return ResponseEntity.ok(regionService.findAll());
    }

    @GetMapping("/activities")
    @Operation(summary = "Return list of all activities")
    public ResponseEntity<List<Activity>> getActivities() {
        return ResponseEntity.ok(activityService.findAll());
    }



    // UPDATE
    @PutMapping("/technicians/{id}")
    @Operation(summary = "Update technician")
    public ResponseEntity<Technician> updateTechnician(@PathVariable Long id, @RequestBody Technician technician) {
        return ResponseEntity.ok(technicianService.updateTechnician(id, technician));
    }

    @PutMapping(value = "/regions/{id}")
    @Operation(summary = "Update region")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        return ResponseEntity.ok(regionService.updateRegion(id, region));
    }

    @PutMapping("/activities/{id}")
    @Operation(summary = "Update activity")
    public ResponseEntity<Activity> updateActivity(@PathVariable Long id, @RequestBody Activity activity) {
        return ResponseEntity.ok(activityService.updateActivity(id, activity));
    }



    // DELETE
    @DeleteMapping("/technicians/{id}")
    @Operation(summary = "Delete technician")
    public ResponseEntity<String> deleteTechnician(@PathVariable Long id) {
        return ResponseEntity.ok(technicianService.deleteTechnician(id));
    }

    @DeleteMapping(value = "/regions/{id}")
    @Operation(summary = "Delete region")
    public ResponseEntity<String> deleteRegion(@PathVariable Long id) {
        return ResponseEntity.ok(regionService.deleteRegion(id));
    }

    @DeleteMapping("/activities/{id}")
    @Operation(summary = "Delete activity")
    public ResponseEntity<String> deleteActivity(@PathVariable Long id) {
        return ResponseEntity.ok(activityService.deleteActivity(id));
    }



    // E-MAIL
    @PostMapping("/send-email")
    @Operation(summary = "Send email to all technicians with activities")
    public void sendEmail(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String content = payload.get("content");
        emailService.sendEmail(email, "Przypisane Obszary", content);
    }
}
