package org.example.grade;

/*
 * 요구사항
 * 평균학점 계산 방법 = (학점수×교과목 평점)의 합계/수강신청 총학점 수
 * MVC패턴(Model-View-Controller) 기반으로 구현한다.
 * 일급 컬렉션 사용 (클래스 안에 단 하나의 컬렉션 Attribute만 존재하는 것)
 * */
public class Course {
    private String subject;
    private int credit;
    private String grade;

    public Course(String subject, int credit, String grade) {
        this.subject = subject;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public double getGradeToDouble() {
        switch(this.grade){
            case "A+":
                return 4.5;
            case "A0":
                return 4.0;
            case "B+":
                return 3.5;
            case "B0":
                return 3.0;
            case "C+":
                return 2.5;
            case "C0":
                return 2.0;
            case "D+":
                return 1.5;
            case "D0":
                return 1.0;
            case "F":
                return 0;
            default:
                throw new IllegalArgumentException("잘못 된 점수입니다");
        }
    }

    public double multiplyCreditAndGrade(){
        return this.credit * this.getGradeToDouble();
    }
}
