/*
Array that contains Numbers that can be divided by Divisor - Programmers Practice
*/

import java.util.Arrays;

public class DivisibleArray {
    public static void main(String[] args){
        int[] arr1 = {5, 9, 7, 10}, arr2 = {2, 36, 1, 3}, arr3 = {3, 2, 6};
        NoSameNumber.printArray(solution(arr1, 5));
        NoSameNumber.printArray(solution(arr2, 1));
        NoSameNumber.printArray(solution(arr3, 10));
    }

    static int[] solution(int[] arr, int divisor) {
        int n = 0;
        for(int i : arr){
            if(i % divisor == 0) n++;
        }

        if(n == 0) return new int[]{-1};

        int[] answer = new int[n];
        int idx = 0;
        for(int i : arr){
            if(i % divisor == 0){
                answer[idx] = i;
                idx++;
            }
        }

        Arrays.sort(answer);
        return answer;
    }
}
