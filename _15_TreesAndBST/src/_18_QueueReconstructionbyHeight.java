/*
Question: Queue Reconstruction by Height
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.
Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).

Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.

Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]

Constraints:
1 <= people.length <= 2000
0 <= hi <= 106
0 <= ki < people.length
It is guaranteed that the queue can be reconstructed.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _18_QueueReconstructionbyHeight {

    /*
    Approach: Sort heights in decreasing order
    ---------------------------------------------
Process the people in the decreasing order of heights and build solution incrementally (greedily) i.e. insert the current person
into the result built so far to build the new result. We can handle people with equal heights gracefully by giving preference to lower k in (h, k) while sorting.

Input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
Sort by height: [[7,0], [7,1], [6,1], [5,0], [5,2], [4,4]]
Result: [ ]
[7, 0]: insert at index 0
Result: [ [7, 0] ]
[7, 1]: insert at index 1
Result: [ [7, 0], [7, 1] ]
[6, 1]: insert at index 1
Result: [ [7, 0], [6, 1], [7, 1] ]
[5, 0]: insert at index 0
Result: [ [5, 0], [7, 0], [6, 1], [7, 1] ]
[5, 2]: insert at index 2
Result: [ [5, 0], [7, 0], [5, 2], [6, 1], [7, 1] ]
[4, 4]: insert at index 4
Result: [ [5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1] ] => Output

Complexity analysis:
Time: O(n log n) for sorting. O(n) in the worst case to insert each person if there are n people so O(n * n) for all of them.
O(n log n) + O(n * n) = O(n^2)
(LinkedList/ArrayList may offer different performance on different input but worst case time complexity is still O(n^2) with either of them)
Space: O(n)
     */

    public int[][] reconstructQueue(int[][] people) {
        if(people == null)
            return new int[0][0];
        List<int[]> q = new ArrayList<>();
        // pick up the tallest guy first and insert the next tall guy, just need to insert him into kth position repeat until all people are inserted into list
        // Input: [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return b[0] - a[0];
        });
        // Output: [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]

        for(int i = 0; i < people.length; i++) {
            int[] person = people[i];
            q.add(person[1], person);
        }
        // Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
        return q.toArray(new int[0][]);
    }
}
