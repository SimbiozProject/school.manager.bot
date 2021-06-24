package com.example.web.dao.repository;


import com.example.web.bean.TgUserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TgUserTableDaoWebRepository extends JpaRepository<TgUserTable, Long> {

    TgUserTable findByUserName(String userName);

    Optional<TgUserTable> findByFirstName(String userName);

    Optional<TgUserTable> findByLastName(String userName);

    TgUserTable findByEmail(String email);



}
