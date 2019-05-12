package com.caidi.springbootadvanced.service.impl;


import com.caidi.springbootadvanced.domain.Person;
import com.caidi.springbootadvanced.service.DownExcelService;
import com.caidi.springbootadvanced.util.ExcelUtil;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class DownExcelServiceImpl implements DownExcelService {
    @Override
    public void downExcel(HttpServletResponse response) {
//        Student s =new Student();
//        s.setId("dsdsd");s.setUsername("都是真的");
//                List<Student> list =new ArrayList<>();
//        list.add(s);
//        System.out.println(list.toString());
//        //指定列表标题和工作表名称
//        ExportParams params = new ExportParams("学生信息表","学生");
//        Workbook workbook = ExcelExportUtil.exportExcel(params,Student.class,list);
//        response.setHeader("content-Type","application/vnd.ms-excel");
//        response.setHeader("Content-Disposition","attachment;filename="+System.currentTimeMillis()+".xls");
//        response.setCharacterEncoding("UTF-8");
//        try {
//            workbook.write(response.getOutputStream());
//            workbook.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(), Student.class, list);

//模拟从数据库获取需要导出的数据
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person("路飞","1",new Date());
        Person person2 = new Person("娜美","2",new Date());
        Person person3 = new Person("索隆","1",new Date());
        Person person4 = new Person("小狸猫","1", new Date());
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);

        //导出操作
        ExcelUtil.exportExcel(personList,"花名册","草帽一伙",Person.class,"海贼王.xls",response);

    }

    public void importExcel(HttpServletResponse response) {

    }
}
