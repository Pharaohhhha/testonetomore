package com.hand.testonetomore.domain;

import java.util.Date;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
public class Stuinfo {
    private String sno;
    private String sname;
    private int gender;
    private Date birthday;
    private int majorId;
    private Major major;
    private int credit;
    private String remark;

    public Stuinfo(String sno, String sname, int gender, Date birthday, int majorId, int credit, String remark) {
        this.sno = sno;
        this.sname = sname;
        this.gender = gender;
        this.birthday = birthday;
        this.majorId = majorId;
        this.credit = credit;
        this.remark = remark;
    }

    public Stuinfo(String sno, String sname, int gender) {
        this.sno = sno;
        this.sname = sname;
        this.gender = gender;
    }

    public Stuinfo(String sno, String sname, int gender, int majorId, int credit, String remark) {
        this.sno = sno;
        this.sname = sname;
        this.gender = gender;
        this.majorId = majorId;
        this.credit = credit;
        this.remark = remark;
    }

    public Stuinfo() {
    }

    public String getSno() {
        return sno;
    }
    public void setSno(String sno) {
        this.sno = sno;
    }
    public String getSname() {
        return sname;
    }
    public void setSname(String sname) {
        this.sname = sname;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public int getMajorId() {
        return majorId;
    }
    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }
    public Major getMajor() {
        return major;
    }
    public void setMajor(Major major) {
        this.major = major;
    }
    public int getCredit() {
        return credit;
    }
    public void setCredit(int credit) {
        this.credit = credit;
    }
    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
    }
    @Override
    public String toString() {
        return "Stuinfo [sno=" + sno + ", sname=" + sname + ", gender=" + gender + ", birthday=" + birthday
                + ", majorId=" + majorId + ", major=" + major + ", credit=" + credit + ", remark=" + remark + "]";
    }
}

