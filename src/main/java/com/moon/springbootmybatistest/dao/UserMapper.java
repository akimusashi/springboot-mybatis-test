package com.moon.springbootmybatistest.dao;

import com.moon.springbootmybatistest.entity.UserEntity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("SELECT * FROM t_user WHERE id = #{id}")
    UserEntity findUserById(@Param("id") Integer id);

    @Select("SELECT * FROM t_user ORDER BY age ASC")
    List<UserEntity> findAllUserWithAgeOrder();

    @Insert("INSERT INTO t_user (name, sex, age) VALUES (#{name}, #{sex}, #{age})")
    Integer addUser(UserEntity userEntity);

    @Update("UPDATE t_user SET name = #{name}, sex = #{sex}, age = #{age} WHERE id = #{id}")
    void updateUser(UserEntity userEntity);

    @Delete("DELETE FROM t_user WHERE id = #{id}")
    void deleteUser(Integer id);
}
