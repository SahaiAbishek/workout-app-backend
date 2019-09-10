//package com.example.training.workout.controller;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.training.workout.model.Workout;
//
//@RestController
//public class WorkoutTrackerController {
//
//	@RequestMapping(method = RequestMethod.GET, path = "/workouts", produces = "application/json")
//	@CrossOrigin
//	public ResponseEntity<String> getAllWorkouts() throws Exception {
//		return new ResponseEntity<String>("Success", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.PUT, path = "/workouts/{name}", produces = "application/json")
//	@CrossOrigin
//	public ResponseEntity<String> updateWorkout(@PathVariable String name) throws Exception {
//		return new ResponseEntity<String>("Success", HttpStatus.OK);
//	}
//
//	@RequestMapping(method = RequestMethod.POST, path = "/workouts/", produces = "application/json")
//	@CrossOrigin
//	public ResponseEntity<String> addWorkout(@RequestBody Workout workout) throws Exception {
//		return new ResponseEntity<String>("Success", HttpStatus.OK);
//	}
//}
