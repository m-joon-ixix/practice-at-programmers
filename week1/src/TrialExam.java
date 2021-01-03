/*
Trial Examination - Complete Search
*/


import java.util.Arrays;

public class TrialExam {
    public static void main(String[] args){
        int[] answers = {1, 2, 3, 4, 5};
        int[] result = solution(answers);

        System.out.print("Who got the best score?: ");
        for(int i : result) System.out.print(i + " ");
    }

    static int[] solution(int[] answers) {
        int numOfProblems = answers.length;
        int[] pattern1 = {1, 2, 3, 4, 5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        // studentAnswers[i-1]: student i's answers
        int[][] studentAnswers = new int[3][numOfProblems];
        for(int i = 0; i < numOfProblems; i++){
            studentAnswers[0][i] = pattern1[i % 5];
            studentAnswers[1][i] = pattern2[i % 8];
            studentAnswers[2][i] = pattern3[i % 10];
        }

        int[] correctAnswers = new int[3]; // {0, 0, 0}
        for(int i = 0; i < numOfProblems; i++){ // i: problem number
            for(int j = 0; j < 3; j++){ // j: student number
                if(studentAnswers[j][i] == answers[i]) correctAnswers[j]++;
            }
        }

        // get idx of max(correctAnswers)
        int numberOfWinners = 1, max = correctAnswers[0];
        for(int i = 1; i < 3; i++){
            if(correctAnswers[i] > max){
                max = correctAnswers[i];
                numberOfWinners = 1;
            } else if(correctAnswers[i] == max){
                numberOfWinners++;
            }
        }

        int[] winners = new int[numberOfWinners]; // student number of winners
        int winnerIdx = 0;
        for(int i = 0; i < 3; i++){
            if(correctAnswers[i] == max){
                winners[winnerIdx] = i + 1;
                winnerIdx++;
            }
        }
        return winners;
    }
}
