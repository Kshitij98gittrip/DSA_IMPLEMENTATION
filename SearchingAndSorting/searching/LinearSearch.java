

public class LinearSearch{

    public static int LinearSearch(int[] arr,int target){

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){

        int[] arr = {3,2,4,6,1,11,5,33};
        int target = 33;
        int index = LinearSearch(arr,target);
        if (index == -1){
            System.out.println("Element not found");
            }else{
                System.out.println("Element found at index "+index);
                }

    }
}