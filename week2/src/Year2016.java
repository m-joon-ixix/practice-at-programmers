/*
Year 2016 Problem - Practice
*/

public class Year2016 {
    public static void main(String[] args){
        int a = 5;
        int b = 24;
        System.out.println(solution(a, b));
    }

    static String solution(int a, int b) {
        String[] dayNames = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        int dayNumber = 0;
        int[] daysPerMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for(int i = 0; i < a - 1; i++){
            dayNumber += daysPerMonth[i];
        }
        dayNumber += b;

        return dayNames[(4 + dayNumber) % 7];
    }
}
