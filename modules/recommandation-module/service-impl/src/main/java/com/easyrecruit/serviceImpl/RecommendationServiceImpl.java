package com.easyrecruit.serviceImpl;

import com.easyrecruit.management.infra.model.Cv;
import com.easyrecruit.management.infra.model.entity.Application;
import com.easyrecruit.management.infra.model.entity.Candidate;
import com.easyrecruit.management.infra.model.entity.Position;
import com.easyrecruit.management.infra.model.entity.Skill;
import com.easyrecruit.management.service.api.ApplicationModule;
import com.easyrecruit.serviceApi.RecommendationServiceAPI;
import com.easyrecruit.serviceApi.TrainingServiceAPI;
import com.eniso.entities.ApplicationReport;
import com.eniso.repositories.ApplicationReportRepository;
import jakarta.inject.Singleton;

import java.util.*;

@Singleton
public class RecommendationServiceImpl implements RecommendationServiceAPI {

    private final ApplicationReportRepository repository;
    private final ApplicationModule applicationModule;

    public RecommendationServiceImpl(ApplicationReportRepository repository, ApplicationModule applicationModule, TrainingServiceAPI trainingServiceAPI) {
        this.repository = repository;
        this.applicationModule = applicationModule;
    }

    @Override
    public void processApplications(){
        List<Application> applications = applicationModule.getAllApplications();
        for (Application app: applications){
             generateApplicationReport(app);
        }
    }



    @Override
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    private void generateApplicationReport(Application app) {
        Position position = app.getPosition();
        Candidate candidate = app.getCandidate();
        Cv cv = app.getCv();
        List<Skill> skills = cv.getSkills();
        List<Skill> requiredSkills = position.getRequiredSkills();

        List<Skill> missing = findMissingSkills(skills, requiredSkills);
        Map<Skill, Integer> skillsMap = skillsMap(skills, requiredSkills);

        ApplicationReport applicationReport = buildApplicationReport(
                app, candidate, missing, skillsMap
        );
        repository.save(applicationReport);
    }

    private ApplicationReport buildApplicationReport
            (Application app, Candidate candidate, List<Skill> missing, Map<Skill, Integer> skillsMap) {
        return ApplicationReport.Builder.builder()
                .withUuid(UUID.randomUUID().toString())
                .withMissingSkills(missing)
                .withSkillMap(skillsMap)
                .withApplicationUUID(app.getUuid())
                .build();
    }

    private Map<Skill, Integer> skillsMap(List<Skill> skills, List<Skill> requiredSkills) {

        Map<Skill, Integer> result = new HashMap<>();
        for (Skill skill: requiredSkills){
            if (skills.contains(skill)){
                result.put(skill, skill.getLevel());
            }
        }
        return result;
    }

    private List<Skill> findMissingSkills(List<Skill> skills, List<Skill> requiredSkills) {

        List<Skill> result = new ArrayList<>();
        for (Skill skill: requiredSkills){
            if (!skills.contains(skill)){
                result.add(skill);
            }
        }
        return result;
    }



}
