package org.zerock.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.FinishedGoodsVO;
import org.zerock.service.finishedgoods.FinishedGoodsService;

import java.util.List;

@Controller
@RequestMapping("/main")
@AllArgsConstructor
public class mainController {
    private FinishedGoodsService service;

    @GetMapping
    public String index() {
        return "/admin/index";
    }

    @GetMapping("/test")
    public String test(Model model) {
        List<FinishedGoodsVO> goodslist =service.insertGoods();
        model.addAttribute("goodslist",goodslist);
        return "/admin/test";
    }
}
