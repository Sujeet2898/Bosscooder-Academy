import java.util.ArrayList;
import java.util.List;

public class _4_SparseArrays {
/*
There is a collection of input strings and a collection of query strings.
For each query string, determine how many times it occurs in the list of input strings. Return an array of the results.
Example
stringList = [' ab' ,' ab' , abc']
queries = [' ab' ,' abc' ,' bc']
There are 2 instances of 'ab', 1 of 'abc' and 0 of 'bc'. For each query, add an element to the return array, results = [2,1,0].
 */

    public static List<Integer> matchingStrings1(List<String> stringList, List<String> queries) {
        List<Integer> result = new ArrayList<Integer>();
        // Write your code here
        for (String str : queries) {
            int totalMatches = 0;
            for (String s : stringList) {
                if (str.equals(s)) {
                    totalMatches++;
                }
            }
            result.add(totalMatches);
        }
        return result;
    }

    public static List<Integer> matchingStrings2(List<String> stringList, List<String> queries) {
        // Write your code here
        List<Integer> res = new ArrayList<>();

        for (String query : queries) {
            int instances = (int) stringList.stream().filter(obj -> obj.equals(query)).count();
            res.add(instances);
        }

        return res;
    }

}