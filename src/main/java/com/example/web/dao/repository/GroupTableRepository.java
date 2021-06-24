package com.example.web.dao.repository;

import com.example.web.bean.GroupTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupTableRepository extends JpaRepository<GroupTable, Long> {
}
