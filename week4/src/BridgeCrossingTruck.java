/*
Trucks are waiting to cross a bridge, the weight that bridge can withstand is limited. Find the minimum time required to cross every truck. (Stack, Queue)
*/

import java.util.LinkedList;
import java.util.Queue;

public class BridgeCrossingTruck {
    public static void main(String[] args){
        int[] truck_weights1 = {7, 4, 5, 6};
        System.out.println(solution(2, 10, truck_weights1));
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        Queue<Integer> trucks = new LinkedList<>();
        for(int truck : truck_weights) trucks.add(truck);
        int[] bridge = new int[bridge_length];
        int sumOfWeights = 0;

        while(sumOfWeights > 0 || !trucks.isEmpty()){
            if(bridge[bridge_length - 1] != 0) sumOfWeights -= bridge[bridge_length - 1];
            for(int i = bridge_length - 1; i > 0; i--){
                bridge[i] = bridge[i - 1];
            }

            if(!trucks.isEmpty() && sumOfWeights + trucks.peek() <= weight){
                bridge[0] = trucks.poll();
                sumOfWeights += bridge[0];
            } else {
                bridge[0] = 0;
            }

            time++;
        }

        return time;
    }

}
