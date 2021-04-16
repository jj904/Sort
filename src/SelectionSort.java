//Algorithm_sort
//Selection Sort
//jj904
public class SelectionSort {
    private static void selectionSort(int[] arr){
        selectionSort(arr, 0);
    }
    private static void selectionSort(int[] arr, int start){
        if(start < arr.length -1){
            int min_index = start;
            for(int i=start; i<arr.length; i++){
                if(arr[i] < arr[min_index]) min_index = i;
            }
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
        }
    }
    private static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
    private static void printArray(int[] arr){
        for(int data: arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 1, 8, 2, 4};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
