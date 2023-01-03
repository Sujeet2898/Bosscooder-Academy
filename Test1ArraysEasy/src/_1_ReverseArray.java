import java.util.ArrayList;
import java.util.List;

public class _1_ReverseArray {
    /*
    An array is a type of data structure that stores elements of the same type in a contiguous block of memory.
    In an array, A, of size N, each memory location has some unique index,i  (where 0 <= i < N), that can be referenced as A[i] or Ai.
    Reverse an array of integers.
    */

    public static List<Integer> reverseArray(List<Integer> a){
        int li = 0;
        int ri = a.size()-1;
        while (li < ri){
            int temp = a.get(li);
            a.set(li, a.get(ri));
            a.set(ri, temp);
            li++;
            ri--;
        }
        return a;
    }

}
