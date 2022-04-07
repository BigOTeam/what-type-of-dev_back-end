package com.bigo.whattypeofdev.domain.statistics.repository;

import com.bigo.whattypeofdev.global.entity.StatisticGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatisticGroupRepository extends JpaRepository<StatisticGroup,Long> {
}
