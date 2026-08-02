package com.tyss.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.tyss.entity.type.BloodGroupType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "unique_patient_name_birthDate",
                        columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(
                        name = "idx_patient_birth_date",
                        columnList = "birthDate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude
    private LocalDate birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

//    @CreationTimestamp
//    @Column(updatable = false)
//    private LocalDateTime createATime;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
    
}