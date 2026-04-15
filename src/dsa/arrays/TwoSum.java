package dsa.arrays;

import java.util.HashMap;

/*
Problem: Two Sum
Link:https://leetcode.com/problems/two-sum/
Difficulty: Easy
Date:13 Apr 2026

--Brute Force-------------------------------------
Idea: Check pair of numbers using 2 loops
Code: for i -> for j(j=i+1) -> if nums[i]+nums[j] == target
Time: O(n²) | Space: O(1)
problem: Too slow for large inputs.
---------------------------------------------------

--Optimization-------------------------------------
HashMap gives O(1) lookup. Store each number as we scan.
For num[i] check if(target - nums[i]) is already in map.
If yes -> found the pair. If no-> add nums[i],i to map and move on.
Time: O(n) | Space : O(n)
---------------------------------------------------

Pattern: HashMap Complement lookup
What I learnt: When you need to eliminate a nested loop, ask:
"Can I store something while I scan to avoid re-scanning?"
HashMap = trade space for time.

*/
class Solution {
    public int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int rem = target - arr[i];
            if(map.containsKey(rem)){
                return new int[] {map.get(rem),i};
            }
            map.put(arr[i],i);
        }
        return new int[] {-1,-1};
    }
}