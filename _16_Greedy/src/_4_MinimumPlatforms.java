/*
Question: Minimum Platforms
Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms
required for the railway station so that no train is kept waiting.
Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be
the same for a train but we can have arrival time of one train equal to departure time of the other. At any given
instance of time, same platform can not be used for both departure of a train and arrival of another train. In such
cases, we need different platforms.
Example 1:
Input: n = 6
arr[] = {0900, 0940, 0950, 1100, 1500, 1800}
dep[] = {0910, 1200, 1120, 1130, 1900, 2000}
Output: 3
Explanation:
Minimum 3 platforms are required to
safely arrive and depart all trains.
Example 2:
Input: n = 3
arr[] = {0900, 1100, 1235}
dep[] = {1000, 1200, 1240}
Output: 1
Explanation: Only 1 platform is required to
safely manage the arrival and departure
of all trains.
 */

import java.util.Arrays;

public class _4_MinimumPlatforms {

    // Time Complexity: O(NlogN) --> Sorting takes O(nlogn) and traversal of arrays takes O(n) so overall time complexity is O(nlogn)
    // Space Complexity: O(1)  --> No extra space used

    public static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int plat_needed = 1;
        int result = 1;
        int i = 1;  // second arrival train
        int j = 0;  // first departure train

        // move till it doesn't cross the boundary
        while (i < n && j < n){

            // if arrival train is coming before the departure train or at the same time, no. of platform increases
            if(arr[i] <= dep[j]){
                plat_needed++;
                i++;
            }
            // if departure train move before the arrival train, platform goes vacant
            else if(arr[i] > dep[j]){
                plat_needed--;
                j++;
            }

            if(plat_needed > result){
                result = plat_needed;
            }
        }
        return result;
    }
}