package com.proteccion.requests.priority.rules.impl;

import com.proteccion.requests.domain.model.Request;
import com.proteccion.requests.priority.rules.interfaces.IPriorityRule;
import org.springframework.stereotype.Component;

@Component
public class RequestTypeRule implements IPriorityRule {

    private static final double WEIGHT = 1;

    @Override
    public double calculateScore(Request request) {
        return switch (request.getType()) {
            case INCIDENT -> 100;
            case REQUIREMENT -> 50;
            case INQUIRY -> 25;
        };
    }

    @Override
    public double getWeight() {
        return WEIGHT;
    }

    @Override
    public String getName() {
        return "RequestType";
    }

}
