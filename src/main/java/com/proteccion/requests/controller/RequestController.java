package com.proteccion.requests.controller;

import com.proteccion.requests.dto.CreateRequestDTO;
import com.proteccion.requests.dto.PrioritizedRequestDTO;
import com.proteccion.requests.dto.RequestDTO;
import com.proteccion.requests.service.interfaces.IRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/requests")
@RequiredArgsConstructor
public class RequestController {

    private final IRequestService requestService;

    /**
     * Create a new request.
     *
     * @param dto the request data
     * @return the created request
     */
    @PostMapping
    public ResponseEntity<RequestDTO> create(@RequestBody CreateRequestDTO dto) {
        RequestDTO created = requestService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    /**
     * Get all requests without prioritization.
     *
     * @return list of all requests
     */
    @GetMapping
    public ResponseEntity<List<RequestDTO>> findAll() {
        return ResponseEntity.ok(requestService.findAll());
    }

    /**
     * Get all requests sorted by calculated priority.
     * Returns requests with their priority scores and breakdown.
     *
     * @return list of prioritized requests
     */
    @GetMapping("/prioritized")
    public ResponseEntity<List<PrioritizedRequestDTO>> findAllPrioritized() {
        return ResponseEntity.ok(requestService.findAllPrioritized());
    }

}
