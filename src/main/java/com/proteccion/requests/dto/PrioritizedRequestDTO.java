package com.proteccion.requests.dto;

import com.proteccion.requests.domain.enums.RequestType;
import com.proteccion.requests.domain.model.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrioritizedRequestDTO {

    private Long id;
    private RequestType type;
    private Integer manualPriority;
    private LocalDateTime createdAt;
    private UserDTO user;
    private Double totalScore;
    private Map<String, Double> scoreBreakdown;

    public static PrioritizedRequestDTO fromEntity(Request request, double totalScore, Map<String, Double> breakdown) {
        return PrioritizedRequestDTO.builder()
                .id(request.getId())
                .type(request.getType())
                .manualPriority(request.getManualPriority())
                .createdAt(request.getCreatedAt())
                .user(UserDTO.fromEntity(request.getUser()))
                .totalScore(totalScore)
                .scoreBreakdown(breakdown)
                .build();
    }

}
