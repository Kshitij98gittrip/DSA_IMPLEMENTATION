package sorting;

/* 
 *The worst case complexity of insertion sort is O(n^2) 
 the avergae time complexity is O(n^2) , If  the list is randomly ordered  
 The best time complexity is O(n) it is when the list is almost sorted
 */


public class InsertionSort {
    
    public static void insertionSort(int[] arr){

        for (int i = 1; i < arr.length; i++){
            int j = i-1;
            int key = arr[i];

            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j -= 1;
            }

            arr[j+1] = key;
        }
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        insertionSort(arr);
        display(arr);
    }
    
}
