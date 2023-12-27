package com.immoc.mall.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.immoc.mall.MallApplicationTests;
import com.immoc.mall.pojo.Category;
import com.immoc.mall.vo.CategoryIdVo;
import com.immoc.mall.vo.CategoryVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class CategoryMapperTest extends MallApplicationTests {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
        Category category = categoryMapper.findById(100001);
        System.out.println(category);
    }

    @Test
    void test01() {
        Category category = categoryMapper.queryById(100001);
        System.out.println(category);
    }

    @Test
    void findById() {
    }

    @Test
    void queryById() {
    }

    @Test
    void queryAllCategory() throws JsonProcessingException {
        List<CategoryVo> categories = categoryMapper.queryAllCategory(0);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(categories);
        System.out.println(s);
    }

    @Test
    void queryAllCategoryId() throws JsonProcessingException {
        List<CategoryIdVo> list = categoryMapper.queryAllCategoryId(100001);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(list);
        System.out.println(s);
    }
}