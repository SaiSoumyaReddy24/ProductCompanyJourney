package dsa.arrays;

import java.util.HashMap;

/*
Problem: Two Sum
Link:https://leetcode.com/problems/two-sum/
Difficulty: Easy
Date:13 Apr 2026

Approach: HashMap - Store each num and its index
for each num check (target - num) exists in map

Time: O(n) | Space : O(n)
Pattern: HashMap lookup
What I learnt: Complement pattern - look for (target - current)
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