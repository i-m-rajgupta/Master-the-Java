package Prac;
import java.util.*;

public class Nov20 {
   public static int[] smallest_largest(int [] arr){
      int max = arr[0],min = arr[0];
      for(int i =1 ;i<arr.length;i++){
        if(arr[i]<min){
            min = arr[i];
        }

        if(arr[i] > max){
            max = arr[i];
        }
      }
     return new int[]{min,max};
   }

   public static int second_largest(int[] arr){
    int largest = arr[0];
    int second_largest = Integer.MIN_VALUE;
    for(int i = 1;i<arr.length;i++){
        if( arr[i] > largest){
            second_largest = largest;
            largest = arr[i];
        } else if(arr[i] > second_largest && arr[i]<largest ){
            second_largest = arr[i];
        } 
    }
    return  second_largest;
   }

   public static void reverse(int[] arr){
    int start = 0,end = arr.length-1;
    while (start < end) {
       int temp = arr[start];
       arr[start] = arr[end];
       arr[end] = temp;
       start++;
       end--;
    }
   }

   public static boolean isSorted(int[] arr){
    int prev = arr[0];
    for(int i=1;i<arr.length;i++){
        if(prev > arr[i]){
          return false;
        }
        prev = arr[i];
    }
    return true;
   }

   public static void countFrequency(int[] arr){
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele:arr){
        map.put(ele, map.getOrDefault(ele,0) + 1);
    }
    
    System.out.println("Frequency of each element in the array :");
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        System.out.println(
            entry.getKey()+"->"+entry.getValue()
        );
    }
   }

   public static long missingNum(int[] arr,int n){
     long expectedSum = (long) n * (n+1) /2;
     long actualSum = 0;
     for( int ele: arr){
        actualSum += ele;
     }
     return expectedSum - actualSum;
   }

   public static void allDuplicate(int[] arr){
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele: arr){
        map.put(ele, map.getOrDefault(ele,0)+1);
    }
    System.out.println("Duplicate element in the array");
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        if(entry.getValue() > 1){
            System.out.print(entry.getKey()+" ");
        }
    }
    System.out.println();
   }
   public static void main(String[] args){
    // Find the largest and smallest elements in an array
    int arr[] = {12,10,52,89,36,89,63,10,52};
    int res[] = smallest_largest(arr);
    System.out.println("Smallest is "+res[0]+" and largest is "+res[1]);

    // Find the second-largest distinct element
    int result = second_largest(arr);
    if(result == Integer.MIN_VALUE){
      System.out.println("Second Largest element does not exists in the array");
    }else{
      System.out.println("Second Largest element in the array : "+ result);
    }
    
    // Reverse an array in-place
    reverse(arr);
    System.out.println("Reverse of an array is : ");
    for(int ele:arr){
        System.out.print(ele+" ");
    }
    System.out.println();

    // Check whether array is sorted or not
    System.out.println("Array is sorted : "+isSorted(arr));
     System.out.println("Array is sorted : "+isSorted(new int[]{2,3,4,5,6}));

    //  Count the frequency using the HashMap
    countFrequency(arr);

    // Find the missing number from 1 to N
    System.out.println("Missing number "+missingNum(new int[]{1,2,4,5,6},6));

    // Find all duplicate elements in an array
    allDuplicate(arr);
   } 
}
