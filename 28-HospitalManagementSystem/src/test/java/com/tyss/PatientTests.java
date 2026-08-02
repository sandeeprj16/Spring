package com.tyss;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tyss.entity.Patient;
import com.tyss.entity.type.BloodGroupType;
import com.tyss.repository.PatientRepository;
import com.tyss.service.PatientService;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAll();

        patientList.forEach(System.out::println);

        Patient patient = new Patient();

        patient.setName("Sandeep");
        patient.setEmail("sandeep@gmail.com");
        patient.setGender("Male");
        patient.setBirthDate(LocalDate.of(2002, 5, 10));
        patient.setBloodGroup(BloodGroupType.A_POSITIVE);

        patientRepository.save(patient);
        
        List<Patient> patientList=patientRepository.findByBornAfterDate(LocalDate.of(1993, 4, 24));
    }

    @Test
    public void testTransactionMethods() {

        Patient patient = patientService.getPatientById(1L);

        System.out.println(patient);
    }

}