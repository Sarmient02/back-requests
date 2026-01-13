package com.proteccion.requests.service.interfaces;

import com.proteccion.requests.dto.CreateRequestDTO;
import com.proteccion.requests.dto.PrioritizedRequestDTO;
import com.proteccion.requests.dto.RequestDTO;

import java.util.List;

public interface IRequestService {

    RequestDTO create(CreateRequestDTO dto);

    List<RequestDTO> findAll();

    List<PrioritizedRequestDTO> findAllPrioritized();
}
