package com.proteccion.requests.repository;

import com.proteccion.requests.domain.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRequestRepository extends JpaRepository<Request, Long> {
}
