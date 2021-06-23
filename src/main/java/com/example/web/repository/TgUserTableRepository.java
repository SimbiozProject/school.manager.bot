package com.example.web.repository;


import com.example.web.bean.TgUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TgUserTableRepository extends JpaRepository<TgUserTable, Long> {
}
