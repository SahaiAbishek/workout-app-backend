package com.example.training.workout.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.workout.dao.WorkoutRepo;
import com.example.training.workout.entity.WorkoutEntity;
import com.example.training.workout.model.Workout;

@Service
public class WorkoutService {

    @Autowired
    private WorkoutRepo workoutRepo;

    public List<Workout> getAllWorkouts() {
        List<Workout> targets = new ArrayList<>();

        for (WorkoutEntity source : workoutRepo.findAll()) {
            Workout target = new Workout();
            BeanUtils.copyProperties(source, target);
            target.setCategory(source.getCategory().getName());
            targets.add(target);
        }
        return targets;
    }

    public Workout getWorkoutById(Long id) {
        Workout target = new Workout();
        BeanUtils.copyProperties(workoutRepo.findById(id), target);
        return target;
    }

    public List<Workout> getWorkoutByTitle(String title) {
        List<Workout> targets = new ArrayList<>();
        for (WorkoutEntity source : workoutRepo.findByTitleIgnoreCaseContaining(title)) {
            Workout target = new Workout();
            BeanUtils.copyProperties(source, target);
            targets.add(target);
        }
        return targets;
    }

    public Workout update(Workout workout) throws Exception {
        WorkoutEntity entity = new WorkoutEntity();
        BeanUtils.copyProperties(workout, entity);
        WorkoutEntity respEntity = workoutRepo.save(entity);
        if (respEntity != null) {
            Workout resp = new Workout();
            BeanUtils.copyProperties(respEntity, resp);
            return resp;
        } else {
            throw new Exception("No records found with id = " + workout.getId());
        }
    }

    public Workout addWorkout(Workout workout) {
        WorkoutEntity target = new WorkoutEntity();
        BeanUtils.copyProperties(workout, target);
        WorkoutEntity entity = workoutRepo.save(target);
        Workout workoutResp = new Workout();
        BeanUtils.copyProperties(entity, workoutResp);
        return workoutResp;
    }

    public void deleteWorkoutById(Long id) {
        workoutRepo.deleteById(id);
    }

}
