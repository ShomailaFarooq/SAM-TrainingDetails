package com.pbma.ngo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pbma.ngo.service.TrainingDetailsService;

@RestController
public class TrainingDetailsController {

	@Autowired
	private TrainingDetailsService trainingDetailsService;

	private static final Logger trainingDetailsLogger = LoggerFactory.getLogger(TrainingDetailsController.class);

	@PostMapping(value = "/trainings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addTrainingDetails(@RequestBody String trainingDetailsRequest) throws Exception {
		trainingDetailsLogger.info("Received request to Add Trainee Details");
		ResponseEntity<String> responseEntity = trainingDetailsService.saveTrainingDetails(trainingDetailsRequest);
		trainingDetailsLogger.info("Completed request to Add Trainee Details");
		return responseEntity;
	}

	@GetMapping(value = "/trainings/{traineeId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> viewTrainingDetails(@PathVariable("traineeId") Long traineeId) throws Exception {
		trainingDetailsLogger.info("Received request to View Trainee Details");
		ResponseEntity<String> responseEntity = trainingDetailsService.getTrainingDetails(traineeId);
		trainingDetailsLogger.info("Completed request to View Trainee Details");
		return responseEntity;
	}

	@GetMapping(value = "/trainings", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> viewAllTrainingDetails() throws Exception {
		trainingDetailsLogger.info("Received request to View All Training Details");
		ResponseEntity<String> responseEntity = trainingDetailsService.getAllTrainingDetails();
		trainingDetailsLogger.info("Completed request to View All Trainee Details");
		return responseEntity;
	}

}
