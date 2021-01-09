/*
Gym Clothes Problem - Greedy
*/

import java.util.Arrays;

public class GymClothes {
    public static void main(String[] args){
        int n = 5;
        int[] lost = {1, 2, 4, 5};
        int[] reserve = {2, 3, 4};
        System.out.println(solution(n, lost, reserve));
    }

    static int solution(int n, int[] lost, int[] reserve){
        // sort numbers into ascending order
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int keeping = n - lost.length, borrowed = 0;

        // if a student lost clothes, but has his own
        for(int j = 0; j < lost.length; j++){
            for(int i = 0; i < reserve.length; i++){
                if(lost[j] == reserve[i]){
                    borrowed++;
                    reserve[i] = -1;
                    lost[j] = -1;
                    break;
                }
            }
        }

        // borrow others' clothes
        for(int lostStudent : lost){
            if(lostStudent == -1) continue;
            // look if lostStudent +- 1 exists in reserve array
            for(int i = 0; i < reserve.length; i++){
                if(reserve[i] < lostStudent - 1){
                    continue;
                } else if(reserve[i] > lostStudent + 1){
                    break;
                } else {
                    reserve[i] = -1; // reserve[i] is already borrowed
                    borrowed++;
                    break;
                }
            }
        }

        return keeping + borrowed;
    }
}
