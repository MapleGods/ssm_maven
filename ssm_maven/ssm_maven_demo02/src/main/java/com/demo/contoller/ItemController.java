package com.demo.contoller;

import com.demo.dao.ItemsMapper;
import com.demo.pojo.Items;
import com.demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @RequestMapping("/findById")
    public String findById(Model model) {
        Items items = itemService.findById(1);
        model.addAttribute("item",items);
        System.out.println(items);
        return "itemDetail";
    }
}
