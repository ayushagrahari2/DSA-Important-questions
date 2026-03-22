
/*

2. Rotate an Array by K Steps
Example: Input:nums=[1,2,3,4,5,6,7],k=3
Output:[5,6,7,1,2,3,4]

*/

import java.util.Arrays;

public class rotateArrays {

    // Brute Force
    public static void brute(int[] arr, int k){
        int n = arr.length;
        k = k % n;

        for(int i = 0; i < k; i++){
            int last = arr[n-1];
            for(int j = n-1; j > 0; j--){
                arr[j] = arr[j-1];
            }
            arr[0] = last;
        }

        for(int num: arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
    // end brut

    //////   Extra Array , tc-0(n), sc-o(n)
    public static void extraArray(int[] arr, int k){
        int n = arr.length;
        int[] res= new int[n];
        for(int i=0; i<n; i++){
            res[(i + k) % n] = arr[i];
        }
        System.out.println(Arrays.toString(res));
    }



    // Reverse helper
    public static void reverseb(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    // Optimized Right Rotation
    static void rotateArr(int arr[], int k) {
        int n = arr.length;
        k = k % n;

        reverseb(arr, 0, n-1);
        reverseb(arr, 0, k-1);
        reverseb(arr, k, n-1);
    }
        ////////  Main ///////
    public static void main(String[] args) {

        int[] arr1 = {1,2,3,4,5,6,7};
        int[] arr2 = {1,2,3,4,5,6,7};
        int[] arr3 = {1,2,3,4,6,7};

        int k = 3;

        // Optimized
        rotateArr(arr1, k);
        for(int num : arr1){
            System.out.print(num + " ");
        }
        System.out.println();

        // Brute
        brute(arr2, k);

        // Extra Arrays
        extraArray(arr3, k);
    }
}
