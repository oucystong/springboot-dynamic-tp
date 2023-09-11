package com.example.springbootdynamictp.controller;

import lombok.extern.slf4j.Slf4j;
import org.dromara.dynamictp.core.thread.DtpExecutor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: Mr.Tong
 */
@RestController
@Slf4j
public class NacosDtpsController {

    @Resource
    @Qualifier(value = "DtpTest1")
    private DtpExecutor dtpExecutor1;


    @Resource
    @Qualifier(value = "DtpTest2")
    private DtpExecutor dtpExecutor2;

    @GetMapping("nacosdtp1")
    public String nacosDtp1Test() {
        String threadPoolAliasName = dtpExecutor1.getThreadPoolAliasName();
        return "dtp1 alias name:" + threadPoolAliasName;
    }

    @GetMapping("nacosdtp2")
    public String nacosDtp2Test() {
        String threadPoolAliasName = dtpExecutor2.getThreadPoolAliasName();
        return "dtp2 alias name:" + threadPoolAliasName;
    }

}
