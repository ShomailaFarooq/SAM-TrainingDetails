package com.pbma.ngo.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bazaarvoice.jolt.JsonUtils;

@Configuration
public class TrainingDetailsConfig {

	@Autowired
	private ApplicationYaml applicationYaml;
	
	@Bean
	public List<Object> getTrainingDetailsPostRequestJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getTrainingDetailsPostRequestJoltSpec());
	}
	
	@Bean
	public List<Object> getTrainingDetailsGetResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getTrainingDetailsGetResponseJoltSpec());
	}
	
	@Bean
	public List<Object> getTrainingDetailsPostResponseJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getTrainingDetailsPostResponseJoltSpec());
	}

	@Bean
	public List<Object> getTrainingDetailsPutRequestJoltSpec() {
		return JsonUtils.classpathToList(applicationYaml.getJolt().getTrainingDetailsPutRequestJoltSpec());
	}

}
