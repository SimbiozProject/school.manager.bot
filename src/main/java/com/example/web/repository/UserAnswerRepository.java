package com.example.web.repository;

import com.example.web.bean.UserAnswerTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswerTable, Long> {
}
