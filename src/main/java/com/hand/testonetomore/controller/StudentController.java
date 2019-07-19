package com.hand.testonetomore.controller;

import com.hand.testonetomore.annotation.PermissionAnnotation;
import com.hand.testonetomore.domain.Major;
import com.hand.testonetomore.domain.Stuinfo;
import com.hand.testonetomore.service.IStudentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
@RestController
@RequestMapping(value = "/stu")
public class StudentController {

    @Autowired
    private IStudentService studentService;

    /**
     * 通过学生id查询学生信息和专业
     * @param sno
     * @return
     */
    @GetMapping(value = "/student")
    @PermissionAnnotation(value = true)
    public Stuinfo queryStudent(@Param("sno") String sno) {
        return studentService.queryStudent(sno);
    }

    /**
     * 通过专业id查询所有的用户
     * @param id
     * @return
     */
    @GetMapping(value = "/major")
    public Major queryMajor(@Param("id") Integer id) {
        return studentService.queryMajor(id);
    }

    /**
     * 查询所有学生
     * @return
     */
    @GetMapping(value = "/all")
    public List<Stuinfo> queryAll() {
        return studentService.queryAll();
    }

    /**
     * 插入学生
     * @param stuinfo
     * @return
     */
    @PostMapping
    public Integer insertStudent(Stuinfo stuinfo) {
        return studentService.insertStudent(stuinfo);
    }

    /**
     * 批量插入学生
     * @param stuinfos
     * @return
     */
    @PostMapping(value = "/stuinfos")
    public Integer insertListStudent(@RequestBody List<Stuinfo> stuinfos) {
        return studentService.insertListStudent(stuinfos);
    }

    /**
     * 更新学生
     * @param stuinfo
     * @return
     */
    @PutMapping
    public Integer updateStudent(Stuinfo stuinfo){
     return studentService.updateStudent(stuinfo);
    }

    /**
     * 更新学生
     * @param stuinfo
     * @return
     */
    @PutMapping(value = "/stuinfos")
    public Integer updateListStudent(@RequestBody List<Stuinfo> stuinfo){
        return studentService.updateListStudent(stuinfo);
    }

    /**
     * 删除学生
     * @param sno
     * @return
     */
    @DeleteMapping
    public Integer deleteStudent(String sno){
        return studentService.deleteStudent(sno);
    }

    /**
     * 批量删除学生
     * @param sno
     * @return
     */
    @DeleteMapping(value = "/stuinfos")
    public Integer deleteListStudent(@RequestBody List<String> sno){
        return studentService.deleteListStudent(sno);
    }

}

