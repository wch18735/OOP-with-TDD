package org.example.calculator;

import java.util.List;

public class Calculator {
    private static final List<StrategyArithmeticOperator> arithmeticOperatorList
            = List.of(new AdditionOperator(), new SubtractionOperator(), new MultiplicationOperator(), new DivisionOperator());

    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2) {
        /* (1) 기존 if - else 방식
        if(operator == "+"){
            return operand1 + operand2;
        } else if(operator == "-"){
            return operand1 - operand2;
        } else if(operator == "*"){
            return operand1 * operand2;
        } else {
            return operand1 / operand2;
        }
        *************************** */

        /* (2) Enum 사용 방식
        return ArithmeticOperator.calculate(operand1, operator, operand2);
        * *************************** */

        return arithmeticOperatorList.stream()
                .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
                .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다"));
    }
}
