package com.gravel.controller;

import com.gravel.bean.acctItem;
import com.gravel.bean.moneyinfo;
import com.gravel.service.mainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by leebr on 2017/8/9.
 */
@RestController
@RequestMapping(value = "/accounts")
public class mainController {
    @Autowired
    private mainService mainService;

    @RequestMapping(value = "/saveItem", method = RequestMethod.POST)
    public String saveAcctItem(@RequestBody acctItem acctItem) {
        // 处理"/saveItem"的GET请求，用来获取用户列表
        return mainService.insertAcctItem(acctItem);
    }

    @RequestMapping(value = "/getItemList", method = RequestMethod.GET)
    public List<acctItem> getAcctItemLsit() {
        // 处理"/getItemList"的GET请求，用来获取用户列表
        return mainService.getAcctItemLsit();
    }

    @RequestMapping(value = "/getMoneyInfo", method = RequestMethod.GET)
    public moneyinfo getMoneyInfo() {
        // 处理"/getItemList"的GET请求，用来获取用户列表
        return mainService.getMoneyInfo();
    }
}
