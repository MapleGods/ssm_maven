package com.demo.dao;

import com.demo.pojo.Items;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsMapper {
    @Select("select * from items where id = #{id}")
    Items findById(int id);
}
