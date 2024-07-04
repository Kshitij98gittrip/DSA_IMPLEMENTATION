package sorting;

//Not suitable for large data because the avergae and worst case complexity of this is O(n^2)
//If the array is almost sorted then don't go for this 

public class BubbleSort {
    
    public static void bubbleSort(int[] arr){

        for (int i = 0; i < arr.length; i++){
            //For optimisation the bubble sort 

            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false)
                break;
        }
                
    }

    public static void display(int[] arr){
        for (int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        bubbleSort(arr);
        display(arr);
    }
    
}
