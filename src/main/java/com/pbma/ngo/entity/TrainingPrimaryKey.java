package com.pbma.ngo.entity;
import java.io.Serializable;

import lombok.Data;


@Data
public class TrainingPrimaryKey implements Serializable{

    private Long trainingId;
    private Long traineeId;

    public TrainingPrimaryKey(Long trainingId, Long traineeId) {
        this.trainingId = trainingId;
        this.traineeId = traineeId;
    }

    public TrainingPrimaryKey() {
    }
    

    
}
