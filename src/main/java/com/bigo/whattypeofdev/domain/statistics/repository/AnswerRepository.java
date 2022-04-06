package com.bigo.whattypeofdev.domain.statistics.repository;

import com.bigo.whattypeofdev.global.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer,Long> {
    Answer findByAnswer(String answer);
}
