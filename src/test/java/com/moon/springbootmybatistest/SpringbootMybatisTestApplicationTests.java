package com.moon.springbootmybatistest;

import com.moon.springbootmybatistest.dao.UserMapper;
import com.moon.springbootmybatistest.entity.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisTestApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void contextLoads() {
        UserEntity userEntity = new UserEntity("甄姬", "女", 18);
        Integer row = userMapper.addUser(userEntity);
        System.out.println(row);
        System.out.println(userMapper.findUserById(1));
        List<UserEntity> userEntities = userMapper.findAllUserWithAgeOrder();
        System.out.println(userEntities);
        userEntity = new UserEntity(3, "孙尚香", "女", 12);
        userMapper.updateUser(userEntity);
        userEntities = userMapper.findAllUserWithAgeOrder();
        System.out.println(userEntities);
        userMapper.deleteUser(2);
        userEntities = userMapper.findAllUserWithAgeOrder();
        System.out.println(userEntities);
    }

}
