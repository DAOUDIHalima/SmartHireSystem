package org.shp.user_service.controllers;

import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.shp.user_service.dtos.CandidateDto;
import org.shp.user_service.dtos.UserDto;
import org.shp.user_service.models.Candidate;
import org.shp.user_service.models.User;
import org.shp.user_service.payloads.LoginRequest;
import org.shp.user_service.payloads.SignupRequest;
import org.shp.user_service.repositories.CandidateRepository;
import org.shp.user_service.repositories.UserRepository;
import org.shp.user_service.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private AuthService authService;
    @Autowired
    private UserRepository userRepository;
    private CandidateRepository candidateRepository;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signUpRequest) {
        return authService.registerUser(signUpRequest);
    }
   /* @GetMapping("/candidates")
    public List<CandidateDto> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();
        List<CandidateDto> candidateDtos = new ArrayList<>();

        for (Candidate candidate : candidates) {
            // Mapping Candidate to CandidateDto
            CandidateDto candidateDto = modelMapper.map(candidate, CandidateDto.class);
            candidateDtos.add(candidateDto);
        }

        return candidateDtos;
    }*/

}
