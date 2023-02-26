/*
Question: K Closest Points to Origin
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

Constraints:
1 <= k <= points.length <= 104
-104 < xi, yi < 104
 */

import java.util.Arrays;
import java.util.PriorityQueue;

public class _4_KClosestPointsToOrigin {

    // Time complexity: O(n *logK) where n is the number of points in the input array and k is the number of closest points to be returned. This is because the algorithm involves iterating through each point in the input array (O(n)), adding the point to the max heap (O(log k)), and removing the top element from the heap if the heap size exceeds k (also O(log k)). Since each of these operations is performed for each point in the input array, the overall time complexity is O(n log k).
    // Space complexity: O(K) since we are storing the k closest points in a 2D array. Additionally, we are using a max heap data structure to track the closest points, which has a space complexity of O(k) as well. Therefore, the overall space complexity is also O(k).
    public static int[][] kClosest(int[][] points, int k) {
        // Create a max heap data structure that will contain integer arrays of length 2
        // The priority of each element in the heap is determined by the distance of the point from the origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>( (a, b) -> (b[0]*b[0]+b[1]*b[1]) - (a[0]*a[0]+a[1]*a[1]));

        // Iterate through each point in the input array
        for(int[] point : points) {

            // Add the current point to the max heap
            maxHeap.add(point);

            // If the size of the max heap is greater than k, remove the top element from the heap
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Create a 2D array to store the k closest points
        int[][] result = new int[k][2];

        // Iterate through the max heap and add each element to the result array
        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll();
        }

        // Return the resulting array
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, -1}, {0, 0}, {4, 6}, {7, 2}};
        int k = 3;
        int[][] closestPoints = kClosest(points, k);
        System.out.println("The " + k + " closest points to the origin are:");
        for (int i = 0; i < closestPoints.length; i++) {
            System.out.println(Arrays.toString(closestPoints[i]));
        }
        // The 3 closest points to the origin are:
        //[1, 3]
        //[-2, 2]
        //[0, 0]
    }
}
