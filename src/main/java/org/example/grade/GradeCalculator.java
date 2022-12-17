package org.example.grade;

import java.util.List;

/*
* 요구사항
* 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
* MVC패턴(Model-View-Controller) 기반으로 구현한다.
* 일급 컬렉션 사용
* */
public class GradeCalculator {
    private Courses courses;
    public GradeCalculator(List<Course> courses) {
        this.courses = new Courses(courses);
    }

    public double calculateResult() {
        // 학점 수 x 교과목 평점
        double resultGrade = courses.getGradeResult();

        // 수강신청 총 학점 수
        int totalCompletedCredit = courses.getTotalCompletedCredit();

        return resultGrade / totalCompletedCredit;
    }
}
