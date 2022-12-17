package org.example.grade;

import java.util.List;

public class Courses {
    List<Course> courses;
    public Courses(List<Course> courses) {
        this.courses = courses;
    }

    public double getGradeResult(){
        double resultGrade = 0.0;
        for(Course course: courses){
            resultGrade += course.multiplyCreditAndGrade();
        }

        return resultGrade;
    }

    public int getTotalCompletedCredit(){
        return courses.stream()
                .mapToInt(Course::getCredit)
                .sum();
    }
}
