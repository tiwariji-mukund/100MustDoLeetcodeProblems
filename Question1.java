/*                        238. Product of Array Except Self
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums 
except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for 
space complexity analysis.)        
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int left[] = new int[nums.length];
        int right[] = new int[nums.length];
        int output[] = new int[nums.length];
        int product = 1;
        for(int i=0; i<nums.length; i++){
            product *= nums[i];
            left[i] = product;
        }
        product = 1;
        for(int i=nums.length-1; i>=0; i--){
            product *= nums[i];
            right[i] = product;
        }
        for(int i=1; i<nums.length-1; i++){
            output[i] = left[i-1] * right[i+1];
        }
        output[0] = right[1];
        output[nums.length-1] = left[nums.length-2];
        return output;
    }
}
