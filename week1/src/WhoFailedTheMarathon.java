/*
Who Failed to Finish the Marathon? - Hash
*/

import java.util.Arrays;

public class WhoFailedTheMarathon {
    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "ana", "stanko"};
        System.out.println(solution(participant, completion));
    }

    /* Correct, but Time-Out -> Complexity is O(n^2)
    static String solution(String[] participant, String[] completion) {
        boolean[] succeeded = new boolean[participant.length];

        for(String name : completion){
            for(int i = 0; i < participant.length; i++){
                if(participant[i].equals(name) && !succeeded[i]){
                    succeeded[i] = true;
                    break;
                }
            }
        }

        for(int i = 0; i < participant.length; i++){
            if(!succeeded[i]) return participant[i];
        }
        return "";
    }
    */

    // Arrays.sort used for participant & completion, and then compare them! -> Complexity becomes O(n*logn)
    static String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i = 0; i < completion.length; i++){
            if(!participant[i].equals(completion[i])) return participant[i];
        }

        return participant[participant.length - 1];
    }
}
