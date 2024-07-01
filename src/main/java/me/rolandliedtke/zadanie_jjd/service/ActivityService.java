package me.rolandliedtke.zadanie_jjd.service;

import me.rolandliedtke.zadanie_jjd.model.Activity;
import me.rolandliedtke.zadanie_jjd.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ActivityService {

    public final ActivityRepository activityRepository;


    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    public Activity addActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public Activity updateActivity(Long id, Activity updatedActivity) {
        activityRepository.findById(id)
                .map(activity -> {
                    activity.setDescription(updatedActivity.getDescription());
                    activity.setDuration(updatedActivity.getDuration());
                    activity.setTechnician_id(updatedActivity.getTechnician_id());
                    return activityRepository.save(activity);
                });
        return activityRepository.findById(id).orElseThrow();
    }

    public String deleteActivity(Long id) {
        activityRepository.deleteById(id);
        return "Success!";
    }

    public Activity getById(Long id) {
        return activityRepository.findById(id).orElseThrow();
    }
}
