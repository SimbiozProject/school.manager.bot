package com.example.web.dao.service;

import com.example.web.bean.HwFromStudentTable;
import com.example.web.dao.repository.HwFromStudentRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

   /* @Transactional
    public Optional<HwFromStudentTable> findByFirstName(String firstName) {
        return hwFromStudentRepository.findByFirstName(firstName);
    }

    @Transactional
    public Optional<HwFromStudentTable> findByLastName(String lastName) {
        return hwFromStudentRepository.findByLastName(lastName);
    }*/

    public void deleteById(Long id) {
        hwFromStudentRepository.deleteById(id);
    }


}


