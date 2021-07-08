package com.example.web.dao.service;

import com.example.web.bean.QuestionAnswerTable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
class QuestionAnswerTableDaoWebServiceTest {

    @Autowired
    QuestionAnswerTableDaoWebService service;

    @Test
    @Sql
    void addToDb() {
        service.addToDb(new QuestionAnswerTable());
    }
}