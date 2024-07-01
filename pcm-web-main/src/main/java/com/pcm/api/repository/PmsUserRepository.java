package com.pcm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.api.entity.PmsUser;

public interface PmsUserRepository extends JpaRepository<PmsUser, Long> {

}
