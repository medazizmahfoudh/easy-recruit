package com.easyrecruit.evaluation.infra;
import org.springframework.stereotype.Component;


@Component
public class PromptTemplate {

        public String construct_template(String jobDescription, String candidateCV) {
            String template = """
                <|begin_of_text|><|start_header_id|>system<|end_header_id|>
                                You are an expert Human talent recruiter with over 30 years of experience.<|eot_id|>
                                <|start_header_id|>user<|end_header_id|>
                                 Your job is to assign a numerical score based on the job requirements to a candidate cv.
                               \s

                                Evaluate the following candidate's suitability for a job:
                                Job Description: {jobDescription}
                                Candidate's CV: {candidateCV}\s

                                The output should only be a json format with two keys that are:
                                - score: (number of mentioned skills in cv/ number of job description skills)
                                - feedback: explaining your decision.
                Please note that you only need to provide the json. Do not generate any other tokens after it.
                """;
            return template
                    .replace("{jobDescription}", jobDescription)
                    .replace("{candidateCV}", candidateCV);
        }
    }



