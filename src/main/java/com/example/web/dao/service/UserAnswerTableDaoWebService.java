package com.example.web.dao.service;

import com.example.web.bean.UserAnswerTable;
import com.example.web.dao.repository.UserAnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserAnswerTableDaoWebService {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    public Iterable<UserAnswerTable> findAll() {
        return userAnswerRepository.findAll();
    }

    public UserAnswerTable findByUserName(String userName) {
        return userAnswerRepository.findByUserName(userName);
    }

    public Optional<UserAnswerTable> findById(Long id) {
        return userAnswerRepository.findById(id);
    }
}
