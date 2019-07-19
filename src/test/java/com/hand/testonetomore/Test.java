package com.hand.testonetomore;

import com.hand.testonetomore.domain.Major;
import com.hand.testonetomore.domain.Stuinfo;
import com.hand.testonetomore.service.IStudentService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {
    @Autowired
    private IStudentService studentService;
    @org.junit.Test
    public void test(){
//        System.out.println("通过用户id查询学生信息和专业");
//        Stuinfo stuinfo = studentService.queryStudent("081001");
//        System.out.println(stuinfo);
//        System.out.println("通过专业id查询此专业所有的学生");
//        Major majors = studentService.queryMajor(15);
//        System.out.println(majors);
//        System.out.println("插入学生");
        Date date=null;
            try {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String time =  format.format(1015-10-10);
                 date = format.parse(time.concat(" 00:00:00"));
            } catch (Exception e) {
                e.printStackTrace();
            }
//        System.out.println("插入学生");
//        Stuinfo stuinfo1 = new Stuinfo("08100AB","网消息",1,date,15,16,"40");
//        System.out.println(studentService.insertStudent(stuinfo1));
//        System.out.println("批量插入学生/更新学生");
//        List<Stuinfo> stuinfos = new ArrayList<>();
//        Stuinfo stuinfo = new Stuinfo("4","tc",3,date,17,88,"5t0");
//        Stuinfo stuinfo2 = new Stuinfo("5","tc",1,date,17,16,"40");
//        Stuinfo stuinfo3 = new Stuinfo("6","tc",1,date,17,16,"40");
//
//        stuinfos.add(stuinfo);
//        stuinfos.add(stuinfo2);
//        stuinfos.add(stuinfo3);
//        Integer integer = studentService.insertListStudent(stuinfos);
//        Integer integer = studentService.updateListStudent(stuinfos);
//        System.out.println(integer);
//        System.out.println("更新学生");
//        Stuinfo stuinfo = new Stuinfo();
//        stuinfo.setSno("081009");
//        stuinfo.setSname("动态更新");
//        Integer integer = studentService.updateStudent(stuinfo);
//        System.out.println(integer);
//          System.out.println("删除学生");
//        Integer integer = studentService.deleteStudent("081004A");
//        System.out.println(integer);
//        System.out.println("批量删除学生");
//        ArrayList<String> list = new ArrayList<>();
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        Integer integer1 = studentService.deleteListStudent(list);
//        System.out.println(integer1);
//        System.out.println("查询所有学生");
//        List<Stuinfo> stuinfos1 = studentService.queryAll();
//        for (Stuinfo stuinfo1 : stuinfos1) {
//            System.out.println(stuinfo1);
//        }
//        System.out.println("事务同时修改");
//            studentService.updateUserInfo(123,"事务特使");
    }

    }

