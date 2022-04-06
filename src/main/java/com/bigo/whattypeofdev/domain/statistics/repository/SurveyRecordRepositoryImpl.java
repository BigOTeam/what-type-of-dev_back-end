package com.bigo.whattypeofdev.domain.statistics.repository;

import lombok.RequiredArgsConstructor;
import javax.persistence.EntityManager;
import java.util.List;


@RequiredArgsConstructor
public class SurveyRecordRepositoryImpl implements SurveyRecordCustumRepository{

    private final EntityManager em;


    @Override
    public List<Integer> findAllTopcountByColumn(String column) {
        List<Integer> count = em.createNativeQuery("" +
                "select ifnull(q.count,0) from \n" +
                "   (select "+column+" as answer_seq, count("+column+") as count from tb_survey_record\n" +
                "   where not "+column+" is null \n" +
                "   group by "+column+"\n" +
                "   order by count("+column+") desc\n" +
                "   ) q \n" +
                "right outer join \n" +
                "   (SELECT * FROM tb_answer\n" +
                "   where answer_id in\n" +
                "       (SELECT answer_id FROM tb_question_answer\n" +
                "           where question_id = \n" +
                "           (SELECT question_id FROM tb_question\n" +
                "               where question_initial=:column \n" +
                "           )\n" +
                "       )\n" +
                "   ) as a \n" +
                "on q.answer_seq= a.answer_seq \n" +
                "order by q.count desc")
                .setParameter("column",column)
                .getResultList();
        return count;
    }



    @Override
    public List<String> findAllTopByColumn(String column) {
        List<String> answer = em.createNativeQuery("" +
                "select a.answer from \n" +
                "   (select "+column+" as answer_seq, count("+column+") as count from tb_survey_record\n" +
                "   where not "+column+" is null\n" +
                "   group by "+column+"\n" +
                "   order by count("+column+") desc\n" +
                "   ) q \n" +
                "right outer join \n" +
                "   (SELECT * FROM tb_answer\n" +
                "   where answer_id in\n" +
                "       (SELECT answer_id FROM tb_question_answer\n" +
                "           where question_id = \n" +
                "           (SELECT question_id FROM tb_question\n" +
                "               where question_initial=:column \n" +
                "           )\n" +
                "       )\n" +
                "   ) as a \n" +
                "on q.answer_seq= a.answer_seq \n" +
                "order by q.count desc")
                .setParameter("column",column)
                .getResultList();
        return answer;
    }

    @Override
    public String findTopByColumn(String column) {
        String answer = em.createNativeQuery("" +
                "select a.answer from \n" +
                "   (select "+column+" as answer_seq, count("+column+") as count from tb_survey_record\n" +
                "   where not "+column+" is null\n" +
                "   group by "+column+"\n" +
                "   order by count("+column+") desc\n" +
                "   limit 1) q \n" +
                "join \n" +
                "   (SELECT * FROM tb_answer\n" +
                "   where answer_id in\n" +
                "       (SELECT answer_id FROM tb_question_answer\n" +
                "           where question_id = \n" +
                "           (SELECT question_id FROM tb_question\n" +
                "               where question_initial=:column \n" +
                "           )\n" +
                "       )\n" +
                "   ) as a \n" +
                "on q.answer_seq= a.answer_seq \n" +
                "order by q.count desc")
                .setParameter("column",column)
                .getSingleResult().toString();
        return answer;
    }

    @Override
    public int countByColumn(String column) {
        String answer = em.createNativeQuery(
                "select count(*) from tb_survey_record ")
                .getSingleResult().toString();
        return Integer.parseInt(answer);
    }

    @Override
    public List<Integer> findAllTopcountByColumnWithFilter(String column, int gender, int age) {
        List<Integer> answer;
        String query = "select ifnull(q.count,0) from \n" +
                "   (select "+column+" as answer_seq, count("+column+") as count from tb_survey_record\n" +
                "   where not "+column+" is null";
        if(gender!=-1){
            query+=" and aboutme_gender="+gender;
        }
        if(age!=-1){
            query+=" and aboutme_age="+age;
        }
        query+="    group by " + column + "\n" +
                "   order by count(" + column + ") desc\n" +
                "   ) q \n" +
                "right outer join \n" +
                "   (SELECT * FROM tb_answer\n" +
                "   where answer_id in\n" +
                "       (SELECT answer_id FROM tb_question_answer\n" +
                "           where question_id = \n" +
                "           (SELECT question_id FROM tb_question\n" +
                "               where question_initial=:column \n" +
                "           )\n" +
                "       )\n" +
                "   ) as a \n" +
                "on q.answer_seq= a.answer_seq \n" +
                "order by q.count desc";
        answer = em.createNativeQuery(query)
                .setParameter("column",column)
                .getResultList();
//        if(gender==-1){
//             answer = em.createNativeQuery("" +
//                    "select ifnull(q.count,0) from \n" +
//                    "   (select "+column+" as answer_seq, count("+column+") as count from tb_survey_record\n" +
//                    "   where not "+column+" is null and aboutme_age=:age" +
//                    "   group by "+column+"\n" +
//                    "   order by count("+column+") desc\n" +
//                    "   ) q \n" +
//                    "right outer join \n" +
//                    "   (SELECT * FROM tb_answer\n" +
//                    "   where answer_id in\n" +
//                    "       (SELECT answer_id FROM tb_question_answer\n" +
//                    "           where question_id = \n" +
//                    "           (SELECT question_id FROM tb_question\n" +
//                    "               where question_initial=:column \n" +
//                    "           )\n" +
//                    "       )\n" +
//                    "   ) as a \n" +
//                    "on q.answer_seq= a.answer_seq \n" +
//                    "order by q.count desc")
//                    .setParameter("column",column)
//                    .setParameter("age",age)
//                    .getResultList();
//        }
//        else {
//            answer = em.createNativeQuery("" +
//                    "select ifnull(q.count,0) from \n" +
//                    "   (select " + column + " as answer_seq, count(" + column + ") as count from tb_survey_record\n" +
//                    "   where not " + column + " is null and aboutme_age=:age and aboutme_gender =:gender" +
//                    "   group by " + column + "\n" +
//                    "   order by count(" + column + ") desc\n" +
//                    "   ) q \n" +
//                    "right outer join \n" +
//                    "   (SELECT * FROM tb_answer\n" +
//                    "   where answer_id in\n" +
//                    "       (SELECT answer_id FROM tb_question_answer\n" +
//                    "           where question_id = \n" +
//                    "           (SELECT question_id FROM tb_question\n" +
//                    "               where question_initial=:column \n" +
//                    "           )\n" +
//                    "       )\n" +
//                    "   ) as a \n" +
//                    "on q.answer_seq= a.answer_seq \n" +
//                    "order by q.count desc")
//                    .setParameter("column", column)
//                    .setParameter("gender", gender)
//                    .setParameter("age", age)
//                    .getResultList();
//        }
        return answer;
    }

    @Override
    public List<String> findAllTopByColumnWithFilter(String column, int gender, int age) {
        List<String> answer;
        String query = "select a.answer from \n" +
                "   (select " + column + " as answer_seq, count(" + column + ") as count from tb_survey_record\n" +
                "   where not " + column + " is null";
        if(gender!=-1){
            query+=" and aboutme_gender="+gender;
        }
        if(age !=-1){
            query+=" and aboutme_age="+age;
        }
        query+="   group by " + column + "\n" +
                "   order by count(" + column + ") desc\n" +
                "   ) q \n" +
                "right outer join \n" +
                "   (SELECT * FROM tb_answer\n" +
                "   where answer_id in\n" +
                "       (SELECT answer_id FROM tb_question_answer\n" +
                "           where question_id = \n" +
                "           (SELECT question_id FROM tb_question\n" +
                "               where question_initial=:column \n" +
                "           )\n" +
                "       )\n" +
                "   ) as a \n" +
                "on q.answer_seq= a.answer_seq \n" +
                "order by q.count desc";
        answer = em.createNativeQuery(query)
                .setParameter("column",column)
                .getResultList();
        return answer;
    }
}
