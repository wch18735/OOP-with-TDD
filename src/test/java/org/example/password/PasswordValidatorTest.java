package org.example.password;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;

/*
* 요구사항
* 비밀번호는 최소 8자 이상 12자 이하여야 한다.
* 비밀번호가 8자 미만 또는 12자 초과인 경우 IllegalArgumentException 예외를 발생시킨다.
* 경계조건에 대해 테스트 코드를 작성해야 한다.
*/
public class PasswordValidatorTest {

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다")
    @Test
    void validatePasswordLengthTest() {
        assertThatCode(()-> PasswordValidator.validate("wch18735~!"))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1234567", "1234567890123"})
    void validatePasswordLengthTest_IllegalArgumentException(String password) {
        assertThatCode(()-> PasswordValidator.validate(password))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PasswordValidator.WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }

    //***********************************************************************//
    /* 테스트하기 쉬운 코드를 작성하려고 노력하면 더 낮은 결합도를 가진 설계를 얻을 수 있다 */
    //***********************************************************************//

    @DisplayName("비밀번호가 최소 8자 이상, 12자 이하면 예외가 발생하지 않는다.")
    @Test
    void validatePasswordTest_by_CorrectPasswordGenerator() {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate_by_password_generator(new CorrectPasswordGenerator()))
                .doesNotThrowAnyException();
    }

    @DisplayName("비밀번호가 8자 미만 또는 12자 초과하는 경우 IllegalArgumentException 예외가 발생한다.")
    @Test
    void validatePasswordTest_by_WrongPasswordGenerator() {
        // given
        PasswordValidator passwordValidator = new PasswordValidator();

        // when, then
        assertThatCode(() -> passwordValidator.validate_by_password_generator(new WrongPasswordGenerator()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(PasswordValidator.WRONG_PASSWORD_LENGTH_EXCEPTION_MESSAGE);
    }
}
