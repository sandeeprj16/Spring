package com.tyss.service;

import org.springframework.stereotype.Service;

import com.tyss.entity.Patient;
import com.tyss.repository.PatientRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {

        Patient p1 = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Patient p2 = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        System.out.println("Same Object : " + (p1 == p2));

        p1.setName("Yoyo");

        // No save() required because of Dirty Checking

        return p1;
    }

}