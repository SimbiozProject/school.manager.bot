package com.example.web.dao.repository;

import com.example.web.bean.HwFromStudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HwFromStudentRepository extends JpaRepository<HwFromStudentTable, Long> {

    List<HwFromStudentTable> findAll();
}
