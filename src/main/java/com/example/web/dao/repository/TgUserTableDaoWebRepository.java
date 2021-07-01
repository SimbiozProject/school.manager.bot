package com.example.web.dao.repository;


import com.example.web.bean.CourseTable;
import com.example.web.bean.GroupTable;
import com.example.web.bean.TgUserTable;
import com.example.web.bean.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TgUserTableDaoWebRepository extends JpaRepository<TgUserTable, Long> {

    TgUserTable findByUserName(String userName);

    Optional<TgUserTable> findByFirstName(String userName);

    Optional<TgUserTable> findByLastName(String userName);

    TgUserTable findByEmail(String email);


//    @Query(value = "SELECT user_name, block_user, email, active, payment FROM tg_user WHERE block_user=true", nativeQuery = true)
    List<TgUserTable> findTgUserTableByBlockUserIsTrue();

    @Transactional
    @Modifying
//    @Query(value = "DELETE FROM tg_user WHERE id_user = ?1", nativeQuery = true)
    void deleteTgUserTableById(Long id);

    TgUserTable findTgUserTableById(Long id);

    @Transactional
    @Modifying
    @Query(value = "UPDATE  tg_user " +
            "SET block_user = ?2 WHERE id_user = ?1 ", nativeQuery = true)
    void updateBlockUserStatus(Long id, Boolean blockUser);

    List<TgUserTable> findAll();

    @Transactional
    @Modifying
    @Query(value = "UPDATE  tg_user " +
            "SET user_name = ?2, first_name = ?3, last_name = ?4, email = ?5, " +
            "date_of_birthday = ?6, active = ?7, block_user = ?8, payment = ?9, tg_user.role = ?10, " +
            "course_name = ?11, group_number = ?12  WHERE id_user = ?1 ", nativeQuery = true)
    void updateUsersData(Long id, String userName, String firstName, String lastName, String email,
                         Date dateOfBirthday, Boolean active, Boolean blockUser, Boolean payment,
                         UserRoles roles, CourseTable courseUser, GroupTable groupUser);

}
/*

 */