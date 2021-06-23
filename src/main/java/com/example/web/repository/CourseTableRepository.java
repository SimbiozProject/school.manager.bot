package com.example.web.repository;

import com.example.web.bean.CourseTable;
import com.example.web.bean.CrmUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTableRepository extends JpaRepository<CourseTable, Long> {
}
