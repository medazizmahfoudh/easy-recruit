package com.easyrecruit.evaluation.service.impl;


import com.easyrecruit.evaluation.infra.PromptTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.langchain4j.model.chat.ChatLanguageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class LLMServiceImpl {

    private final ChatLanguageModel chatModel;
    private final PromptTemplate promptTemplate;

    @Autowired
    public LLMServiceImpl(ChatLanguageModel chatModel, PromptTemplate promptTemplate) {
        this.chatModel = chatModel;
        this.promptTemplate = promptTemplate;
    }


    public static JsonNode parseJson(String jsonString) {
        // convert the llm output to a json format
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Parse the JSON string and return the JsonNode
            return objectMapper.readTree(jsonString);
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Return null in case of an exception
        }
    }

    public HashMap<String, String> getScoreAndFeedback(String completion) {
        JsonNode jsonNode = parseJson(completion);
        HashMap<String, String> output = new HashMap<>();
        if (jsonNode != null) {
            String score = jsonNode.get("score").asText();
            String feedback = jsonNode.get("feedback").asText();

            // Output for verification
            System.out.println("Score: " + score);
            System.out.println("Feedback: " + feedback);

            output.put("score", score);
            output.put("feedback", feedback);


        }
        return output;

    }

    public String evaluate_candidate(String jobDescription,String cv){
        String prompt = promptTemplate.construct_template(jobDescription,cv);
        return chatModel.generate(prompt);
    }

    public HashMap<String, String> evaluateCandidateJson(String jobDescription, String cv){
        String completion = evaluate_candidate(jobDescription,cv);
        return getScoreAndFeedback(completion);
    };

}



