package com.gx.dao;

import com.gx.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by gx on 2016/12/22.
 */
public interface UserMapping {
    List<User> selectUserList();

    User selectUser(@Param(value = "userName") String userName, @Param(value = "passWord")String passWord);

    User selectUserById(@Param(value = "uid") String uid);
}
