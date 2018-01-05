package com.jmu.bibasedmanage.controller;

import com.jmu.bibasedmanage.excel.ExcelImportContext;
import com.jmu.bibasedmanage.excel.ExcelImportHandler;
import com.jmu.bibasedmanage.excel.ExcelImportService;
import com.jmu.bibasedmanage.excel.RowData;
import com.jmu.bibasedmanage.exception.BusinessException;
import com.jmu.bibasedmanage.pojo.BmStudent;
import com.jmu.bibasedmanage.util.ResponseUtil;
import com.jmu.bibasedmanage.vo.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ljc on 2017/12/14.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ExcelImportService excelImportService;

    @RequestMapping("/index")
    public ModelAndView test(){
        return new ModelAndView("test.html");
    }
    @RequestMapping("/data")
    @ResponseBody
    public JsonResponse data(){
        String key1 = "test";
        Map<String, String> map = new HashMap<String, String>();
        map.put("ss","111");
        map.put("te","22");
        return ResponseUtil.successMap(key1, map);
    }
    @RequestMapping("/exception")
    public void exception(){
        throw new BusinessException("测试");
    }
    @RequestMapping("/excel")
    public void excel(HttpServletRequest request){
        String name = "E://学生信息导入模板.xls";
        try {
            String ret = excelImportService.importExcel(name, new ExcelImportHandler() {
                public String importRow(int rowIndex, RowData rowData, ExcelImportContext context) {
                    String studentId = rowData.getContentByColumnName("学号");
                    String grade = rowData.getContentByColumnName("年级");
                    String college = rowData.getContentByColumnName("学院");
                    String major = rowData.getContentByColumnName("专业");
                    String classes = rowData.getContentByColumnName("班级");
                    String name = rowData.getContentByColumnName("姓名");
                    String sexStr = rowData.getContentByColumnName("性别");
                    String email = rowData.getContentByColumnName("电子邮箱");
                    String mobile = rowData.getContentByColumnName("手机");

                    String sex = "";
                    if ("MALE".equals(sexStr)){
                        sex = "MALE";
                    }else if ("FEMALE".equals(sexStr)){
                        sex = "FEMALE";
                    }
                    //TODO 设置数据来源
                    BmStudent student = new BmStudent();
                    student.setStudentId(studentId);
                    student.setGrade(Integer.parseInt(grade));
                    student.setCollege(college);
                    student.setMajor(major);
                    student.setClasses(classes);
                    student.setName(name);
                    student.setSex(sex);
                    student.setEmail(email);
                    student.setMobile(mobile);

                    return null;
                }
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @RequestMapping("/main")
    public String mainYe(){
        return "/demo/container.html";
    }
}
