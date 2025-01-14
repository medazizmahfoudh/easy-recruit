package com.easyrecruit.serviceApi;

import jakarta.inject.Singleton;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RecommendationServiceAPI {

    void processApplications();

//    List<TrainingResponse> getAllSuggestions();
//
//    TrainingResponse getSuggestionByUUID(String uuid);

    void deleteAll();

    void deleteById(Long id);

}
