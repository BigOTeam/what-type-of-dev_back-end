package com.bigo.whattypeofdev.domain.surveys.repository;

import com.bigo.whattypeofdev.global.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {

}
