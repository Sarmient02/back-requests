package com.proteccion.requests.dto;

import com.proteccion.requests.domain.enums.RequestType;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "CreateRequestDTO", description = "DTO for creating a new request")
public class CreateRequestDTO {

    @Schema(description = "Type of the request", example = "INCIDENT")
    private RequestType type;
    @Schema(description = "Manual priority of the request", example = "1")
    private Integer manualPriority;
    @Schema(description = "ID of the user associated with the request", example = "42")
    private Long userId;

}
