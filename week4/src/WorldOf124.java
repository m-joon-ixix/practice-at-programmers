/*
World Of Numbers 1, 2, 4 - Representing an integer with only 1, 2, 4
*/

public class WorldOf124 {
    public static void main(String[] args){
        int[] numbers = new int[]{1, 2, 3, 4, 13};

        for(int number : numbers){
            System.out.println(solution(number));
        }
    }

    static String solution(int n) {
        String answer = "";
        String[] digits = new String[]{"1", "2", "4"};

        int digit = 1, power = 3;
        while(n - power > 0){
            n -= power;
            digit++;
            power *= 3;
        }
        // it's the nth number among numbers with the number of digits 'digit'
        n--;

        // changing n to ternary notation (base of 3)
        // each digit of ternary notation (0, 1, 2) becomes the index of array 'digits'
        power = (int)Math.pow(3, digit - 1);
        for(int i = 0; i < digit; i++){
            answer += digits[n / power];
            n %= power;
            power /= 3;
        }

        return answer;
    }
}
