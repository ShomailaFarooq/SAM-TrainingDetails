package com.pbma.ngo.service;

import org.springframework.http.ResponseEntity;

public interface TrainingDetailsService {

	public ResponseEntity<String> saveTrainingDetails(final String trainingDetailsRequest) throws Exception;
	public ResponseEntity<String> getTrainingDetails(final long traineeId) throws Exception;
	public ResponseEntity<String> getAllTrainingDetails() throws Exception;
}
