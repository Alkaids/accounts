package com.gravel.bean;

import java.util.Date;

/**
 * Created by leebr on 2017/8/9.
 */
public class acctItem {
    private int id;
    private double acctMoney;
    private String type;
    private String dealDate;
    private int userId;
    private String userName;
    private String acctDesc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAcctMoney() {
        return acctMoney;
    }

    public void setAcctMoney(double acctMoney) {
        this.acctMoney = acctMoney;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAcctDesc() {
        return acctDesc;
    }

    public void setAcctDesc(String acctDesc) {
        this.acctDesc = acctDesc;
    }
}
