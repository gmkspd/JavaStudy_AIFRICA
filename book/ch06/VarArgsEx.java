package ch6;

/**
 * [book 6-22] 가변인자
 * 가변인자가 선언된 메소드를 호출할 때마다 배열이 새로 생성
 * if 매매변수의 타입을 배열로 할 시, 반드시 인자를 지정 -> null | 길이가 0인 배열
 *
 * 활용예시
 * 1.PrintStream.java
 * public PrintStream printf(String format, Object ... args) { }
 * 2.Class.java
 * public Method getMethod(String name, Class<?>... parameterTypes) { }
 */

public class VarArgsEx {
    public static void main(String[] args) {
        String[] strArr = { "100", "200", "300" };

        System.out.println(concatenate("", "100", "200", "300"));
        System.out.println(concatenate("-", strArr));
        System.out.println(concatenate(",", new String[] {"1", "2", "3"}));
        System.out.println("[" + concatenate(",", new String[0]) + "]");
        System.out.println("[" + concatenate(",") + "]");
    }

    static String concatenate(String delim, String... args) {
        String result = "";

        for (String str : args)
            result += str + delim;

        return result;
    }
}
