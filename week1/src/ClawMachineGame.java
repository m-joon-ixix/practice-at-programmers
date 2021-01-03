/*
Claw Machine Game - 2019 Kakao Developer Winter Internship Problem
*/

public class ClawMachineGame {
    public static void main(String[] args){
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println("Result: " + solution(board, moves));
    }

    static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] cart = new int[moves.length];
        int dollsInCart = 0; // doll on top of the cart: cart[dollsInCart - 1]

        for(int j : moves){
            for(int i = 0; i < board.length; i++){
                if(board[i][j-1] != 0){
                    cart[dollsInCart] = board[i][j-1];
                    dollsInCart++;
                    board[i][j-1] = 0;
                    if(dollsInCart >= 2 && cart[dollsInCart - 1] == cart[dollsInCart - 2]){
                        cart[dollsInCart - 1] = 0;
                        cart[dollsInCart - 2] = 0;
                        dollsInCart -= 2;
                        answer += 2;
                    }
                    break;
                }
            }
        }

        return answer;
    }
}
