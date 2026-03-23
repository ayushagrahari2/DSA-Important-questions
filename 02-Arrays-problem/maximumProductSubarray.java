/*


5. Maximum Product Subarray
Example: Input:[2,3,-2,4]
Output:6


*/

public class maximumProductSubarray {
    //// Bruteforce Approach
    public static int maxProduct(int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int prod = 1;
            for (int j = i; j < arr.length; j++) {
                prod *= arr[j];
                max = Math.max(max, prod);
            }
        }
        return max;
    }

    /// Optimize way [ kanade's algorithm ]
    public static int maxProductt(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            if (curr < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            maxProd = Math.max(curr, maxProd * curr);
            minProd = Math.min(curr, minProd * curr);

            result = Math.max(result, maxProd);
        }

        return result;
    }
    /// main
    public static void main(String[] args) {
        int[] arr = { 2, 3, -2, 4 };
        System.out.println(maxProduct(arr));
        System.out.println(maxProductt(arr));
    }
}
