package com.demo.service.impl;

import com.demo.dao.ItemsMapper;
import com.demo.pojo.Items;
import com.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemsMapper itemsMapper;

    @Override
    public Items findById(int id) {
        return itemsMapper.findById(id);
    }
}
