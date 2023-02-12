/*
Question: Ice Cream Parlor
Two friends like to pool their money and go to the ice cream parlor. They always choose two distinct flavors and they spend all of their money.
Given a list of prices for the flavors of ice cream, select the two that will cost all of the money they have.
Example. m = 6 cost = [1, 3, 4, 5, 6]
The two flavors that cost 1 and 5 meet the criteria. Using 1-based indexing, they are at indices 1 and 4
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class _2_IceCreamParlor {

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // populate the map with the flavor price as key and its index as value
        for (int i = 0; i < arr.size(); i++) {
            map.put(arr.get(i), i + 1);
        }

        // loop through the array to find the two flavors
        for (int i = 0; i < arr.size(); i++) {
            int difference = m - arr.get(i);
            if (map.containsKey(difference) && map.get(difference) != i + 1) {
                result.add(i + 1);
                result.add(map.get(difference));
                break;
            }
        }

        // return the result
        return result;
    }

    public static void main(String[] args) {
        int m = 6;
        List<Integer> arr = Arrays.asList(1, 3, 4, 5, 6);
        List<Integer> result = icecreamParlor(m, arr);
        System.out.println(result);  // [1, 4]

        m = 10;
        arr = Arrays.asList(2, 2, 4, 3, 5);
        result = icecreamParlor(m, arr);
        System.out.println(result);  // []

        m = 2;
        arr = Arrays.asList(1, 1);
        result = icecreamParlor(m, arr);
        System.out.println(result);  // [1, 2]
    }
}
