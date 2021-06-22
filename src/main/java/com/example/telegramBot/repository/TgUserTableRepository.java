package com.example.telegramBot.repository;

import com.example.telegramBot.bean.TgUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgUserTableRepository extends JpaRepository<TgUserTable, Long> {
}
