package com.easyrecruit.dmn.infra.config;

import com.easyrecruit.dmn.infra.ann.DmnConfig;
import com.easyrecruit.dmn.infra.ann.Step;
import org.camunda.bpm.dmn.engine.DmnDecision;
import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@DmnConfig
public class DmnConfiguration {


    @Qualifier("webApplicationContext")
    @Autowired
    private ResourceLoader resourceLoader;

    @Bean
    public DmnEngine dmnEngine() {
        DmnEngineConfiguration configuration = DmnEngineConfiguration.createDefaultDmnEngineConfiguration();
        return configuration.buildEngine();
    }

    @Step(
            order = 1,
            name = "PRELIMINARY",
            description = "Decision for whether to move the candidate to the interview or not, based on the AI evaluation"
    )
    @Bean()
    public DmnDecision preliminary() {
        Resource resource = resourceLoader.getResource("classpath:dmn/step-one-decision.dmn");
        try (InputStream decisionStream = resource.getInputStream()) {
            return dmnEngine().parseDecision("decision_19xv9ll", decisionStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step(
            order = 2,
            name = "INTERVIEW",
            description = "Decision for whether to accept, waitlist or reject the candidate, based on his interview evaluation")
    @Bean()
    public DmnDecision interview() {
        Resource resource = resourceLoader.getResource("classpath:dmn/step-two-decision.dmn");
        try (InputStream decisionStream = resource.getInputStream()) {
            return dmnEngine().parseDecision("decision_19xv9li", decisionStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
