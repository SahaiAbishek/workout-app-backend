package com.example.training.workout.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.workout.exception.WorkoutExceptionResolver;
import com.example.training.workout.model.Workout;
import com.example.training.workout.service.UserService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, path = "/workouts/user/{userId}", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Workout.class, responseContainer = "List") })
	public ResponseEntity<List<Workout>> getAllWorkouts(@PathVariable Long userId) throws Exception{
		return new ResponseEntity<List<Workout>>(userService.getAllWorkouts(userId), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/workouts/user/{userId}/{title}", produces = "application/json")
	@CrossOrigin
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
			@ApiResponse(code = 200, message = "OK", response = Workout.class, responseContainer = "List") })
	public ResponseEntity<List<Workout>> getWorkoutsByTile(@PathVariable Long userId, @PathVariable String title ) throws Exception{
		return new ResponseEntity<List<Workout>>(userService.findWorkoutsByTitle(userId,title), HttpStatus.OK);
	}
}
