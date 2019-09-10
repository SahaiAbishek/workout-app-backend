package com.example.training.workout.dao;

import com.example.training.workout.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.workout.entity.WorkoutEntity;

import java.util.List;
import java.util.Set;

@Transactional
public interface WorkoutRepo extends JpaRepository<WorkoutEntity, Long> {
    List<WorkoutEntity> findByTitleIgnoreCaseContaining(String title);
    Set<WorkoutEntity> findByTitleIgnoreCaseContainingAndUserId(String title,Long userId);
}
