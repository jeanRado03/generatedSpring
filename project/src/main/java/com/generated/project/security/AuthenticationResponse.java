package com.generated.project.security;

import com.generated.project.entity.Utilisateur;
import com.generated.project.repository.AuthenticationResponeRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Token")
public class AuthenticationResponse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    @JoinColumn(name = "id_user")
    @OneToOne
    private Utilisateur user;
    private Timestamp expiration;
    
    public void deleteExpiredToken(AuthenticationResponeRepository authenticationResponeRepository) {
        Iterable<AuthenticationResponse> authenticationResponses = authenticationResponeRepository.findAll();
        Timestamp timestampNow = new Timestamp(System.currentTimeMillis());
        for (AuthenticationResponse authenticationResponse : authenticationResponses) {
            if (authenticationResponse.getExpiration().before(timestampNow)) {
                authenticationResponeRepository.delete(authenticationResponse);
            }
        }
    }
}
