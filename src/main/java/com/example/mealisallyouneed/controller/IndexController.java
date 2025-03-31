package com.example.mealisallyouneed.controller;

import com.example.mealisallyouneed.config.MyBatisConfig;
import com.example.mealisallyouneed.model.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("/")
    public String index(Model model) {
        try (SqlSession session = MyBatisConfig.getSqlSessionFactory().openSession()) {
            TestMapper testMapper = session.getMapper(TestMapper.class);
            int result = testMapper.selectOnePlusOne();
            model.addAttribute("result", result);
        }
        return "index";
    }
}
