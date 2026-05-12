package dsa.arrays;

/*
Problem: Second Largest Element
Difficulty: Easy
Date:12 May 2026

--Approach-------------------------------------
Idea: Use two variables to track the top two values while traversing the array.
whenever a bigger value is found, the current maximum steps down to second maximum
and bigger value is new maximum.
Time: O(n) | Space: O(1)
---------------------------------------------------

*/
class Solution {
    public int secondLargestElement(int[] nums) {
        int n = nums.length;
        int max_ele = Integer.MIN_VALUE;
        int secmax_ele = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(max_ele<nums[i]){
                secmax_ele = max_ele;
                max_ele = nums[i];
            }
            else if(secmax_ele<nums[i] && nums[i]!=max_ele){
                secmax_ele = nums[i];
            }
        }
        return (secmax_ele == Integer.MIN_VALUE) ? -1 : secmax_ele;
    }
}