package com.proteccion.requests.priority.rules.impl;

import com.proteccion.requests.domain.model.Request;
import com.proteccion.requests.priority.rules.interfaces.IPriorityRule;
import org.springframework.stereotype.Component;

@Component
public class ManualPriorityRule implements IPriorityRule {

    private static final double WEIGHT = 1;

    @Override
    public double calculateScore(Request request) {
        int priority = request.getManualPriority();
        return switch (priority) {
            case 1 -> 100.0;
            case 2 -> 75.0;
            case 3 -> 50.0;
            case 4 -> 25.0;
            case 5 -> 0.0;
            default -> 50.0; // Default to invalid values (medium priority)
        };
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public String getName() {
        return "ManualPriority";
    }

}
