package com.tyss.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tyss.entity.Patient;
import com.tyss.entity.type.BloodGroupType;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findByName(String name);

    Patient findByBirthDate(LocalDate birthDate);
    
    @Query("select p from Patient p where p.bloodGroup=?1")
    List<Patient>findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);
    
    @Query("select p from Patient p where p.birthDate>:birthDate")
    List<Patient>findByBornAfterDate(@Param("birthDate") LocalDate birthDate);
    
}