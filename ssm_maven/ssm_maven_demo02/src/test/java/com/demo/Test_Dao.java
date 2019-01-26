package com.demo;

import com.demo.dao.ItemsMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class Test_Dao {
    @Autowired
    private ItemsMapper itemsMapper;
    @Test
    public void testDao(){
        System.out.println(itemsMapper.findById(1));
    }

}
