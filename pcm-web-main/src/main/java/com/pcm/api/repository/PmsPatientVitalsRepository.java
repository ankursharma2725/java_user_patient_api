package com.pcm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.api.entity.PmsPatientVitals;

public interface PmsPatientVitalsRepository extends JpaRepository<PmsPatientVitals, Long> {
//    PmsPatientVitals findPatientById(long id);
}
