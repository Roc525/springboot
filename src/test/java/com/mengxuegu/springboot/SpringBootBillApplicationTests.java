package com.mengxuegu.springboot;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengxuegu.springboot.entities.BIllProvier;
import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.entities.User;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;

    @Autowired
    BillMapper billMapper;

    @Test
    void contextLoads() {
        Provider provider=new Provider();
        provider.setProviderName("A货");
        List<Provider> provider1 = providerMapper.getProvider(provider);
        System.out.println(provider1.get(0));

        Provider provider2 = providerMapper.getProviderByPid(2);
        System.out.println(provider2);

        provider2.setProviderName("B货域名供应商....");
        int i = providerMapper.updateProviderByPid(provider2);
        System.out.println(i);

        providerMapper.addProvider(new Provider(null, "PR-AA", "梦学谷供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));

        providerMapper.deleteProviderByPid(8);
    }

    @Test
    void contextLoads1() {
        Bill bill = new Bill();
        bill.setBillName("com");
        List<BIllProvier> bills = billMapper.getBills(bill);
        //分页
       final PageInfo<Bill> pageInfo = PageHelper.startPage(1, 15).setOrderBy("bid desc").doSelectPageInfo(() -> this.billMapper.getBills(null));
        System.out.println(pageInfo.getList().size());


//        BIllProvier billProvider = billMapper.getBillByBid(4);
//        System.out.println(billProvider);
//
//        Bill billl= (Bill)billProvider;
//        billl.setBillName("cn域名....");
//        int i = billMapper.updateBill(billl);
//        System.out.println(1);
//
//        int i1 = billMapper.addBill(new Bill(null, "Bi-AA11", "粮油aaa", "斤", 80, 480.8, new Provider(2002, "PR-BB", "梦学谷供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 1));
//        System.out.println(i1);
//
//        billMapper.deleteBillByBid(6);
    }

}
