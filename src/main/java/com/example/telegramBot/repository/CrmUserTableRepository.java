package com.example.telegramBot.repository;

import com.example.telegramBot.bean.CrmUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmUserTableRepository extends JpaRepository<CrmUserTable, Long> {
}
