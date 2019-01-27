package com.csayl.clblog.service;

import com.csayl.clblog.model.bo.LogBo;
import com.csayl.clblog.model.domain.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: chen
 * @date: 2019/1/23
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class LogServiceTest {
    @Autowired
    private LogService logService;

    @Test
    public void testInsert() {
        Log log = new Log("123", "123", new Date());
        logService.insertLog(new LogBo(log));
    }


    @Test
    public void testDelete() {
    }


}
