/*
Who Failed to Finish the Marathon? - Hash
*/

// Correct, but Time-Out

public class WhoFailedTheMarathon {
    public static void main(String[] args){
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"mislav", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }

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
}
