package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import com.mengxuegu.springboot.mapper.ProviderMapper;
import com.mengxuegu.springboot.utils.EasyExcelUtil;
import com.mengxuegu.springboot.utils.ExcelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 供应商的控制层
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    public ProviderDao providerDao;

    @Autowired
    public ProviderMapper providerMapper;

    //@RequestMapping(value = "/providers",method = RequestMethod.GET)
    @GetMapping("/providers")
    public String list(Map<String, Object> map, Provider provider) {
        logger.info("供应商查询...." + provider);
        List<Provider> providers = providerMapper.getProvider(provider);
        map.put("provides", providers);
        map.put("providerName", provider.getProviderName());
        return "provider/list";
    }

    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid, @RequestParam(value = "type", defaultValue = "view") String type, Map<String, Object> map) {
        logger.info("查询" + pid + "的供应商信息");
        Provider provider = providerMapper.getProviderByPid(pid);
        map.put("provider", provider);
        //  return  "provider/view";
        return "provider/" + type;
    }

    //修改供应商信息
    @PutMapping("/providerss")
    //@RequestMapping(value = "/providerss",method = RequestMethod.POST)
    public String update(Provider provider) {
        logger.info("更新供应商信息");
        providerMapper.updateProviderByPid(provider);
        return "redirect:/providers";
    }

    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }

    @PostMapping("/providers")
    public String add(Provider provider) {
        logger.info("添加数据" + provider);
        providerMapper.addProvider(provider);
        return "redirect:/providers";
    }

    @PostMapping("/provider/{pid}")
    //@Delete("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除操作" + pid);
        providerMapper.deleteProviderByPid(pid);
        return "redirect:/providers";
    }

    @GetMapping("/export")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        response.setContentType("application/vnd.ms.excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + "test.xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        Provider provider = new Provider();
        List<Provider> providers = providerMapper.getProvider(provider);
        ExcelUtil.writeExcel(response, providers);
    }

    //导入excel
    @RequestMapping(value = "excelImport", method = {RequestMethod.GET, RequestMethod.POST})
    public String excelImport(@RequestParam("uploadFile") MultipartFile[] files) throws Exception {
        if (files != null && files.length > 0) {
            MultipartFile file = files[0];
            List<Object> list = EasyExcelUtil.readExcel(file, new Provider(), 1, 1);
            if (list != null && list.size() > 0) {
                for (Object o : list) {
                    Provider xfxx = (Provider) o;
                    // System.out.println(xfxx.getXm()+"/"+xfxx.getSjh()+"/"+xfxx.getSjh());
                }
            }
        }
        return "index";
    }


}
