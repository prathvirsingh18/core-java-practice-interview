package codingpractice;

public class BinarySearchRecursive {

    public boolean binarySearch(int []arr, int low, int high, int element){

        if (low>high) return false;
        int mid = (low+high)/2;
        if(arr[mid]==element){
            return true;
        }
        if(arr[mid]>element){
            return binarySearch(arr, low, mid-1, element);
        } else{
           return  binarySearch(arr, mid+1, high, element);
        }

    }
    public static void main(String[] args) {
     int [] arr = {1,5,6,7,10,15,16};
     int element = 5;
     BinarySearchRecursive bs = new BinarySearchRecursive();
        System.out.println(bs.binarySearch(arr, 0, arr.length-1, element));
    }
}
