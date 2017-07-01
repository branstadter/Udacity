package com.example.android.reportcard;

import java.util.ArrayList;

/**
 * Created by brans on 2017. 07. 01..
 */

public class ReportCard {

    private ArrayList<Grade> gradeList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public ReportCard() {
        this.gradeList = new ArrayList<>();
        this.name = "Zoltan";
    }

    //if the subject exists than modify the grade else add the new subject + grade
    public void setGrade(String subject, int newGrade) {
        boolean newSubject = true;
        for (Grade item : this.gradeList) {
            if (item.getSubject().equalsIgnoreCase(subject)) {
                item.setGrade(newGrade);
                newSubject = false;
            }
        }

        if (newSubject) {
            gradeList.add(new Grade(subject, newGrade));
        }

    }

    //return with the grade of the subject, if doesnt exists this subject the value is -1
    public int getGrade(String subject) {
        for (Grade item : this.gradeList) {
            if (item.getSubject().equalsIgnoreCase(subject)) {
                return item.getGrade();
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        String report = "Name: " + this.name;

        for (Grade item : this.gradeList) {
            report += "; " + item.getSubject() + " grade: " + item.getGrade();
        }
        return report;
    }

    public class Grade {

        private String subject;
        private int grade;


        public Grade(String subject, int grade) {
            this.grade = grade;
            this.subject = subject;
        }

        public int getGrade() {
            return grade;
        }

        public void setGrade(int grade) {
            this.grade = grade;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }
    }


}
