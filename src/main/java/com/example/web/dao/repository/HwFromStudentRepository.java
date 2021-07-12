package com.example.web.dao.repository;

import com.example.web.bean.HwFromStudentTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface HwFromStudentRepository extends JpaRepository<HwFromStudentTable, Long> {

   // Optional<HwFromStudentTable> findByFirstName(String userName);

   // Optional<HwFromStudentTable> findByLastName(String userName);

    List<HwFromStudentTable> findAll();

    @Query(value = "SELECT * FROM hw_from_students WHERE student_id = ?", nativeQuery = true)
    HwFromStudentTable findHwFromStudentTableByStudentId(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hw_from_students WHERE student_id = ?1", nativeQuery = true)
    void deleteById(Long id);
}
