package com.pbma.ngo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pbma.ngo.entity.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

	public List <Training> findByTraineeId (@Param("traineeId") final long traineeId);
}
