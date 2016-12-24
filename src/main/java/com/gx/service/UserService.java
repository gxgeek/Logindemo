package com.gx.service;

import com.gx.controller.UserController;
import com.gx.dao.UserMapping;
import com.gx.model.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gx on 2016/12/22.
 */
@Service
public class UserService {
    private static Logger log = Logger.getLogger(UserController.class);

    @Resource
    UserMapping userMapping;

    public List<User> userList() {
        return userMapping.selectUserList();
    }

    /**
     * 查找用户是否存在
     * @param userName
     * @param passWord
     * @return
     */
    public User findUse(String userName, String passWord) {
        try {
            return  userMapping.selectUser(userName,passWord);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    public User findUseById(String uid) {
        return  userMapping.selectUserById(uid);

    }
}
