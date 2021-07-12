package com.example.web.dao.service;

import com.example.web.bean.HwFromStudentTable;
import com.example.web.dao.repository.HwFromStudentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HwFromStudentService {

    @Autowired
    HwFromStudentRepository hwFromStudentRepository;

    @Transactional
    public List<HwFromStudentTable> findAll() {
        return Lists.reverse(hwFromStudentRepository.findAll());
    }

    @Transactional
    public HwFromStudentTable findById(Long id) {
        return hwFromStudentRepository.findHwFromStudentTableByStudentId(id);
    }

    @Transactional
    public List<HwFromStudentTable> findByFirstName(String firstName) {
        return hwFromStudentRepository.findHwFromStudentTablesByStudentName_FirstNameContains(firstName);
    }

    @Transactional
    public List<HwFromStudentTable> findByLastName(String lastName) {
        return hwFromStudentRepository.findHwFromStudentTablesByStudentNameLastNameContains(lastName);
    }

    @Transactional
    public List<HwFromStudentTable> findByLesson(Integer lesson) {
        return hwFromStudentRepository.findHwFromStudentTablesByLessonNumber(lesson);
    }

    @Transactional
    public void deleteById(Long id) {
        hwFromStudentRepository.deleteById(id);
    }

}


