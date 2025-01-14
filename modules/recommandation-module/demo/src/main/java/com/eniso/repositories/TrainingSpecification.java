package com.eniso.repositories;

import com.eniso.entities.Training;
import com.eniso.entities.TrainingLevel;
import com.eniso.entities.TrainingSeverity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class TrainingSpecification {

    public static Specification<Training> findTraining(
            TrainingLevel level,
            TrainingSeverity severity,
            String topic
    ) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (topic != null) {
                predicates.add(
                        criteriaBuilder.like(root.get("topic"), "%" + topic + "%")
                );
            }

            if (severity != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("severity"), severity)
                );
            }

            if (level != null) {
                predicates.add(
                        criteriaBuilder.equal(root.get("level"), level)
                );
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}
