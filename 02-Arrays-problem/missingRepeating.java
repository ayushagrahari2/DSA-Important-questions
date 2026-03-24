/* 

Q6. Find the Missing and Repeating Number
Example: Input:n=5,arr[]={1,3,3,5,4}
Output: Missing=2,
Repeating=3

*/

class Solution {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;

        long S = (long)n * (n + 1) / 2;
        long P = (long)n * (n + 1) * (2 * n + 1) / 6;

        long S1 = 0, P1 = 0;

        for (int i = 0; i < n; i++) {
            S1 += arr[i];
            P1 += (long)arr[i] * arr[i];
        }

        long val1 = S - S1;      // x - y
        long val2 = P - P1;      // x^2 - y^2

        long val3 = val2 / val1; // x + y

        long missing = (val1 + val3) / 2;
        long repeating = missing - val1;

        return new int[]{(int)repeating, (int)missing};
    }
}

public class missingRepeating {

    // Brute force Aproach
    public static int[] misRepeat(int[] arr) {
        int n = arr.length;
        int repeating = -1, missing = -1;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 0; j < n; j++) {
                if (arr[j] == i) {
                    count++;
                }
            }

            if (count == 0) {
                missing = i;
            } else if (count > 1) {
                repeating = i;
            }
        }
        return new int[]{repeating, missing};
    }



    public static void main(String[] args) {

        int[] arr = {4, 3, 6, 2, 1, 1};

        // brute-start
        int[] res = misRepeat(arr);
        System.out.println("Repeating = " + res[0]);
        System.out.println("Missing = " + res[1]);
        /// brute-end
        
        Solution obj = new Solution();
        int[] result = obj.findTwoElement(arr);

        System.out.println("Repeating = " + result[0]);
        System.out.println("Missing = " + result[1]);
    }
}