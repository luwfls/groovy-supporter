package com.groovy.supporter.manager;

import com.groovy.supporter.manager.dao.UserDOMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiddleWebApplicationTests {

    @Autowired
    UserDOMapper userDOMapper;
    @Test
    public void contextLoads() {
        System.out.println(userDOMapper.selectByPrimaryKey(1L));
    }

}
