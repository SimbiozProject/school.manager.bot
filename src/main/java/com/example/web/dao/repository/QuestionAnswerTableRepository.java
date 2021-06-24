package com.example.web.dao.repository;


import com.example.web.bean.QuestionAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerTableRepository extends JpaRepository<QuestionAnswerTable, Long> {

    @Query(value = "SELECT * FROM question_answer", nativeQuery = true)
    List<QuestionAnswerTable> selectAll();
}
