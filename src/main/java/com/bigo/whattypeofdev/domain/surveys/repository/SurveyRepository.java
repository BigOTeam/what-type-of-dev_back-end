package com.bigo.whattypeofdev.domain.surveys.repository;

import com.bigo.whattypeofdev.global.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SurveyRepository extends JpaRepository<Page,Long>{

}
