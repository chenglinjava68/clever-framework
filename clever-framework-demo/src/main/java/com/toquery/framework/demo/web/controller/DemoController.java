package com.toquery.framework.demo.web.controller;

import com.toquery.framework.demo.entity.TbJpaDemo;
import com.toquery.framework.demo.entity.TbMyBatisDemo;
import com.toquery.framework.demo.service.IJpaDemoService;
import com.toquery.framework.demo.service.IMyBatisDemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author toquery
 * @version 1
 */
@RestController
@RequestMapping("/demo")
public class DemoController {

    @Resource
    private IJpaDemoService demoService;

    @Resource
    private IMyBatisDemoService myBatisDemoService;

    @RequestMapping({"/", "/index"})
    public String index() {
        return "OK";
    }


    @RequestMapping("/jpa/get")
    public TbJpaDemo getByName1(@RequestParam("name") String name) {
        return demoService.getByName(name);
    }

    @RequestMapping("/jpa/get/{id}")
    public TbJpaDemo getById(@PathVariable("id") Long id) {
        return demoService.getById(id);
    }


    @RequestMapping("/jpa/update")
    public TbJpaDemo jpaUpdate(@RequestParam Long id, @RequestParam String name) {
        return demoService.update(id, name);
    }


    @RequestMapping("/mybatis/get")
    public TbMyBatisDemo getByName2(@RequestParam String name) {
        return myBatisDemoService.getByName(name);
    }

    @RequestMapping("/mybatis/jpa/get")
    public TbMyBatisDemo getByName3(@RequestParam String name) {
        return myBatisDemoService.getByName3(name);
    }
}