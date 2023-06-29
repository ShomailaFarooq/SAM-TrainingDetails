package com.pbma.ngo.service;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbma.ngo.config.TrainingDetailsConfig;
import com.pbma.ngo.entity.Training;
import com.pbma.ngo.repository.TrainingRepository;
import com.pbma.ngo.util.Constants;
import com.pbma.ngo.util.TrainingDetailsUtils;

@Service
public class TrainingDetailsServiceImpl implements TrainingDetailsService {

	@Autowired
	private TrainingDetailsConfig trainingDetailsConfig;

	@Autowired
	private TrainingRepository trainingRepository;

	private static final Logger trainingDetailsLogger = LoggerFactory
			.getLogger(TrainingDetailsServiceImpl.class);

	@Override
	public ResponseEntity<String> saveTrainingDetails(String trainingDetailsRequest) throws Exception {

		// jolt for request json - flatten to map to entity
		String transformedTrainingRequest = TrainingDetailsUtils.transformRequest(trainingDetailsRequest,
				trainingDetailsConfig.getTrainingDetailsRequestJoltSpec());
		trainingDetailsLogger.debug("Save Training Details transformed request : {}", transformedTrainingRequest);

		ObjectMapper objectMapper = new ObjectMapper();
		Training requestTrainingObject = objectMapper.readValue(transformedTrainingRequest, Training.class);
		Training training = trainingRepository.save(requestTrainingObject);
		trainingDetailsLogger.info("Training Details inserted in database successfully");

		// response jolt for traineeId
		String trainingResponse = new JSONObject(training).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);

		String response = new JSONObject(TrainingDetailsUtils.transformRequest(trainingResponse,
				trainingDetailsConfig.getTrainingDetailsPostResponseJoltSpec()))
				.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		trainingDetailsLogger.debug("Save Training Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.CREATED);

	}


	@Override
	public ResponseEntity<String> getTrainingDetails(long traineeId) throws Exception {

		List<Training> trainings = trainingRepository.findByTraineeId(traineeId);
		trainingDetailsLogger.info("Training Details retrieved from database successfully");

		JSONArray transformedTrainings = new JSONArray();

		trainings.forEach(training -> {

			JSONObject responseTraining = new JSONObject(TrainingDetailsUtils.transformRequest(
					new JSONObject(training).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR),
					trainingDetailsConfig.getTrainingDetailsGetResponseJoltSpec()));
			transformedTrainings.put(responseTraining);

		});

		String response = transformedTrainings.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		trainingDetailsLogger.debug("Get Training Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<String> getAllTrainingDetails() throws Exception {

		List<Training> trainings = trainingRepository.findAll();
		trainingDetailsLogger.info("All Training Details retrieved from database successfully");

		JSONArray transformedTrainings = new JSONArray();

		trainings.forEach(training -> {

			JSONObject responseTraining = new JSONObject(TrainingDetailsUtils.transformRequest(
					new JSONObject(training).toString(Constants.JSON_OBJECT_INDENTATION_FACTOR),
					trainingDetailsConfig.getTrainingDetailsGetResponseJoltSpec()));
			transformedTrainings.put(responseTraining);

		});

		String response = transformedTrainings.toString(Constants.JSON_OBJECT_INDENTATION_FACTOR);
		trainingDetailsLogger.debug("Get All Training Details transformed response : {}", response);

		return new ResponseEntity<String>(response, HttpStatus.OK);

	}
}
