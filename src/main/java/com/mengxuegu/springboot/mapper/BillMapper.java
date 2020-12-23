package com.mengxuegu.springboot.mapper;

import com.mengxuegu.springboot.entities.BIllProvier;
import com.mengxuegu.springboot.entities.Bill;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//@Mapper
public interface BillMapper {

    List<BIllProvier> getBills(Bill bill);

    BIllProvier getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deleteBillByBid(Integer bid);

}
