package com.example.training.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.workout.exception.WorkoutExceptionResolver;
import com.example.training.workout.model.Category;
import com.example.training.workout.service.CategoryService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(method = RequestMethod.GET, path = "/workouts/categories", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Category.class, responseContainer = "List") })
	public ResponseEntity<List<Category>> getAllCatrgories() {
		return new ResponseEntity<List<Category>>(categoryService.getAllCategories(), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/workouts/categories", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<Category> addCatrgory(@RequestBody Category category) {
		return new ResponseEntity<Category>(categoryService.addCategory(category), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/workouts/categories/{id}/{name}", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<Category> updateCatrgory(@PathVariable Long id, String name) throws Exception {
		return new ResponseEntity<Category>(categoryService.updateCategory(id, name), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/workouts/categories/{id}", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK") })
	public ResponseEntity<String> deleteCatrgory(@PathVariable Long id) throws Exception {
		categoryService.deleteCategory(id);
		return new ResponseEntity<String>("Deleted Successfully", HttpStatus.OK);
	}
}
