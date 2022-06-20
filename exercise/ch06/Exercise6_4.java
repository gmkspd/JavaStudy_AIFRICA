package ch6;

public class Exercise6_4 {
    public static void main(String[] args) {
        Student s = new Student();
        s.name = "홍길동";
        s.ban = 1;
        s.no = 1;
        s.kor = 100;
        s.eng = 60;
        s.math = 76;

        System.out.println("이름:" + s.name);
        System.out.println("총점:" + s.getTotal());
        System.out.println("평균:" + s.getAverage());
    }
}

class Student {
    String name;
    int ban, no;
    int kor, eng, math;
    final int nSubject = 3;

    int getTotal() { return kor + eng + math; }

    // 평균을 소수점 둘째자리에서 반올림
    float getAverage() {
        float avg = getTotal() / (float) nSubject;
        float roundAvg = Math.round(avg * 10); // 반올림할 숫자를 소수점 첫째자리로 만듬
        roundAvg /= 10;
        return roundAvg;
    }
}
