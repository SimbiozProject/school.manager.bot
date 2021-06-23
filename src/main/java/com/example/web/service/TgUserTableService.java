package com.example.web.service;

import com.example.web.bean.TgUserTable;
import com.example.web.repository.TgUserTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TgUserTableService {

    @Autowired
    private TgUserTableRepository tgUserTableRepository;

    @Transactional
    public Iterable<TgUserTable> findAll() {
        return tgUserTableRepository.findAll();
    }

    @Transactional
    public Optional<TgUserTable> findById(Long id) {
        return tgUserTableRepository.findById(id); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public Optional<TgUserTable> findByUserName(String userName) {
        return tgUserTableRepository.findByUserName(userName); // не знаю почему ругается на Optional.ofNullable????
    }

//    @Transactional
//    public Optional<TgUserTable> findByFirstName(String firstName) {
//        return tgUserTableRepository.findByFirstName(firstName); // не знаю почему ругается на Optional.ofNullable????
//    }
//
//    @Transactional
//    public Optional<TgUserTable> findByLastName(String lastName) {
//        return tgUserTableRepository.findByLastName(lastName); // не знаю почему ругается на Optional.ofNullable????
//    }

    @Transactional
    public Optional<TgUserTable> findByEmail(String email) {
        return tgUserTableRepository.findByEmail(email); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public void deleteByUserName(String userName) {
        tgUserTableRepository.deleteByUserName(userName);
    }


}
