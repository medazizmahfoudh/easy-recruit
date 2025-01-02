
package com.easyrecruit.dmn.infra.config;

import com.easyrecruit.dmn.infra.ann.DmnConfig;
import com.easyrecruit.dmn.infra.ann.Step;
import com.easyrecruit.dmn.infra.model.StepModel;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class DmnInitializer implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    private final List<StepModel> STEPS = new ArrayList<>();

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
    public void initializeSteps() {
        applicationContext.getBeansWithAnnotation(DmnConfig.class).forEach((beanName, beanInstance) -> {
            Class<?> aClass = ClassUtils.getUserClass(beanInstance);
            Method[] methods = aClass.getDeclaredMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(Step.class)) {
                    try {
                        method.setAccessible(true);
                        Step stepAnnotation = method.getAnnotation(Step.class);
                        StepModel stepModel = new StepModel()
                                .setOrder(stepAnnotation.order())
                                .setName(stepAnnotation.name())
                                .setDescription(stepAnnotation.description())
                                .setQualifier(beanName)
                                .setDecision(method.invoke(beanInstance));
                        STEPS.add(stepModel);
                    } catch (Exception e) {
                        throw new RuntimeException("Failed to initialize step: " + method.getName(), e);
                    }
                }
            }
        });
        STEPS.sort(Comparator.comparingInt(StepModel::getOrder));
    }

    public List<StepModel> getSteps() {
        return new ArrayList<>(STEPS);
    }
}

