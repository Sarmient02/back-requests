package com.proteccion.requests.priority.rules.interfaces;

import com.proteccion.requests.domain.model.Request;

public interface IPriorityRule {

    double calculateScore(Request request);

    double getWeight();

    String getName();
}
