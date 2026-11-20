package Arr2d;
import java.util.*;

public class search {
    public static int[] search_element(int[][] arr,int key){
      int row = -1,column = -1;
      for(int i = 0 ; i < arr.length;i++){
        for(int j = 0;j<arr[0].length;j++){
            if( key == arr[i][j]){
                row = i;
                column = j;
                break;
            }
        }
      }
      int res[] = {row,column};
      return res; 
    }
    public static void main(String[] args){
        int[][] matrix = new int[3][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for matrices ");
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the element to search : ");
        int key = sc.nextInt();
        int res[] = search_element(matrix,key);
        if(res[0] == -1){
            System.out.println(key+" is not present in the matrix");
        }else{
            System.out.println(key+" is found at the ("+res[0]+","+res[1]+") of the matrix");
        }
    }
}
