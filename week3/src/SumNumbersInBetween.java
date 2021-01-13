/*
Sum up all numbers that are between two numbers given - Programmers Practice
*/

public class SumNumbersInBetween {
    public static void main(String[] args){
        int a = 3, b = 5;
        System.out.println("Sum: " + solution(a, b));
    }

    static long solution(int a, int b) {
        if(a == b) return a;

        long answer = 0;
        for(int i = Math.min(a, b); i <= Math.max(a, b); i++) answer += i;

        return answer;
    }
}
