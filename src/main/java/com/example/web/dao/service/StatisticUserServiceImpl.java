package com.example.web.dao.service;

import com.example.web.bean.StatisticUser;
import com.example.web.dao.repository.StatisticUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatisticUserServiceImpl implements StatisticUserService{

    private final StatisticUserRepository statisticUserRepository;

    @Autowired
    public StatisticUserServiceImpl(StatisticUserRepository statisticUserRepository) {
        this.statisticUserRepository = statisticUserRepository;
    }


    @Override
    public void save(StatisticUser statisticUser) {
        statisticUserRepository.save(statisticUser);
    }

    @Override
    public List<StatisticUser> retrieveAllActiveUsers() {
        return statisticUserRepository.findAllByActiveTrue();
    }

    @Override
    public Optional<StatisticUser> findByChatId(Long chatId) {
        return statisticUserRepository.findById(chatId);
    }
}
