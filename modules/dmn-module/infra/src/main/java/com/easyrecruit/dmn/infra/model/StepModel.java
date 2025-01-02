package com.easyrecruit.dmn.infra.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.Map;

@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
public class StepModel {

    private int order;
    private String qualifier;
    private String name;
    private String description;
    private Map<String, Object> variables;
    private Object decision;
    private boolean result;


}
