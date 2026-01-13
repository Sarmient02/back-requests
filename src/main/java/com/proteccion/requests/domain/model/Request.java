package com.proteccion.requests.domain.model;

import com.proteccion.requests.domain.enums.RequestType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "REQUESTS")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private RequestType type;

    @Column(name = "MANUAL_PRIORITY", nullable = false)
    private Integer manualPriority;

    @CreationTimestamp
    @Column(name = "CREATED_AT", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

}
