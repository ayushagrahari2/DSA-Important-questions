/* 


1. Find the Largest Sum Contiguous Subarray
Example: Input:[-2,1,-3,4,-1,2,1,-5,4]
Output:6(Subarray:[4,-1,2,1])


*/

import java.util.Arrays;

public class largSumContSubarray {

    // kanada's algo [ negative ko reset kr do ]

    public static int largestSum(int[] arr) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if (currSum > maxSum) {
                maxSum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    // agr negative bhi krna ho to

    public static int largestSumNeg(int[] arr) {
        int currSum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currSum = Math.max(arr[i], currSum + arr[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
    // subArrays ka range bhi puche to

    public static int[] largestSumRange(int[] arr){

    int currSum = arr[0];
    int maxSum = arr[0];

    int start = 0, end = 0;
    int tempStart = 0;

    for(int i = 1; i < arr.length; i++){

        if(arr[i] > currSum + arr[i]){
            currSum = arr[i];
            tempStart = i;
        } else {
            currSum = currSum + arr[i];
        }

        if(currSum > maxSum){
            maxSum = currSum;
            start = tempStart;
            end = i;
        }
    }

    return new int[]{maxSum, start, end}; // 
}

    public static void main(String args[]) {
        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        // System.out.println(largestSum(arr));            // kanada's algo [ negative ko reset kr do ]
        // System.out.println(largestSumNeg(arr));           // agr negative bhi krna ho to
        System.out.println(Arrays.toString(largestSumRange(arr)));      // subArrays ka range bhi puche to

    }
}
