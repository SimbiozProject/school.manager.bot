package com.example.web.dao.repository;

import com.example.web.bean.HwFromStudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HwFromStudentRepository extends JpaRepository<HwFromStudentTable, Long> {
}
