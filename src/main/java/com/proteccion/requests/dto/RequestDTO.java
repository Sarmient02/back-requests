package com.proteccion.requests.dto;

import com.proteccion.requests.domain.enums.RequestType;
import com.proteccion.requests.domain.model.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {

    private Long id;
    private RequestType type;
    private Integer manualPriority;
    private LocalDateTime createdAt;
    private UserDTO user;

    public static RequestDTO fromEntity(Request request) {
        return RequestDTO.builder()
                .id(request.getId())
                .type(request.getType())
                .manualPriority(request.getManualPriority())
                .createdAt(request.getCreatedAt())
                .user(UserDTO.fromEntity(request.getUser()))
                .build();
    }

}
