package com.example.web.dao.service;

import com.example.web.bean.QuestionAnswerTable;
import com.example.web.dao.repository.QuestionAnswerTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionAnswerTableDaoWebService {

    @Autowired
    QuestionAnswerTableRepository questionAnswerTableRepository;

    public List<QuestionAnswerTable> findAll(){
        return questionAnswerTableRepository.selectAll();
    };

    public void addToDb(QuestionAnswerTable newQuestion) {
        questionAnswerTableRepository.save(newQuestion);
    }
}
