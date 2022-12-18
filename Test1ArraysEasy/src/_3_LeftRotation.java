import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _3_LeftRotation {
/*
A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
Given an integer, d, rotate the array that many steps left and return the result.
Example
d = 2
arr = [1,2,3,4,5]
After 2 rotations, arr = [3,4,5,1,2].
 */

    public static List<Integer> rotateLeft1(int d, List<Integer> arr){
        Queue<Integer> queue = new LinkedList<>(arr);
        while (d > 0) {
            queue.add(queue.poll());
            d--;
        }
        return new ArrayList<>(queue);
    }

    public static List<Integer> rotateLeft2(int d, List<Integer> arr) {
        // Write your code here
        List<Integer> results = new ArrayList<>(arr);
        for(int i=arr.size()-1;i>=0;i--){
            int index = (i-d);
            if(index<0){
                index = index+ arr.size();
                results.set(index, arr.get(i));
            } else {
                results.set(index, arr.get(i));
            }
        }
        return results;
    }
}
