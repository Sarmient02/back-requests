package com.proteccion.requests.service.interfaces;

import com.proteccion.requests.dto.CreateRequestDTO;
import com.proteccion.requests.dto.PrioritizedRequestDTO;
import com.proteccion.requests.dto.RequestDTO;

import java.util.List;

public interface IRequestService {

    /**
     * Create a new request.
     *
     * @param dto the request data
     * @return the created request
     */
    RequestDTO create(CreateRequestDTO dto);

    /**
     * Get all requests without prioritization.
     *
     * @return list of all requests
     */
    List<RequestDTO> findAll();

    /**
     * Get all requests sorted by calculated priority (highest first).
     * Includes score breakdown for each request.
     *
     * @return list of prioritized requests
     */
    List<PrioritizedRequestDTO> findAllPrioritized();
}
