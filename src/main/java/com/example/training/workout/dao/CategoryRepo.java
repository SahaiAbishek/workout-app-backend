package com.example.training.workout.dao;

import com.example.training.workout.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.example.training.workout.entity.CategoryEntity;

import java.util.List;
import java.util.Optional;

@Transactional
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
	
	@Transactional
    Long deleteByName(String name);
}
