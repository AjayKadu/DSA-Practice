public class MaxSubArray {
    public static void main(String[] args) {
        int[] arr = { -1, 3, 7, -4, 2 };
        int[] num = { -1, 3, 7, -4, 2 };
        int[] array = { -1, 3, 7, -4, 2 };
        bruteForceFun(arr);
        prefixSumFun(num);
        kadanesFun(array);
    }

    // Brute-Force Method (n^3) complexity;

    public static void bruteForceFun(int[] arr) {
        int n = arr.length;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currSum = 0;

                for (int k = i; k <= j; k++) {
                    currSum += arr[k];
                }

                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println(maxSum);
    }

    // PrefixSum Method (n^2) Complexity (n) Space Complexity;

    public static void prefixSumFun(int[] arr) {
        int n = arr.length;
        int[] prefix = new int[n];
        int maxSum = Integer.MIN_VALUE;

        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int currSum = (i == 0) ? prefix[j] : prefix[j] - prefix[i - 1];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println(maxSum);
    }

    // Kadane'S Algorith (n) complexity most optimal solution;

    public static void kadanesFun(int[] arr) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            currSum += arr[i];
            if (currSum < 0) {         // If all array with negative value write special case
                currSum = 0;          //  smallest negative number;
            }

            maxSum = Math.max(maxSum, currSum);
        }

        System.out.println(maxSum);
    }

}
