package com.proteccion.requests.dto;

import com.proteccion.requests.domain.enums.RequestType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRequestDTO {

    private RequestType type;
    private Integer manualPriority;
    private Long userId;

}
