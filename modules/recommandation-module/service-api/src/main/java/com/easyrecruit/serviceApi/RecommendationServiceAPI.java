package com.easyrecruit.serviceApi;

import com.easyrecruit.payloads.TrainingResponse;

import java.util.List;

public interface RecommendationServiceAPI {

    void processApplications();

    List<TrainingResponse> getAllSuggestions();

    TrainingResponse getSuggestionByUUID(String uuid);

    void deleteAll();

    void deleteById(Long id);

}
