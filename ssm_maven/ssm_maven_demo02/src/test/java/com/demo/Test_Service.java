package com.demo;

import com.demo.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test_Service {
    @Autowired
    private ItemService itemService;
    @Test
    public void testService(){
        System.out.println(itemService.findById(1));
    }
}
