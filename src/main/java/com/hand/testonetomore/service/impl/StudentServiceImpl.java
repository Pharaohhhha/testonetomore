package com.hand.testonetomore.service.impl;

import com.hand.testonetomore.domain.Major;
import com.hand.testonetomore.domain.Stuinfo;
import com.hand.testonetomore.mapper.StudentMapper;
import com.hand.testonetomore.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
@Service
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Stuinfo queryStudent(String sno) {
        return studentMapper.queryStudent(sno);
    }

    @Override
    public Major queryMajor(Integer id) {
        return studentMapper.queryMajor(id);
    }

    @Override
    public List<Stuinfo> queryAll() {
        return  studentMapper.queryAll();
    }

    @Override
    public Integer insertStudent(Stuinfo stuinfo) {
       return studentMapper.insertStudent(stuinfo);
    }

    @Override
    public Integer updateStudent(Stuinfo stuinfo) {
        return  studentMapper.updateStudent(stuinfo);
    }

    @Override
    public Integer deleteStudent(String sno) {
        return studentMapper.deleteStudent(sno);
    }

    @Override
    public Integer insertListStudent(List<Stuinfo> stuinfos) {
        return studentMapper.insertListStudent(stuinfos);
    }

    @Override
    public Integer updateListStudent(List<Stuinfo> stuinfos) {
        return studentMapper.updateListStudent(stuinfos);
    }

    @Override
    public Integer deleteListStudent(List<String> sno) {
        return  studentMapper.deleteListStudent(sno);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public void updateUserInfo(Integer gender, String sname) {
        studentMapper.updateGender(gender);
        int i=1/0;
        studentMapper.updateSname(sname);
    }


}

