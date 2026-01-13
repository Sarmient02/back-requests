package com.proteccion.requests.priority;

import com.proteccion.requests.domain.model.Request;
import com.proteccion.requests.priority.rules.interfaces.IPriorityRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class PriorityEngine {

    private final List<IPriorityRule> rules;

    /**
     * Calculate the total priority score for a request.
     * Score = SUM(ruleScore*ruleWeight)
     *
     * @param request the request to evaluate
     * @return the total weighted priority score
     */
    public double calculateTotalScore(Request request) {
        return rules.stream()
                .mapToDouble(rule -> rule.calculateScore(request) * rule.getWeight())
                .sum();
    }

    /**
     * Get detailed breakdown of scores by rule for a request.
     *
     * @param request the request to evaluate
     * @return map of rule name to weighted score
     */
    public Map<String, Double> getScoreBreakdown(Request request) {
        Map<String, Double> breakdown = new HashMap<>();
        for (IPriorityRule rule : rules) {
            double weightedScore = rule.calculateScore(request) * rule.getWeight();
            breakdown.put(rule.getName(), weightedScore);
        }
        return breakdown;
    }

    /**
     * Sort requests by calculated priority.
     *
     * @param requests list of requests to sort
     * @return sorted list with highest priority first
     */
    public List<Request> sortByPriority(List<Request> requests) {
        return requests.stream()
                .sorted((r1, r2) -> Double.compare(
                        calculateTotalScore(r2),
                        calculateTotalScore(r1)))
                .toList();
    }

}
