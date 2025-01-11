package com.easyrecruit.evaluation.service.impl;

import ch.qos.logback.core.boolex.EventEvaluator;
import com.easyrecruit.management.dal.entity.EvaluationEntity;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.dal.repository.EvaluationRepository;
import com.easyrecruit.management.infra.model.entity.Evaluation;
import com.easyrecruit.management.infra.model.entity.EvaluationStatus;
import org.bson.RawBsonDocument;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CandidateService {

    private final  LLMService llmService ;
    private final EvaluationRepository evaluationRepository;

    @Autowired
    public CandidateService(LLMService llmService,
                            EvaluationRepository evaluationRepository){
        this.llmService=llmService;
        this.evaluationRepository=evaluationRepository;
    }


    public void processApplication(Application application) {

        System.out.println("Processing candidate ID= "+application.getCandidate().getId()+" for application "+application.getId());
        String jobDescription = application.getPosition().getDescription();
        Binary binarycv = application.getCv().getDocument();

        String  cv = convertBinaryToString(binarycv);

        // Inference
        HashMap<String,String> results = llmService.evaluateCandidateJson(jobDescription,cv);

        Double  score = Double.parseDouble(results.get("score"));
        String feedback = results.get("feedback");


        // Create Evaluation
        EvaluationEntity evaluation = new EvaluationEntity();
        evaluation.setFeedback(feedback);
        evaluation.setScore(score);
        evaluation.setStatus(EvaluationStatus.COMPLETED);

        // Save evaluation
        evaluationRepository.save(evaluation);


    }
    public static String convertBinaryToString(Binary bsonData){
            // Convert a BinaryFile to a String
            RawBsonDocument rawBsonDocument = RawBsonDocument.parse(bsonData.toString());
            return rawBsonDocument.toString();


    };




    }
}
