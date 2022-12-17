package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/*
 * 요구사항
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * 일급 컬렉션 사용
 * */

public class GradeCalculatorTest {
    private static List<Course> courses = List.of(
            new Course("OOP", 3, "A+"),
            new Course("Computer Science", 3, "A+")
    );

    @DisplayName("평균 학점을 계산한다")
    @Test
    void calculateAverageGradeTest() {
        GradeCalculator gradeCalculator = new GradeCalculator(courses);

        double gradeResult = gradeCalculator.calculateResult();
        assertThat(gradeResult).isEqualTo(4.5);
    }
}
