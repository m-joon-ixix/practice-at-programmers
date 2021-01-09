/*
Kth Number Problem - Sorting
*/

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args){
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = solution(array, commands);
        for(int i : answer) System.out.print(i + " ");
    }

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int i, j, k;
        for(int n = 0; n < commands.length; n++){
            i = commands[n][0];
            j = commands[n][1];
            k = commands[n][2];
            int[] subList = new int[j - i + 1];
            for(int m = i - 1; m < j; m++){
                subList[m - i + 1] = array[m];
            }
            Arrays.sort(subList);
            answer[n] = subList[k - 1];
        }

        return answer;
    }
}
