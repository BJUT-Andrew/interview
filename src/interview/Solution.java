package interview;

import java.util.Stack;

/**
 * @author andrew
 * @create 2021-11-30 10:16
 */
public class Solution {

    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.maximumProduct(new int[]{1, 2, 3}));
    }

    public int maximumProduct(int[] nums) {
        int n = nums.length;
        //min1表示数组中最小的元素，min2表示数组中第2小的元素；
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        //max1表示数组中最大的元素，max2表示数组中第2大的元素，max3表示数组中第3大的元素
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            if(nums[i] < min1){
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2){
                min2 = nums[2];
            }

            if(nums[i] > max1){
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            }else if(nums[i] > max2){
                max3 = max2;
                max2 = nums[i];
            }else if(nums[i] > max3){
                max3 = nums[i];
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
