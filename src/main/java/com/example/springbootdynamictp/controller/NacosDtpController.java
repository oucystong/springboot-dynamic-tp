package com.example.springbootdynamictp.controller;

import lombok.extern.slf4j.Slf4j;
import org.dromara.dynamictp.core.DtpRegistry;
import org.dromara.dynamictp.core.thread.DtpExecutor;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NacosDtpController {
    @Resource
    @Qualifier(value = "DtpTest1")
    private DtpExecutor dtpExecutor;

    @GetMapping("nacosdtp")
    public String nacosDtpTest() {
        String threadPoolAliasName = dtpExecutor.getThreadPoolAliasName();
        return "dtp alias name:" + threadPoolAliasName;
    }

}
