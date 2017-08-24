package com.gravel.service;

import com.gravel.bean.acctItem;
import com.gravel.bean.moneyinfo;
import com.gravel.dao.acctItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leebr on 2017/8/10.
 */
@Service("mainService")
public class mainService {
    @Autowired
    private acctItemMapper acctItemMapper;

    public String insertAcctItem(acctItem acctItem) {

            acctItemMapper.insert(acctItem.getAcctMoney(), acctItem.getType(), acctItem.getDealDate(), acctItem.getUserId(), acctItem.getUserName(), acctItem.getAcctDesc());
            setMoney(acctItem);
            return "1";

    }

    public List<acctItem> getAcctItemLsit() {
        List<acctItem> acctItems = acctItemMapper.getAcctItemList();
        return acctItems;
    }

    public void setMoney(acctItem acctItem) {
        moneyinfo mi = acctItemMapper.getMoneyinfo();
        double count = mi.getCount();//使用的总金额
        double balance = mi.getBalance();//剩余金额
        String type = acctItem.getType();
        double newCount = 0;//初始为0
        double newBalance = 0;
        if (type.equals("1")) {//支出
            newCount = count + acctItem.getAcctMoney();
            newBalance = balance - acctItem.getAcctMoney();
        } else {//收入
            newCount = count;
            newBalance = balance + acctItem.getAcctMoney();
        }
        acctItemMapper.updateMoneyInfo(newCount, newBalance);
    }

    public moneyinfo getMoneyInfo() {
        moneyinfo mi = acctItemMapper.getMoneyinfo();
        return mi;
    }
}
