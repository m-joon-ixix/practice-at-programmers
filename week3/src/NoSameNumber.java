/*
Remove Continuous Identical Numbers in Array - Programmers Practice
*/

public class NoSameNumber {
    public static void main(String[] args){
        int[] arr1 = {1, 1, 3, 3, 0, 1, 1};
        int[] arr2 = {4, 4, 4, 3, 3};
        printArray(solution(arr1));
        printArray(solution(arr2));
    }

    static int[] solution(int[] arr) {
        int n = 1; // size of array to return
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] != arr[i]) n++;
        }

        int[] answer = new int[n];
        int idx = 1;
        answer[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i-1] != arr[i]){
                answer[idx] = arr[i];
                idx++;
            }
        }

        return answer;
    }

    static void printArray(int[] arr){
        System.out.print("Printing Array: ");
        for(int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}
