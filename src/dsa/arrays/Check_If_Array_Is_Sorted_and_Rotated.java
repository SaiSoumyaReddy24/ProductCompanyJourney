package dsa.arrays;

/*
 * Problem : Check if Array is Sorted and Rotated
 * Link    : https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 * Difficulty: Easy
 * Date    : 14 May 2026
 *
 * NOTE: For LeetCode submission, rename class to 'Solution'
 *       and the method to 'check'.
 */

public class CheckIfSortedAndRotated {

    /*
     * Approach 1: Brute Force (Break Point)
     * ----------------------------------------
     * Idea: Find the break point where a drop occurs. Check for increasing
     * order on both sides of the break point along with wrap-around condition.
     *
     * Time : O(n)
     * Space: O(1)
     */
    public boolean checkBrute(int[] nums) {
        int n = nums.length;
        int breakPoint = -1;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (breakPoint != -1) return false; // Second drop → invalid
                breakPoint = i + 1;
            }
        }

        if (breakPoint == -1) return true; // No rotation, already sorted

        if (nums[n - 1] > nums[0]) return false; // Wrap-around check

        // Check left part: nums[0..breakPoint-1]
        for (int i = 0; i < breakPoint - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }

        // Check right part: nums[breakPoint..n-1]
        for (int i = breakPoint; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) return false;
        }

        return true;
    }

    /*
     * Approach 2: Optimal (Count Drops)
     * ----------------------------------------
     * Idea: A valid rotated sorted array has at most 1 drop (including wrap-around).
     * Use modulo to check wrap-around (nums[n-1] vs nums[0]) in the same loop.
     *
     * Time : O(n)
     * Space: O(1)
     *
     * Pattern : Count the Drops
     * Learnt  : Multiple conditions can often be unified into a single
     *           elegant check rather than handling each separately.
     */
    public boolean checkOptimal(int[] nums) {
        int countDrops = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n])
                countDrops++;
            if (countDrops > 1)
                return false;
        }

        return true;
    }
}