package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.entities.BIllProvier;
import com.mengxuegu.springboot.entities.Bill;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.BillMapper;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 供应商的控制层
 */
@Controller
public class BillController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public BillMapper billMapper;

    @Autowired
    public ProviderMapper providerMapper;

    //@RequestMapping(value = "/providers",method = RequestMethod.GET)
    @GetMapping("/bills")
    public String list(Map<String, Object> map, Bill bill){
        logger.info("账单查询...." + bill);

        List<BIllProvier> billProviers = billMapper.getBills(bill);
        //获取所有供应商
        List<Provider> providers = providerMapper.getProvider(null);
        map.put("billProviders", billProviers);
        map.put("providers", providers);
        map.put("billName", bill.getBillName());
        map.put("pid", bill.getPid());
        map.put("pay", bill.getPay()); //用于搜索回显数据
        return "bill/list";
    }

    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value = "type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + bid + "的账单信息");

        BIllProvier billProvider = billMapper.getBillByBid(bid);
        //获取所有供应商
        List<Provider> providers = providerMapper.getProvider(null);
        map.put("billProvider", billProvider);
        if (type.equals("update"))
            map.put("providers", providers);
        return "bill/" + type;
    }

    //修改账单信息
     @PutMapping("/bill")
    //@RequestMapping(value = "/bill", method = RequestMethod.POST)
    public String update(Bill bill) {
        logger.info("更新供应商信息");
        billMapper.updateBill(bill);
        return "redirect:/bills";
    }

    @GetMapping("/addbill")
    public String toAddPage(Map<String, Object> map) {
        //获取所有供应商
        List<Provider> providers = providerMapper.getProvider(null);
        map.put("providers", providers);
        return "bill/add";
    }


    @PostMapping("/addbills")
    public String add(Bill bill) {
        logger.info("添加数据" + bill);
        billMapper.addBill(bill);
        return "redirect:/bills";
    }

    @RequestMapping("/bill/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除操作" + pid);
        billMapper.deleteBillByBid(pid);
        return "redirect:/bills";
    }

}
