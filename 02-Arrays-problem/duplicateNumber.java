import java.util.*;
/*


4. Find the Duplicate Number
Example: Input:[1,3,4,2,2]
Output:2


 */

public class duplicateNumber {

    /// Brute force Approach
    public static int findDuplicate(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return -1;
    }

    //// Better Aproach ( Sorting )

    public static int findDuplicatee(int[] arr) {
        Arrays.sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return arr[i];
            }
        }
        return -1;
    }

    ///// Optimized Approach (Floyd’s Cycle Detection 🔥 BEST)
    public static int findDuplicateee(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // Step 1: Detect cycle
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Step 2: Find entry point
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 2, 2 };
        System.out.println(findDuplicate(arr));
        System.out.println(findDuplicatee(arr));
        System.out.println(findDuplicatee(arr));
    }
}