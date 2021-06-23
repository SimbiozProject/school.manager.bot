package com.example.telegramBot.repository;

import com.example.telegramBot.bean.HwFromStudentTable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface HwForStudentRepository extends JpaRepository<HwFromStudentTable, Long> {
}
