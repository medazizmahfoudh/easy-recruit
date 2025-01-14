package com.easyrecruit.serviceApi;

import com.eniso.entities.ApplicationReport;
import com.eniso.entities.Training;
import com.eniso.entities.TrainingLevel;
import com.eniso.entities.TrainingSeverity;
import com.eniso.payloads.requests.TrainingCreationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrainingServiceAPI {

    List<Training> findTraining(
            TrainingLevel level,
            TrainingSeverity severity,
            String topic
    );

    List<Training> suggestTrainings(ApplicationReport report);

    void createTraining(TrainingCreationRequest request);
}
