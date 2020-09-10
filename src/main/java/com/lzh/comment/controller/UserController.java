package com.lzh.comment.controller;

import com.lzh.comment.pojo.User;
import com.lzh.comment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/list")
    public List<User> getUserList(){
        List<User> list = userService.list(null);
        return list;
    }
    @GetMapping("/insert")
    public Map insert(@RequestParam(name = "name",defaultValue = "李四") String name){
        HashMap<String, Object> map = new HashMap<>();
        User user = new User();
        user.setName(name);
        userService.save(user);
        map.put("status",200);
        return map;
    }
}
