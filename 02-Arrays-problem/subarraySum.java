/*

Q7. Subarray with Given Sum(Hint- If indexing is position based)
Example: Input:arr=[1,2,3,7,5],sum=12
Output:[2,4]


*/

import java.util.*;

public class subarraySum{


    ///// brute force     
    public static void subarraySum(int[] arr, int target) {
    int n = arr.length;

    for (int i = 0; i < n; i++) {
        int sum = 0;

        for (int j = i; j < n; j++) {
            sum += arr[j];

            if (sum == target) {
                System.out.println("[" + (i + 1) + "," + (j + 1) + "]");
                return;
            }
        }
    }
    System.out.println("No subarray found");
}


   ///// optimize Approach Sliding window [ only have positive ]
    public static void subarraySumm(int[] arr, int target) {
    int n = arr.length;
    int left = 0, sum = 0;

    for (int right = 0; right < n; right++) {
        sum += arr[right];

        while (sum > target) {
            sum -= arr[left];
            left++;
        }

        if (sum == target) {
            System.out.println("[" + (left + 1) + "," + (right + 1) + "]");
            return;
        }
    }

    System.out.println("No subarray found");
}


////// POSITIVE AND NEGATIVE BOTH USING PPREFIXSUM AND HASHMAP --- 
    public static void subarraySummm(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: from index 0
            if (prefixSum == target) {
                System.out.println("[1," + (i + 1) + "]");
                return;
            }

            // Case 2: check in map
            if (map.containsKey(prefixSum - target)) {
                int start = map.get(prefixSum - target) + 2;
                int end = i + 1;
                System.out.println("[" + start + "," + end + "]");
                return;
            }

            map.put(prefixSum, i);
        }

        System.out.println("No subarray found");
    }

    public static void main(String[] args){
        int[] arr={1,2,3,7,5};
        int sum = 12;
        subarraySum(arr, sum);
        subarraySumm(arr, sum);
        subarraySummm(arr, sum);
    }
}