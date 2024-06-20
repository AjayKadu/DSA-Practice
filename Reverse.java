public class Reverse {
    public static void main(String[] args) {
        
        int []arr = {2,4,6,8,10};
      funReverse(arr);
        
    }

    static void funReverse(int[] arr){

        for(int i=0; i<arr.length; i++){

            int last = arr.length-1;
            int start = 0;

            int temp = arr[last];
            arr[last] = arr[start];
            arr[start] = temp;

            last--;
            start++;
        }

        for(int num : arr){
            System.out.print(num + " ");
        }
    }
}
