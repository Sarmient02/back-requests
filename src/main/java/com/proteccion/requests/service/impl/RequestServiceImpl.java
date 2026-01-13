package com.proteccion.requests.service.impl;

import com.proteccion.requests.domain.model.Request;
import com.proteccion.requests.domain.model.User;
import com.proteccion.requests.dto.CreateRequestDTO;
import com.proteccion.requests.dto.PrioritizedRequestDTO;
import com.proteccion.requests.dto.RequestDTO;
import com.proteccion.requests.priority.PriorityEngine;
import com.proteccion.requests.repository.IRequestRepository;
import com.proteccion.requests.repository.IUserRepository;
import com.proteccion.requests.service.interfaces.IRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RequestServiceImpl implements IRequestService {

    private final IRequestRepository requestRepository;
    private final IUserRepository userRepository;
    private final PriorityEngine priorityEngine;

    /**
     * Create a new request.
     *
     * @param dto the request data
     * @return the created request
     */
    public RequestDTO create(CreateRequestDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + dto.getUserId()));

        Request request = Request.builder()
                .type(dto.getType())
                .manualPriority(dto.getManualPriority())
                .user(user)
                .build();

        Request saved = requestRepository.save(request);
        return RequestDTO.fromEntity(saved);
    }

    /**
     * Get all requests without prioritization.
     *
     * @return list of all requests
     */
    @Transactional(readOnly = true)
    public List<RequestDTO> findAll() {
        return requestRepository.findAll().stream()
                .map(RequestDTO::fromEntity)
                .toList();
    }

    /**
     * Get all requests sorted by calculated priority (highest first).
     * Includes score breakdown for each request.
     *
     * @return list of prioritized requests with scores
     */
    @Transactional(readOnly = true)
    public List<PrioritizedRequestDTO> findAllPrioritized() {
        List<Request> requests = requestRepository.findAll();
        List<Request> sorted = priorityEngine.sortByPriority(requests);

        return sorted.stream()
                .map(request -> PrioritizedRequestDTO.fromEntity(
                        request,
                        priorityEngine.calculateTotalScore(request),
                        priorityEngine.getScoreBreakdown(request)))
                .toList();
    }

}
