import sun.plugin.javascript.navig.Array;

import java.util.Arrays;

public class RadixSort {
    static int getMex(int[] arr, int n){
        int max = arr[0];
        for(int i=1; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static void contSort(int[] arr, int n, int exp){
        int[] result = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(i=0; i<n; i++){
            count[(arr[i] / exp) % 10]++;
        }
        for(i=1; i<10; i++){
            count[i] += count[i-1];
        }
        for(i=n-1; i>=0; i--){
            result[count[(arr[i] / exp) % 10]-1] = arr[i];
            count[(arr[i]/exp) % 10]--;
        }
        for(i=0; i<n; i++){
            arr[i] = result[i];
        }
    }
    static void radixSort(int[] arr, int n){
        int mx = getMex(arr, n);
        for(int exp = 1; mx/exp > 0; exp *=10){
            contSort(arr, n, exp);
        }
    }
    static void printArray(int arr[], int n){
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;

        radixSort(arr,n);
        printArray(arr, n);
    }
}
