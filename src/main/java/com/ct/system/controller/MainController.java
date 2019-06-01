package com.ct.system.controller;

import com.ct.system.util.Constants;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by chentong1 on 2019/6/1.
 */

@Controller
@EnableAutoConfiguration
public class MainController {
    @RequestMapping("")
    @ResponseBody
    public String welcome() {
        return "Welcome to Intelligent Electricity System!";
    }

    // 重置状态
    @RequestMapping("re-init")
    @ResponseBody
    public String init(@RequestParam(value = "name") String name, @RequestParam(value = "pwd") String pwd) {
        Constants.ADMIN_NAME = name;
        Constants.ADMIN_PWD = pwd;
        return "ok";
    }
}
