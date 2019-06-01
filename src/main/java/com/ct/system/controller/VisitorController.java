package com.ct.system.controller;

import com.ct.system.bean.Tester;
import com.ct.system.bean.js.Result;
import com.ct.system.service.TesterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chentong1 on 2019/6/1.
 */

@Controller
@EnableAutoConfiguration
@RequestMapping("visitor")
public class VisitorController {
    @Autowired
    private TesterService testerService;

    @PostMapping("create")
    @ResponseBody
    public Result create() {
        return Result.successResult(testerService.create().id);
    }

    @GetMapping("")
    @ResponseBody
    public Result getById(@RequestParam(value = "uid") String uid) {
        Tester tester = testerService.getById(uid);
        if (tester != null) {
            return Result.successResult(tester);
        } else {
            return Result.failResult("no user");
        }
    }
}
