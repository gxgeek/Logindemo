package com.gx.controller;

import com.gx.model.User;
import com.gx.service.UserService;
import com.gx.until.DateUtil;
import org.apache.http.HttpRequest;
import org.apache.ibatis.annotations.Param;
import org.apache.log4j.Logger;
import org.springframework.orm.hibernate5.SpringJtaSessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String login() {
        return  "login";
    }

    /**
     * 跳转错误页面
     * @return
     */
    @RequestMapping(value = "/error")
    public String error() {
        return  "error";
    }





    /**
     * 验证表单数据
     * @return
     */
    @RequestMapping(value = "/verification")
    public String findUse(String userName , String passWord, String isLogin, HttpServletRequest req, HttpServletResponse rsp, ModelMap map, RedirectAttributes attr, Model model) {
        User user =userService.findUse(userName,passWord);
         if (user==null){
            attr.addAttribute("msg","用户名密码错误");
            return "redirect:/user/login";
        }
        HttpSession session = req.getSession();
        session.setAttribute("user",user);
        map.put("User",session.getAttribute("user"));
        return  "redirect:/user/member/info";
    }

    @RequestMapping(value = "/member/info")
    public String info() {
        return  "user";
    }


}
