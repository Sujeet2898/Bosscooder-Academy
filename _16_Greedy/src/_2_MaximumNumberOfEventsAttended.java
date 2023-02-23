/*
Question: Maximum Number of Events That Can Be Attended
You are given an array of events where events[i] = [startDayi, endDayi]. Every event i starts at startDayi and ends at endDayi.
You can attend an event i at any day d where startTimei <= d <= endTimei. You can only attend one event at any time d.
Return the maximum number of events you can attend.

Input: events = [[1,2],[2,3],[3,4]]
Output: 3
Explanation: You can attend all the three events.
One way to attend them all is as shown.
Attend the first event on day 1.
Attend the second event on day 2.
Attend the third event on day 3.

Input: events= [[1,2],[2,3],[3,4],[1,2]]
Output: 4

Constraints:
1 <= events.length <= 105
events[i].length == 2
1 <= startDayi <= endDayi <= 105
 */

import java.util.Arrays;
import java.util.TreeSet;

public class _2_MaximumNumberOfEventsAttended {

    // Greedy approach
    // Time Complexity: Sorting the events array takes O(n log n) time, where n is the number of events. Adding integers from 1 to 100000 to the TreeSet takes O(log n) time for each insertion, for a total of O(n log n) time. Looping through each event and finding the earliest available time slot takes O(n log n) time in the worst case, since it requires a ceiling search in the TreeSet. This is because each of the n events may need to search through the entire TreeSet to find an available time slot. Removing a time slot from the TreeSet takes O(log n) time. Therefore, the overall time complexity of the method is O(n log n).
    // Space Complexity: O(n) since there are n events. The space required to store the TreeSet is also O(n), since it can contain up to 100000 integers. Therefore, the overall space complexity of the method is O(n).

    public static int maxEvents(int[][] events) {
        // Sorts the events array in ascending order of end time (if end times are equal, sort by start time)
        Arrays.sort(events,(a, b) -> a[1] == b[1]?a[0]-b[0]:a[1]-b[1]);

        // Creates a new TreeSet of integers
        TreeSet<Integer> set = new TreeSet<>();

        // Adds integers from 1 to 100000 inclusive to the TreeSet
        for(int i = 1; i<=100000 ; i++)set.add(i);

        // Initializes a variable called ans to 0
        int ans = 0;

        // Loops through each event in the events array
        for(int i = 0 ; i<events.length ; i++){
            // Finds the earliest available time slot after the start time of the current event
            Integer available = set.ceiling(events[i][0]);

            // If there is no available time slot or the available time slot is after the end time of the current event, continue to the next event
            if(available == null || available > events[i][1])continue;
                // If there is an available time slot within the duration of the current event, increment the answer and remove the time slot from the TreeSet
            else{
                ans++;
                set.remove(available);
            }
        }

        // Return the number of events that could be scheduled
        return ans;
    }

    public static void main(String[] args) {
        int[][] events = {{1,4},{4,4},{2,2},{3,4},{1,1}};
        int ans = maxEvents(events);
        System.out.println("The maximum number of events that can be attended is: " + ans);
        // The maximum number of events that can be attended is: 4
    }
}
