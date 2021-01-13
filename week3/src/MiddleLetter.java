/*
Taking the Middle Letter of a Word - Programmers Practice
*/

public class MiddleLetter {
    public static void main(String[] args){
        String s1 = "abcde";
        String s2 = "qwer";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
    }

    static String solution(String s) {
        int n = s.length();
        if(n % 2 == 0) return s.substring(n/2 - 1, n/2 + 1);
        else return s.substring(n/2, n/2 + 1);
    }
}
