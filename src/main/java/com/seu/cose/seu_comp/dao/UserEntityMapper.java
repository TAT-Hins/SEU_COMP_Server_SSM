package com.seu.cose.seu_comp.dao;

import com.seu.cose.seu_comp.entity.UserEntity;
import com.seu.cose.seu_comp.entity.UserEntityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserEntityMapper {
    long countByExample(UserEntityExample example);

    int deleteByExample(UserEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserEntity record);

    int insertSelective(UserEntity record);

    List<UserEntity> selectByExample(UserEntityExample example);

    UserEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByExample(@Param("record") UserEntity record, @Param("example") UserEntityExample example);

    int updateByPrimaryKeySelective(UserEntity record);

    int updateByPrimaryKey(UserEntity record);
}