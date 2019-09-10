package com.example.training.workout.dao;

import com.example.training.workout.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepo extends JpaRepository<UserEntity, Long> {

//    @Query("SELECT u FROM  UserEntity u, WorkoutEntity w WHERE u.id = :id and w.title like %:title%")
    UserEntity findByIdAndWorkoutsTitleIgnoreCaseContaining(@Param("id") Long id,@Param("title") String title);

}
