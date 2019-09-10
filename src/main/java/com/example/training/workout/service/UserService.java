package com.example.training.workout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.example.training.workout.dao.UserRepo;
import com.example.training.workout.dao.WorkoutRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.workout.entity.UserEntity;
import com.example.training.workout.entity.WorkoutEntity;
import com.example.training.workout.model.Workout;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private WorkoutRepo workoutRepo;

    public List<Workout> getAllWorkouts(Long userId) throws Exception {
        Optional<UserEntity> optionalUserEntity = userRepo.findById(userId);
        UserEntity userEntity = optionalUserEntity.get();
        if (null != userEntity) {
            List<Workout> targets = new ArrayList<>();
            for (WorkoutEntity source : userEntity.getWorkouts()) {
                Workout target = new Workout();
                BeanUtils.copyProperties(source, target);
                target.setCategory(source.getCategory().getName());
                targets.add(target);
            }
            return targets;
        } else {
            throw new Exception("No users found for user id : " + userId);
        }
    }

    public List<Workout> findWorkoutsByTitle(Long userId, String title) throws Exception {
        UserEntity userWorkouts = userRepo.findByIdAndWorkoutsTitleIgnoreCaseContaining(userId, title);
        if (null != userWorkouts) {
            Set<WorkoutEntity> workouts = workoutRepo.findByTitleIgnoreCaseContainingAndUserId(title,userId);//userWorkouts.getWorkouts();
            if (null != workouts) {
                List<Workout> targets = new ArrayList<>();
                for (WorkoutEntity source : workouts) {
                    Workout target = new Workout();
                    BeanUtils.copyProperties(source, target);
//				target.setCategory(source.getCategory().getName());
                    targets.add(target);
                }
                return targets;
            }else{
                throw new Exception("No users forund for user id : " + userId);
            }
        } else {
            throw new Exception("No users forund for user id : " + userId);
        }
    }
}
