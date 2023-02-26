//first initializes the minimum difference to the maximum integer value to ensure that any absolute difference
//        we compute will be smaller than the minimum difference found so far. We then iterate over all possible
//        ways of dividing the array into two subarrays using a bitmask. For each bitmask, we compute the product
//        and count of elements in each subarray using a loop and a conditional statement. We then compute the absolute
//        difference of the products and update the minimum absolute difference found so far if the subarrays have the
//        same length. Finally, we return the minimum absolute difference found. In the main method, we define the input
//        array and call the minProductDifference method to compute the minimum product difference of any two subarrays.


package QuestionThree;

public class Divide {
    public static int minProductDifference(int[] arr) {
        int n = arr.length;
        int minDiff = Integer.MAX_VALUE;

        // Iterate over all possible ways of dividing the array into two subarrays
        for (int mask = 0; mask < (1 << n); mask++) {
            int prod1 = 1, prod2 = 1;
            int cnt1 = 0, cnt2 = 0;

            // Compute the product and count of elements in each subarray
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    prod1 *= arr[i];
                    cnt1++;
                } else {
                    prod2 *= arr[i];
                    cnt2++;
                }
            }

            // Compute the absolute difference of the products
            int diff = Math.abs(prod1 - prod2);

            // Update the minimum absolute difference found so far
            if (cnt1 == cnt2 && diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 4, 11};
        int minDiff = minProductDifference(arr);
        System.out.println("Minimum product difference: " + minDiff);
    }

}
