import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Nov22 {
  public static int[] two_sum(int arr[],int target){
    int first_index = 0;
    for(int i=1;i<arr.length;i++){
     first_index = i-1;
     for(int j = first_index;j<arr.length;j++){
       if(arr[first_index] + arr[j] == target){
        return new int[] {first_index,j};
       }
     }
    }
    return  new int[]{-1,-1};
  }

  public static int[] zero_end(int[] arr){
    int[] res = new int[arr.length];
    int idx = 0;
    for(int ele: arr){
        if(ele != 0){
            res[idx++] = ele;
        }
    }
    return res;
  }

public static void rotate(int arr[], int k) {
    int size = arr.length;

    if (size == 0) {
        return;
    }

    k = k % size;

    if (k == 0) {
        return;
    }

    int left = 0;
    int right = size - 1;

    while (left < right) {
        int temp = arr[right];
        arr[right--] = arr[left];
        arr[left++] = temp;
    }

    left = 0;
    right = k - 1;

    while (left < right) {
        int temp = arr[right];
        arr[right--] = arr[left];
        arr[left++] = temp;
    }

    left = k;
    right = size - 1;

    while (left < right) {
        int temp = arr[right];
        arr[right--] = arr[left];
        arr[left++] = temp;
    }
}
  
  public static int[] union(int[] arr1,int[] arr2){
    int size1 = arr1.length;
    int size2 = arr2.length;
    
    if (size1 == 0 && size2 == 0 ) {
        return  new int[0];
    }

    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele:arr1){
        if(!map.containsKey(ele)){
          map.put(ele, 1);
        }
    }
    for(int ele:arr2){
        if(!map.containsKey(ele)){
          map.put(ele, 1);
        }
    }
    
    int idx=0;
    int res[] = new int[map.size()];
    for(Map.Entry<Integer,Integer> entry:map.entrySet()){
         res[idx++] = entry.getKey();
    }
  
    return res;
  }

  public static int[] intersection(int[] arr1, int[] arr2){
    if(arr1.length == 0 && arr2.length == 0){
        return new int[0];
    }
    HashMap<Integer,Integer> map = new HashMap<>();
    for(int ele: arr1){
      if(!map.containsKey(ele)){
      map.put(ele, 1);
      }
    }

    for(int ele:arr2){
      if(map.containsKey(ele) && map.get(ele) != -1){
        map.remove(ele);
        map.put(ele, -1);
      }
    }

    map.entrySet().removeIf(entry -> entry.getValue() != -1);
   return map.keySet().stream().mapToInt(Integer::intValue).toArray();

  }

  public static int[] subarray(int[] arr,int target){
    if(arr.length == 0){
      return new int[] {-1,-1};
    }

    for(int i = 1;i<arr.length;i++){
      int sum = arr[i-1];
      for(int j = i;j<arr.length;j++){
        sum += arr[j]; 
        if(sum == target){
          return new int[]{i-1,j};
        }
      }
    }
     return new int[] {-1,-1};
  } 


public static int max_sum_subarray(int arr[]) {
    if (arr.length == 0) {
        return 0;
    }

    int maxSum = arr[0];
    int currentSum = arr[0];

    for (int i = 1; i < arr.length; i++) {
        currentSum = Math.max(arr[i], currentSum + arr[i]);
        maxSum = Math.max(maxSum, currentSum);
    }

    return maxSum;
}

 public static int majority(int[] arr) {

    int candidate = 0;
    int count = 0;

    for (int i = 0; i < arr.length; i++) {

        if (count == 0) {
            candidate = arr[i];
        }

        if (arr[i] == candidate) {
            count++;
        } else {
            count--;
        }
    }

    count = 0;

    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == candidate) {
            count++;
        }
    }

    if (count > arr.length / 2) {
        return candidate;
    }

    return -1;
}

public static int longestConsecutive(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int x : nums) set.add(x);
    int longest = 0;
    for (int x : set) {
        if (!set.contains(x - 1)) {
            int current = x, length = 1;
            while (set.contains(current + 1)) {
                current++;
                length++;
            }
            longest = Math.max(longest, length);
        }
    }
    return longest;
}

public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] result = new int[n];
    int prefix = 1;
    for (int i = 0; i < n; i++) {
        result[i] = prefix;
        prefix *= nums[i];
    }
    
    int suffix = 1;
    for (int i = n - 1; i >= 0; i--) {
        result[i] *= suffix;
        suffix *= nums[i];
    }
    return result;
}

  public static void print(int[] arr){
    for(int ele:arr){
      System.out.print(ele+" ");
    }
    System.out.println();
  }
  public static void main(String [] args){
    // Given an integer array and a target, find the indices of two distinct elements whose sum equals the target. Return {-1, -1} if no pair exists.
    int res[] = two_sum(new int[]{2,7,11,5}, 55);
    System.out.println("Result : "+res[0]+" "+res[1]);
    res = two_sum(new int[]{2,7,11,5}, 9);
    System.out.println("Result : "+res[0]+" "+res[1]);

    // Move all zeros to the end of an array while maintaining the relative order of non-zero elements. Do this in-place.
    res = zero_end(new int[]{2,0,6,9,0,12});
    print(res);
    res = zero_end(new int[]{0,1,0,3,12,0});
    print(res);

    // Rotate an array to the right by K positions. Do it in-place using O(1) extra space.
    int[] arr2 = {1,2,3,4,5,6,7};
     rotate(arr2, 3);
     print(arr2);

    //  Find the union of two integer arrays. Each element should appear only once in the result.
    int[] union = union(new int[]{5,7,8,9,5,8},new int[] {1,7,2,2});
    print(union);

    // Find the distinct elements present in both arrays. Return each common element only once.
    res = intersection(new int[]{2,3,5,1,9}, new int[]{1,5,7});
    print(res);

    //Given an array of positive integers and a target sum, find the starting and ending indices of a contiguous subarray whose sum equals the target. Return [-1, -1] if none exists. Use 0-based indexing.
     res = subarray(new int[]{1,2,3,7,5},15);
     print(res);

    //  Find the maximum possible sum of a contiguous subarray. Use Kadane's algorithm.
     System.out.println(max_sum_subarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
     System.out.println(max_sum_subarray(new int[]{-2,-3,5}));
     System.out.println(max_sum_subarray(new int[]{-2}));

    //  Find the element that appears more than n/2 times in an array. Return -1 if no such element exists. Aim for O(n) time and O(1) extra space.
     System.out.println(majority(new int[]{2,2,1,2,1}));

    //  Find the length of the longest sequence of consecutive integers in an unsorted array. Aim for O(n) average time.
    System.out.println(longestConsecutive(new int[]{1,2,8,9,3,4}));

    // Create an output array where each position contains the product of all other elements. Do not use division. Aim for O(n) time.
    res = productExceptSelf(new int[]{1,2,3,4});
    print(res);
  }   
}
