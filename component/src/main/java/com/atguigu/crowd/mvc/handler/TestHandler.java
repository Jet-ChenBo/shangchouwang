package com.atguigu.crowd.mvc.handler;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.ParamData;
import com.atguigu.crowd.entity.Student;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.util.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestHandler {

    @Autowired
    private AdminService adminService;

    private Logger logger = LoggerFactory.getLogger(TestHandler.class);

    @RequestMapping("/test/ssm.html")
    public String testSsm(ModelMap modelMap) {
        List<Admin> adminList = adminService.getAll();
        modelMap.addAttribute("adminList", adminList);
        return "target";
    }

    @ResponseBody
    @RequestMapping("send/array/one.html")
    public String testReceiveArrayOne(@RequestParam("array[]") List<Integer> array) {
        for (int i :
                array) {
            System.out.println("number=" + i);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("send/array/two.html")
    public String testReceiveArrayTwo(ParamData paramData) {
        List<Integer> array = paramData.getArray();
        for (int i :
                array) {
            System.out.println("number2=" + i);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("send/array/three.html")
    public String testReceiveArrayThree(@RequestBody List<Integer> array) {
        for (int i :
                array) {
            System.out.println("number3=" + i);
        }
        return "success";
    }

    @ResponseBody
    @RequestMapping("send/compose/object.json")
    public ResultEntity<Student> testReceiveComposeObject(@RequestBody Student student) {
        logger.info(student.toString());
        return ResultEntity.successWithData(student);
    }
}
