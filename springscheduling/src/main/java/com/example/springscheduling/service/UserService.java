package com.example.springscheduling.service;

import com.example.springscheduling.entity.UserEntity;
import com.example.springscheduling.repository.UserRepository;
import lombok.Value;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;
@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository userRepository;
/*
    @Value("${corn.expression.value}")
    private String cornExpression;
*/
// schedule a job to add object in DB (Every 5 sec)
    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        UserEntity user = new UserEntity();
        user.setName("user" + new Random().nextInt(374483));
        userRepository.save(user);
        log.info("add service call in " + new Date().toString());
    }

    @Scheduled(cron = "${corn.expression.value}")
    public void fetchDBJob() {
        List<UserEntity> users = userRepository.findAll();
        log.info("fetch service call in " + new Date().toString());
        log.info("no of record fetched : " + users.size());
        log.info("users : {}", users);
    }
}
