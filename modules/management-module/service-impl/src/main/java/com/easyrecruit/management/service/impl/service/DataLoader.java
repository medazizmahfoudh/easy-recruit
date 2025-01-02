package com.easyrecruit.management.service.impl.service;

import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.document.Position;
import com.easyrecruit.management.infra.model.entity.Skill;
import com.easyrecruit.management.infra.model.payload.request.ApplicationSubmitOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.request.CandidateCreateOrUpdateRequest;
import com.easyrecruit.management.infra.model.payload.request.PositionCreateOrUpdateRequest;
import com.easyrecruit.management.service.api.ApplicationModule;
import com.easyrecruit.management.service.api.CandidateModule;
import com.easyrecruit.management.service.api.PositionModule;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {


    @Autowired
    private CandidateModule candidateModule;
    @Autowired
    private PositionModule positionModule;
    @Autowired
    private ApplicationModule applicationModule;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (candidateModule.getAllCandidates().isEmpty()) {
            String[] names = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank"};
            for (int i = 0; i < 10; i++) {
                CandidateCreateOrUpdateRequest request = new CandidateCreateOrUpdateRequest(names[i], names[i], names[i] + "@example.com");
                candidateModule.createCandidate(request);
            }
        }

        List<List<Skill>> skills = new ArrayList<>(List.of(
                List.of(
                        new Skill().setName("Java").setLevel(5),
                        new Skill().setName("Spring").setLevel(4),
                        new Skill().setName("Hibernate").setLevel(3)
                ),
                List.of(
                        new Skill().setName("Python").setLevel(5),
                        new Skill().setName("Pandas").setLevel(4),
                        new Skill().setName("Numpy").setLevel(3)
                ),
                List.of(
                        new Skill().setName("Product Management").setLevel(5),
                        new Skill().setName("Agile").setLevel(4),
                        new Skill().setName("Scrum").setLevel(3)
                ),
                List.of(
                        new Skill().setName("Selenium").setLevel(5),
                        new Skill().setName("Junit").setLevel(4),
                        new Skill().setName("TestNG").setLevel(3)
                ),
                List.of(
                        new Skill().setName("Docker").setLevel(5),
                        new Skill().setName("Kubernetes").setLevel(4),
                        new Skill().setName("Jenkins").setLevel(3)
                )));

        if (positionModule.getAllPositions().isEmpty()) {
            String[] positions = {"Software Engineer", "Data Scientist", "Product Manager", "QA Engineer", "DevOps Engineer", "Technical Support Engineer", "Sales Manager", "Marketing Manager", "HR Manager", "Finance Manager"};
            String[] locations = {"New York", "San Francisco", "Los Angeles", "Chicago", "Houston", "Phoenix", "Philadelphia", "San Antonio", "San Diego", "Dallas"};

            for (int i = 0; i < 10; i++) {
                PositionCreateOrUpdateRequest request = new PositionCreateOrUpdateRequest(
                        positions[i],
                        "Description for " + positions[i],
                        locations[i],
                        skills.get(i/2));
                positionModule.createPosition(request);
            }
        }


        if (applicationModule.getAllApplications().isEmpty()) {
            List<Candidate> candidates = candidateModule.getAllCandidates();
            List<Position> positionsList = positionModule.getAllPositions();

            for (int i = 0; i < 10; i++) {
                ApplicationSubmitOrUpdateRequest request = new ApplicationSubmitOrUpdateRequest(
                        candidates.get(i).getUuid(),
                        positionsList.get(i).getUuid(),
                        Lists.reverse(skills).get(i / 2));
                applicationModule.createApplication(request);
            }
        }




    }
}
