public class Solution {
    class fruit {
        int a = 2;
        int b = 4;
    }

    class apple extends fruit{
        int a = 2;

    }
    // [1,5,5,6,1,7,2,8]

    // sorting this arr
    public static void main(String[] args) {
        // bubble sort
        int[] arr = {1,5,5,6,1,7,2,8};
        int n = arr.length;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length-1 - i; j++){
                if(arr[j] > arr[j+1]){
                    // swapping
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(arr);
    }

}
