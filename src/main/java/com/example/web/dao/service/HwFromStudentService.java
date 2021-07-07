package com.example.web.dao.service;

import com.example.web.bean.HwFromStudentTable;
import com.example.web.dao.repository.HwFromStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HwFromStudentService {

    @Autowired
    HwFromStudentRepository hwFromStudentRepository;

    public List<HwFromStudentTable> findAll() {
        return hwFromStudentRepository.findAll();
    }
}


