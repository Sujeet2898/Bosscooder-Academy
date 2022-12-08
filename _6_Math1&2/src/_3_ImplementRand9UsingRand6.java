public class _3_ImplementRand9UsingRand6 {
/*
    public int rand10() {
        //we try to pick values in the range from 6 * 6 = 36 values as we want 1 - 6 uniform random values.
        int column = rand6();
        int row = rand6();

        int val = (column) + (row - 1) * 6; // if u make a grid of 7 * 7 u will observe that values from all the columns are possible and value from last row is not possible as it belongs in the range greater than 40. we find the value using the above formula column + (row - 1) * 7.

        return (val - 1) % 9 + 1; // this needs to be done to handle edge case if we encounter 10. if we just do 10 % 10 we get 0. and we want 1-10.
    }

 */
}
