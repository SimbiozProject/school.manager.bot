package com.example.web.dao.repository;

import com.example.web.bean.HwFromStudentTable;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface HwFromStudentRepository extends JpaRepository<HwFromStudentTable, Long> {

    List<HwFromStudentTable> findHwFromStudentTablesByStudentName_FirstNameContains(String userName);

    List<HwFromStudentTable> findHwFromStudentTablesByStudentNameLastNameContains(String userName);

    List<HwFromStudentTable> findHwFromStudentTablesByLessonNumber(Integer lessson);

    @Query(value = "select * from hw_from_students inner join tg_user u where u.last_name like %?1%", nativeQuery = true)
    Optional<HwFromStudentTable> findByLastName(String userName);

    List<HwFromStudentTable> findAll();

    @Query(value = "SELECT * FROM hw_from_students WHERE student_id = ?", nativeQuery = true)
    HwFromStudentTable findHwFromStudentTableByStudentId(Long id);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM hw_from_students WHERE student_id = ?1", nativeQuery = true)
    void deleteById(Long id);

}
