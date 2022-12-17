package org.example.grade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

public class CourseTest {
    @DisplayName("Course를 정상적으로 생성한다")
    @Test
    void courseCreationTest() {
        assertThatCode(() -> {
            new Course("OOP", 3, "A+");
        }).doesNotThrowAnyException();
    }
}
