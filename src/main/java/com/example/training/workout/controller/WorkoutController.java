package com.example.training.workout.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.training.workout.exception.WorkoutExceptionResolver;
import com.example.training.workout.model.Workout;
import com.example.training.workout.service.WorkoutService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class WorkoutController {

    Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    @Autowired
    private WorkoutService workoutService;

    @RequestMapping(method = RequestMethod.GET, path = "/workouts", produces = "application/json")
    @CrossOrigin
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 200, message = "OK", response = Workout.class, responseContainer = "List")})
    public ResponseEntity<List<Workout>> getAllWorkouts() throws Exception {
        logger.debug("Inside getAllWorkouts..");
        return new ResponseEntity<List<Workout>>(workoutService.getAllWorkouts(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/workouts/id", produces = "application/json")
    @CrossOrigin
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 200, message = "OK", response = Workout.class)})
    public ResponseEntity<Workout> getWorkoutbyId(@RequestParam Long id) throws Exception {
        return new ResponseEntity<Workout>(workoutService.getWorkoutById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/workouts/title", produces = "application/json")
    @CrossOrigin
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 200, message = "OK", response = Workout.class)})
    public ResponseEntity<List<Workout>> getWorkoutbyTitle(@RequestParam String title) throws Exception {
        logger.debug("Inside getWorkoutbyTitle..");
        return new ResponseEntity<>(workoutService.getWorkoutByTitle(title), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/workouts", produces = "application/json")
    @CrossOrigin
    public ResponseEntity<Workout> updateWorkout(@RequestBody Workout workout) throws Exception {
        logger.debug("Inside updateWorkout..");
        return new ResponseEntity<>(workoutService.update(workout), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/workouts/", produces = "application/json")
    @CrossOrigin
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 200, message = "OK", response = Workout.class)})
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) throws Exception {
        return new ResponseEntity<>(workoutService.addWorkout(workout), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/workouts/id/{id}", produces = "application/json")
    @CrossOrigin
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 500, message = "Handled Exception", response = WorkoutExceptionResolver.class),
            @ApiResponse(code = 200, message = "OK", response = String.class)})
    public ResponseEntity<String> deleteWorkout(@PathVariable Long id) throws Exception {
        try {
            workoutService.deleteWorkoutById(id);
            return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
