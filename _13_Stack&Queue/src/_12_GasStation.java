/*
Question: Gas Station
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.
Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
Output: 3
Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: gas = [2,3,4], cost = [3,4,3]
Output: -1
Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */

public class _12_GasStation {

    // Brute Force
    // Time Complexity: O(n^2)
    // Space Complexity: O(1)
    /*
    In the Brute-Force approach, we will check from which index we can start the traversal, and then from that point, we will start our inner loop.
    Ex - gas = [1,2,3,4,5], cost = [3,4,5,1,2]
    index = 0 ==> gas[0] < cost[0], hence we can's start traversing from here.
    Inside the inner loop, We will traverse the entire loop again to check if we can complete the circuit or not. If completed, then return the index, and if not, then return -1.
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;

        for(int i = 0; i < len; i++){
            // If we can start the traversal
            if(gas[i] >= cost[i]){
                int idx = i, Gas = 0, j = 0;
                int remainingGas = 0;
                for(j = i; j < i+len; j++){
                    int index = j % len;
                    Gas = gas[index] + remainingGas;
                    if(Gas < cost[index]){
                        break;
                    }
                    remainingGas = Gas - cost[index];
                }
                // to verify that if the circuit is fully traversed
                if((j % len) == idx){
                    return idx;
                }
            }
        }

        return -1;
    }
}
