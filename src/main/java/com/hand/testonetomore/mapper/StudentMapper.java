package com.hand.testonetomore.mapper;

import com.hand.testonetomore.domain.Major;
import com.hand.testonetomore.domain.Stuinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
@Mapper
public interface StudentMapper {

    /**
     * 通过学生id查询学生的信息和专业信息
     * @param sno
     * @return
     */
    Stuinfo queryStudent(@Param("sno") String sno);

    /**
     * 通过专业id查询所有学生信息
     * @param id
     * @return
     */
    Major queryMajor(@Param("id") Integer id);

    /**
     * 查询所有学生
     * @return
     */
    List<Stuinfo> queryAll();

    /**
     * 插入学生
     * @param stuinfo
     * @return
     */
    Integer insertStudent(Stuinfo stuinfo);

    /**
     * 更新学生
     * @param stuinfo
     * @return
     */
    Integer updateStudent(Stuinfo stuinfo);

    /**
     * 删除学生
     * @param sno
     * @return
     */
    Integer deleteStudent(@Param("sno")String sno);


    /**
     * 批量插入学生
     * @param stuinfos
     * @return
     */
    Integer insertListStudent(List<Stuinfo> stuinfos);

    /**
     * 批量更新学生
     * @param stuinfos
     * @return
     */
    Integer updateListStudent(List<Stuinfo> stuinfos);

    /**
     * 批量删除学生
     * @param sno
     * @return
     */
    Integer deleteListStudent(List<String> sno);

    /**
     * 事务测试方法
     * @param gender
     * @return
     */
    Integer updateGender(@Param("gender") Integer gender);

    /**
     * 事务测试方法
     * @param sname
     * @return
     */
    Integer updateSname(@Param("sname") String sname);



}

