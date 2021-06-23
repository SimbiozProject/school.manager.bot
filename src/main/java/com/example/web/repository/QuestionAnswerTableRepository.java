package com.example.web.repository;


import com.example.web.bean.QuestionAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionAnswerTableRepository extends JpaRepository<QuestionAnswerTable, Long> {

    @Override
    List<QuestionAnswerTable> findAll();
}
