/*
Select 2 numbers and Add them - Monthly Coding Challenge Season1
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectAndAddTwo {
    public static void main(String[] args){
        int[] numbers1 = {2, 1, 3, 4, 1};
        int[] numbers2 = {5, 0, 2, 7};
        printArray(solution(numbers1));
        printArray(solution(numbers2));
    }

    static int[] solution(int[] numbers) {
        List<Integer> resultList = new ArrayList<>();
        int sum;

        for(int i = 0; i < numbers.length; i++){
            for(int j = i + 1; j < numbers.length; j++){
                sum = numbers[i] + numbers[j];
                if(!resultList.contains(sum)) resultList.add(sum);
            }
        }

        Collections.sort(resultList);

        Integer[] answerInteger = resultList.toArray(new Integer[0]);
        int[] answer = new int[answerInteger.length];
        for(int i = 0; i < answerInteger.length; i++) answer[i] = answerInteger[i];

        return answer;
    }

    static void printArray(int[] numbers){
        System.out.print("Printing the array: ");
        for(int i : numbers) System.out.print(i + " ");
        System.out.println();
    }
}
