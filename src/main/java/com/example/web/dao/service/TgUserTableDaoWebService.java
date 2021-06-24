package com.example.web.dao.service;

import com.example.web.bean.TgUserTable;
import com.example.web.dao.repository.TgUserTableDaoWebRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TgUserTableDaoWebService {

    @Autowired
    private TgUserTableDaoWebRepository tgUserTableDaoWebRepository;

    @Transactional
    public Iterable<TgUserTable> findAll() {
        return tgUserTableDaoWebRepository.findAll();
    }

    @Transactional
    public Optional<TgUserTable> findById(Long id) {
        return tgUserTableDaoWebRepository.findById(id); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public TgUserTable findByUserName(String userName) {
        return tgUserTableDaoWebRepository.findByUserName(userName);
    }

    @Transactional
    public Optional<TgUserTable> findByFirstName(String firstName) {
        return tgUserTableDaoWebRepository.findByFirstName(firstName); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public Optional<TgUserTable> findByLastName(String lastName) {
        return tgUserTableDaoWebRepository.findByLastName(lastName); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public TgUserTable findByEmail(String email) {
        return tgUserTableDaoWebRepository.findByEmail(email);
    }

    @Transactional
    public void deleteById(Long id) {
        tgUserTableDaoWebRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        tgUserTableDaoWebRepository.deleteAll();
    }

    @Transactional
    public Long countAll() {
        return tgUserTableDaoWebRepository.count();
    }

}
