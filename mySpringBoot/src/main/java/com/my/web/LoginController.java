package com.my.web;

import com.my.domain.User;
import com.my.repo.UserRepo;
import com.my.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @Resource
    private UserRepo userRepo;


    @RequestMapping(value = {"/", "/index.html"})
    public ModelAndView loginPage(){
        System.out.println("login");
        return new ModelAndView("login");
//        return new ModelAndView("login");
    }


    @RequestMapping("/test")
    public String login(Model model) {

        List<User> all = userRepo.findAll();

//        List<User> list = new ArrayList<>();
//        list.add(new User("张三","111"));
//        list.add(new User("李四","111"));
//        list.add(new User("王五","111"));
//        //需要一个 Model 对象
        model.addAttribute("data", all);
        //跳转视图
        return "userList2";

    }


//    @RequestMapping("/hello")
//    public ModelAndView getListaUtentiView(){
//        ModelMap model = new ModelMap();
//        model.addAttribute("name", "Spring Boot");
//        return new ModelAndView("demo", model);
//    }


    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String helloTheme(Model model){
        model.addAttribute("name", "world");
        return "/hello";
    }

}
