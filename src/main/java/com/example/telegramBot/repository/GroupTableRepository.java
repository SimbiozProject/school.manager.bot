package com.example.telegramBot.repository;

import com.example.telegramBot.bean.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupTableRepository extends JpaRepository<GroupTable, Long> {
}
