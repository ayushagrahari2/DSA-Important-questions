/*

Q8. Longest Consecutive Sequence
Example: Input:[100,4,200,1,3,2]
Output:4

*/

import java.util.*;

public class longestConsecutiveSequence {

    // Brute Force
    public static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int longest = 0;

        for (int num : nums) {
            int current = num;
            int count = 1;

            while (contains(nums, current + 1)) {
                current++;
                count++;
            }

            longest = Math.max(longest, count);
        }

        return longest;
    }

    public static boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) return true;
        }
        return false;
    }

    // Optimized
    public static int longestConsecutiveOptimized(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 1, 2, 3, 200};

        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveOptimized(nums));
    }
}