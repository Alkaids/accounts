package com.gravel.service;

import com.gravel.bean.acctItem;
import com.gravel.bean.moneyinfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by leebr on 2017/8/9.
 */
@Mapper
public interface acctItemMapper {
    @Insert("INSERT INTO acctitem(acctMoney, type,dealDate,userId,userName,acctDesc) VALUES(#{acctMoney}, #{type}, #{dealDate}, #{userId}, #{userName}, #{desc})")
    int insert(@Param("acctMoney") double acctMoney, @Param("type") String type, @Param("dealDate") String dealDate, @Param("userId") int userId, @Param("userName") String userName, @Param("desc") String desc);

    @Select("SELECT * FROM acctitem order by id desc")
    List<acctItem> getAcctItemList();

    @Select("SELECT * FROM moneyinfo ")
    moneyinfo getMoneyinfo();

    @Update("UPDATE moneyinfo SET count = #{count},balance = #{balance} WHERE ID = 1")
    int updateMoneyInfo(@Param("count") double count, @Param("balance") double balance);
}
