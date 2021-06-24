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
    public TgUserTable findByUserName(String userName) {
        return tgUserTableRepository.findByUserName(userName);
    }

    @Transactional
    public Optional<TgUserTable> findByFirstName(String firstName) {
        return tgUserTableRepository.findByFirstName(firstName); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public Optional<TgUserTable> findByLastName(String lastName) {
        return tgUserTableRepository.findByLastName(lastName); // не знаю почему ругается на Optional.ofNullable????
    }

    @Transactional
    public TgUserTable findByEmail(String email) {
        return tgUserTableRepository.findByEmail(email);
    }

    @Transactional
    public void deleteById(Long id) {
        tgUserTableRepository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        tgUserTableRepository.deleteAll();
    }

    @Transactional
    public Long countAll() {
        return tgUserTableRepository.count();
    }

}
