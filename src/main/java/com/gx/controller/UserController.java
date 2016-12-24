package com.gx.controller;

import com.gx.model.User;
import com.gx.service.UserService;
import com.gx.until.DateUtil;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.List;

/**
 * Created by gx on 2016/12/22.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    private static Logger log = Logger.getLogger(UserController.class);
    @Resource
    UserService userService;


    /**
     * 跳转到用户登录界面
     * @return
     */
    @RequestMapping(value = "/login")
    public String Login() {
        return  "login";
    }

    /**
     * 验证表单数据
     * @return
     */
    @RequestMapping(value = "/info")
    public String findUse(String userName , String passWord,String isLogin ,ModelMap map, HttpServletRequest req, HttpServletResponse rsp) {
        //如果有isLogin 就是直接过来的
        if (isLogin==null){
            Cookie []cookies = req.getCookies();
            for (Cookie ck: cookies){
                if ("userToken".equals(ck.getName())){
                    String uid = ck.getValue().split(":")[0];
                    User user = userService.findUseById(uid);
                    map.put("User",user);
                    return "user";
                }
            }
            return  "error";
        }else {  //判断登录数据是否有效
            User user =userService.findUse(userName,passWord);
            if (user==null){
                map.put("msg","用户名密码错误");
                return "login";
            }
            map.put("User",user);
            String token = user.getUserId()+":"+ DateUtil.getTimeLong();
            Cookie userToken = new Cookie("userToken",token);
            userToken.setMaxAge(1200);
            userToken.setPath("/");
            rsp.addCookie(userToken);
            return  "user";
        }
    }

}
