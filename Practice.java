import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Practice {
    public static void two_sum(int n,int target,int arr[]){
            for(int i = 0 ; i < n;i++){
                for(int j = i+1; j < n;j++){
                    if (arr[i] + arr[j] == target) {
                        System.out.print("YES");
                    }else{
                        System.out.println("NO");
                    }
                }
            }
    }

    public static void sum(int n,int target,int arr[]){
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0 ; i < n ;i++){
            set.add(arr[i]);
        }

       for(int num : arr){
        int rem = target - num;
        if (set.contains(rem)) {
            System.out.println("YES");
        }else{
            System.out.println("No");
        }
       }
    }

    public static int maxProfit(int stocks[]){
        int Buyprice = stocks[0];
        int profit = 0;
        int max = 0;
        for(int i = 0 ; i < stocks.length;i++){
            if (stocks[i]  > Buyprice) {
                //PROFIT is made 
                profit = stocks[i] - Buyprice;
               max =  Math.max(profit, max);
            }else{
                Buyprice = stocks[i];
            }
        }
        return max;
    }


    public static boolean isSubset(int a[],int b[]){
        int n = a.length;
        int m = b.length;

        HashSet<Integer> set = new HashSet<>();
        if (n > m) {
            for (int i = 0; i < a.length; i++) {
                set.add(a[i]);
            }

            for(int el : b){
                if (!set.contains(el)) {
                    return false;
                }
            }
          
        }else{
            for (int i = 0; i < b.length; i++) {
                set.add(b[i]);
            }

            for(int el : a){
                if (!set.contains(el)) {
                    return false;
                }
            }
        }
        return true;
       
    }

    public static boolean optimised_Subset(int nums1[],int nums2[]){   
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums1.length;i++){
            map.put(nums1[i], map.getOrDefault(nums1[i],0)+1);
        }

        for(int i = 0 ; i < nums2.length;i++){
            if (!map.containsKey(nums2[i]) || map.get(nums2[i]) == 0) {
                return false;
            }
            map.put(nums2[i], map.get(nums2[i])-1);
        }
        return true;
    }

   public static int min_Operations_tomake_ArrayPalindrome(int nums[]){
    int i = 0 , j = nums.length-1;
    int ans = 0;
    while (i < j) {
        if (nums[i] == nums[j]) {
            i++;j--;
        }
        else if(nums[i] < nums[j]){
            i++;
            nums[i] += nums[i-1];
            ans++;
        }else if (nums[j] < nums[i]) {
            j--;
            nums[j] += nums[j+1];
            ans++;
        }
    }
    return ans;
   }

   public static void Spiral_Matrix(int[][] matrix){
    if (matrix.length == 0) {
        return;
    }

    int top = 0;
    int left = 0;
    int bottom = matrix.length-1;
    int right = matrix[0].length-1;

    while (top <= bottom && left <= right) {
        //for the top portion
        for(int i = left; i<= right;i++){
            System.out.print(matrix[top][i] + " ");
        }
        top++;


        //right side ke liye
        for(int i = top+1; i <= bottom;i++){
            System.out.print(matrix[i][right] + " ");
        }
        right--;

        if (top <= bottom) {
            for(int i = right; i >= left;i--){
                    System.out.print(matrix[bottom][i] + " ");
            }bottom--;
        }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++; // Move left boundary right
        }
    }
   }
    public static void main(String[] args) {
        int[][] matrix = {
            {1,  2,  3,  4},
            {5,  6,  7,  8},
            {9, 10, 11, 12},
            {13,14, 15,16}
        };
      
        Spiral_Matrix(matrix);
    }
}