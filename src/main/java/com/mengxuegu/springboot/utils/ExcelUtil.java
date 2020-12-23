package com.mengxuegu.springboot.utils;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.mengxuegu.springboot.entities.Provider;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {

    /***
     * 导出Excel
     * @param response
     * @param list
     */
    public static void writeExcel(HttpServletResponse response, List<Provider> list) throws IOException {
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();

        //定义excel表
        WriteSheet sheet = EasyExcel.writerSheet(0, "sheet").head(Provider.class).build();
        sheet.setAutoTrim(true);
        //excel文件写入数据
        excelWriter.write(list, sheet);

        //关闭输出流
        excelWriter.finish();
    }
}
