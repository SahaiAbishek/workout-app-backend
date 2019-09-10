package com.example.training.workout.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.training.workout.dao.CategoryRepo;
import com.example.training.workout.entity.CategoryEntity;
import com.example.training.workout.model.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	public List<Category> getAllCategories() {
		Iterable<CategoryEntity> sources = categoryRepo.findAll();
		List<Category> targets = new ArrayList<>();
		for (CategoryEntity source : sources) {
			Category target = new Category();
			BeanUtils.copyProperties(source, target);
			targets.add(target);
		}
		return targets;
	}

	public Category addCategory(Category category) {
		CategoryEntity target = new CategoryEntity();
		BeanUtils.copyProperties(category, target);
		CategoryEntity responseSource = categoryRepo.save(target);
		Category respTaret = new Category();
		BeanUtils.copyProperties(responseSource, respTaret);
		return respTaret;
	}

	public Category updateCategory(long id, String value) throws Exception {
		Optional<CategoryEntity> targetOptional = categoryRepo.findById(id);
		CategoryEntity target = targetOptional.get();
		if (target != null) {
			target.setId(id);
			target.setName(value);
			CategoryEntity responseSource = categoryRepo.save(target);
			Category respTaret = new Category();
			BeanUtils.copyProperties(responseSource, respTaret);
			return respTaret;
		} else {
			throw new Exception("No Categories found");
		}
	}

	public void deleteCategory(long id) throws Exception {
		Optional<CategoryEntity> targetOptional = categoryRepo.findById(id);
		CategoryEntity target = targetOptional.get();
		if (target != null) {
			categoryRepo.deleteByName(target.getName());
		} else {
			throw new Exception("No Categories found");
		}
	}
}
