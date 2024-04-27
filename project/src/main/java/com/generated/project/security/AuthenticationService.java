package com.generated.project.security;

import com.generated.project.entity.Role;
import com.generated.project.entity.Utilisateur;
import com.generated.project.repository.AuthenticationResponeRepository;
import com.generated.project.repository.UtilisateurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UtilisateurRepository utilisateurRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final AuthenticationResponeRepository authenticationResponeRepository;

    public AuthenticationResponse register(RegisterRequest request) {
        int sequence = utilisateurRepository.getNextval();
        var user = Utilisateur.builder()
                .id(utilisateurRepository.getSequence(5,"USR",sequence))
                .nom(request.getNom())
                .prenom(request.getPrenom())
                .datenaissance(request.getDate_naissance())
                .email(request.getEmail())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        utilisateurRepository.save(user);
        var jwt = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwt)
                .user(user)
                .expiration(jwtService.dateExpiration(jwt))
                .build();
        authenticationResponse.deleteExpiredToken(authenticationResponeRepository);
        authenticationResponeRepository.save(authenticationResponse);
        return authenticationResponse;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));
        var user = utilisateurRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwt = jwtService.generateToken(user);
        AuthenticationResponse authenticationResponse = AuthenticationResponse.builder()
                .token(jwt)
                .user(user)
                .expiration(jwtService.dateExpiration(jwt))
                .build();
        authenticationResponse.deleteExpiredToken(authenticationResponeRepository);
        authenticationResponeRepository.save(authenticationResponse);
        return authenticationResponse;
    }

    public void logOut(String iduser) {
        authenticationResponeRepository.deleteToken(iduser);
    }
}
