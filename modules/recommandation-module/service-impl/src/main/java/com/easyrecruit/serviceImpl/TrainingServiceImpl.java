package com.easyrecruit.serviceImpl;

import com.easyrecruit.management.infra.model.entity.Skill;
import com.easyrecruit.serviceApi.TrainingServiceAPI;
import com.eniso.entities.*;
import com.eniso.payloads.requests.TrainingCreationRequest;
import com.eniso.repositories.TrainingRepository;
import com.eniso.repositories.TrainingSpecification;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Singleton
public class TrainingServiceImpl implements TrainingServiceAPI {

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }


    @Override
    public List<Training> findTraining(
            TrainingLevel level,
            TrainingSeverity severity,
            String topic
    ) {
        return trainingRepository.findAll(
                TrainingSpecification.findTraining(
                        level, severity, topic)
        );
    }

    @Override
    public List<Training> suggestTrainings(ApplicationReport report){

        List<Training> result = new ArrayList<>();

        for (Skill missingSkill: report.getMissingSkills()){
            result.addAll(
                    findTraining(
                            TrainingLevel.BASIC,
                            TrainingSeverity.MANDATORY,
                            missingSkill.getName()
                    ));
        }
        for (Map.Entry<Skill, Integer> entry :  report.getSkillMap().entrySet()){
            result.addAll(findComplementaryTrainings(entry));
        }

        return result;
    }

    @Override
    public void createTraining(TrainingCreationRequest request) {
        Training training = Training.Builder
                .builder()
                .withLevel(TrainingLevel.valueOf(request.getLevel().toUpperCase()))
                .withSeverity(TrainingSeverity.valueOf(request.getSeverity().toUpperCase()))
                .withTopic(request.getTopic())
                .withTrainerContact(new TrainerContact(
                        request.getTrainerName(),
                        request.getTrainerEmail(),
                        request.getTrainerPhoneNumber()
                )).build();
        trainingRepository.save(training);
    }

    private List<Training> findComplementaryTrainings(Map.Entry<Skill, Integer> entry) {
        List<Training> trainings = new ArrayList<>();

        if (entry.getValue() > 4){
            List<Training> result = findTraining(
                    TrainingLevel.ADVANCED,
                    TrainingSeverity.OPTIONAL,
                    entry.getKey().getName()
            );
            trainings.addAll(result);
        }
        if (entry.getValue() == 4){
            List<Training> result = findTraining(
                    TrainingLevel.INTERMEDIATE,
                    TrainingSeverity.OPTIONAL,
                    entry.getKey().getName()
            );
            trainings.addAll(result);
        }
        if (entry.getValue() < 4){
            List<Training> result = findTraining(
                    TrainingLevel.BASIC,
                    TrainingSeverity.MANDATORY,
                    entry.getKey().getName()
            );
            trainings.addAll(result);
        }
        return trainings;
    }

}
