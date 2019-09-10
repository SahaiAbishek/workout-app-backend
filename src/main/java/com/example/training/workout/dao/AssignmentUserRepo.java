package com.example.training.workout.dao;

import com.example.training.workout.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

interface AssignmentUserRepo extends JpaRepository<UserEntity, Long> {
        @SuppressWarnings("unchecked")
        UserEntity save(UserEntity user);

        List<UserEntity> findByEmail(String email);

        Optional<UserEntity> findByEmail(Long id);

        UserEntity findByUserName(String userName);
    }