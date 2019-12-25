package com.qf.acgInformation.mapper;

import com.qf.acgInformation.entity.User;
import org.apache.ibatis.annotations.Param;

public interface IRechargeMapper {

    //用户余额增加相应的金额
    void addMoney(@Param("uMoney") Integer money, @Param("uId") Integer uid);


}
