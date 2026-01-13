package com.proteccion.requests.priority.rules.impl;

import com.proteccion.requests.domain.model.Request;
import com.proteccion.requests.priority.rules.interfaces.IPriorityRule;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Component
public class AgeRule implements IPriorityRule {

    private static final double WEIGHT = 1;
    private static final double POINTS_PER_DAY = 10;
    private static final double MAX_SCORE = 100;

    @Override
    public double calculateScore(Request request) {
        long daysOld = ChronoUnit.DAYS.between(request.getCreatedAt(), LocalDateTime.now());
        double score = daysOld * POINTS_PER_DAY;
        return Math.min(score, MAX_SCORE);
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public String getName() {
        return "Age";
    }

}
