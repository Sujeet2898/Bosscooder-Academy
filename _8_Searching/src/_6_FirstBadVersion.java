/*
Question: First Bad Version
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version.
You should minimize the number of calls to the API.

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Input: n = 1, bad = 1
Output: 1
 */

public class _6_FirstBadVersion {

    // Time Complexity: O(logn)
    // Space Complexity: O(1)
    public int firstBadVersion(int n){
        // 1. Defining the search space
        int left = 1, right = n;

        // 2. Iterating over the search space
        while (left < right){
            int mid = left + (right - left)/2;
            if(isBadVersion(mid)){
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        // return left --> the smallest possible number that satisfies the condition
        return left;
    }

    // Already given in the question with inbuilt function
    private boolean isBadVersion(int mid) {
        return true;
    }
}

















