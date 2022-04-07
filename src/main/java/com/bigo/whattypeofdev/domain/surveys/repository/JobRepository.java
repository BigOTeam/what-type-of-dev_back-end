package com.bigo.whattypeofdev.domain.surveys.repository;

import com.bigo.whattypeofdev.global.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {
}
