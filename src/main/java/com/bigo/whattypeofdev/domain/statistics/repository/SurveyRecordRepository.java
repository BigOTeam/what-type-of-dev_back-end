package com.bigo.whattypeofdev.domain.statistics.repository;

import com.bigo.whattypeofdev.global.entity.SurveyRecord;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SurveyRecordRepository extends JpaRepository<SurveyRecord,Long> {

    int countByAboutmeDev(int answer_seq);

    @Query(nativeQuery = true,
            value = "SELECT count(:column) FROM tb_survey_record\n" +
                    "GROUP BY :column \n" +
                    "Order by count(:column) desc\n" +
                    "limit 3"
    )
    public List<Integer> findTop3countByColumn(@Param("column") String column);

    @Query(nativeQuery = true,
            value = "select a.answer from \n" +
                    "    (select :column as answer_seq, count(:column) as count from tb_survey_record\n" +
                    "    group by :column\n" +
                    "    order by count(:column) desc\n" +
                    "    limit 3) q\n" +
                    "join \n" +
                    "    (SELECT * FROM tb_answer\n" +
                    "    where answer_id in\n" +
                    "        (SELECT answer_id FROM tb_question_answer\n" +
                    "            where question_id = \n" +
                    "            (SELECT question_id FROM tb_question\n" +
                    "                where question_initial=:column\n" +
                    "            )\n" +
                    "        )\n" +
                    "    ) as a\n" +
                    "on q.answer_seq= a.answer_seq"
    )
    public List<String> findTop3ByColumn(@Param("column") String column);
}
