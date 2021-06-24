package com.example.web.dao.repository;

import com.example.web.bean.CrmUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmUserTableRepository extends JpaRepository<CrmUserTable, Long> {
}
