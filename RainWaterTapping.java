public class RainWaterTapping {
    public static void main(String[] args) {

        int[] arr = { 4, 2, 0, 6, 3, 1, 5 };
        int n = arr.length;
       System.out.println(RainWaterTappingFun(arr, n));
    }

    public static int RainWaterTappingFun(int[] arr, int n) {

        int[] leftArray = new int[n];
        int[] rightArray = new int[n];

        leftArray[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftArray[i] = Math.max(arr[i], leftArray[i - 1]);
        }

        rightArray[n-1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightArray[i] = Math.max(arr[i], rightArray[i + 1]);
        }
         
        int trappedWater = 0;

        for(int i=0; i<n; i++){
            int waterlevel = Math.min(rightArray[i], leftArray[i]);

            trappedWater += waterlevel - arr[i];
        }

        return trappedWater;
        
    }

}
