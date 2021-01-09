/*
Reversing Ternary Notation Problem - Monthly Coding Challenge Season 1
*/

import java.util.ArrayList;
import java.util.List;

public class ReversingTernary {
    public static void main(String[] args){
        int n1 = 45;
        int n2 = 125;
        System.out.println(solution(n1) + "   " + solution(n2));
    }

    static int solution(int n) {
        List<Integer> ternaryList = new ArrayList<>();

        while(n > 0){
            ternaryList.add(n % 3);
            n /= 3;
        }

        int power = ternaryList.size() - 1, answer = 0;
        for(int k : ternaryList){
            answer += (k * Math.pow(3, power));
            power--;
        }

        return answer;
    }
}
