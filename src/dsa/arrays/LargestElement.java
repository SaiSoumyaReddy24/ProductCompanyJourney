package dsa.arrays;

/*
Problem: Largest Element
Difficulty: Easy
Date:01 May 2026

--Approach-------------------------------------
Idea: Assume the first element is the maximum, then iterate
through the array to update the max if a larger element is found.
Time: O(n) | Space: O(1)
---------------------------------------------------

*/
class Solution {
    public int largestElement(int[] nums) {
        int max_ele= nums[0];
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(max_ele<nums[i]){
                max_ele = nums[i];
            }
        }
        return max_ele;
    }
}