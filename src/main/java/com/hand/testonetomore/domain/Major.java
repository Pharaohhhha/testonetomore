package com.hand.testonetomore.domain;

import java.util.List;

/**
 * @author 谭春
 * Date: 2019/7/18
 * Description:
 */
public class Major {

        private int id;
        private String majorName;
        private int personNum;
        private String turtor;
        private List<Stuinfo> students;

        @Override
        public String toString() {
            return "Major [id=" + id + ", majorName=" + majorName + ", personNum=" + personNum + ", turtor=" + turtor
                    + ", students=" + students + "]";
        }

        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getMajorName() {
            return majorName;
        }
        public void setMajorName(String majorName) {
            this.majorName = majorName;
        }
        public int getPersonNum() {
            return personNum;
        }
        public void setPersonNum(int personNum) {
            this.personNum = personNum;
        }
        public String getturtor() {
            return turtor;
        }
        public void setturtor(String turtor) {
            this.turtor = turtor;
        }
        public List<Stuinfo> getStudents() {
            return students;
        }
        public void setStudents(List<Stuinfo> students) {
            this.students = students;
        }

}

