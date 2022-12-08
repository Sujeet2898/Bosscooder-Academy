public class _4_ImplementRand10UsingRand7 {
/*
    public int rand10() {
        //we try to pick values in the range from 7 * 7 = 49 values as we want 1 - 10 uniform random values. we can only go till 40 as 41- 49 only has 9 numbers and hence our uniformity will be broken.
        int column = rand7();
        int row = rand7();

        int val = (column) + (row - 1) * 7; // if u make a grid of 7 * 7 u will observe that values from all the columns are possible and value from last row is not possible as it belongs in the range greater than 40. we find the value using the above formula column + (row - 1) * 7.

        if (val > 40) {
            return rand10(); //recursive call if we dont find value less than or equal to 40 for uniform distribution.
        }
        return (val - 1) % 10 + 1; // this needs to be done to handle edge case if we encounter 10. if we just do 10 % 10 we get 0. and we want 1-10.
    }
    */
}
