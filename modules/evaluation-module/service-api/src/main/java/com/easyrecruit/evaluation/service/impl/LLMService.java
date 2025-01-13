package com.easyrecruit.evaluation.service.impl;

import java.util.HashMap;

public interface LLMService {

    public String evaluate_candidate(String jobDescription,String cv);

    public HashMap<String, String> evaluateCandidateJson(String jobDescription, String cv);

    public HashMap<String, String> getScoreAndFeedback(String completion) ;



    }
