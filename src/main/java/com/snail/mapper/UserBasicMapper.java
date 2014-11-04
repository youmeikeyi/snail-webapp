package com.snail.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.snail.entity.UserBasic;

import java.util.List;

/**
 * User: jinchao.xu
 * Date: 14-10-15
 * Time: 下午2:55
 */
@Repository(value = "userBasicMapper")
public interface UserBasicMapper {

    @Select("${sql}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "userType", column = "user_type"),
            @Result(property = "headUrl", column = "head_url"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "headUrlFlag", column = "head_url_flag"),
            @Result(property = "guideStep", column = "guide_step"),
            @Result(property = "hot", column = "hot"),
            @Result(property = "declaration", column = "declaration"),
            @Result(property = "validFlag", column = "valid_flag"),
            @Result(property = "namecardInfoType", column = "namecard_info_type"),
            @Result(property = "namecardInfoId", column = "namecard_info_id")
    })
    public List<UserBasic> findUsersByTest(@Param(value = "sql") String sql);

    @Select("${sql}")
    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name")
    })
    public String getUserNameById(@Param(value = "sql") String sql);
}
